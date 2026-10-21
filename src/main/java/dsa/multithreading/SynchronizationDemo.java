package dsa.multithreading;

public class SynchronizationDemo {
    public static void main(String[] args) {
        Display displayOne = new Display();
        Display displayTwo = new Display();
        DisplayThread t1 = new DisplayThread(displayOne, "Dhoni");
        DisplayThread t2 = new DisplayThread(displayOne, "Sachin");
        DisplayThread t3 = new DisplayThread(displayOne, "Raina");
        DisplayThread t4 = new DisplayThread(displayOne, "Rahul");
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
