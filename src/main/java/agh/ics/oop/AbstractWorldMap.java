package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animalList = new ArrayList<Animal>();
//    protected List<Grass> grassList = new ArrayList<Grass>();
    public Vector2d upperRight;
    public Vector2d lowerLeft;
    public boolean canMoveTo(Vector2d position) {
        return position.follows(this.upperRight) && position.precedes(this.lowerLeft) && (!isOccupied(position));
    }

    @Override

    public boolean place(Animal animal) {
        Vector2d animalPosition = animal.getPosition();
        if(canMoveTo(animalPosition)){
            this.animalList.add(animal);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal animal:animalList){
            if (animal.isAt(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal:animalList){
            if (animal.isAt(position)){
                return animal;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        MapVisualizer newMap = new MapVisualizer(this);
        return newMap.draw(lowerLeft,upperRight);
    }

}
