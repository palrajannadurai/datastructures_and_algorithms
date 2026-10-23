package dsa.multithreading.deadlock;

public class A {
    public synchronized void d1(B b) {
        System.out.println("Thread-1 starts executing method d1().");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread-1 trying to execute B's last() method.");
        b.last();
    }

    public synchronized void last() {
        System.out.println("Inside A's last() method.");
    }
}
