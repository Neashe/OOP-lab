package agh.ics.oop;

import java.util.Comparator;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{

    private TreeSet<Vector2d> sortedbyX = new TreeSet<>(Comparator.comparing((Vector2d a)->a.x).thenComparing(a->a.y));
    private TreeSet<Vector2d> sortedbyY = new TreeSet<>(Comparator.comparing((Vector2d a)->a.y).thenComparing(a->a.x));

//    public MapBoundary(TreeSet<Vector2d> sortedbyX,TreeSet<Vector2d> sortedbyY){
//
//    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        sortedbyX.remove(oldPosition);
        sortedbyY.remove(oldPosition);

        sortedbyX.add(newPosition);
        sortedbyY.add(newPosition);
    }
    public void addPosition(Vector2d position){
        sortedbyX.add(position);
        sortedbyY.add(position);
    }
    public Vector2d getLowerLeft(){
        Vector2d x = sortedbyX.first();
        Vector2d y = sortedbyY.first();
        return x.lowerLeft(y);
    }
    public Vector2d getUpperRight(){
        Vector2d x = sortedbyX.last();
        Vector2d y = sortedbyY.last();
        return x.upperRight(y);
    }
    public TreeSet<Vector2d> getElementsSet(){
        return this.sortedbyX;
    }

}
