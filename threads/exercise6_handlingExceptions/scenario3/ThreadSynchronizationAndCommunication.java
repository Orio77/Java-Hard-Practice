package threads.exercise6_handlingExceptions.scenario3;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.List;

class ThreadSynchronizationAndCommunication {
    private Object sharedResource;

    public ThreadSynchronizationAndCommunication(Object sharedResource) {
        this.sharedResource = sharedResource;
    }

    public void synchronizedOperation() {
        synchronized(sharedResource) {
            System.out.println("Performing cryptographic Operation on object at " + sharedResource.toString());
            interThreadCommunication();
        }
    }

    public void interThreadCommunication() {
        synchronized(sharedResource) {
            notify();
        }
    }
}

class ThreadPoolAndExecutorsFramework {
    private List<Runnable> tasks;
    private long delay;
    private ExecutorService executor;
    private ScheduledExecutorService scheduledExecutor;

    public ThreadPoolAndExecutorsFramework(List<Runnable> tasks, long delay) {
        this.tasks = tasks;
        this.delay = delay;
    }

    public void executeWithThreadPool() {
        for (Runnable runnable : tasks) {
            executor.submit(runnable);
        }

        executor.shutdown();
    }

    public void scheduleTasks() {
        for (Runnable runnable : tasks) {
            scheduledExecutor.schedule(runnable, delay, TimeUnit.MILLISECONDS);
        }

        scheduledExecutor.shutdown();
    }
}

class LockObjectsAndAtomicVariables {
    private AtomicInteger operationsPerformed;
    private Object sharedResource;
    ReentrantLock lock;

    public LockObjectsAndAtomicVariables(Object sharedResource) {
        operationsPerformed = new AtomicInteger();
        this.sharedResource = sharedResource;
    }

    public void performAtomicOperation() {
        lock.lock();

        try {
            System.out.println("Performing cryptographic Operation on object at " + sharedResource.toString());
            operationsPerformed.incrementAndGet();
        } finally {
            lock.unlock();
        }

    }

    public void secureCriticalSection() {
        lock.lock();
        try {
            System.out.println("Performing cryptographic operation on critical section on object at " + sharedResource.toString());
            operationsPerformed.incrementAndGet();
        } finally {
            lock.unlock();
        }
    }
}

class ForkJoinAndParallelAlgorithms {
    private List<Object> dataset;
    private ForkJoinPool pool;

    public ForkJoinAndParallelAlgorithms(List<Object> dataset) {
        this.dataset = dataset;
    }

    public void processWithForkJoin() {
        for (Object object : dataset) {
            pool.invoke(new RecursiveDatabaseTask(object));
        }
    }

    public void implementParallelAlgorithm() {
        dataset.parallelStream().map(object -> object).toList();
    }

    public void optimizePerformance() {
        dataset.parallelStream().forEach(object -> {
            pool.invoke(new RecursiveDatabaseTask(object));
        });
    }
}

class RecursiveDatabaseTask extends RecursiveTask<Object> {
    private Object object;

    public RecursiveDatabaseTask(Object object) {
        this.object = object;
    } 

    @Override
    protected Object compute() {
        System.out.println("Processing object at " + object);
        return object;
    }
}
