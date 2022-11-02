package agh.ics.oop;
public class Animal {
    private Vector2d position;
    private MapDirection orientation;
    private final IWorldMap map;
    public Animal(IWorldMap map){
        this.map = map; //do poprawy,idk o co chodzi
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;
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
        switch(direction){
            case LEFT -> this.orientation = this.orientation.previous();
            case RIGHT -> this.orientation=this.orientation.next();
            case FORWARD -> newPosition = this.position.add(this.orientation.toUnitVector());
            case BACKWARD -> newPosition = this.position.subtract(this.orientation.toUnitVector());
            }
            if (this.map.canMoveTo(newPosition)){
                this.position = newPosition;
            }
        }
    }
