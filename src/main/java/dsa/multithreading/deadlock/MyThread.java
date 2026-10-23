package dsa.multithreading.deadlock;

public class MyThread extends Thread {
    A a = new A();
    B b = new B();

    public void m1() {
        this.start();
        a.d1(b);    // This code executed by main thread
    }

    @Override
    public void run() {
        b.d2(a); // This code executed by child thread
    }

    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.m1();
    }
}
