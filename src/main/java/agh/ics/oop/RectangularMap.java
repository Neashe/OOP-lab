package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;

public class RectangularMap extends AbstractWorldMap {

//    private final Vector2d lowerLeft;
//
//    private  final Vector2d upperRight;
//    private final List<Animal> animalList;

    public RectangularMap(int width,int height){
        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(width,height);
        this.animalList = new HashMap<>();
    }

    @Override
    public Vector2d getUpperRight() {
        return this.upperRight;
    }
    public Vector2d getLowerLeft(){
        return this.lowerLeft;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(this.lowerLeft) && position.precedes(this.upperRight) && (!isOccupied(position));
    }

    @Override

    public String toString() {
        MapVisualizer animalsMap = new MapVisualizer(this);
        return animalsMap.draw(lowerLeft, upperRight);
    }

}
