package com.maxwell.javafxprograms.event_handling;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KeyHandlingDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        // a pane to hold the controls
        Pane pane = new Pane();

        // controls to demonstrate
        Text txt = new Text(20, 20, "JAVAFX");

        // add the controls to the pane
        pane.getChildren().add(txt);

        // handle the keys such that
        // when pressed, moves the text accordingly
        txt.setOnKeyPressed(keyEvent -> {

            // move the text down/up/left/right4

            switch (keyEvent.getCode()){
                case DOWN -> txt.setY(txt.getY() + 5);
                case UP -> txt.setY(txt.getY() - 5);
                case LEFT -> txt.setX(txt.getX() - 5);
                case RIGHT -> txt.setX(txt.getX() + 5);
            }

        });

        // increase and decrease the size using buttons
        txt.setOnMouseClicked(mouseEvent -> {

            Font fontToUse;

            switch (mouseEvent.getButton()){
                // LEFT click
                case PRIMARY -> {
                    fontToUse = new Font(txt.getFont().getSize() + 2);
                    txt.setFont(fontToUse);
                }
                // Right click
                case SECONDARY -> {
                    fontToUse = new Font(txt.getFont().getSize() - 2);
                    txt.setFont(fontToUse);
                }
            }
        });

        // a scene to hold the container
        Scene scene = new Scene(pane, 300, 300);

        // set the scene in the stage
        stage.setScene(scene);

        // set the properties of the stage
        stage.setTitle("Key Event Demo");

        // show the stage
        stage.show();

        // the most important step
        // focus the text to receive the key input
        txt.requestFocus();

    }
}
