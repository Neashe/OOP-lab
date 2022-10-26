package agh.ics.oop;
public class Animal {
    private Vector2d position;
    private MapDirection orientation;
    public Animal(){
        this.position = new Vector2d(2,2);
        this.orientation = MapDirection.NORTH;
    }
    public String toString(){
        return "Zwierzak stoi w punkcie "+position+" skierowany na "+orientation;
    }
    public boolean isAt(Vector2d position){
        return (this.position==position);
    }
    public void move(MoveDirection direction){
        Vector2d a;
        if(direction == MoveDirection.LEFT){
            this.orientation = this.orientation.previous();
        } else if (direction==MoveDirection.RIGHT) {
            this.orientation = this.orientation.next();

        } else if (direction==MoveDirection.FORWARD) {
            a = this.position.add(this.orientation.toUnitVector());
            if(a.x>=0 && a.y>=0 && a.x<=4 && a.y<=4){
                this.position = a;
            }
        }
        else{
            a = this.position.subtract(this.orientation.toUnitVector());
            if(a.x>=0 && a.y>=0 && a.x<=4 && a.y<=4){
                this.position = a;
            }
        }
    }
}
