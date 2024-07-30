**Task 1: Thread Synchronization and Inter-thread Communication**

You are tasked with implementing a real-time inventory tracking system for an e-commerce platform. The system should be able to process sales transactions concurrently and update the inventory in real-time.

**Function 1: processTransaction(int productId, int quantity)**

This function should simulate the processing of a sales transaction. It should reduce the inventory of the specified product by the given quantity. If the inventory is insufficient, it should wait until the inventory is restocked.

**Function 2: restockProduct(int productId, int quantity)**

This function should simulate the restocking of a product. It should increase the inventory of the specified product by the given quantity and notify any waiting transactions.

Example:

Input: processTransaction(1, 5), restockProduct(1, 10), processTransaction(1, 5) Output: Inventory of product 1: 0

---

**Task 2: Thread Pools and Concurrency Utilities**

You are tasked with implementing a system that processes sales transactions using a thread pool. The system should also use concurrency utilities to ensure thread safety.

**Function 1: initThreadPool(int size)**

This function should initialize a thread pool of the specified size.

**Function 2: processTransaction(int productId, int quantity)**

This function should submit a task to the thread pool to process a sales transaction. It should reduce the inventory of the specified product by the given quantity. If the inventory is insufficient, it should wait until the inventory is restocked.

Example:

Input: initThreadPool(5), processTransaction(1, 5), processTransaction(1, 5) Output: Inventory of product 1: 0

---

**Task 3: Atomic Variables and Lock Objects**

You are tasked with implementing a system that uses atomic variables and lock objects to ensure thread safety when processing sales transactions.

**Function 1: processTransaction(int productId, int quantity)**

This function should use a lock object to ensure that only one thread can access the inventory of a product at a time. It should reduce the inventory of the specified product by the given quantity.

**Function 2: restockProduct(int productId, int quantity)**

This function should use an atomic variable to safely increase the inventory of the specified product by the given quantity.

Example:

Input: processTransaction(1, 5), restockProduct(1, 10), processTransaction(1, 5) Output: Inventory of product 1: 0

---

**Task 4: Executors Framework and Fork/Join Framework**

You are tasked with implementing a system that uses the Executors framework to manage a pool of threads and the Fork/Join framework to process sales transactions in parallel.

**Function 1: initExecutorService(int size)**

This function should initialize an ExecutorService with a fixed thread pool of the specified size.

**Function 2: processTransaction(int productId, int quantity)**

This function should submit a task to the ExecutorService to process a sales transaction. It should reduce the inventory of the specified product by the given quantity.

**Function 3: processTransactionsInParallel(List transactions)**

This function should use the Fork/Join framework to process a list of sales transactions in parallel.

Example:

Input: initExecutorService(5), processTransaction(1, 5), processTransactionsInParallel([Transaction(1, 5), Transaction(2, 3)]) Output: Inventory of product 1: 0, Inventory of product 2: -3