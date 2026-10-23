package dsa.multithreading.sync_block;

public class MyThread extends Thread {
    private final Display display;
    private final String name;

    public MyThread(Display display, String name) {
        this.display = display;
        this.name = name;
    }

    @Override
    public void run() {
        this.display.wish(this.name);
    }
}
