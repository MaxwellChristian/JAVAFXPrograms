package com.maxwell.javafxprograms.class_tests.simulation_FL;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cashier extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane paneForText = new BorderPane();
        paneForText.setPadding(new Insets(5,5,5,5));
        paneForText.setLeft(new Label("First Name:"));
        TextField tf = new TextField();
        tf.setAlignment(Pos.CENTER_LEFT);
        paneForText.setCenter(tf);


        BorderPane paneForText1 = new BorderPane();
        paneForText1.setPadding(new Insets(5,5,5,5));
        paneForText1.setLeft(new Label("First Name:"));
        TextField tf1 = new TextField();
        tf.setAlignment(Pos.CENTER_LEFT);
        paneForText1.setCenter(tf1);

        Button button = new Button("Send");

        VBox box = new VBox(10);
        box.getChildren().addAll(paneForText,paneForText1,button);

        Scene scene = new Scene(box, 450, 200);
        stage.setTitle("Cashier"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show();
        button.setOnAction(e->{
            Socket socket = null;
            try {
                socket = new Socket("localhost", 10001);
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                Order order=new Order(tf.getText().trim(),tf1.getText().trim());
                out.writeUTF(order.toString());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        });

    }
}
