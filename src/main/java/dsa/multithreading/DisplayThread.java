package dsa.multithreading;

public class DisplayThread extends Thread {

    private final Display display;
    private final String name;

    public DisplayThread(Display display, String name) {
        this.display = display;
        this.name = name;
    }

    @Override
    public void run() {
        this.display.wish(this.name);
    }
}
