package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.List;


public class App extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        String[] parameters = this.getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] directions = new OptionsParser().parse(parameters);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };

        IWorldMap map2 = new GrassField(10);
        IEngine engine2 = new SimulationEngine(directions,map2,positions);
        System.out.println(map2);
        engine2.run();

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        gridPane.setPadding(new Insets(3,3,3,3));



        Label label = new Label("Zwierzak");

        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}



