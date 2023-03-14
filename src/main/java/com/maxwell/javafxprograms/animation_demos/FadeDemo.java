package com.maxwell.javafxprograms.animation_demos;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FadeDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        // create a pane
        Pane pane = new Pane();

        // create an ellipse and set the prorperties
        Ellipse ellipse = new Ellipse(10, 10, 100, 50);

        ellipse.setFill(Color.YELLOW);
        ellipse.setStroke(Color.ORANGE);

        ellipse.centerXProperty().bind(pane.widthProperty().divide(2));
        ellipse.centerYProperty().bind(pane.heightProperty().divide(2));

        ellipse.radiusXProperty().bind(pane.widthProperty().multiply(0.4));
        ellipse.radiusYProperty().bind(pane.heightProperty().multiply(0.4));

        // add the node to the pane
        pane.getChildren().add(ellipse);

        // Fade animation
        FadeTransition ft = new FadeTransition();

        // set the properties of the fade animation
        ft.setDuration(Duration.millis(1000));

        // set from and to for fade
        ft.setFromValue(1.0);
        ft.setToValue(0.1);

        // the cycle count
        ft.setCycleCount(Timeline.INDEFINITE);

        // set the animation to auto reverse
        ft.setAutoReverse(true);

        // set the node on which animation should be applied
        ft.setNode(ellipse);

        // start/play the animation
        ft.play();

        // create a scene with the container
        Scene scene = new Scene(pane, 200, 150);

        // set the scene to the stage
        stage.setScene(scene);

        // set the properties of the stage
        stage.setTitle("Fade Animation Demo");

        // show the stage
        stage.show();

    }
}
