import agh.ics.oop.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class IntegrationTest {

    @Test
    public void someTest(){
        IWorldMap map = new RectangularMap(3,6);
        Animal dog = new Animal(map,new Vector2d(2,7));
        Animal capybara = new Animal(map,new Vector2d(3,5));
        Assertions.assertTrue(map.place(capybara));
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class,()->map.place(dog));
        Assertions.assertEquals(dog.getPosition()+" znajduje się poza planszą!",exception.getMessage());
        Assertions.assertFalse(map.canMoveTo(new Vector2d(3,5)));
        Assertions.assertEquals(capybara,map.objectAt(new Vector2d(3,5)));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(1,1)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(3,5)));
    }
    @Test
    public void RectangularMapTest(){
        IWorldMap map = new RectangularMap(3,6);
        Animal capybara = new Animal(map,new Vector2d(3,5));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(2,2)));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(3,5)));
        map.place(capybara);
        Assertions.assertEquals(capybara,map.objectAt(new Vector2d(3,5)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(3,5)));
        Assertions.assertFalse(map.canMoveTo(new Vector2d(3,5)));
        Assertions.assertEquals(capybara,map.objectAt(new Vector2d(3,5)));
        capybara.move(MoveDirection.FORWARD);
        System.out.println(map);
        Assertions.assertEquals(capybara,map.objectAt(new Vector2d(3,6)));
    }
    @Test
    void SimulationEngineTest(){
        MoveDirection[] directions = new OptionsParser().parse("f b r l f f r r f f f f f f f f".split(" "));
        IWorldMap map = new RectangularMap(5, 5);
        Vector2d[] positions = { new Vector2d(1,1), new Vector2d(1,2),new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        Assertions.assertEquals(new Vector2d(1,4),positions[0]);
        Assertions.assertEquals(new Vector2d(3,3),positions[1]);
        Assertions.assertEquals(new Vector2d(5,4),positions[2]);

    }
    @Test
    void parserTest(){
        String[] arguments = ("f hehe b r l f f r r f f hm f f f f f f").split(" ");
        OptionsParser parser = new OptionsParser();
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, ()-> parser.parse(arguments));
        Assertions.assertEquals("hehe nie jest poprawnym argumentem!",exception.getMessage());
    }


}
