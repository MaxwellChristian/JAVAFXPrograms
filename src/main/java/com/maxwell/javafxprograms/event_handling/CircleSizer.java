package com.maxwell.javafxprograms.event_handling;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleSizer extends Application {

    private CirclePane circlePane = new CirclePane();
    @Override
    public void start(Stage stage) throws Exception {

        // create a box to hold buttons
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);

        // create the buttons to increase and decrease the size of shape
        Button btnInc = new Button("Increase");
        Button btnDec = new Button("Decrease");

        // add the buttons to the box
        hBox.getChildren().addAll(btnInc, btnDec);

        // create and register the handler

        // adding an anonymous class as handler
        btnInc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                circlePane.enlarge();
            }
        });

        // adding an inner class object as handler
        ShrinkHandler shrinkHandler = new ShrinkHandler();
        btnDec.setOnAction(shrinkHandler);

        // create a pane to hold the circle shape
        BorderPane pane = new BorderPane();
        pane.setCenter(circlePane);
        pane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        // create a scene to hold the pane
        Scene scene = new Scene(pane, 200, 150);

        // set the scene on the stage
        stage.setScene(scene);

        // set the properties of the stage
        stage.setTitle("Circle Size Changer");

        // show the stage
        stage.show();
    }

    private class ShrinkHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            circlePane.shrink();
        }
    }
}

class CirclePane extends StackPane {

    private Circle circle = new Circle(50);

    public CirclePane() {
        getChildren().add(circle);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.YELLOW);
    }

    public void enlarge(){
        circle.setRadius(circle.getRadius() + 2);
    }

    public void shrink(){
        circle.setRadius( circle.getRadius() > 2 ? circle.getRadius()-2 : circle.getRadius()  );
    }
}
