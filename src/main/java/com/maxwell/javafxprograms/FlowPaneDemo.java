package com.maxwell.javafxprograms;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FlowPaneDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        // set the pane
        Pane pane = new FlowPane();
        pane.setPadding(new Insets(10, 10, 10, 10));

        // add nodes to pane
        pane.getChildren().add(new Label("Enter your message: "));
        pane.getChildren().add(new TextField());
        pane.getChildren().add(new Label("Your message"));

        // add the pane to the scene
        Scene scene = new Scene(pane, 200, 200);

        // set the properties of the stage
        stage.setTitle("Flow pane demo");

        // add the scene to the stage
        stage.setScene(scene);

        // show the stage
        stage.show();

    }


}
