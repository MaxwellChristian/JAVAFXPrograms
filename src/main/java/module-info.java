module com.maxwell.javafx_programs {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.maxwell.javafxprograms to javafx.fxml;
    exports com.maxwell.javafxprograms;
}