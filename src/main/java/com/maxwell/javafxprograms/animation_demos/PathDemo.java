package com.maxwell.javafxprograms.animation_demos;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PathDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Create a pane
        Pane pane = new Pane();

        // Create a rectangle
        Rectangle rectangle = new Rectangle(0, 0, 25, 50);
        rectangle.setFill(Color.ORANGE);

        // Create a circle
        Circle circle = new Circle(125, 100, 50);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        // Add circle and rectangle to the pane
        pane.getChildren().add(circle);
        pane.getChildren().add(rectangle);

        // Path transition

        // 1. create a transition
        PathTransition pt = new PathTransition();

        // 2. set the duration
        pt.setDuration(Duration.millis(4000));

        // 3. set the path
        pt.setPath(circle);

        // 4. set the node and desired properties
        pt.setNode(rectangle);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);

        // 5. start the animation
        // pt.play(); // Start animation

        // event handling with circle for the animation
        circle.setOnMousePressed(e -> pt.pause());
        circle.setOnMouseReleased(e -> pt.play());

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 250, 200);
        stage.setTitle("Path Transition Demo"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage
    }
}
