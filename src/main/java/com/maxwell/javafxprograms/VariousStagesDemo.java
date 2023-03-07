package com.maxwell.javafxprograms;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class VariousStagesDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        // create controls to add to scene
        Button btnFirst = new Button("First Button");
        Button btnSecond = new Button("Second Button");

        // create scene to hold controls
        Scene scene1 = new Scene(btnFirst, 200, 200);
        Scene scene2 = new Scene(btnSecond, 100, 100);

        // set the properties of stage
        stage.setTitle("First Stage");

        Stage secondStage = new Stage();
        secondStage.setTitle("Second Stage");

        // add the scene to stage
        stage.setScene(scene1);
        secondStage.setScene(scene2);

        // show the stage
        stage.show();
        secondStage.show();
    }

    public static void main(String []args){
        Application.launch(args);
    }
}
