package dsa.multithreading.itc;

public class ThreadA {
    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        b.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (b) {
            System.out.println("1. Main thread trying call wait() method.");
            try {
                b.wait(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("4. The main thread got the notification");
            System.out.println("The total -> " + b.total);
        }

    }
}
