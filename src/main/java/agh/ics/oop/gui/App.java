package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;


public class App extends Application {
    private final int height = 50;
    private final int width = 50;
    private GridPane gridPane = new GridPane();


    @Override
    public void start(Stage primaryStage) throws Exception {
        String[] parameters = this.getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] directions = new OptionsParser().parse(parameters);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };

        GrassField map2 = new GrassField(10);
        IEngine engine2 = new SimulationEngine(directions,map2,positions);
        System.out.println(map2);
        engine2.run();

        gridPane.setGridLinesVisible(true);
        gridPane.setPadding(new Insets(3,3,3,3));

        int x = map2.getUpperRight().x+2;
        int y = map2.getUpperRight().y+2;

        for(int i = 1; i<x-1;i++)
        {
            ColumnConstraints columnConstraints = new ColumnConstraints(this.width);
            columnConstraints.setPercentWidth(100.0 / x);
            gridPane.getColumnConstraints().add(columnConstraints);
        }

        for(int i = 1; i<y-1;i++)
        {
            RowConstraints rowConstraints = new RowConstraints(this.height);
            rowConstraints.setPercentHeight(100.0 / y);
            gridPane.getRowConstraints().add(rowConstraints);
        }
        Label label;
        for(int i = 0; i<y;i++)
            for(int j = 0; j<x;j++)
            {
                int x1 = i;
                if (i == 0 && j == 0) {
                    label = new Label("y/x");
                    gridPane.add(label, j, x1);
                    GridPane.setHalignment(label, HPos.CENTER);
                    GridPane.setConstraints(label, j, x1);
                }
                else if (i == 0) {
                    label = new Label(""+(j - 1));
                    gridPane.add(label, j, x1);
                    GridPane.setHalignment(label, HPos.CENTER);
                    GridPane.setConstraints(label, j, x1);}

                else if (j == 0) {
                    label = new Label(""+(y-i-1));
                    gridPane.add(label, j, x1);
                    GridPane.setHalignment(label, HPos.CENTER);
                    GridPane.setConstraints(label, j, x1);}
                else {
                    if (map2.objectAt(new Vector2d(j - 1, i - 1)) != null) {
                        GuiElementBox vBox = new GuiElementBox((IMapElement) map2.objectAt(new Vector2d(j-1,i-1)));
                        gridPane.add(vBox.vbox,j,x1);
                    }

                }

            }

        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}



