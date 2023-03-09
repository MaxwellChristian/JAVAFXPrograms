package com.maxwell.javafxprograms;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class EllipseDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        // create the scene
        Scene scene = new Scene(new EllipsePane(), 300, 200);

        // set the scene to the stage
        stage.setScene(scene);

        // set the properties of the stage
        stage.setTitle("Ellipse Demo");

        // show the stage
        stage.show();

    }
}

class EllipsePane extends Pane {
    private void paint() {

        // clear all the existing nodes
        getChildren().clear();

        for (int i = 0; i < 16; i++) {

            // Create an ellipse and add it to pane
            // centerX, centerY, radiusX, radiusY
            Ellipse e1 = new Ellipse(getWidth() / 2, getHeight() / 2,
                    getWidth() / 2 - 50, getHeight() / 2 - 50);

            e1.setStroke(Color.color(Math.random(), Math.random(),
                    Math.random()));
            e1.setFill(Color.WHITE);

            // rotate the ellipse
            e1.setRotate(i * 180 / 16);

            // add to the node collection
            getChildren().add(e1);
        }
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        paint();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paint();
    }
}
