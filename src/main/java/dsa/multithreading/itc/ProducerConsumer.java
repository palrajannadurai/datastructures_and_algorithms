package dsa.multithreading.itc;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    private static final int CAPACITY = 5;
    private final Queue<Integer> queue = new LinkedList<>();

    private void produce(int value) throws InterruptedException {
        synchronized (queue) {
            while (queue.size() == CAPACITY) {
                queue.wait(); // if the queue got full. Thread goes to WAITING. Release the monitor
            }
            queue.add(value);
            System.out.println("Produce: " + value);
            queue.notifyAll(); // wake consumers
        }
    }

    private int consume() throws InterruptedException {
        synchronized (queue) {
            while (queue.isEmpty()) {
                queue.wait();
            }
            int value = queue.poll();
            System.out.println("Consumed: " + value);
            queue.notifyAll(); // wakes producers
            return value;
        }
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();

        new Thread(() -> {
            try {
                for (int i = 0; ; i++) {
                    pc.produce(i);
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        new Thread(() -> {
            try {
                while (true) {
                    pc.consume();
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}
