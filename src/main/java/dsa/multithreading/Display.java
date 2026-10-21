package dsa.multithreading;

public class Display {
    public synchronized void wish(String name) {
        for (int i = 0; i < 10; i++) {
            System.out.print("Good morning: ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name);
        }
        // 1 lakh line
    }
}
