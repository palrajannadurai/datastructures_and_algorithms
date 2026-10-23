package dsa.multithreading.sync_example2;

public class Display {

    private final Object object = new Object();

    public void displayN() {
        for (int i = 1; i <= 10; i++) {
            synchronized (this) {
                System.out.print(i);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void displayC() {
        for (int i = 65; i <= 75; i++) {
            synchronized (this) {
                System.out.print((char) i);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
