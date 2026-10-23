package dsa.multithreading.sync_block;

public class SyncBlockDemo {
    public static void main(String[] args) {
        Display d1 = new Display();
        Display d2 = new Display();
        MyThread t1 = new MyThread(d1, "Dhoni");
        MyThread t2 = new MyThread(d2, "Yuvi");
        t1.start();
        t2.start();
    }
}
