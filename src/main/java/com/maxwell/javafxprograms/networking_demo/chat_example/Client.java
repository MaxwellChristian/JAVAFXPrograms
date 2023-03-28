package com.maxwell.javafxprograms.networking_demo.chat_example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public abstract class Client extends Application {
    private static Socket socket;
    private static DataOutputStream out;
    private  static DataInputStream in;


    protected abstract String getName();

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane paneforText = new BorderPane();
        paneforText.setPadding(new Insets(5,5,5,5));
        paneforText.setStyle("-fx-border-color: green");
        paneforText.setLeft(new Label("Enter a message: "));

        TextField tf = new TextField();
        tf.setAlignment(Pos.CENTER_LEFT);
        paneforText.setCenter(tf);

        BorderPane pane = new BorderPane();
        TextArea ta = new TextArea();
        ta.setPrefColumnCount(80);
        ta.setEditable(false);
        pane.setCenter(new javafx.scene.control.ScrollPane(ta));
        pane.setTop(paneforText);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 450, 200);
        stage.setTitle("Client"+" - "+getName()); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage

        tf.requestFocus();
        stage.setOnCloseRequest(e->{
            try {
                out.writeUTF(MountPoint.BYE);
                out.flush();
                socket.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            finally {
                Platform.exit();
                System.exit(0);
            }
        });

        tf.setOnAction(e->{
            try {
                String msg = tf.getText().trim();
                out.writeUTF(msg);
                ta.appendText(String.format("%"+ta.getPrefColumnCount()+"s","You: "+msg+"\n"));
                tf.setText("");
                tf.requestFocus();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


        new Thread(()->{
            try {
                socket = new Socket("localhost",8000);
                out = new DataOutputStream(socket.getOutputStream());
                in = new DataInputStream(socket.getInputStream());
                out.writeUTF(getName());
                while(true)
                {
                    String msg = in.readUTF();
                    Platform.runLater(()->{
                        ta.appendText(msg+"\n");
                    });
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }).start();
    }

}
