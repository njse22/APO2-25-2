package ui;

public class Main2 {

    private static int counter = 0;
    public static void main(String[] args) {

         try {
            Thread th1 = new Thread(() ->{
                    //try {
                        for (int i = 0; i < 1000; i++) {
                            System.out.println("Contador: " + i);
                            counter++;
                            //Thread.sleep(1000);
                        }
                    //} catch (InterruptedException e) {
                    //    throw new RuntimeException(e);
                    //}
            });

            Thread th2 = new Thread(() -> {
                //try {
                    for (int i = 0; i < 1000; i++) {
                        System.out.println("Contador 2: " + i);
                        counter++;
                        // Thread.sleep(1000);
                    }

                // }catch (InterruptedException e){
                //     e.printStackTrace();
                // }
            });

            th1.start();
            th2.start();
            th1.join();
            th2.join();
            System.out.println("counter: " + counter);
            System.out.println("FIN del método MAIN ");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
