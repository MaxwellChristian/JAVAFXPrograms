package com.maxwell.javafxprograms.networking_demo.student_demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class StudentClient extends Application {


    TextField tfName = new TextField();
    TextField tfStreet = new TextField();
    TextField tfCity = new TextField();
    TextField tfState = new TextField();
    TextField tfZip = new TextField();

    Button btnRegister = new Button("Store to the server");

    String host = "localhost";

    @Override
    public void start(Stage stage) throws Exception {

        GridPane pane = new GridPane();

        pane.add(new Label("Name"), 0, 0 );
        pane.add(tfName, 1, 0);

        pane.add(new Label("Street"), 0, 1 );
        pane.add(tfStreet, 1, 1);

        pane.add(new Label("City"), 0, 2 );
        HBox hBox = new HBox(2);
        pane.add(hBox, 1, 2);

        hBox.getChildren().add(tfCity);

        hBox.getChildren().add(new Label("State"));
        hBox.getChildren().add(tfState);

        hBox.getChildren().add(new Label("ZIP"));
        hBox.getChildren().add(tfZip);

        pane.add(btnRegister, 1, 3);

        GridPane.setHalignment(btnRegister, HPos.RIGHT);

        pane.setAlignment(Pos.CENTER);

        tfName.setPrefColumnCount(15);
        tfStreet.setPrefColumnCount(15);
        tfCity.setPrefColumnCount(10);
        tfState.setPrefColumnCount(2);
        tfZip.setPrefColumnCount(3);

        btnRegister.setOnAction(new ButtonListener());

        // create the scene
        Scene scene = new Scene(pane, 450, 200);

        stage.setTitle("Student Registration");
        stage.setScene(scene);

        stage.show();

    }

    private class ButtonListener implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {

            try {
                // connect to the server
                Socket socket = new Socket(host, 8001);

                // create an output stream to send to server
                ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());

                // fetch the input from all text fields
                String name = tfName.getText().trim();
                String street = tfStreet.getText().trim();
                String city = tfCity.getText().trim();
                String state = tfState.getText().trim();
                String zip = tfZip.getText().trim();

                // create a student object to send to the server
                Student student = new Student(name, street, city, state, zip);

                // send the object to the server
                toServer.writeObject(student);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static void main(String []args){
        launch(args);
    }
}
