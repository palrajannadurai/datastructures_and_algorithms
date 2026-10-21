package dsa.multithreading.sync_example2;

public class ThreadOne extends Thread {

    private final Display display;

    public ThreadOne(Display display) {
        this.display = display;
    }

    @Override
    public void run() {
        this.display.displayN();
    }
}
