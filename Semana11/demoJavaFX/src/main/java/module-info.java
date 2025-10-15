module org.icesi.demojavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.icesi.demojavafx to javafx.fxml;
    exports org.icesi.demojavafx;
    exports org.icesi.demojavafx.control;
    opens org.icesi.demojavafx.control to javafx.fxml;
}