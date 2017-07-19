/**
 * Created by cassiano on 7/18/17.
 */
public class java01 {

    static void threadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        long threadPid = Thread.currentThread().getId();
        System.out.format("%d - %s: %s%n", threadPid, threadName, message);
    }

    private static class MessageLoop implements Runnable {

        public void run() {
            String importantInfo[] = {
                    "Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "A kid will eat ivy too"
            };
            try {
                for (int i = 0;
                     i < importantInfo.length;
                     i++) {
                    // Pause for 4 seconds
                    Thread.sleep(4000);
                    System.out.println("Executando thread");
                    // Print a message
                    threadMessage(importantInfo[i]);
                }
            } catch (InterruptedException e) {
                threadMessage("I wasn't done!");
            }
        }
    }


    public static void main(String[] args) {

        System.out.println("Starting");

        //Criando uma thread"
        Thread here = new Thread(new SimpleThreads("here"));
        // inicializando a thread!!
        here.start();

        // Dont work, any object that is runnable need to be in a thread!
        SimpleThreads simple = new SimpleThreads("Second");


        //Need to be started
        Thread second = new Thread(simple);
        second.start();

        System.out.println("Here: " + here.isAlive());
        System.out.println("Second: " + second.isAlive());


        System.out.println("Finalizou");
    }


    public void executar1(String[] args) throws InterruptedException {
        // Delay, in milliseconds before
        // we interrupt MessageLoop
        // thread (default one hour).
        long patience = 1000 * 60 * 60;

        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        threadMessage("Waiting for MessageLoop thread to finish");
        // loop until MessageLoop
        // thread exits
        while (t.isAlive()) {
            threadMessage("Still waiting...");
            // Wait maximum of 1 second
            // for MessageLoop thread
            // to finish.
            t.join(1000);
            if (((System.currentTimeMillis() - startTime) > patience)
                    && t.isAlive()) {
                threadMessage("Tired of waiting!");
                t.interrupt();
                // Shouldn't be long now
                // -- wait indefinitely
                t.join();
            }
        }
        threadMessage("Finally!");
    }
}
