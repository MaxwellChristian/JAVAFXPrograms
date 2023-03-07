package com.maxwell.javafxprograms;

// 1. Extend the class from Application

// Concept:
// JAVA FX describes the UI in following components
// 1. Stage*
// 2. Scene*
// 3. Pane
// 4. Controls

// Write a FX program to display a button titled "OK"

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FirstDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        // create controls (a button)
        Button btnOK = new Button("OK");

        // create a scene to hold the controls (button)
        Scene scene = new Scene(btnOK, 200, 200);

        // set the properties of the stage
        stage.setTitle("First Demo");

        // add the scene to the stage
        stage.setScene(scene);

        // show the stage
        stage.show();
    }

    public static void main(String []args){
        Application.launch(args);
    }
}
