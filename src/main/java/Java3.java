/**
 * Created by cassiano on 7/21/17.
 */
public class Java3 {


    public static void main(String[] args) {

        Thread t1 = new Thread(new Test("T1"));
        Test t2 = new Test("T2");
        Thread tt2 = new Thread(t2);

        t1.start();
        tt2.start();

        System.out.println("Finish");
    }

    public static class Test implements Runnable {
        private String message;

        public Test(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            System.out.println("Count");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.format("Message: %s\n", message);
        }


    }


}
