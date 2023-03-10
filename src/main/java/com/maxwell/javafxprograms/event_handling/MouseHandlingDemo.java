package com.maxwell.javafxprograms.event_handling;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MouseHandlingDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        // a pane to hold the controls
        Pane pane = new Pane();

        // controls to demonstrate
        Text txt = new Text(20, 20, "Programming with JAVAFX");

        // add the controls to the pane
        pane.getChildren().add(txt);

        // handle the mouse such that
        // when dragged, shifts the text accordingly
        txt.setOnMouseDragged(mouseEvent -> {
            txt.setX(mouseEvent.getX());
            txt.setY(mouseEvent.getY());
        });

        // a scene to hold the container
        Scene scene = new Scene(pane, 300, 300);

        // set the scene in the stage
        stage.setScene(scene);

        // set the properties of the stage
        stage.setTitle("Mouse Event Demo");

        // show the stage
        stage.show();

    }
}
