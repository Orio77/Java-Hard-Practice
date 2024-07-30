package threads.exercise17_concurrencyBestPractices.scenario2;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

class Transaction {
    private String id;

    public String getId() {
        return id;
    }
}

class Log {
    private String id;

    public String getId() {
        return id;
    }
}

class TransactionRecordSystem {
    private List<Transaction> processedTransactions;
    private ExecutorService threadPool;

    public void processTransactions(List<Transaction> transactions) {
        processedTransactions = Collections.synchronizedList(processedTransactions);

        for (Transaction transaction : transactions) {
            threadPool.submit(() -> {
                System.out.println("Processing transaction " + transaction.getId());
                processedTransactions.add(transaction);
            });
        }
    }

    public List<Transaction> getProcessedTransactions() {
        return Collections.unmodifiableList(processedTransactions);
    }
}

class CommunicationLogSystem {
    private List<Log> logQueue;
    private final int maxQueueSize = 10;

    public void addLog(Log log) {
        synchronized(this) {
            try {
                if (logQueue.size() == maxQueueSize) {
                    wait();
                }
                logQueue.add(log);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void analyzeLogs() {
        synchronized(this) {
            for (Log log : logQueue) {
                System.out.println("Analysing log " + log.getId());
            }
        }
    }
}

class TransactionAnalysisSystem {
    private ExecutorService threadPool;
    private AtomicInteger processedTransactionCount;

    public void submitTransaction(Transaction transaction) {
        threadPool.submit(() -> {
            System.out.println("Processing transaction " + transaction.getId());
        });
    }

    public int getProcessedTransactionCount() {
        return processedTransactionCount.get();
    }
}

class LogAnalysisSystem {
    private ExecutorService executor;
    private AtomicInteger analyzedLogCount;
    private Lock countLock;

    public void submitLog(Log log) {
        countLock.lock();
        try {
            executor.submit(() -> {
                System.out.println("Processing log " + log.getId());
            });
        } finally {
            countLock.unlock();
        }
    }

    public void shutdown() {
        executor.shutdown();
    }

    public int getAnalyzedLogCount() {
        return analyzedLogCount.get();
    }
}
