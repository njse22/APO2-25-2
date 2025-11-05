module org.icesi.canvas {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.icesi.canvas to javafx.fxml;
    exports org.icesi.canvas;

    opens org.icesi.canvas.entities to javafx.fxml;
    exports org.icesi.canvas.entities to javafx.fxml;
}