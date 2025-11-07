package org.icesi.canvas.entities;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Rec extends Thread{
    private double x;
    private double y;
    private double width;
    private double height;
    private boolean isLive;

    // Eventos de teclado
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;

    private ArrayList<Image> runs;
    private ArrayList<Image> idles;
    private int frame;
    private int state;

    private Canvas canvas;
    private GraphicsContext gc;

    public Rec(double x, double y, double width, double height, Canvas canvas) {
        this.gc = canvas.getGraphicsContext2D();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        runs = new ArrayList<>(6);
        idles = new ArrayList<>(4);
        frame = 1;
        isLive = true;

        for (int i = 0; i < 6; i++) {
            Image img = new Image(
                    getClass().getResourceAsStream("/images/hero/run/adventurer-run-0"+i+".png"),
                    this.width,
                    this.height, true, true);
            runs.add(img);
        }

        for (int i = 0; i < 4; i++) {
            Image img = new Image(
                    getClass().getResourceAsStream("/images/hero/idle/adventurer-idle-2-0"+i+".png"),
                    this.width,
                    this.height, true, true);
            idles.add(img);
        }
    }

    @Override
    public void run(){
        while (isLive){
            try {
                //x += 10;
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void paint() {
        onMove();
        if (state == 0){
            gc.drawImage(idles.get(frame%idles.size()), x, y);
        }
        else if (state == 1){
            gc.drawImage(runs.get(frame%6), x, y);
        }
        frame++;
    }

    public void onMove(){
        if (up){
           y -= 10;
        }
        if(down){
            y += 10;
        }
        if(left){
            x -= 10;
        }
        if (right){
            x += 10;
        }
    }

    public void setOnKeyPressed(KeyEvent e) {
        // System.out.println(e.getCode());
        switch (e.getCode()){
            case UP -> {
                state = 1;
                up = true;
            }
            case DOWN -> {
                state = 1;
                down = true;
            }
            case LEFT -> {
                state = 1;
                left = true; }
            case RIGHT -> {
                state = 1;
                right = true; }
        }
    }

    public void setOnKeyReleased(KeyEvent e) {
        switch (e.getCode()){
            case UP -> {
                state = 0;
                up = false;
            }
            case DOWN -> {
                state = 0;
                down = false; }
            case LEFT -> {
                state = 0;
                left = false; }
            case RIGHT -> {
                state = 0;
                right = false; }
        }
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
