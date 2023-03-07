package com.maxwell.javafxprograms;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BoxDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        // Create a border pane
        BorderPane pane = new BorderPane();

        // Place nodes in the pane
        pane.setTop(getHBox());
        pane.setLeft(getVBox());

        // create a scene
        Scene scene = new Scene(pane);

        // set the scene to the stage
        stage.setScene(scene);

        // set the properties of the stage
        stage.setTitle("H and V Box Demo");

        // show the stage
        stage.show();

    }

    private Node getVBox() {
        VBox vBox = new VBox(15); // Create a VBox with 15px spacing
        vBox.setPadding(new Insets(15, 5, 5, 5));
        vBox.getChildren().add(new Label("Courses"));

        Label[] courses = {new Label("CSCI 1301"), new Label("CSCI 1302"),
                new Label("CSCI 2410"), new Label("CSCI 3720")};

        for (Label course: courses) {
            VBox.setMargin(course, new Insets(0, 0, 0, 15));
            vBox.getChildren().add(course);
        }

        return vBox;
    }

    private Node getHBox() {
        HBox hBox = new HBox(15); // Create an HBox with 15px spacing
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: gold");
        hBox.getChildren().add(new Button("Computer Science"));
        hBox.getChildren().add(new Button("Chemistry"));
//        ImageView imageView = new ImageView(new Image("image/us.gif"));
//        hBox.getChildren().add(imageView);
        return hBox;
    }
}
