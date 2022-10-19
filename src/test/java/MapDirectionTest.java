import agh.ics.oop.MapDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapDirectionTest {
    @Test
    public void nextTest(){
        MapDirection x1 = MapDirection.NORTH;
        MapDirection x2 = MapDirection.EAST;
        MapDirection x3 = MapDirection.SOUTH;
        MapDirection x4 = MapDirection.WEST;
        Assertions.assertEquals(MapDirection.EAST,x1.next());
        Assertions.assertEquals(MapDirection.WEST,x3.next());
        Assertions.assertEquals(MapDirection.NORTH,x4.next());
        Assertions.assertEquals(MapDirection.SOUTH,x2.next());
    }
    @Test
    public void testPrevious(){
        Assertions.assertEquals(MapDirection.NORTH,MapDirection.EAST.previous());
        Assertions.assertEquals(MapDirection.EAST,MapDirection.SOUTH.previous());
        Assertions.assertEquals(MapDirection.SOUTH,MapDirection.WEST.previous());
        Assertions.assertEquals(MapDirection.WEST,MapDirection.NORTH.previous());
    }
}
