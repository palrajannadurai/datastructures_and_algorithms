package dsa.multithreading.sync_block;

public class Display {
    public void wish(String name) {
        synchronized (Display.class) {
            for (int i = 0; i < 10; i++) {
                System.out.print("Good morning: ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(name);
            }
        }
        // 10 Lakh line of code
    }
}
