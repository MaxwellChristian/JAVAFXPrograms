package com.maxwell.javafxprograms.animation_demos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.security.cert.CertPathBuilder;
import java.util.Random;

public class TranslationDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        // create a pane
        Pane pane = new Pane();

        double x = 10;
        double y = 10 ;

        Random randomGenerator = new Random();
        for (int i = 0 ; i < 10 ; i++) {

            Rectangle rectangle = new Rectangle(10, 10, 50, 60);
            rectangle.setFill(Color.WHITE);

            rectangle.setStroke(Color.color(randomGenerator.nextDouble(), randomGenerator.nextDouble(), randomGenerator.nextDouble()));

            rectangle.setTranslateX(x+=20);
            rectangle.setTranslateY(y+=5);

            // add to the pane
            pane.getChildren().add(rectangle);

        }

        // create the scene
        Scene scene = new Scene(pane, 300, 250);

        // set the scene to the stage
        stage.setScene(scene);

        // set the properties of the stage
        stage.setTitle("Translation Demo");

        // show the stage
        stage.show();

    }
}
