package threads.exercise11_performanceOptimization.scenario1;


import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

class ThreadManagement {
    private Thread thread1;
    private Thread thread2;
    private AtomicInteger sharedVariable;

    public void setPriorityAndStart() {
        thread1 = new Thread();
        thread2 = new Thread();

        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);

        thread1.start();
        thread2.start();
    }

    public void synchronizedIncrement() {
        synchronized(this) {
            sharedVariable.incrementAndGet();
        }
    }
}

class InterThreadCommunication {
    private Queue<Integer> sharedQueue;
    private int capacity;

    public void produce(int n) {
        try {
            for (int i = 1; i <= n; i++) {
                while (sharedQueue.size() == capacity) {
                    wait();
                }

                sharedQueue.add(i);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void consume() {
        try {
            while (sharedQueue.isEmpty()) {
                wait();
            }

            System.out.println(sharedQueue.poll());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class ThreadLocalUsage {
    private ThreadLocal<String> threadLocalVariable;

    public void setThreadLocal(String s) {
        this.threadLocalVariable.set(s);
    }

    public void printThreadLocal() {
        System.out.println(threadLocalVariable.get());
    }
}

class ExecutorsFramework {
    private ExecutorService executorService;

    public void executeTasks(List<Runnable> tasks) {
        for (Runnable runnable : tasks) {
            executorService.submit(runnable);
        }
    }

    public void scheduleTask(Runnable task, long delay) {
        try {
            executorService.wait(delay);
            executorService.submit(task);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void shutdownAndAwaitTermination() {
        executorService.shutdown();
    }
}