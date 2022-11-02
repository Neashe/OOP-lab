package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private final int height;
    private final int width;
    private final Vector2d lowerPoint;
    private  final Vector2d upperPoint;
    private final List<Animal> animalList;

    public RectangularMap(int width,int height){
        this.height = height;
        this.width = width;
        this.lowerPoint = new Vector2d(0,0);
        this.upperPoint = new Vector2d(width,height);
        this.animalList = new ArrayList<>();
    }
    //get methods
    public int getHeight(){
        return this.height;
    }
    public int getWidth(){
        return this.width;
    }
    public List<Animal> getAnimalList(){
        return this.animalList;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(this.lowerPoint) && position.precedes(this.upperPoint) && (!isOccupied(position));
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d animalPosition = animal.getPosition();
        if(canMoveTo(animalPosition)){
            this.animalList.add(animal);
            return true;
        }
        return false;
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
}
