package dsa.tutorials;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {

        // Step 1: Create a latch with count = 3
        CountDownLatch latch = new CountDownLatch(5);

        // Step 2: Create worker threads
        for (int i = 1; i <= 3; i++) {
            int workerId = i;
            new Thread(() -> {
                try {
                    System.out.println("Worker " + workerId + " is working...");
                    Thread.sleep(10000 * workerId); // simulate work
                    System.out.println("Worker " + workerId + " finished.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // Step 3: Decrease the latch count
                    latch.countDown();
                }
            }).start();
        }

        // Step 4: Main thread waits
        System.out.println("Main thread waiting...");
        latch.await(); // blocks until count reaches 0

        // Step 5: Continues after all workers finish
        System.out.println("All workers finished. Main thread continues.");
    }
}
