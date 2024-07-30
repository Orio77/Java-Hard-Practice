package threads.exercise1_multithreading.scenario3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

class ThreadSynchronizationAndCommunication {
    private List<Object> dataset;

    public ThreadSynchronizationAndCommunication(List<Object> dataset) {
        this.dataset = dataset;
    }

    public void processDataInParallel() {
        synchronized(this) {
            Queue<Object> queue = new LinkedList<>(dataset);

            while (!queue.isEmpty()) {
                new Thread(() -> {
                    System.out.println("Processing data of type " + queue.poll().getClass().toString());
                });
            }
        }
    }

    public void communicateBetweenThreads() {
        
        new Thread(() -> {
            synchronized(dataset) {
                Iterator<Object> iterator = dataset.iterator();
                while (iterator.hasNext()) {
                    System.out.println("Updating element " + iterator.next());
                }
            }
        }).start();

        new Thread(() -> {
            synchronized(dataset) {
                Iterator<Object> iterator = dataset.iterator();
                while (iterator.hasNext()) {
                    System.out.println("Checking element for updates " + iterator.next());
                }
            }
        }).start();
    }
}

class ThreadPoolAndConcurrencyUtilities {
    private int poolSize;

    public ThreadPoolAndConcurrencyUtilities(int poolSize) {
        this.poolSize = poolSize;
    }

    public void createThreadPool() {
        Executors.newFixedThreadPool(poolSize);
    }

    public void utilizeConcurrencyUtilities() {
        new CountDownLatch(3);
        new Semaphore(poolSize);
        new CyclicBarrier(poolSize);
    }
}

class AtomicVariablesAndLockObjects {
    private AtomicInteger atomicCounter;
    private Object sharedResource;

    public AtomicVariablesAndLockObjects(AtomicInteger atomicCounter, Object sharedResource) {
        this.atomicCounter = atomicCounter;
        this.sharedResource = sharedResource;
    }

    public void useAtomicVariables() {
        atomicCounter.incrementAndGet();
    }

    public void manageLockObjects() {
        ReentrantLock lock = new ReentrantLock();

        lock.lock();
        try {
            System.out.println("Acquired shared resource at: " + sharedResource.toString());
        } finally {
            lock.unlock();
        }


    }
}

class ExecutorsForkJoinAndInterruptedException {
    private Callable<Object> task;
    private ForkJoinTask<Object> forkJoinTask;

    public ExecutorsForkJoinAndInterruptedException(Callable<Object> task, ForkJoinTask<Object> forkJoinTask) {
        this.task = task;
        this.forkJoinTask = forkJoinTask;
    }

    public void useExecutorsFramework() {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        executor.submit(task);

        executor.shutdown();
    }

    public void applyForkJoinFramework() {
        forkJoinTask.join();
    }

    public void handleInterruptedException(InterruptedException e) {
        Thread.currentThread().interrupt();
    }
}
