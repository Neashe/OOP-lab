package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap {

    int grassNum;
//    List<Grass> grassList;

    public GrassField(int grassNum){
        this.grassNum = grassNum;
        this.animalList = new HashMap<>();
        this.grassList = new HashMap<>();
        this.upperRight =new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
        this.lowerLeft = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);

        int maxL = (int) Math.sqrt(grassNum*10);
        Random rand = new Random();
        int grassCounter = 0;
        while(grassCounter<grassNum){
            int randA = rand.nextInt(maxL);
            int randB = rand.nextInt(maxL);
            if(!isOccupied(new Vector2d(randA,randB))){
                this.grassList.put(new Vector2d(randA,randB),new Grass(new Vector2d(randA,randB)));
                grassCounter++;
            }

        }
    }
    public Grass getGrassAt(Vector2d position){
        return grassList.get(position);
    }
    public Set<Vector2d> getgrassSet(){
        return this.grassList.keySet();
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(this.upperRight) && position.precedes(this.lowerLeft) && (!isOccupied(position) || objectAt(position) instanceof Grass);
    }

    @Override

    public boolean place(Animal animal) {
        Vector2d animalPosition = animal.getPosition();
        if (super.place(animal)) {
            return true;
        }
        Object object = objectAt(animalPosition);
        if (object instanceof Grass) {
            this.animalList.put(animalPosition,animal);
            return true;
            }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return (super.isOccupied(position) || grassList.containsKey(position));
    }

    @Override
    public Object objectAt(Vector2d position) {
        if(super.objectAt(position)==null){
            return grassList.get(position);
        }
        else return super.objectAt(position);
    }

    @Override
    public String toString() {
        Set<Vector2d> setA=animalList.keySet();
        Set<Vector2d> setG=grassList.keySet();

        for (Vector2d vector:setA){
            upperRight = upperRight.upperRight(vector);
            lowerLeft = lowerLeft.lowerLeft(vector);
        }
        for (Vector2d vector:setG){
            upperRight = upperRight.upperRight(vector);
            lowerLeft = lowerLeft.lowerLeft(vector);
        }
        MapVisualizer newMap = new MapVisualizer(this);
        return newMap.draw(lowerLeft,upperRight);
    }
}
