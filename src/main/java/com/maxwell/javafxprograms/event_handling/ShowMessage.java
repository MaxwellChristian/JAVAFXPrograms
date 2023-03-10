package com.maxwell.javafxprograms.event_handling;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ShowMessage extends Application {

    static TextField tfMessage;
    static Label lblMessage;
    @Override
    public void start(Stage stage) throws Exception {

        // pane to hold the controls
        Pane pane = new FlowPane();

        // controls to be used

        // label to prompt
        Label lbl = new Label("Enter your message: ");

        // text field for capturing user message
        tfMessage = new TextField();
        tfMessage.setPrefColumnCount(50);

        // button to transfer/show the user message
        // from text field to adjacent label
        Button btnShow = new Button("Show");

        // label to show the user message
        lblMessage = new Label();

        // set the handler with the button

        // the handler is defined by a custom class
        MuButtonHandler btnHandler = new MuButtonHandler();
        btnShow.setOnAction(btnHandler);

        // add the controls to the pane
        pane.getChildren().addAll(lbl, tfMessage, btnShow, lblMessage);

        // create a scene to add the pane
        Scene scene = new Scene(pane);

        // add the scene to the stage
        stage.setScene(scene);

        // set the properties of the stage
        stage.setTitle("Message display");

        // show the stage
        stage.show();
    }

}
class MuButtonHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        // System.out.println("Button clicked");

        // transfer the message from the text field to the label
        // System.out.println(ShowMessage.tfMessage.getText());
        ShowMessage.lblMessage.setText(ShowMessage.tfMessage.getText());
    }
}