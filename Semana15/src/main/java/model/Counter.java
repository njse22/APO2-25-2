package model;

public class Counter extends Thread {

    private String id;

    public Counter(String id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 10 ; i++) {
            try {
                System.out.println(i + " " + id);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
