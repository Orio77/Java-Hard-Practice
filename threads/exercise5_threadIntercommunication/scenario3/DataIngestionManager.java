package threads.exercise5_threadIntercommunication.scenario3;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

class DataIngestionManager {
    private int numberOfThreads;
    private List<Thread> threads;

    public void startIngestionPipeline() {
        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(() -> {
                System.out.println("Ingesting data");

            });
            threads.add(thread);
            thread.start();
        }
    }

    public void stopIngestionPipeline() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}

class SynchronizedDataIngestionManager {
    private int numberOfThreads;
    private List<Thread> threads;

    public synchronized void synchronizedIngestionStart() {
        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(() -> {
                System.out.println("Ingesting data");

            });
            threads.add(thread);
            thread.start();
        }
    }

    public synchronized void synchronizedIngestionStop() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}

class ThreadPoolDataIngestionManager {
    private ExecutorService executorService;

    public void startIngestionWithThreadPool(int numberOfThreads) {
        for (int i = 0; i < numberOfThreads; i++) {
            executorService.submit(() -> {
                System.out.println("Ingesting data");
            });
        }
    }

    public void stopIngestionWithThreadPool() {
        executorService.shutdown();
    }
}

class ConcurrencyUtilitiesDataIngestionManager {
    private int numberOfThreads;
    private ExecutorService executorService;
    private AtomicBoolean pause;

    public void startIngestionWithConcurrencyUtilities() {
        for (int i = 0; i < numberOfThreads; i++) {
            executorService.submit(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    if (!pause.get()) {
                        System.out.println("Ingesting data");
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }
    }

    public void pauseIngestion() {
        pause.set(true);
    }

    public void stopIngestionWithConcurrencyUtilities() {
        executorService.shutdown();
    }
}
