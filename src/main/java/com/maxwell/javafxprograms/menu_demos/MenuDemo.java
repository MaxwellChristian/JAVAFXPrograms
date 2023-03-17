package com.maxwell.javafxprograms.menu_demos;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuDemo extends Application {

    TextField tfValue1;
    TextField tfValue2;
    TextField tfValueResult;
    @Override
    public void start(Stage stage) throws Exception {

        // create and add a menu to the stage

        // step 1: create a menu bar
        MenuBar menuBar = new MenuBar();

        // step 2: create menus with desired options
        Menu menuCalculations = new Menu("Calculations");
        Menu menuExit = new Menu("Exit");

        // step 2.1: add individual menu items to appropriate menus
        MenuItem miAdd = new MenuItem("Add");
        MenuItem miSubtract = new MenuItem("Subtract");
        MenuItem miMultiply = new MenuItem("Multiply");
        MenuItem miDivide = new MenuItem("Divide");

        menuCalculations.getItems().add(miAdd);
        menuCalculations.getItems().add(miSubtract);
        menuCalculations.getItems().add(miMultiply);
        menuCalculations.getItems().add(miDivide);

        MenuItem miClose = new MenuItem("Close");
        menuExit.getItems().add(miClose);

        // step 3: add the menus to the menu bar
        menuBar.getMenus().add(menuCalculations);
        menuBar.getMenus().add(menuExit);


        // create a container to store all the required controls
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);

        tfValue1 = new TextField();
        tfValue1.setPrefColumnCount(2);

        tfValue2 = new TextField();
        tfValue2.setPrefColumnCount(2);

        tfValueResult = new TextField();
        tfValueResult.setPrefColumnCount(5);

        hBox.getChildren().add(new Label("Number 1: "));
        hBox.getChildren().add(tfValue1);

        hBox.getChildren().add(new Label("Number 2: "));
        hBox.getChildren().add(tfValue2);

        hBox.getChildren().add(new Label("Result: "));
        hBox.getChildren().add(tfValueResult);

        // create a container to hold the menu bar and other content
        VBox vBox = new VBox();
        vBox.getChildren().add(menuBar);
        vBox.getChildren().add(hBox);

        // create a scene
        Scene scene = new Scene(vBox, 300, 250);

        // set the scene to the stage
        stage.setScene(scene);

        // set the properties of the stage
        stage.setTitle("Menu Demo");

        // show the stage
        stage.show();

        // perform actions on menu items
        miAdd.setOnAction(actionEvent -> performCalculation('+'));
        miSubtract.setOnAction(actionEvent -> performCalculation('-'));
        miMultiply.setOnAction(actionEvent -> performCalculation('*'));
        miDivide.setOnAction(actionEvent -> performCalculation('/'));

        miClose.setOnAction(actionEvent -> System.exit(0));

        // assign key combinations to menu items
        miAdd.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
        miSubtract.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
        miMultiply.setAccelerator(KeyCombination.keyCombination("Ctrl+M"));
        miDivide.setAccelerator(KeyCombination.keyCombination("Ctrl+D"));

        miClose.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));

    }

    private void performCalculation(char operation) {

        double value1 = Double.parseDouble(tfValue1.getText());
        double value2 = Double.parseDouble(tfValue2.getText());

        double result = 0;
        switch (operation){
            case '+' -> result = value1 + value2;
            case '-' -> result = value1 - value2;
            case '*' -> result = value1 * value2;
            case '/' -> result = value1 / value2;
        }

        tfValueResult.setText(result + "");

    }
}
