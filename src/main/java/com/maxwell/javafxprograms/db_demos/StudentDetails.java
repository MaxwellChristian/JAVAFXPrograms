package com.maxwell.javafxprograms.db_demos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;

public class StudentDetails extends Application {

    // Statement for executing queries
    private Statement stmt;
    private TextField tfStudentID = new TextField();

    private Label lblStatus = new Label();

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Initialize database connection and create a Statement object
        initializeDB();

        Button btShowGrade = new Button("Show Level and Room");
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(
                new Label("Student ID"),
                tfStudentID,
                 btShowGrade);

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(hBox, lblStatus);

        tfStudentID.setPrefColumnCount(6);
        btShowGrade.setOnAction(e -> showGrade());

        // Create a scene and place it in the stage
        Scene scene = new Scene(vBox, 420, 80);
        primaryStage.setTitle("FindGrade"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }

    private void initializeDB() {
        try {
            // Load the JDBC driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//      Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver loaded");

            // Establish a connection
            Connection connection = DriverManager.getConnection
                    ("jdbc:ucanaccess://Students.accdb", "scott", "tiger");
//    ("jdbc:oracle:thin:@liang.armstrong.edu:1521:orcl",
//     "scott", "tiger");
            System.out.println("Database connected");

            // Create a statement
            stmt = connection.createStatement();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showGrade() {
        String studentID = tfStudentID.getText();
        try {

//            String query = "select field_list from table_list where condtion_list groupby field_list orderby field_list ";

//            String query = "" +
//                    "select " +
//                        "FirstName, " +
//                        "LastName, " +
//                        "Level, " +
//                        "Room " +
//                    "from " +
//                        "Students " +
//                    "where " +
//                        "StudentID = '" + tfStudentID.getText()+ "' " +
//                    "orderby " +
//                        "FirstName ASC, " +
//                        "LastName ASC ";

            String queryString = "" +
                    "select " +
                        "Students.LastName, " +
                        "Students.FirstName, " +
                        "Students.Level, " +
                        "Students.Room " +
                    "from " +
                        "Students " +
                    "where " +
                        "Students.StudentID = '" + tfStudentID.getText() + "'";

            ResultSet rset = stmt.executeQuery(queryString);

            if (rset.next()) {
                String lastName = rset.getString(1);
                String firstName = rset.getString(2);
                String level = rset.getString(3);
                String room = rset.getString(4);


                // Display result in a label
                lblStatus.setText(firstName + " " + lastName +
                        " " + "'s level on course is " + level + " and studies in room " +
                        room);
            } else {
                lblStatus.setText("Not found");
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
