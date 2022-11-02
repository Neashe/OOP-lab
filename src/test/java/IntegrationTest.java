import agh.ics.oop.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class IntegrationTest {

    @Test
    public void RectangularMapTest(){
        IWorldMap map = new RectangularMap(3,6);
        Animal dog = new Animal(map,new Vector2d(2,7));
        Animal capybara = new Animal(map,new Vector2d(3,5));

        Assertions.assertTrue(map.canMoveTo(new Vector2d(2,2)));
        Assertions.assertFalse(map.place(dog));
        map.place(capybara);
        Assertions.assertTrue(map.isOccupied(new Vector2d(3,5)));
        Assertions.assertEquals(capybara,map.objectAt(new Vector2d(3,5)));
        capybara.move(MoveDirection.FORWARD);
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

}
