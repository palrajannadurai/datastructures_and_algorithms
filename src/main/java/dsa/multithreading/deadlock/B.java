package dsa.multithreading.deadlock;

public class B {
    public synchronized void d2(A a ) {
        System.out.println("Thread-2 starts executing method d2().");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread-2 trying to execute A's last() method.");
        a.last();
    }

    public synchronized void last() {
        System.out.println("Inside B's last() method.");
    }
}
