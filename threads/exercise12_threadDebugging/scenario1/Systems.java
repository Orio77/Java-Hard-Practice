package threads.exercise12_threadDebugging.scenario1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

class Transaction {
    private int productId;
    private int quantity;

    public int getProductId() {
        return productId;
    }
    public int getQuantity() {
        return quantity;
    }
}

class InventorySystem {
    private Map<Integer, Integer> inventory;
    private ReentrantLock lock;

    public void processTransaction(int productId, int quantity) {
        lock.lock();
        try {
            while (inventory.get(productId) < quantity) {
                wait();
            }
            inventory.replace(productId, inventory.get(productId) - quantity);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void restockProduct(int productId, int quantity) {
        lock.lock();
        inventory.replace(productId, inventory.get(productId) + quantity);
        notifyAll();
    }
}

class ThreadPoolSystem {
    private ExecutorService threadPool;

    public void initThreadPool(int size) {
        threadPool = Executors.newFixedThreadPool(size);
    }
    public ExecutorService getThreadPool() {
        return threadPool;
    }
}

class AtomicInventorySystem {

    public void processTransaction(int productId, int quantity) {
        ThreadPoolSystem pool = new ThreadPoolSystem();
        pool.initThreadPool(quantity);

        pool.getThreadPool().submit(new Thread(() -> {
            InventorySystem system = new InventorySystem();
            system.processTransaction(productId, quantity);
        }));
    }

    public void restockProduct(int productId, int quantity) {
        ThreadPoolSystem pool = new ThreadPoolSystem();
        pool.initThreadPool(quantity);

        pool.getThreadPool().submit(new Thread(() -> {
            InventorySystem system = new InventorySystem();
            system.restockProduct(productId, quantity);;
        }));
    }
}

class ExecutorFrameworkSystem {
    private ExecutorService executorService;
    private ForkJoinPool forkJoinPool;

    public void initExecutorService(int size) {
        executorService = Executors.newFixedThreadPool(size);
    }

    public void processTransaction(int productId, int quantity) {
        executorService.submit(new Thread(() -> {
            InventorySystem system = new InventorySystem();
            system.processTransaction(productId, quantity);
        }));
    }

    public void processTransactionsInParallel(List<Transaction> transactions) {
        forkJoinPool.submit(new Thread(() -> {
            for (Transaction transaction : transactions) {
                processTransaction(transaction.getProductId(), transaction.getQuantity());
            }
        }));
    }
}
