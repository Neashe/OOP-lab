package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap {

    int grassNum;
    List<Grass> grassList;

    public GrassField(int grassNum){
        this.grassNum = grassNum;
        this.animalList = new ArrayList<Animal>();
        this.grassList = new ArrayList<Grass>();
        this.upperRight =new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
        this.lowerLeft = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);

        int maxL = (int) Math.sqrt(grassNum*10);
        Random rand = new Random();
        int grassCounter = 0;
        while(grassCounter<grassNum){
            int randA = rand.nextInt(maxL);
            int randB = rand.nextInt(maxL);
            if(!isOccupied(new Vector2d(randA,randB))){
                this.grassList.add(new Grass(new Vector2d(randA,randB)));
                grassCounter++;
            }

        }
    }
    public Grass getGrassAt(int i){
        return grassList.get(i);
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
            this.animalList.add(animal);
            return true;
            }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if (super.isOccupied(position)){
            return true;
        }
        for(Grass grass:grassList){
            if (grass.isAt(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if(super.objectAt(position)==null){
            for(Grass grass:grassList){
                if (grass.isAt(position)){
                    return grass;
                }
            }
            return null;
        }
        else return super.objectAt(position);
    }

    @Override
    public String toString() {

        for (Animal animal:animalList){
            upperRight = upperRight.upperRight(animal.getPosition());
            lowerLeft = lowerLeft.lowerLeft(animal.getPosition());
        }
        for (Grass grass:grassList){
            upperRight = upperRight.upperRight(grass.getPosition());
            lowerLeft = lowerLeft.lowerLeft(grass.getPosition());
        }
        MapVisualizer newMap = new MapVisualizer(this);
        return newMap.draw(lowerLeft,upperRight);
    }
}
