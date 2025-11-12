package ui;

public class ContadorSincronizado {
    private int contador = 0;


    // El Mutex se aplica sobre TODO!! el método
    public synchronized void incrementar2() {
        contador++;
    }


    public  void incrementar() {
        // El Mutex se aplica únicamente sobre el fragmento de código
        synchronized (this){
            contador++;
        }
        System.out.println("HHHHH");
    }

    public int getContador() {
        return contador;
    }

    public static void main(String[] args) throws InterruptedException {
        ContadorSincronizado c = new ContadorSincronizado();

        // ANterior a Java 8
        Runnable task = new Runnable() {
            @Override
            public void run(){

            }
        };

        // Posterior a Java 11
        // Lambda Expression
        Runnable tarea = () -> {
            for (int i = 0; i < 10; i++)
                c.incrementar();
        };

        Thread h1 = new Thread(tarea);
        Thread h2 = new Thread(tarea);

        h1.start();
        h2.start();

        h1.join();
        h2.join();
        System.out.println("Resultado: " + c.getContador());
    }
}