package agh.ics.oop;

public class World {
    public static void main(String[] args) {

        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        IWorldMap map2 = new GrassField(10);
        IEngine engine2 = new SimulationEngine(directions,map2,positions);
        engine2.run();


    }

}
