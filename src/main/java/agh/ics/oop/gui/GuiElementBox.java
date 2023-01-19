package agh.ics.oop.gui;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import agh.ics.oop.*;
public class GuiElementBox {
    VBox vbox = new VBox();
    Label label;
    public GuiElementBox(IMapElement element){
        try{
            Image image = new Image(new FileInputStream(element.getImagePath()));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(20);
            imageView.setFitHeight(20);
            Label label;
            if (element instanceof Animal){
                label = new Label(element.getPosition().toString());
            }
            else{
                label = new Label("grass");
            }
            vbox.getChildren().add(label);
            vbox.getChildren().add(imageView);
            vbox.setAlignment(Pos.CENTER);
        }
        catch(FileNotFoundException e){
            System.out.println("Nie znaleziono pliku");
        }
    }
    public Node getVboxLabel(){
        return vbox.getChildren().get(0);
    }
    public Node getVboxPos(){
        return vbox.getChildren().get(1);
    }

}
