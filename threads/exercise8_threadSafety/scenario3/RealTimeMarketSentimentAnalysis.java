package threads.exercise8_threadSafety.scenario3;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

class RealTimeMarketSentimentAnalysis {
    private List<Thread> threads;

    public void startAnalysisThreads() {
        synchronized(threads) {
            Iterator<Thread> iterator = threads.iterator();
            
            if (iterator.hasNext()) {
                Thread thread = iterator.next();
                thread = new Thread(() -> {
                    System.out.println("Analysing social media");
                    // Simulate Social Media Analisys
                    try {
                        Thread.sleep(new Random().nextInt(1000, 5000));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });

                thread.start();
            }

            if (iterator.hasNext()) {
                Thread thread = iterator.next();
                thread = new Thread(() -> {
                    System.out.println("Analysing news feed");
                    // Simulate News Feed Analisys
                    try {
                        Thread.sleep(new Random().nextInt(1000, 5001));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });

                thread.start();
            }

            if (iterator.hasNext()) {
                Thread thread = iterator.next();
                thread = new Thread(() -> {
                    System.out.println("Analysing financial reports");
                    // Simulate Financial Reports Analisys
                    try {
                        Thread.sleep(new Random().nextInt(1000, 5000));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });

                thread.start();
            }
        }
    }

    public boolean waitForThreadsToComplete() {
        Iterator<Thread> iterator = threads.iterator();

        if (iterator.next().isAlive() || iterator.next().isAlive() || iterator.next().isAlive()) {
            return false;
        }

        return true;

    }
}

class SynchronizedRealTimeMarketSentimentAnalysis {
    private List<Thread> threads;
    private List<Integer> sharedData;

    public void analyzeAndStoreResults() {
        synchronized(sharedData) {
            for (Thread thread : threads) {
                thread = new Thread(() -> {
                    sharedData.add(new Random().nextInt());
                });
                thread.start();
            }
        }
    }

    public void printResults() {
        System.out.println(sharedData);
    }
}

class ExecutorsRealTimeMarketSentimentAnalysis {
    private ExecutorService executorService;
    private List<Integer> sharedData;

    public void startAnalysisTasks() {
        executorService.submit(() -> {
            System.out.println("Analysing social media");
            // Simulate Social Media Analisys
            try {
                Thread.sleep(new Random().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        executorService.submit(() -> {
            System.out.println("Analysing news feed");
            // Simulate News Feed Analisys
            try {
                Thread.sleep(new Random().nextInt(1000, 5001));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        executorService.submit(() -> {
            System.out.println("Analysing financial reports");
            // Simulate Financial Reports Analisys
            try {
                Thread.sleep(new Random().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    public void shutdownAndAwaitTermination() {
        executorService.shutdown();
        try {
            executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void printResults() {
        System.out.println(sharedData);
    }
}

class ForkJoinRealTimeMarketSentimentAnalysis {
    private ForkJoinPool forkJoinPool;
    private List<Integer> sharedData;

    public void divideAndConquer() {
        forkJoinPool.invoke(new AnalysisRecursiveTask(sharedData));
    }

    public void combineResults() {
        sharedData.stream().mapToInt(num -> num).sum();
    }

    public void printFinalResult() {
        System.out.println(sharedData);
    }
}

class AnalysisRecursiveTask extends RecursiveTask<Integer> {
    private final List<Integer> data;

    public AnalysisRecursiveTask(List<Integer> data) {
        this.data = data;
    }

    @Override
    protected Integer compute() {
        int mid = data.size() / 2;

        List<Integer> data1 = data.subList(0, mid);
        List<Integer> data2 = data.subList(mid, data.size());

        AnalysisRecursiveTask task1 = new AnalysisRecursiveTask(data1);
        AnalysisRecursiveTask task2 = new AnalysisRecursiveTask(data2);

        task1.fork();
        Integer result2 = task2.compute();
        Integer result1 = task1.join();

        return result1 + result2;
    }
}
