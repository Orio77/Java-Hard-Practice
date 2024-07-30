package threads.exercise16_memoryModel.scenario1;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AutomatedTradingSystem {

    // Task 1
    public void monitorMarket(String market) {
        int nThreads = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[nThreads];

        for (Thread thread : threads) {
            thread = new Thread(() -> {
                System.out.println("Analysing the cryptocurrency market");
            });
            thread.start();
        }
    }

    public synchronized void executeTrade(TradeOrder order) {
        order.execute();
    }

    // Task 2
    public void notifyTradeExecution() {
        notifyAll();
    }

    public void waitForTradeExecution() {
        try {
            while (Runtime.getRuntime().availableProcessors() == 0) {
                wait();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Task 3
    public ExecutorService createThreadPool(int numberOfThreads) {
        return Executors.newFixedThreadPool(numberOfThreads);
    }

    public void executeTrades(List<TradeOrder> orders) {
        ExecutorService executor = createThreadPool(Runtime.getRuntime().availableProcessors());
        for (TradeOrder tradeOrder : orders) {
            executor.submit(new Thread(() -> {
                executeTrade(tradeOrder);
            }));
        }
    }

    // Task 4
    public ExecutorService createExecutorService(int numberOfThreads) {
        return Executors.newFixedThreadPool(numberOfThreads);
    }

    public void executeTradesWithExecutorService(List<TradeOrder> orders) {
        ExecutorService executor = createThreadPool(Runtime.getRuntime().availableProcessors());
        for (TradeOrder tradeOrder : orders) {
            executor.submit(new Thread(() -> {
                executeTrade(tradeOrder);
            }));
        }
    }

    public void tunePerformance(List<TradeOrder> orders) {
        ExecutorService executor = createThreadPool(Runtime.getRuntime().availableProcessors());
    
        orders.stream().parallel().forEach(order -> {
            executor.submit(new Thread(() -> {
                executeTrade(order);
            }));
        });
    }
}

class TradeOrder {
    private int id;
    
    public void execute() {
        System.out.println("Trade " + id + "is being executed");
    }
}
