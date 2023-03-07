package com.maxwell.javafxprograms;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FlowPaneDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        // set the pane
        FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHgap(5);

        // add nodes to pane
        pane.getChildren().add(new Label("Enter your message: "));
        pane.getChildren().add(new TextField());
        pane.getChildren().add(new Label("Your message"));

        pane.getChildren().addAll(new Label("Label 1"), new TextField(), new Button("OK"));

        // add the pane to the scene
        Scene scene = new Scene(pane, 400, 200);

        // set the properties of the stage
        stage.setTitle("Flow pane demo");

        // add the scene to the stage
        stage.setScene(scene);

        // show the stage
        stage.show();

    }


}
