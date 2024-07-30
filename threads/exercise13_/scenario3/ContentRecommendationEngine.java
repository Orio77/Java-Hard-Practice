package threads.exercise13_.scenario3;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class UserThread extends Thread {
    private List<String> preferences;

    public List<String> getPreferences() {
        return preferences;
    }
}

class Task implements Runnable {
    private String content;
    private boolean isDone;

    @Override
    public void run() {
        System.out.println("Preforming task: " + content);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        isDone = true;
    }

    public String getContent() {
        return content;
    }
    public boolean isDone() {
        return isDone;
    }
}

class ContentRecommendationEngine {
    private UserThread userThread;

    public void processUserPreferences() {
        synchronized(userThread.getPreferences()) {
            for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
                new Thread(() -> {
                    while (!userThread.getPreferences().isEmpty()) {
                        String preference = userThread.getPreferences().get(new Random().nextInt(0, userThread.getPreferences().size()));
                        System.out.println("Processing preference: " + preference);
                    }
                }).start();
            }
        }
    }

    public void deliverRecommendations() {
        synchronized(userThread.getPreferences()) {
            for (int i = 0; i < 3; i++) {
                new Thread(() -> {
                    System.out.println("Analysing user's preferences");
                    System.out.println("Recommendation: " + userThread.getPreferences().remove(userThread.getPreferences().size()));
                }).start();
            }
        }
    }
}

class ThreadPoolContentRecommendationEngine {
    private ThreadPoolExecutor threadPool;
    private List<Task> tasks;

    public void createThreadPool(int numberOfThreads) {
        threadPool = new ThreadPoolExecutor(numberOfThreads, numberOfThreads, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    }

    public void assignTasksToThreadPool() {
        for (Task task : tasks) {
            threadPool.submit(task);
        }
    }
}

class ConcurrencyUtilitiesContentRecommendationEngine {
    private Semaphore semaphore;
    private CountDownLatch latch;

    public void useSemaphore() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void useCountDownLatch() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class ExecutorsFrameworkContentRecommendationEngine {
    private ExecutorService executorService;
    private ScheduledExecutorService scheduledExecutorService;
    private List<Task> tasks;

    public void createFixedThreadPool(int numberOfThreads) {
        executorService = Executors.newFixedThreadPool(numberOfThreads);
    }

    public void scheduleTasksWithFixedDelay(long delay) {
        for (Task task : tasks) {
            scheduledExecutorService.schedule(task, delay, TimeUnit.NANOSECONDS);
        }
    }

    public void shutdownExecutorService() {
        executorService.shutdown();
    }
}
