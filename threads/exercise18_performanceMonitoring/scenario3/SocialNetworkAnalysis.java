package threads.exercise18_performanceMonitoring.scenario3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SocialNetworkData {
    private String id;

    public String getId() {
        return id;
    }
}

public class SocialNetworkAnalysis {
    private List<SocialNetworkData> dataset;
    private ExecutorService threadPool;
    private ForkJoinPool forkJoinPool;
    private AtomicInteger processedDataCount;

    public void processDataInParallel(List<SocialNetworkData> dataset, int numberOfThreads) {
        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(() -> {
                while (processedDataCount.get() <= dataset.size()) {
                    SocialNetworkData data = dataset.get(processedDataCount.getAndIncrement());
                    System.out.println("Processing data at " + data);
                }
            }).start();
        }
    }

    public void aggregateResults() {
        List<SocialNetworkData> results = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            threadPool.submit(() -> {
                while (processedDataCount.get() <= dataset.size()) {
                    SocialNetworkData data = dataset.get(processedDataCount.getAndIncrement());
                    System.out.println("Processing data at " + data);
                    results.add(data);
                }
            });
        }
        threadPool.shutdown();
    }

    private void resetDataCounter() {
        this.processedDataCount = new AtomicInteger();
    }

    public void createThreadPool(int numberOfThreads) {
        threadPool = Executors.newFixedThreadPool(numberOfThreads);
    }

    public void processData(List<SocialNetworkData> dataset) {
        List<SocialNetworkData> results = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            threadPool.submit(() -> {
                while (processedDataCount.get() <= dataset.size()) {
                    SocialNetworkData data = dataset.get(processedDataCount.getAndIncrement());
                    System.out.println("Processing data at " + data);
                    results.add(data);
                }
            });
        }
        threadPool.shutdown();
    }

    public void createExecutorService(int numberOfThreads) {
        threadPool = Executors.newFixedThreadPool(numberOfThreads);
    }

    public void submitTasks(List<SocialNetworkData> dataset) {
        for (SocialNetworkData socialNetworkData : dataset) {
            threadPool.submit(() -> {
                System.out.println("Task submitted for " + socialNetworkData.getId());
            });
        }
    }

    public void createForkJoinPool() {
        forkJoinPool = new ForkJoinPool();
    }

    public void createRecursiveTask(List<SocialNetworkData> dataset) {
        new SocialNetworkDataRecursiveTask(dataset);
    }

    public void invokeTask() {
        forkJoinPool.invoke(new SocialNetworkDataRecursiveTask(dataset));
    }
}

class SocialNetworkDataRecursiveTask extends RecursiveTask<Void> {
    private List<SocialNetworkData> dataset;

    public SocialNetworkDataRecursiveTask(List<SocialNetworkData> dataset) {
        this.dataset = dataset;
    }

    @Override
    protected Void compute() {
        if (dataset.size() > 1) {
            int mid = dataset.size() / 2;
    
            List<SocialNetworkData> dataset1 = dataset.subList(0, mid);
            List<SocialNetworkData> dataset2 = dataset.subList(mid, dataset.size()); 
    
            SocialNetworkDataRecursiveTask task1 = new SocialNetworkDataRecursiveTask(dataset1);
            SocialNetworkDataRecursiveTask task2 = new SocialNetworkDataRecursiveTask(dataset2);
    
            invokeAll(task1, task2);
        } else {
            System.out.println("Processing data at " + dataset.get(0));
        }

        return null;
    }
}
