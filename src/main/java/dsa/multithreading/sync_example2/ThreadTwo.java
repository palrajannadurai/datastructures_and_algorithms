package dsa.multithreading.sync_example2;

public class ThreadTwo extends Thread {

    private final Display display;

    public ThreadTwo(Display display) {
        this.display = display;
    }

    @Override
    public void run() {
        this.display.displayC();
    }
}
