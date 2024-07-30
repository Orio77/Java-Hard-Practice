package threads.exercise2_threadSynchronization.scenario2;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.stream.Collectors;

class ResourceMonitor {
    private int resources;

    public ResourceMonitor(int resources) {
        this.resources = resources;
    }

    public synchronized void allocateResources(int resources) {
        try {
            while (this.resources - resources < 0) {
                wait();
            }
            this.resources -= resources;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void releaseResources(int resources) {
        this.resources += resources;
    }
}

class ThreadPool {
    private ExecutorService executorService;

    public ThreadPool(int threads) {
        executorService = Executors.newFixedThreadPool(threads);
    }

    public void submitTask(Runnable task) {
        executorService.submit(task);
    }

    public void shutdown() {
        executorService.shutdown();
    }
}

class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
}

class Bank {
    private Lock bankLock;
    private Condition sufficientFunds;

    public Account createAccount(int balance) {
        return new Account(balance);
    }

    public void transfer(Account from, Account to, int amount) {
        bankLock.lock();
        try {
            while (from.getBalance() < amount) {
                wait();
            }

            sufficientFunds.signal();
            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void deposit(Account account, int amount) {
        synchronized(this) {
            account.setBalance(account.getBalance() + amount);
        }
    }
}

class ParallelSorter {

    public int[] sort(int[] array) {
        Arrays.parallelSort(array);
        return array;
    }

    public int[][] split(int[] array) {
        int size = (int) Math.sqrt(array.length);
        int[][] result = new int[size][size];

        for (int i = 0; i < array.length; i++) {
            result[i / size][i % size] = array[i];
        }

        return result;
    }

    public int[] merge(int[][] arrays) {
        int size = Arrays.stream(arrays).collect(Collectors.summingInt(array -> array.length));

        int[] array = new int[size];
        int currentPos = 0;

        for (int[] arr : arrays) {
            System.arraycopy(arr, 0, array, currentPos, arr.length);
            currentPos += arr.length;
        }
        

        return array;
    }
}
