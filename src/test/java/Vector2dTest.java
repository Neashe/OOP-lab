import agh.ics.oop.Vector2d;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2dTest {
    @Test
    public void testEquals(){
        Vector2d vector1 = new Vector2d(1,2);
        Vector2d vector2 = new Vector2d(1,2);
        Object object = new Object();
        Object object2 = new Object();
        Assertions.assertTrue(object.equals(object));
        Assertions.assertFalse(object.equals(object2));
        Assertions.assertTrue(vector1.equals(vector2));
    }
    @Test
    public void testToString(){
        Vector2d testVector = new Vector2d(1,2);
        Assertions.assertEquals("(1,2)",testVector.toString());
    }
    @Test
    public void testPrecedes(){
        Vector2d testVector1 = new Vector2d(2,2);
        Vector2d testVector2 = new Vector2d(2,3);
        Vector2d testVector3 = new Vector2d(1,3);
        Assertions.assertTrue(testVector3.precedes(testVector2));
        Assertions.assertFalse(testVector3.precedes(testVector1));
    }
    @Test
    public void testFollow(){
        Vector2d testVector1 = new Vector2d(2,2);
        Vector2d testVector2 = new Vector2d(2,3);
        Vector2d testVector3 = new Vector2d(1,3);
        Assertions.assertTrue(testVector2.follows(testVector1));
        Assertions.assertFalse(testVector3.follows(testVector2));
    }
    @Test
    public void testUpperRight(){
        Vector2d testVector1 = new Vector2d(1,5);
        Vector2d testVector2 = new Vector2d(12,3);
        Assertions.assertEquals(new Vector2d(12,5),testVector1.upperRight(testVector2));
    }
    @Test
    public void testLowerLeft(){
        Vector2d testVector1 = new Vector2d(1,5);
        Vector2d testVector2 = new Vector2d(12,3);
        Assertions.assertEquals(new Vector2d(1,3),testVector1.lowerLeft(testVector2));
    }
    @Test
    public void testAdd(){
        Vector2d v1 = new Vector2d(1,7);
        Vector2d v2 = new Vector2d(-4,6);
        Assertions.assertEquals(new Vector2d(-3,13),v1.add(v2));
    }
    @Test
    public void testSubstract(){
        Vector2d v1 = new Vector2d(1,7);
        Vector2d v2 = new Vector2d(-4,6);
        Assertions.assertEquals(new Vector2d(5,1),v1.subtract(v2));
    }
    @Test
    public void testOpposite(){
        Vector2d v = new Vector2d(3,-7);
        Assertions.assertEquals(new Vector2d(-3,7),v.opposite());
    }
}
