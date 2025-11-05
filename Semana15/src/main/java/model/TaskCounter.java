package model;

public class TaskCounter implements Runnable {

    private String id;

    public TaskCounter(String id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(i + " " + id);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
