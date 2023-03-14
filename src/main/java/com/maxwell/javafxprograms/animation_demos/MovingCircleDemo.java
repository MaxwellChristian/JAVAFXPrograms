package com.maxwell.javafxprograms.animation_demos;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MovingCircleDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Create a pane
        Pane pane = new Pane();

        // Add a circle and add it to pane
        Circle circle = new Circle(125, 100, 50);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        pane.getChildren().add(circle);

        // Create a path transition
//        PathTransition pt = new PathTransition(Duration.millis(5000),
//                new Line(100, 200, 100, 0), circle);

        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(5000));
        pt.setPath(new Line(100, 200, 100, 0));
        pt.setNode(circle);

        pt.setCycleCount(10);

        // for auto reverse
        pt.setAutoReverse(true);

        pt.play(); // Start animation

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 250, 200);
        stage.setTitle("Moving Circle Demo"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage
    }
}
