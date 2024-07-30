package threads.exercise4_concurrencyUtilities.scenario1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
// AI Guided & AI Copied
class Request {
    private final int id;

    public Request(int id) {
        this.id = id;
    }

    int getId() {
        return id;
    }
}

class Server {
    private BlockingQueue<Request> requestQueue;
    private boolean isProcessing;

    public Server() {
        requestQueue = new LinkedBlockingQueue<>();
        isProcessing = false;
    }

    private void processNextRequest() {
        if (!requestQueue.isEmpty()) {
            isProcessing = true;
            new Thread(() -> processRequest(requestQueue.poll())).start();
        }
        else
            isProcessing = false;
    }

    synchronized void addRequest(Request request) {
        requestQueue.add(request);
        if (!isProcessing) {
            processRequest(request);
        }
    }

    public void processRequest(Request request) {
        System.out.println("Started processing request " + request.getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Finished processing request " + request.getId());
        synchronized (this) {
            processNextRequest();
        }
    }
}

class Task implements Runnable {
    private int id;
    private long duration;

    public Task(int id, long duration) {
        this.id = id;
        this.duration = duration;
    }

    int getId() {
        return id;
    }

    long getDuration() {
        return duration;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(duration);
            System.out.println("Task " + id + " completed");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class ThreadPool {
    private BlockingQueue<Task> taskQueue;
    private List<Thread> workerThreads = new ArrayList<>();

    public ThreadPool(int numThreads) {
        taskQueue = new LinkedBlockingQueue<>();

        for (int i = 0; i < numThreads; i++) {
            Thread workerThread = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Task task = taskQueue.take();
                        task.run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });

            workerThread.start();
            workerThreads.add(workerThread);
        }
    }

    synchronized void submitTask(Task task) {
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    void shutdown() {
        for (Thread workerThread : workerThreads) {
            workerThread.interrupt();
        }
    }
}

class Counter {
    private AtomicInteger count;

    public Counter() {
        this.count = new AtomicInteger();
    }

    void increment() {
        count.incrementAndGet();
    }

    int getValue() {
        return count.get();
    }
}

class TaskExecutor {
    private ExecutorService executor;

    public TaskExecutor(int numThreads) {
        executor = Executors.newFixedThreadPool(numThreads);
    }

    void submitTask(Task task) {
        executor.submit(task);
    }

    void shutdown() {
        executor.shutdown();
    }

    void awaitTermination(int timeout) {
        try {
            executor.awaitTermination(timeout, TimeUnit.NANOSECONDS);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}