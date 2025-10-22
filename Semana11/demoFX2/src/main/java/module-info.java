module org.icesi.demofx2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.icesi.demofx2 to javafx.fxml;
    exports org.icesi.demofx2;
    exports org.icesi.demofx2.control;
    opens org.icesi.demofx2.control to javafx.fxml;
}