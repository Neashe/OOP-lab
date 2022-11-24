package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {
    public static void main(String[] args) {
        try {
            MoveDirection[] directions = new OptionsParser().parse(args);
            IWorldMap map = new RectangularMap(10, 5);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            map.place(new Animal(map,new Vector2d(3,1)));
            System.out.println(map);


            IWorldMap map2 = new GrassField(10);
            IEngine engine2 = new SimulationEngine(directions,map2,positions);
            engine2.run();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        Application.launch(App.class, args);

    }

}
