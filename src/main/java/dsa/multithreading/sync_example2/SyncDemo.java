package dsa.multithreading.sync_example2;

public class SyncDemo {
    public static void main(String[] args) {
        Display display = new Display();
        ThreadOne t1 = new ThreadOne(display);
        ThreadTwo t2 = new ThreadTwo(display);
        t1.start();
        t2.start();
    }
}
