import agh.ics.oop.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class GrassFieldTest {
    int grassN = 10;
    GrassField map = new GrassField(grassN);
    Animal kotek = new Animal(map);
    Animal piesek = new Animal(map, new Vector2d(7, 7));
    Animal krowa = new Animal(map, new Vector2d(8, 8));

    @Test
    public void canMoveObjAtTest() {
        Assertions.assertTrue(map.canMoveTo(kotek.getPosition()));
        Assertions.assertTrue(map.canMoveTo(piesek.getPosition()));
        Assertions.assertTrue(map.canMoveTo(krowa.getPosition()));
        map.place(kotek);
        map.place(piesek);
        map.place(krowa);

        Assertions.assertEquals(piesek,map.objectAt(new Vector2d(7,7)));

        Assertions.assertFalse(map.canMoveTo(kotek.getPosition()));
        Assertions.assertFalse(map.canMoveTo(piesek.getPosition()));
        Assertions.assertFalse(map.canMoveTo(krowa.getPosition()));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(7,12)));
        System.out.println(map);
    }

    @Test
    public void placeOccupTest(){
        Set<Vector2d> grassSet = map.getgrassSet();
        for(Vector2d vector:grassSet){
            Assertions.assertTrue(map.place(new Animal(map,vector)));
            Assertions.assertTrue(map.isOccupied(vector));
        }
    }
    @Test
    public void canMovetoGrass(){
        Set<Vector2d> grassSet = map.getgrassSet();
        for(Vector2d vector:grassSet){
            Assertions.assertTrue(map.canMoveTo(vector));
        }
        System.out.println(map);
        for(Vector2d vector:grassSet){
            Assertions.assertTrue(map.place(new Animal(map,vector)));
        }
        System.out.println(map);
    }



}
