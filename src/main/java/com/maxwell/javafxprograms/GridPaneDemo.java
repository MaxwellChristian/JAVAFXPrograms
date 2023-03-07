package com.maxwell.javafxprograms;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GridPaneDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        // create a grid pane
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHgap(5);
        pane.setVgap(5);

        // create controls
        Label lbl = new Label("Enter your message: ");

        TextField tf = new TextField();
        tf.setPrefColumnCount(10);

        Button btn = new Button("Show");

        // add controls to grid pane
        pane.add(lbl, 0, 0);
        // pane.add(tf, 0, 1);
        pane.add(tf, 1, 0);

        pane.add(btn, 1, 2);
        GridPane.setHalignment(btn, HPos.RIGHT);

        pane.add(new Button("HI"), 0, 2);

        // create a scene with the grid pane
        Scene scene = new Scene(pane, 400, 200);

        // add the scene to the stage
        stage.setScene(scene);

        // set the properties of the stage
        stage.setTitle("Grid Pane Demo");

        // show the stage
        stage.show();


    }
}
