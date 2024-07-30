package threads.exercise9_threadStates.scenario1;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

class ThreadManager {
    private List<Thread> threads = new ArrayList<>();

    public void startThreadsInOrder(int n) {
        CountDownLatch latch = new CountDownLatch(n);
        
        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                finally {
                    latch.countDown();
                }
            });
            threads.add(thread);
            thread.start();
        }
    }

    public void stopThreadsInOrder() {
        Semaphore semaphore = new Semaphore(1);

        for (Thread thread : threads) {
            try {
                semaphore.acquire();
                thread.interrupt();
                thread.join();
                semaphore.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class SharedCounter {
    private AtomicInteger counter;

    public void synchronizedIncrement() {
        counter.incrementAndGet();
    }

    public void synchronizedDecrement() {
        counter.decrementAndGet();
    }
}

class ProducerConsumer {
    private Queue<Integer> sharedQueue;
    private int maxSize;

    public void produce(int n) {
        synchronized(sharedQueue) {
            while (sharedQueue.size() == maxSize) {
                try {
                    sharedQueue.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            for (int i = 0; i < n; i++) {
                sharedQueue.add(i);
            }

            sharedQueue.notifyAll();
        }
    }

    public void consume() {
        synchronized(sharedQueue) {
            while (sharedQueue.isEmpty()) {
                try {
                    sharedQueue.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                sharedQueue.poll();
                sharedQueue.notifyAll();
            }
        }
    }
}

class ThreadPoolManager {
    private ExecutorService threadPool;

    public void initThreadPool(int n) {
        threadPool = Executors.newFixedThreadPool(n);
    }

    public void executeTasks(int m) {
        for (int i = 0; i < m; i++) {
            threadPool.submit(new Thread(() -> {
                System.out.println("Thread is being executed!");
            }));
        }
    }

    public void shutdownThreadPool() {
        threadPool.shutdown();
    }
}
