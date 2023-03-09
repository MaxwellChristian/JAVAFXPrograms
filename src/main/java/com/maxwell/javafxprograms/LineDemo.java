package com.maxwell.javafxprograms;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class LineDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        // create a pane
        Pane pane = new LinePane();

        // create a scene
        Scene scene = new Scene(pane, 200, 200);

        // set the scene in the stage
        stage.setScene(scene);

        // set the properties of the stage
        stage.setTitle("Line Demo");

        // show the stage
        stage.show();

    }
}

class LinePane extends Pane {
    public LinePane() {

        // create line 1
        Line line1 = new Line();

        line1.setStartX(10);
        line1.setStartY(10);

        line1.endXProperty().bind(widthProperty().subtract(10));
        line1.endYProperty().bind(heightProperty().subtract(10));

        line1.setStrokeWidth(5);
        line1.setStroke(Color.GREEN);

        getChildren().add(line1);

        // create line 2
        Line line2 = new Line();

        line2.setStartX(10);
        line2.setStartY(10);

        line2.startXProperty().bind(widthProperty().subtract(10));
        line2.endYProperty().bind(heightProperty().subtract(10));

        line2.setStrokeWidth(15);
        line2.setStroke(Color.BLACK);

        getChildren().add(line2);

    }
}
