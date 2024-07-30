package threads.exercise12_threadDebugging.scenario3;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

class WeatherDataProcessor {
    private List<Object> sharedResource;
    private BlockingQueue<Object> queue;

    public void synchronizeDataProcessing() {
        synchronized(sharedResource) {
            sharedResource.parallelStream().forEach(resource -> {
                System.out.println("Processing resource at: " + resource.toString());
                try {
                    queue.put(resource);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
    }

    public void communicateBetweenThreads() {
        while (!queue.isEmpty()) {
            new Thread(() -> {
                try {
                    Object resource = queue.take();
                    System.out.println("Thread " + Thread.currentThread().getName() + " processed resource at: " + resource.toString());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    }
}

class WeatherSimulation {
    private ExecutorService threadPool;
    private AtomicInteger predictions;

    public void createThreadPool(int size) {
        threadPool = Executors.newFixedThreadPool(size);
    }

    public void useAtomicVariables(int predictions) {

        for (int i = 0; i < predictions; i++) {
            while (!threadPool.isShutdown()) {
                threadPool.submit(() -> {
                    System.out.println("Calculating new weather prediction");
                    this.predictions.incrementAndGet();
                });
            }
        }

        threadPool.shutdown();
    }
}

class WeatherPrediction {
    private ExecutorService executorService;

    public void useExecutorsFramework(int predictions) {
        for (int i = 0; i < predictions; i++) {
            while (!executorService.isShutdown()) {
                executorService.submit(() -> {
                    System.out.println("Calculating new weather prediction");
                });
            }
        }

        executorService.shutdown();
    }

    public void handleInterruptedException(InterruptedException e) {
        Thread.currentThread().interrupt();
    }
}

class WeatherSimulationOptimization {
    private ForkJoinPool forkJoinPool;

    public void useForkJoinFramework() {
        forkJoinPool.invoke(new WeatherSimulationRecursiveTask());
    }

    public void manageThreadGroups() {
        int parallelism = Runtime.getRuntime().availableProcessors();
        forkJoinPool = new ForkJoinPool(parallelism);
    }

    public void tuneThreadPerformance() {
        ForkJoinPool.ForkJoinWorkerThreadFactory threadFactory = new ForkJoinPool.ForkJoinWorkerThreadFactory() {
            @Override
            public ForkJoinWorkerThread newThread(ForkJoinPool pool) {
                ForkJoinWorkerThread worker = ForkJoinPool.defaultForkJoinWorkerThreadFactory.newThread(pool);
                worker.setPriority(Thread.MAX_PRIORITY);
                return worker;
            }
        };

        forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors(), threadFactory, null, false);
    }
}

class WeatherSimulationRecursiveTask extends RecursiveTask<Void> {

    @Override
    protected Void compute() {
        System.out.println("Using machine learning for weather simultation");
        System.out.println("Prediction machine just got better");
        return null;
    }
}
