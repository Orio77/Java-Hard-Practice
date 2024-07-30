package threads.exercise19_documentation.scenario2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.locks.Lock;

public class GameServer {

    public synchronized List<String> synchronizedProcessing(List<String> requests) {
        List<String> processedRequests = new ArrayList<>();
        for (String request : requests) {
            System.out.println("Processing request: '" + request + "'");
            processedRequests.add(request);
        }
        return processedRequests;
    }

    public List<String> interThreadCommunication(List<String> requests, String signal) {
        List<String> processesRequests = new ArrayList<>();
        BlockingQueue<String> queue = new LinkedBlockingDeque<>();

        new Thread(() -> {
            for (String request : queue) {
                try {
                    queue.put(request);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        new Thread(() -> {
            while (true) {
                try {
                    String request = queue.take();
                    System.out.println("Processing request '" + request + "' with signal '" + signal + "'");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();

        return processesRequests;
    }

    public List<String> implementThreadPool(List<String> requests, int maxThreads) {
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        List<String> processedRequests = Collections.synchronizedList(new ArrayList<>());

        for (String request : requests) {
            executor.submit(() -> {
                System.out.println("Processing request: '" + request + "'");
                processedRequests.add(request);
            });
        }
        return processedRequests;
    }

    public List<String> avoidDeadlock(List<String> requests) {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<String> processedRequests = new ArrayList<>();

        for (String request : requests) {
            executor.submit(() -> {
                System.out.println("Processing request: '" + request + "'");
                processedRequests.add(request);
            });
        }
        return processedRequests;
    }

    public List<String> ensureThreadSafety(List<String> requests) {
        return avoidDeadlock(requests);
    }

    public List<String> useLockObjects(List<String> requests, Lock lock) {
        lock.lock();
        List<String> processedRequests = Collections.synchronizedList(new ArrayList<>());

        try {
            for (String request : requests) {
                System.out.println("Processing request: '" + request + "'");
                processedRequests.add(request);
            }
        } finally {
            lock.unlock();
        }
        return processedRequests;
    }

    public List<String> useExecutorsFramework(List<String> requests) {
        return avoidDeadlock(requests);
    }

    public List<String> useForkJoinFramework(List<String> requests) {
        ForkJoinPool pool = new ForkJoinPool();
        List<String> processedRequests = new ArrayList<>();

        for (String request : processedRequests) {
            processedRequests.add(pool.invoke(new PlayerRequestTask(request)));
        }
        return processedRequests;
    }

    public List<String> handleInterruptedException(List<String> requests) {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<String> processedRequests = new ArrayList<>();

        for (String request : requests) {
            executor.submit(() -> {
                try {
                    System.out.println("Processing request: '" + request + "'");
                    Thread.sleep(1);
                    processedRequests.add(request);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        return processedRequests;
    }
}

class PlayerRequestTask extends RecursiveTask<String> {
    private String request;

    public PlayerRequestTask(String request) {
        this.request = request;
    }

    @Override
    protected String compute() {
        try {
            System.out.println("Processing request: '" + request + "'");
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return request;
    }
}
