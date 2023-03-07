package com.maxwell.javafxprograms;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        // create a circle
        Circle circle = new Circle();

        // set the properties of the circle
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setRadius(50);

        // set the background of the circle
        circle.setFill(Color.YELLOW);
        // set the border of the circle
        circle.setStroke(Color.RED);

        // create a pane to hold the circle
        Pane pane = new Pane();
        // add the components/nodes to the pane
        pane.getChildren().add(circle);

        // create a scene to hold the components
        Scene scene = new Scene(pane, 200, 200);

        // set the properties of the stage
        stage.setTitle("Circle Demo");

        // add the scene to the stage
        stage.setScene(scene);

        // display the stage
        stage.show();
    }

    public static void main(String []args){
        Application.launch(args);
    }
}
