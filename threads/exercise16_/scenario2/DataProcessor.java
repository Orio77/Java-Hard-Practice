package threads.exercise16_.scenario2;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DataProcessor {
    private List<Thread> threads;
    private ExecutorService executor;

    public void processData(ConcurrentLinkedQueue<String> data) {
        for (Thread thread : threads) {
            thread = new Thread(() -> {
                System.out.println("Processing data: " + data.poll());
            });
            executor.submit(thread);
        }
    }

    public void waitForAll() throws InterruptedException {
        executor.shutdown();
        executor.awaitTermination(Short.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println("Finished all threads");
    }

    public synchronized void synchronizedProcessData(ConcurrentLinkedQueue<String> data) {
        processData(data);
    }

    public synchronized void waitForAllSynchronized() throws InterruptedException {
        waitForAll();
    }

    public void pooledProcessData(List<String> data) {
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (String string : data) {
            executor.submit(() -> {
                System.out.println("Processing data: " + string);
            });
        }
    }

    public void waitForAllPooled() throws InterruptedException {
        executor.shutdown();
        executor.awaitTermination(Short.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println("Finished all threads");
    }

    public void executorProcessData(List<String> data) {
        for (String string : data) {
            executor.submit(() -> {
                System.out.println("Processing data: " + string);
            });
        }
    }

    public void shutdownAndAwaitTermination() {
        try {
            waitForAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public List<Runnable> cancelAll() {
        return executor.shutdownNow();
    }
}
