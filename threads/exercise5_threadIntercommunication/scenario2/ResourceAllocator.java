package threads.exercise5_threadIntercommunication.scenario2;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

class ResourceAllocator {
    private int resourcesLeft;

    public synchronized void allocateResource(int n) {
        synchronized(this) {
            try {
                while (resourcesLeft - n < 0) {
                    wait();
                }

                resourcesLeft -= n;
                notify();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized void releaseResource(int n) {
        synchronized(this) {
            resourcesLeft += n;
        }
    }
}

class ExecutorServiceAllocator {
    ExecutorService executorService;

    public void startExecutorService(int threadPoolSize) {
        executorService = Executors.newFixedThreadPool(threadPoolSize);
    }

    public void stopExecutorService() {
        executorService.shutdown();
    }
}

class AtomicResourceAllocator {
    AtomicInteger resourceAvailability;

    public void atomicAllocateResource(AtomicInteger n) {
        try {
            while (resourceAvailability.get() - n.get() < 0) {
                wait();
            }

            int newResourceAvailability = resourceAvailability.get() - n.get();
            resourceAvailability.set(newResourceAvailability);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }   

    public void atomicReleaseResource(AtomicInteger n) {
        resourceAvailability.addAndGet(n.get());
    }
}

class ForkJoinAllocator {
    ForkJoinPool forkJoinPool;

    public void startForkJoinPool(int parallelismLevel) {
        forkJoinPool = new ForkJoinPool(parallelismLevel);
    }

    public void allocateResourceTask() {
        forkJoinPool.execute(new ResourceTask());
    }

    public void stopForkJoinPool() {
        forkJoinPool.shutdown();
        while (!forkJoinPool.isTerminated()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ResourceTask extends RecursiveTask<Void> {

    @Override
    protected Void compute() {
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
