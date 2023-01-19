package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class Animal implements IMapElement{
    private Vector2d position;
    private MapDirection orientation;
    private final IWorldMap map;

    private final List<IPositionChangeObserver> observers = new LinkedList<>();
    public Animal(IWorldMap map){
        this.map = map;
        this.position = new Vector2d(2,2);
        this.orientation = MapDirection.NORTH;
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;
    }
    public void addObserver(IPositionChangeObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        observers.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer : observers) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }
    public String toString(){
        MapDirection orient = this.orientation;
        return switch(orient) {
            case NORTH->"^";
            case WEST -> "<";
            case EAST -> ">";
            case SOUTH -> "v";
        };
    }

    public boolean isAt(Vector2d position){
        return (this.position.equals(position));
    }
    public MapDirection getOrientation(){
        return this.orientation;
    }
    public Vector2d getPosition(){
        return this.position;
    }

    public void move(MoveDirection direction){
        Vector2d newPosition = this.position;
        Vector2d oldPosition = this.position;
        switch(direction){
            case LEFT -> this.orientation = this.orientation.previous();
            case RIGHT -> this.orientation=this.orientation.next();
            case FORWARD -> newPosition = this.position.add(this.orientation.toUnitVector());
            case BACKWARD -> newPosition = this.position.subtract(this.orientation.toUnitVector());
            }
            if (this.map.canMoveTo(newPosition)){
                this.position = newPosition;
                positionChanged(oldPosition,newPosition);
            }
        }

    @Override
    public String getImagePath() {
        return switch(this.orientation){
            case SOUTH -> "src/main/resources/down.png";
            case EAST -> "src/main/resources/right.png";
            case WEST -> "src/main/resources/left.png";
            case NORTH -> "src/main/resources/up.png";
        };
    }
}
