package org.icesi.canvas.entities;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Mira extends Thread{
    private double x;
    private double y;
    private double width;
    private double height;
    private boolean isLive;

    private Canvas canvas;
    private GraphicsContext gc;

    public Mira(double x, double y, double width, double height, Canvas canvas) {
        this.gc = canvas.getGraphicsContext2D();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        isLive = true;

    }

    @Override
    public void run(){
        while (isLive){
            try {
                //x += 10;
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void paint() {
        gc.setFill(Color.BLUE);
        gc.fillRect(x, y, width, height);
    }

    public void onMove(){
    }

    public void setOnMouseMoved(MouseEvent e){
        this.x = e.getX();
        this.y = e.getY();
    }


    public void setIsLive(boolean isLive) {
        this.isLive = isLive;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x + width/2;
    }

    public double getY() {
        return y + height/2;
    }
}
