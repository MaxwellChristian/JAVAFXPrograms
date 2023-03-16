package com.maxwell.javafxprograms;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SplitPaneDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {


        VBox vBox = new VBox(10);

        // Radio Button with country names
        RadioButton rbUS = new RadioButton("US");
        RadioButton rbCA = new RadioButton("CA");
        RadioButton rbUK = new RadioButton("UK");

        vBox.getChildren().add(rbUS);
        vBox.getChildren().add(rbCA);
        vBox.getChildren().add(rbUK);

        // Split pane
        SplitPane splitPaneForButtons = new SplitPane();
        splitPaneForButtons.setOrientation(Orientation.VERTICAL);

        // Buttons for country description

        StackPane spUS = new StackPane();
        spUS.getChildren().add(new Button("US Description"));

        StackPane spCA = new StackPane();
        spCA.getChildren().add(new Button("CA Description"));

        StackPane spUK = new StackPane();
        spUK.getChildren().add(new Button("UK Description"));

        splitPaneForButtons.getItems().add(spUS);
        splitPaneForButtons.getItems().add(spCA);
        splitPaneForButtons.getItems().add(spUK);

        TextArea taDescription = new TextArea("Description is displayed here");
        splitPaneForButtons.getItems().add(new ScrollPane(taDescription));

        SplitPane splitPane = new SplitPane();
        splitPane.getItems().add(vBox);
        splitPane.getItems().add(splitPaneForButtons);

        // scene
        Scene scene = new Scene(splitPane, 300, 250);

        stage.setScene(scene);
        stage.setTitle("Split pane demo");

        stage.show();


        // toggle group for all radio buttons
        ToggleGroup rbGroup = new ToggleGroup();
        rbUS.setToggleGroup(rbGroup);
        rbCA.setToggleGroup(rbGroup);
        rbUK.setToggleGroup(rbGroup);


        rbCA.setOnAction(actionEvent -> taDescription.setText("This is CANADA"));

        rbUS.setOnAction(actionEvent -> taDescription.setText("This is United States of America"));

        rbUK.setOnAction(actionEvent -> taDescription.setText("This is United Kingdom"));

    }
}
