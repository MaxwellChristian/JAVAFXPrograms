module com.maxwell.javafx_programs {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;
    requires java.desktop;

    opens com.maxwell.javafxprograms to javafx.fxml;

    exports com.maxwell.javafxprograms;

    exports com.maxwell.javafxprograms.clock_demo;
    exports com.maxwell.javafxprograms.event_handling;

    exports com.maxwell.javafxprograms.animation_demos;
    exports com.maxwell.javafxprograms.animation_demos.bouncing_ball;

    exports com.maxwell.javafxprograms.menu_demos;

    exports com.maxwell.javafxprograms.networking_demo;
    exports com.maxwell.javafxprograms.networking_demo.student_demo;
    exports com.maxwell.javafxprograms.networking_demo.tic_tac_toe;
    exports com.maxwell.javafxprograms.networking_demo.chat_example;

    exports com.maxwell.javafxprograms.db_demos;

    exports com.maxwell.javafxprograms.slot_machine_demo;

    exports com.maxwell.javafxprograms.class_tests.simulation_FL;


}