package threads.exercise3_threadPools.scenario2;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

class Transaction {
    private int id;
    private TransactionStatus status;
    
    public int getId() {
        return id;
    }
    public TransactionStatus getStatus() {
        return status;
    }
}

enum TransactionStatus {
    PENDING,
    COMPLETED
}

class TransactionContext {
    private Transaction transaction;
    private String content;

    public String getContent() {
        return content;
    }
    public Transaction getTransaction() {
        return transaction;
    }
}

class TransactionAnalysisSystem {
    private ExecutorService executorService;
    private Map<Integer, TransactionStatus> transactionStatusMap;
    private Map<Integer, TransactionContext> transactionContextMap;
    private List<Integer> processingOrder;

    public void processTransactions(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            executorService.submit(() -> {
                System.out.println("Processing transaction: " + transaction.getId());
            });
        }
    }

    public TransactionStatus getTransactionStatus(int transactionId) {
        return transactionStatusMap.get(transactionId);
    }

    public void processTransactions(List<Transaction> transactions, Map<Integer, Integer> priorities) {
        for (Transaction transaction : transactions) {
            Thread thread = new Thread(() -> {
                System.out.println("Processing transaction: " + transaction.getId());
            });
            thread.setPriority(priorities.get(transaction.getId()));
            executorService.submit(thread);
        }
        
    }

    public List<Integer> getProcessingOrder() {
        return Collections.unmodifiableList(processingOrder);
    }

    public Map<Integer, TransactionContext> getTransactionContexts() {
        return this.transactionContextMap;
    }

    public void stopProcessing() {
        executorService.shutdown();
    }

    public boolean isProcessing() {
        return !executorService.isTerminated();
    }
}
