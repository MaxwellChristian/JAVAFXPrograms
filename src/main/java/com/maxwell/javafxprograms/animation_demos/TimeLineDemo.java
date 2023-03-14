package com.maxwell.javafxprograms.animation_demos;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TimeLineDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        StackPane pane = new StackPane();
        Text text = new Text(20, 50, "Programming is fun");
        text.setFill(Color.RED);
        pane.getChildren().add(text); // Place text into the stack pane

        // Create a handler for changing text
        EventHandler<ActionEvent> eventHandler = e -> {
            if (text.getText().length() != 0) {
                text.setText("");
            }
            else {
                text.setText("Programming is fun");
            }
        };

        // Create an animation for alternating text
        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(500), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Start animation

        // Pause and resume animation
        text.setOnMouseClicked(e -> {
            if (animation.getStatus() == Animation.Status.PAUSED) {
                animation.play();
            }
            else {
                animation.pause();
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 250, 50);
        stage.setTitle("TimelineDemo"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage
    }
}
