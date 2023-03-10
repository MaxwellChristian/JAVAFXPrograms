package com.maxwell.javafxprograms.event_handling;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class OkAndCancelDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        // create a HBOX to hold two buttons

        HBox pane = new HBox(200);

        // set the alignment of the box
        pane.setAlignment(Pos.CENTER);

        // create the buttons to be used
        Button btnOk = new Button("OK");
        Button btnCancel = new Button("Cancel");

        // add the event handlers to the button

        // approach 1
        btnOk.setOnAction(actionEvent -> {
            System.out.println("User clicked the button: Ok");
        });

        // approach 2
        CancelHandler handlerForCancel = new CancelHandler();
        btnCancel.setOnAction(handlerForCancel);

        // add the buttons to the box
        pane.getChildren().addAll(btnOk, btnCancel);

        // create a scene to hold the pane
        Scene scene = new Scene(pane);

        // set the properties of the stage
        stage.setTitle("Button Click Demo");

        // set the scene to the stage
        stage.setScene(scene);

        // show the stage
        stage.show();

    }
}

class CancelHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("User clicked the button: Cancel");
    }
}
