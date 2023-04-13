package com.maxwell.javafxprograms.db_demos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;

public class StudentDetailsAUD extends Application {

    Connection connection;

    // Statement for executing queries
    private PreparedStatement stmt;
    private TextField tfStudentID = new TextField();
    private TextField tfStudentFirstName = new TextField();
    private TextField tfStudentLastName = new TextField();

    private Label lblStatus = new Label();

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Initialize database connection and create a Statement object
        initializeDB();

        Button btShowGrade = new Button("Show Level and Room");
        Button btAdd = new Button("Add");
        Button btUpdate = new Button("Update");
        Button btDelete = new Button("Delete");

        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(
                new Label("Student ID"),
                tfStudentID,

                new Label("First Name"),
                tfStudentFirstName,

                new Label("Last Name"),
                tfStudentLastName,

                 btAdd,
                 btUpdate,
                btDelete,
                 btShowGrade);

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(hBox, lblStatus);

        tfStudentID.setPrefColumnCount(6);
        tfStudentFirstName.setPrefColumnCount(20);
        tfStudentLastName.setPrefColumnCount(20);

        btShowGrade.setOnAction(e -> showGrade());

        btAdd.setOnAction(e -> addStudent());

        btUpdate.setOnAction(e -> updateStudent());
        btDelete.setOnAction(e -> deleteStudent());

        // Create a scene and place it in the stage
        Scene scene = new Scene(vBox, 420, 80);
        primaryStage.setTitle("FindGrade"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }

    private void deleteStudent() {
    }

    private void updateStudent() {
    }

    private void addStudent() {
        String query = "" +
                "insert into " +
                "Students " +
                    "( " +
                        "FirstName, " +
                        "LastName " +
                    ") " +
                "values " +
                    "( ?, ? )";

        try {

            stmt = connection.prepareStatement(query);

            stmt.setString(1, tfStudentFirstName.getText());
            stmt.setString(2, tfStudentLastName.getText());

            if(stmt.executeUpdate() != 0){
                System.out.println(stmt.getUpdateCount() + " : Record added");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    private void initializeDB() {
        try {
            // Load the JDBC driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//      Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver loaded");

            // Establish a connection
            connection = DriverManager.getConnection
                    ("jdbc:ucanaccess://Students.accdb", "scott", "tiger");
//    ("jdbc:oracle:thin:@liang.armstrong.edu:1521:orcl",
//     "scott", "tiger");
            System.out.println("Database connected");

//            String queryString = "" +
//                    "select " +
//                    "Students.LastName, " +
//                    "Students.FirstName, " +
//                    "Students.Level, " +
//                    "Students.Room " +
//                    "from " +
//                    "Students " +
//                    "where " +
//                    "Students.StudentID = '" + tfStudentID.getText() + "'";

            String queryString = "" +
                    "select " +
                    "Students.LastName, " +
                    "Students.FirstName, " +
                    "Students.Level, " +
                    "Students.Room " +
                    "from " +
                    "Students " +
                    "where " +
                        "Students.StudentID = ? " +
                    "AND " +
                        "Room = ?";

            // Create a statement

            stmt = connection.prepareStatement(queryString);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showGrade() {
        String studentID = tfStudentID.getText();
        try {

            stmt.setInt(2, 10);
            stmt.setString(1, studentID);


            ResultSet rset = stmt.executeQuery();

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
