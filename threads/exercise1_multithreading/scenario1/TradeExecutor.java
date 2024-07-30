package threads.exercise1_multithreading.scenario1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
// AI Guided & AI Copied
class Trade {
    private ReentrantLock lock;
    private Condition condition;
    private int stocks;
    private boolean hasStock;

    public Trade() {
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
        this.stocks = 0;
        this.hasStock = false;
    }

    void buy() {
        lock.lock();
        try {
            hasStock = true;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    void sell(int num) {
        lock.lock();
        try {
            while (!hasStock) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    
            if (stocks - num >= 0) {
                stocks -= num;
            }
    
            hasStock = false;
        } finally {
            lock.unlock();
        }
    }
}

class TradeExecutor {
    private AtomicInteger totalStocks;
    private ExecutorService executorService;

    public TradeExecutor() {
        this.totalStocks = new AtomicInteger();
        this.executorService = Executors.newFixedThreadPool(10);
    }

    void executeBuy(int amount) {
        executorService.submit(() -> totalStocks.getAndAdd(amount));
    }

    void executeSell(int amount) {
        executorService.submit(() -> totalStocks.getAndAdd(amount*(-1)));
    }
}

class TradeManager {
    private ExecutorService executor;

    public TradeManager() {
        this.executor = Executors.newFixedThreadPool(5);
    }

    void startTrading() {
        if (this.executor == null || this.executor.isShutdown()) {
            this.executor = Executors.newFixedThreadPool(10);
        }
    }

    void stopTrading() {
        executor.shutdown();

        try {
            executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}

class ParallelTrader {
    private ForkJoinPool pool;
    private AtomicInteger totalStocks;

    public ParallelTrader() {
        this.pool = new ForkJoinPool();
        this.totalStocks = new AtomicInteger();
    }

    void buy(int amount) {
        pool.submit(() -> totalStocks.addAndGet(amount));
    }

    void sell(int amount) {
        pool.submit(() -> {
            int currentTotal;
            do {
                currentTotal = totalStocks.get();
                if (currentTotal < amount) {
                    throw new IllegalStateException("Not enough stocks to sell");
                }
            } while (!totalStocks.compareAndSet(currentTotal, currentTotal - amount));
        });
    }

    int getTotalStocks() {
        return totalStocks.get();
    }
}
