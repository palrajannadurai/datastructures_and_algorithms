package dsa.multithreading.itc;

public class ThreadB extends Thread {
    int total = 0;

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("2. The child thread starts calculation.");
            for (int i = 1; i <= 100; i++) {
                total += i;
            }
            System.out.println("3. The child thread completed calculation.");
            this.notify();
        }

    }
}
