package com.maxwell.javafxprograms;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class NodeStyleDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // create controls
        Button btnOK = new Button("OK");
        btnOK.setStyle("-fx-border-color: red;");

        // create a pane to hold the controls
        StackPane pane = new StackPane();
        // set the style of the pane
        pane.setStyle("-fx-border-color: red; -fx-background-color: lightgray");
        pane.setRotate(45);
        // add the controls to the pane [adding child components/nodes to the pane]
        pane.getChildren().add(btnOK);

        // create a scene to hold the controls [pane]
        Scene scene = new Scene(pane, 200, 200);

        // set the properties of the stage
        stage.setTitle("Stack Pane Demo");

        // add the scene to the stage
        stage.setScene(scene);

        // show the stage
        stage.show();
    }

    public static void main(String []args){
        Application.launch(args);
    }
}
