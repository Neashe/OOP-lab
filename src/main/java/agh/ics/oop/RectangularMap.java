package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {

    private final Vector2d lowerPoint;
    private  final Vector2d upperPoint;
//    private final List<Animal> animalList;

    public RectangularMap(int width,int height){
        this.lowerPoint = new Vector2d(0,0);
        this.upperPoint = new Vector2d(width,height);
        this.animalList = new ArrayList<>();
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(this.lowerPoint) && position.precedes(this.upperPoint) && (!isOccupied(position));
    }

    @Override

    public String toString() {
        MapVisualizer animalsMap = new MapVisualizer(this);
        return animalsMap.draw(lowerPoint, upperPoint);
    }
}
