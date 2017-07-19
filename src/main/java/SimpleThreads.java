/**
 * Created by cassiano on 7/18/17.
 */
public class SimpleThreads implements Runnable {

    private String message;
    private int maxTime = 666666;

    public SimpleThreads(String message) {
        this.message = message;
    }

    public void run() {

        try {
            for (int i = 0; i < this.maxTime; i++) {
                Thread.sleep(10);
                System.out.print(".");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.format("%s - %s \n", Thread.currentThread().

                getName(), this.message);
    }
}
