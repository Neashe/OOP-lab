package agh.ics.oop;

public class Grass {
    Vector2d grassPosition;

    public Grass(Vector2d grassPosition){
        this.grassPosition = grassPosition;
    }
    public Vector2d getPosition(){
        return this.grassPosition;
    }
    public boolean isAt(Vector2d position){
        return (this.grassPosition.equals(position));
    }
    public String toString(){
        return "*";
    }
}
