package com.maxwell.javafxprograms;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BorderPaneDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        // create a new pane
        BorderPane pane = new BorderPane();

        // add the components to the pane
        pane.setTop(new MyPane("TOP"));
        pane.setBottom(new MyPane("BOTTOM"));
        pane.setLeft(new MyPane("LEFT"));
        pane.setRight(new MyPane("RIGHT"));

        // add content to center area
        //pane.setCenter(grPane);
        pane.setCenter(getCenterPane());

        // create a scene and add the pane to the scene
        Scene scene = new Scene(pane, 400, 200);

        // set the properties of the stage
        stage.setTitle("Border pane demo");

        // add the scene to the stage
        stage.setScene(scene);

        // show the stage
        stage.show();
    }

    private Node getCenterPane() {

        GridPane grPane = new GridPane();
        grPane.setAlignment(Pos.CENTER);
        grPane.setPadding(new Insets(10, 10, 10, 10));
        grPane.setHgap(5);
        grPane.setVgap(5);

        // create controls
        Label lbl = new Label("Enter your message: ");

        TextField tf = new TextField();
        tf.setPrefColumnCount(10);

        Button btn = new Button("Show");

        // add controls to grid pane
        grPane.add(lbl, 0, 0);
        // pane.add(tf, 0, 1);
        grPane.add(tf, 1, 0);

        grPane.add(btn, 1, 2);
        GridPane.setHalignment(btn, HPos.RIGHT);

        grPane.add(new Button("HI"), 0, 2);

        return grPane;
    }
}

class MyPane extends StackPane {
    public MyPane(String message) {
        getChildren().add(new Label(message));
        setStyle("-fx-border-color: blue");
        setPadding(new Insets(10, 10, 10, 10));
    }
}