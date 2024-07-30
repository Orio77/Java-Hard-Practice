package threads.exercise3_threadPools.scenario1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
// AI Guided & AI Copied
class Task implements Runnable {
    @Override
    public void run() {
        
    }
}

class ThreadPool {
    private boolean isShutdown;
    private ExecutorService executor;

    public ThreadPool(int numThreads) {
        isShutdown = false;
        executor = Executors.newFixedThreadPool(numThreads);
    }

    void submitTask(Runnable task) {
        if (!isShutdown) {
            executor.submit(task);
        }
    }

    void shutdown() {
        if (!isShutdown) {
            executor.shutdown();
        }
    }
}

class SynchronizedThreadPool {
    private boolean isShutdown;
    private ExecutorService executor;
    private ReentrantLock lock;

    public SynchronizedThreadPool(int numThreads) {
        executor = Executors.newFixedThreadPool(numThreads);
        isShutdown = false;
        lock = new ReentrantLock();
    }

    synchronized void submitTask(Runnable task) {
        lock.lock();
        try {
            if (!isShutdown) {
                executor.submit(task);
            }
        } finally {
            lock.unlock();
        }
    }

    synchronized void shutdown() {
        lock.lock();
        try {
            if (!isShutdown) {
                executor.shutdown();
            } 
        } finally {
            lock.unlock();
        }
    }
}

class ConcurrencyUtilitiesThreadPool {
    private ExecutorService executor;
    private boolean isShutdown;

    public ConcurrencyUtilitiesThreadPool(int numThreads) {
        executor = Executors.newFixedThreadPool(numThreads);
        isShutdown = false;
    }

    <T> Future<T> submitTask(Callable<T> task) {
        if (!isShutdown) {
            return executor.submit(task);
        }
        else return null;
    }

    void shutdown() {
        if (!isShutdown) {
            executor.shutdown();
        }
    }
}

class ExecutorsFrameworkThreadPool {
    private ExecutorService executor;
    private boolean isShutdown;

    public ExecutorsFrameworkThreadPool(int numThreads) {
        executor = Executors.newFixedThreadPool(numThreads);
        isShutdown = false;
    }

    <T> Future<T> submitTask(Callable<T> task) {
        if (!isShutdown) {
            return executor.submit(task);
        }
        else return null;
    }

    void shutdown() {
        if (!isShutdown) {
            executor.shutdown();
        }
    }

    void awaitTermination(long timeout, TimeUnit unit) {
        try {
            executor.awaitTermination(timeout, unit);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}