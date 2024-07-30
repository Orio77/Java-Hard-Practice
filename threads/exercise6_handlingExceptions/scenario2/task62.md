**Task 1: Thread Synchronization and Exception Handling**

You are given a system that processes financial transactions. The system uses multiple threads to process transactions concurrently. However, the system must ensure that no two threads process the same transaction at the same time.

Your task is to implement two methods:

1. `processTransaction(Transaction transaction)`: This method should process a given transaction. If the transaction is already being processed by another thread, the method should throw a `TransactionInProgressException`.
    
2. `getProcessedTransactions()`: This method should return a list of all transactions that have been processed so far.
    

Example:

Input: `processTransaction(transaction1)`, `processTransaction(transaction1)`

Output: `TransactionInProgressException`

---

**Task 2: Inter-thread Communication and Exception Handling**

In the context of the financial system, you need to implement a mechanism for inter-thread communication. One thread (Producer) generates transaction records, while another thread (Consumer) processes them.

Your task is to implement two methods:

1. `produceTransaction()`: This method should generate a new transaction and add it to a shared data structure. If the data structure is full, the method should throw a `QueueFullException`.
    
2. `consumeTransaction()`: This method should process a transaction from the shared data structure. If the data structure is empty, the method should throw a `QueueEmptyException`.
    

Example:

Input: `consumeTransaction()` (when no transaction has been produced)

Output: `QueueEmptyException`

---

**Task 3: Thread Pools and Exception Handling**

Considering the financial system, you are required to implement a mechanism that uses a thread pool to process transactions.

Your task is to implement two methods:

1. `submitTransaction(Transaction transaction)`: This method should submit a transaction to the thread pool for processing. If the thread pool is not able to accept new tasks, the method should throw a `ThreadPoolFullException`.
    
2. `shutdown()`: This method should attempt to shut down the thread pool. If tasks are still being processed, the method should throw a `TasksStillRunningException`.
    

Example:

Input: `submitTransaction(transaction)` (when thread pool is full)

Output: `ThreadPoolFullException`

---

**Task 4: Executors Framework, Exception Handling, and Thread Safety**

In the context of the financial system, you need to implement a mechanism that uses the Executors framework to process transactions in a thread-safe manner.

Your task is to implement three methods:

1. `init()`: This method should initialize an ExecutorService with a fixed thread pool.
    
2. `submitTransaction(Transaction transaction)`: This method should submit a transaction to the ExecutorService for processing. If the ExecutorService is shut down, the method should throw a `ExecutorServiceShutdownException`.
    
3. `shutdown()`: This method should attempt to shut down the ExecutorService. If tasks are still being processed, the method should throw a `TasksStillRunningException`.
    

Example:

Input: `submitTransaction(transaction)` (after `shutdown()` has been called)

Output: `ExecutorServiceShutdownException`