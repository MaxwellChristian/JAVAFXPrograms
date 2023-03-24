package com.maxwell.javafxprograms.networking_demo.student_demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class StudentServer {

    private ObjectOutputStream outputToFile;
    private ObjectInputStream inputFromClient;

    public static void main(String[] args) {

        new StudentServer();

    }

    public StudentServer() {

        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8001);
            System.out.println("Server started ");

            // Create an object ouput stream
            outputToFile = new ObjectOutputStream(
                    new FileOutputStream("student.dat", true));

            while (true) {
                // Listen for a new connection request
                Socket socket = serverSocket.accept();

                // Create an input stream from the socket
                inputFromClient =
                        new ObjectInputStream(socket.getInputStream());

                // Read from input
                Object object = inputFromClient.readObject();

                // Write to the file
                outputToFile.writeObject(object);
                System.out.println("A new student object is stored");
            }
        } catch (ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                assert inputFromClient != null;
                inputFromClient.close();
                outputToFile.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}


