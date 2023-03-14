package com.maxwell.javafxprograms.clock_demo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ResizingClock extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        // Create a clock and a label
        ClockPane clock = new ClockPane();
        String timeString = clock.getHour() + ":" + clock.getMinute()
                + ":" + clock.getSecond();
        Label lblCurrentTime = new Label(timeString);

        // Place clock and label in border pane
        BorderPane pane = new BorderPane();
        pane.setCenter(clock);
        pane.setBottom(lblCurrentTime);
        BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);

        // Create a scene and place the pane in the stage
        Scene scene = new Scene(pane, 250, 250);
        stage.setTitle("DisplayClock"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage

        pane.widthProperty().addListener(ov ->
                clock.setWidth(pane.getWidth())
        );

        pane.heightProperty().addListener(ov ->
                clock.setHeight(pane.getHeight())
        );
    }
}
