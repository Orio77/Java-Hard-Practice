package threads.exercise6_handlingExceptions.scenario2;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class Transaction {
    private String id;

    public String getId() {
        return id;
    }
}

class TransactionInProgressException extends Exception {
    public TransactionInProgressException() {
        super();
    }
}

class QueueFullException extends Exception {
    public QueueFullException() {
        super();
    }
}

class QueueEmptyException extends Exception {
    public QueueEmptyException() {
        super();
    }
}

class ThreadPoolFullException extends Exception {
    public ThreadPoolFullException() {
        super();
    }
}

class TasksStillRunningException extends Exception {
    public TasksStillRunningException() {
        super();
    }
}

class ExecutorServiceShutdownException extends Exception {
    public ExecutorServiceShutdownException() {
        super();
    }
}

class TransactionProcessor {
    private List<Transaction> processed;
    private ConcurrentHashMap<String, Boolean> inProcessing;

    public synchronized void processTransaction(Transaction transaction) throws TransactionInProgressException {
        if (inProcessing.putIfAbsent(transaction.getId(), true) != null) {
            throw new TransactionInProgressException();
        }

        try {
            System.out.println("Processing transaction: " + transaction.getId());
        } finally {
            inProcessing.remove(transaction.getId());
        }
    }

    public synchronized List<Transaction> getProcessedTransactions() {
        return Collections.unmodifiableList(processed);
    }
}

class TransactionProducerConsumer {
    private ConcurrentLinkedQueue<Transaction> queue;
    private final AtomicInteger maxQueueSize = new AtomicInteger(10);

    public void produceTransaction() throws QueueFullException {
        synchronized(this) {
            if (queue.size() == maxQueueSize.get()) {
                throw new QueueFullException();
            }

            queue.add(new Transaction());
        }
    }

    public void consumeTransaction() throws QueueEmptyException {
        synchronized(this) {
            if (queue.isEmpty()) {
                throw new QueueEmptyException();
            }

            queue.poll();
        }
    }
}

class TransactionThreadPool {
    private ExecutorService executor;

    public void submitTransaction(Transaction transaction) throws ThreadPoolFullException {
        try {
            executor.submit(() -> {
                System.out.println("Submitting transcation " + transaction.getId());
            });
        } catch (Exception e) {
            throw new ThreadPoolFullException();
        }
    }

    public void shutdown() throws TasksStillRunningException {
        executor.shutdown();

        if (!executor.isShutdown()) {
            throw new TasksStillRunningException();
        }
    }
}

class TransactionExecutorService {
    ExecutorService executorService;

    public void init(int threadPoolSize) {
        executorService = Executors.newFixedThreadPool(threadPoolSize);
    }

    public void submitTransaction(Transaction transaction) throws ExecutorServiceShutdownException {
        if (executorService.isShutdown()) {
            throw new ExecutorServiceShutdownException();
        }

        executorService.submit(() -> {
            System.out.println("Submitting transaction " + transaction.getId());
        });
    }

    public void shutdown() throws TasksStillRunningException {
        executorService.shutdown();

        if (!executorService.isShutdown()) {
            throw new TasksStillRunningException();
        }
    }
}
