package agh.ics.oop;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x,int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return '('+Integer.toString(x)+','+Integer.toString(y)+')';
    }
    public boolean precedes(Vector2d other){
        return this.x <= other.x && this.y <= other.y;
    }
    public boolean follows(Vector2d other){
        return this.x>=other.x && this.y>=other.y;
    }
    public Vector2d add(Vector2d other){
        int a = this.x+ other.x;
        int b = this.y+ other.y;
        return new Vector2d(a,b);
    }
    public Vector2d subtract(Vector2d other){
        return new Vector2d(this.x-other.x,this.y-other.y);
    }
    public Vector2d upperRight(Vector2d other){
        int a = Math.max(this.x,other.x);
        int b = Math.max(this.y,other.y);
        return new Vector2d(a,b);
    }
    public Vector2d lowerLeft(Vector2d other){
        return new Vector2d(Math.min(this.x,other.x),Math.min(this.y,other.y));
    }
    public Vector2d opposite(){
        return new Vector2d(-this.x,-this.y);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        return (this.x==that.x && this.y==that.y);
    }
}
