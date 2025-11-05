package org.icesi.canvas.entities;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Rec extends Thread{
    private double x;
    private double y;
    private double width;
    private double height;
    private Canvas canvas;
    private GraphicsContext gc;

    public Rec(double x, double y, double width, double height, Canvas canvas) {
        this.gc = canvas.getGraphicsContext2D();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void run(){
        paint();
    }

    public void paint() {
        for (int i = 0; i < 100; i+=10) {
            try {
                Image img = new Image(
                        Rec.class.getResourceAsStream("/images/img.png"),
                        50, 50, false, false
                );
                gc.drawImage(img, i, 60);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setX(double x) {
        this.x = x;
    }
}
