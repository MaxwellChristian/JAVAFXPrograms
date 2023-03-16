package com.maxwell.javafxprograms.animation_demos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ScaleDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        // create the pane
        Pane pane = new Pane();

        // x - axis
        Line lineX1 = new Line(10, 100, 420, 100);
        Line lineX2 = new Line(420, 100, 400, 90);
        Line lineX3 = new Line(420, 100, 400, 110);

        // x - axis labels
        Text xLabel = new Text(380, 70, "X");

        // y - axis
        Line lineY1 = new Line(200, 10, 200, 200);
        Line lineY2 = new Line(200, 10, 190, 30);
        Line lineY3 = new Line(200, 10, 210, 30);

        // y - axis labels
        Text yLabel = new Text(220, 20, "Y");

        // draw a sine curve
        Polyline polyline = new Polyline();
        for( double angle = -360 ; angle <= 360 ; angle++ ){
            polyline.getPoints().addAll(angle, Math.sin(Math.toRadians(angle)));
        }

        // set the properties of the polyline
        polyline.setStrokeWidth(1.0/25);

        polyline.setTranslateX(200);
        polyline.setTranslateY(100);

        polyline.setScaleX(0.5);
        polyline.setScaleY(50);

        // add the axis to the pane
        pane.getChildren().addAll(polyline, lineX1, lineX2, lineX3, xLabel, lineY1, lineY2, lineY3, yLabel);

        // create the scene
        Scene scene = new Scene(pane, 450, 200);

        // set the scene to the stage
        stage.setScene(scene);

        // set the properties of the stage
        stage.setTitle("Scaling Demo");

        // show the stage
        stage.show();

    }
}
