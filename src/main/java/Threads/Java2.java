package Threads;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

/**
 * Created by cassiano on 7/20/17.
 */
public class Java2 {


    public static void main(String[] args) {
        System.out.println("Iniciando t1");
        new Thread(t1).start();
        System.out.println("Iniciando t2");
        new Thread(t2).start();


    }

    private static Runnable t1 = new Runnable() {

        private final int maxTime = 100;

        @Override
        public void run() {
            try {
                for (int i = 0; i < this.maxTime; i++) {
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.format("%s - %s \n", Thread.currentThread().getName(), "t1");
        }
    };


    private static Runnable t2 = new Runnable() {
        private final int maxTime = 100;

        @Override
        public void run() {
            try {
                for (int i = 0; i < this.maxTime; i++) {
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.format("%s - %s \n", Thread.currentThread().getName(), "t2");
        }
    };
}
