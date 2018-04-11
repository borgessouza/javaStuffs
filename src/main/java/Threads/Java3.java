package Threads;

/**
 * Created by cassiano on 7/21/17.
 */
public class Java3 {


    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Test("T1"));
        Thread t3 = new Thread(new Test("T3"));
        Thread t4 = new Thread(new Test("T4"));
        Thread t5 = new Thread(new Test("T5"));
        Thread t6 = new Thread(new Test("T6"));
        Test t2 = new Test("T2");
        Thread tt2 = new Thread(t2);

        t1.start();
        //tt2.start();
       // t3.start();
        //t4.start();
        //t5.start();
       // t6.start();


       /*while (t1.isAlive() && tt2.isAlive()) {
           System.out.println("Not yet!!");
          try {
              Thread.sleep(100);
          } catch(Exception e){
              e.printStackTrace();
          }
       }*/

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
