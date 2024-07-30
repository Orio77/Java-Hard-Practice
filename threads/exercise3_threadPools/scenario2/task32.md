**Task 1: Transaction Analysis System**

You are tasked with creating a system that concurrently analyzes transaction records in real time. Implement the following methods:

1. `void processTransactions(List<Transaction> transactions)`: This method should use a thread pool to process the transactions concurrently. Each transaction should be processed by a separate thread. The processing of a transaction involves a computationally heavy operation that takes significant time. Use synchronization mechanisms to ensure thread safety.
    
2. `TransactionStatus getTransactionStatus(int transactionId)`: This method should return the status of a transaction. If the transaction is still being processed, it should return `TransactionStatus.PENDING`. If the transaction has been processed, it should return `TransactionStatus.COMPLETED`.
    

Example: If you have a list of 10 transactions and you call `processTransactions(transactions)`, the method should start processing the transactions concurrently. If you immediately call `getTransactionStatus(id)` for a transaction id, it should return `TransactionStatus.PENDING`.

**Task 2: Thread Priorities in Transaction Analysis**

For this task, focus on the topic of Thread Priorities. Implement the following methods:

1. `void processTransactions(List<Transaction> transactions, Map<Integer, Integer> priorities)`: This method should process the transactions concurrently, similar to the previous task. However, this time, the threads should be assigned priorities based on the input map. The map's keys are transaction ids and the values are thread priorities.
    
2. `List<Integer> getProcessingOrder()`: This method should return a list of transaction ids in the order they were processed. Higher priority transactions should be processed before lower priority transactions.
    

Example: If you have a list of 3 transactions with ids 1, 2, 3 and priorities 3, 2, 1 respectively, `getProcessingOrder()` should return [1, 2, 3].

**Task 3: ThreadLocal Usage in Transaction Analysis**

For this task, focus on the topic of ThreadLocal Usage. Implement the following methods:

1. `void processTransactions(List<Transaction> transactions)`: This method should process the transactions concurrently. Each thread should have its own ThreadLocal variable that stores some context about the transaction it's processing.
    
2. `Map<Integer, TransactionContext> getTransactionContexts()`: This method should return a map where the keys are transaction ids and the values are the ThreadLocal contexts for each transaction.
    

Example: If you have a list of 5 transactions and you call `processTransactions(transactions)`, then `getTransactionContexts()` should return a map with 5 entries.

**Task 4: Executors Framework in Transaction Analysis**

For this task, focus on the topic of Executors Framework. Implement the following methods:

1. `void processTransactions(List<Transaction> transactions)`: This method should process the transactions concurrently using an ExecutorService.
    
2. `void stopProcessing()`: This method should stop all transaction processing as soon as possible.
    
3. `boolean isProcessing()`: This method should return whether any transactions are currently being processed.
    

Example: If you have a list of 10 transactions and you call `processTransactions(transactions)`, then `isProcessing()` should return true. If you then call `stopProcessing()`, `isProcessing()` should return false.