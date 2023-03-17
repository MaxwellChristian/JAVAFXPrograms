package com.maxwell.javafxprograms.menu_demos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ContextMenuDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {


        // create the content menu
        ContextMenu contextMenu = new ContextMenu();

        // create the menu items for the context menu
        MenuItem miNew = new MenuItem("New");
        MenuItem miOpen = new MenuItem("Open");
        MenuItem miPrint = new MenuItem("Print");
        MenuItem miExit = new MenuItem("Exit");

        // add the menu items to the context menu
        contextMenu.getItems().add(miNew);
        contextMenu.getItems().add(miOpen);
        contextMenu.getItems().add(miPrint);
        contextMenu.getItems().add(miExit);

        // create a pane
        Pane pane = new Pane();

        // add the context menu to the right click of the pane
        pane.setOnMousePressed(mouseEvent -> contextMenu.show(pane, mouseEvent.getScreenX(), mouseEvent.getScreenY()));

        // create a scene
        Scene scene = new Scene(pane, 300, 250);

        // set the scene in the stage
        stage.setScene(scene);

        // set the properties of the stage
        stage.setTitle("Context Menu Demo");

        // show the stage
        stage.show();
    }
}
