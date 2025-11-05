package org.icesi.canvas;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import org.icesi.canvas.entities.Rec;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Canvas canvas;
    private GraphicsContext gc;

    private Rec rectangle;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gc = canvas.getGraphicsContext2D();
        rectangle = new Rec(60, 60, 50, 50, canvas);
        rectangle.start();

        Platform.runLater(() -> {

            new Thread(() -> {
                for (int i = 0; i < 100; i+=10) {
                    try {
                        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                        //gc.setFill(Color.RED);
                        //gc.fillRect(0, i, 50, 50);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }).start();
        });



    }
}