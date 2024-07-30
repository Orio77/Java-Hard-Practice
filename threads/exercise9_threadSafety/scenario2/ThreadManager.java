package threads.exercise9_threadStates.scenario2;

import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadManager {
    

    public synchronized void waitForThreads(Thread[] threads) {
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void checkThreadStates(Thread[] threads) {
        for (Thread thread : threads) {
            System.out.println(thread.getState());
        }
    }

    public synchronized void synchronizedMethod() {
        System.out.println("Current thread " + Thread.currentThread().getName() + " is in the state of: " + Thread.currentThread().getState());
    }

    public void printThreadStates(Thread[] threads) {
        Arrays.stream(threads).parallel().forEach(thread -> {
            System.out.println(thread.getState());
        });
    }

    public void executeInThreadPool(ThreadPoolExecutor executor, Runnable task) {
        executor.submit(task);
    }

    public void shutdownAndAwaitTermination(ThreadPoolExecutor pool) {
        pool.shutdown();

        try {
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                pool.shutdownNow();
                if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                    System.err.println("Pool did not terminate");
                }
            }
        } catch (InterruptedException e) {
            pool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public ThreadPoolExecutor createThreadPool(int corePoolSize, int maximumPoolSize) {
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 100000, TimeUnit.NANOSECONDS, new LinkedBlockingQueue<>());
    }

    public void executeTasks(ThreadPoolExecutor executor, Runnable[] tasks) {
        for (Runnable runnable : tasks) {
            executor.submit(runnable);
        }
    }

    public void shutdownPool(ThreadPoolExecutor executor) {
        executor.shutdown();
    }
}
