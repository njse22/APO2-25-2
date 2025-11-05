package ui;

import model.Counter;
import model.InterfaceExample;
import model.TaskCounter;

import javax.swing.plaf.TableHeaderUI;

public class Main {
    public static void main(String[] args) {

        Thread th1 = new Thread(Main::printer);
        th1.start();

        Thread th2 = new Thread(Main::printer);
        th2.start();

        Counter c1 = new Counter("Counter1");
        c1.start();

        Thread th3 = new Thread(new TaskCounter("TaskCounter"));
        th3.start();

        // una @FuntionalInterface -> Lambda expression
        InterfaceExample ie = (a, b) -> {
            return a + b;
        };

        Thread th4 = new Thread( () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println(i + " lambda");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Mensaje");

        });
        th4.start();

    }

    public static void printer(){
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
