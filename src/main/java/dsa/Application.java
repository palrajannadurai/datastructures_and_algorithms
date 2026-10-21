package dsa;

import java.util.concurrent.*;

public class Application {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final int numOfCores = Runtime.getRuntime().availableProcessors();
        System.out.println(numOfCores);
        Callable<Integer> task = () -> numOfCores;
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> result = executor.submit(task);
        System.out.println(result.get());
        executor.shutdownNow();
    }
}
