package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
//    protected List<Animal> animalList = new ArrayList<>();
//    protected List<Grass> grassList = new ArrayList<Grass>();
    protected Map<Vector2d,Animal> animalList;// = new HashMap<>();
    protected Map<Vector2d,Grass> grassList;
    protected Vector2d upperRight;
    protected Vector2d lowerLeft;
    public abstract boolean canMoveTo(Vector2d position);

    public abstract Vector2d getLowerLeft();
    public abstract Vector2d getUpperRight();
    @Override

    public boolean place(Animal animal) throws IllegalArgumentException{

        Vector2d animalPosition = animal.getPosition();
        if(canMoveTo(animalPosition)){
            this.animalList.put(animalPosition,animal);
            animal.addObserver(this);
            return true;
        }
        else if (animalPosition.follows(this.lowerLeft) && animalPosition.precedes(this.upperRight)) {

            throw new IllegalArgumentException(animalPosition + " jest już zajęte");
        }
        else{
            throw new IllegalArgumentException(animalPosition+ " znajduje się poza planszą!");
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.animalList.containsKey(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (isOccupied(position)) {
            return this.animalList.get(position);
        }
        return null;
    }

    @Override
    public abstract String toString();


    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = this.animalList.get(oldPosition);
        this.animalList.remove(oldPosition);
        this.animalList.put(newPosition,animal);
    }
}
