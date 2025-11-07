package org.icesi.canvas;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import org.icesi.canvas.entities.Mira;
import org.icesi.canvas.entities.Rec;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Canvas canvas;
    private GraphicsContext gc;
    private boolean isActive;

    private Rec rectangle;
    private Mira mira;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        isActive = true;
        initActions();
        gc = canvas.getGraphicsContext2D();
        rectangle = new Rec(60, 60, 100, 100, canvas);
        mira = new Mira(0, 0, 50, 50, canvas);

        // Logica de movimineto con los hilos
        rectangle.start();
        mira.start();


        Platform.runLater(() -> {

            new Thread(() -> {
                while (isActive) {
                    try {
                        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                        // Logica de pintado
                        rectangle.paint();
                        mira.paint();

                        gc.setFill(Color.RED);
                        gc.fillRect(250, 250, 50, 50);

                        double distance = Math.sqrt(
                                Math.pow(250 - rectangle.getX(), 2) + Math.pow(250 - rectangle.getY(), 2)
                        );

                        //System.out.println(distance);
                        if(distance < 40) {
                            rectangle.setY(rectangle.getY()-10);
                            //System.out.println("HOLA la distancia es baja");

                        }

                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }).start();
        });
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
        rectangle.setIsLive(isActive);
        mira.setIsLive(isActive);
    }

    public void initActions(){
        canvas.setOnKeyPressed( (event) -> {
            rectangle.setOnKeyPressed(event);
        });

        canvas.setOnKeyReleased( (event) -> {
            rectangle.setOnKeyReleased(event);
        });

        canvas.setOnMouseMoved( (event) -> {
            mira.setOnMouseMoved(event);
            System.out.println( event.getY());
            System.out.println( event.getX());
        });


    }

}