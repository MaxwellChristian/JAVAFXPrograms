package com.maxwell.javafxprograms.networking_demo.chat_example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Server extends Application {
    private Queue<String> queue = new LinkedList<>();
    private ArrayList<MountPoint> mps = new ArrayList<>();

    private TextArea ta = new TextArea();
    private void appendText(String s){
        Platform.runLater(()->{
            ta.appendText(s+"\n");
        });
    }
    @Override
    public void start(Stage stage) throws Exception {
        // Create a scene and place it in the stage
        Scene scene = new Scene(new javafx.scene.control.ScrollPane(ta), 450, 200);
        stage.setTitle("Server"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage
        stage.setOnCloseRequest(e->{
            Platform.exit();
            System.exit(0);
        });
        new Thread(()->{
            while(true)
            {
                if(queue.isEmpty()) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    continue;
                }
                String msg;
                synchronized (queue){msg = queue.remove();}
                synchronized (mps) {
                    for (MountPoint mp : mps) {
                        try {
                            mp.write(msg);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }

        }).start();

        //Start the server socket listening(accepting) thread
        new Thread(()->{
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                appendText("Server started.");
                while(true) {
                    Socket socket = serverSocket.accept();
                    //Start the thread for the IO of the client just connected
                    new Thread(()->{
                        try {
                            MountPoint mp = null;
                            mp = new MountPoint(socket);
                            synchronized (mps){ mps.add(mp);}
                            appendText(mp.getName()+ " is connected.");
                            while(mp.isConnected())
                            {
                                String msg = null;
                                msg = mp.read();
                                if (msg.equals(MountPoint.BYE)) break;
                                synchronized (queue){queue.add(msg);}
                                appendText(msg.replace(MountPoint.SEP,":"));
                            }
                            appendText(mp.getName()+ " is disconnected.");
                            synchronized (mps){ mps.remove(mp);}

                        }catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }).start();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }
}
