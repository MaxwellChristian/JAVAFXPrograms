package com.maxwell.javafxprograms.animation_demos.bouncing_ball;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class BouncingBall extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        BallPane ballPane = new BallPane(); // Create a ball pane

        // Pause and resume animation
        ballPane.setOnMousePressed(e -> ballPane.pause());
        ballPane.setOnMouseReleased(e -> ballPane.play());

        // Increase and decrease animation
        ballPane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                ballPane.increaseSpeed();
            }
            else if (e.getCode() == KeyCode.DOWN) {
                ballPane.decreaseSpeed();
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(ballPane, 250, 150);
        stage.setTitle("Bouncing Ball Demo"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage

        // Must request focus after the primary stage is displayed
        ballPane.requestFocus();

    }
}
