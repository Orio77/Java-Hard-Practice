**Background:** In modern multi-core processors, multithreading is a common technique used to maximize CPU utilization. Understanding thread states and how to manage them is crucial for writing efficient, concurrent programs.

**Main Topic:** Thread States

**Task 1**  
**Problem:** Implement two methods, `startThreadsInOrder(int n)` and `stopThreadsInOrder()`. The first method should start `n` threads in order, i.e., Thread 1 should start before Thread 2, and so on. The second method should stop these threads in the same order. Use synchronization mechanisms to ensure the correct order.

**Example:**  
Input: `startThreadsInOrder(3)`  
Output: "Thread 1 started", "Thread 2 started", "Thread 3 started"

Input: `stopThreadsInOrder()`  
Output: "Thread 1 stopped", "Thread 2 stopped", "Thread 3 stopped"

**Task 2**  
**Topic:** Synchronization

**Problem:** Implement two methods, `synchronizedIncrement()` and `synchronizedDecrement()`. These methods should increment and decrement a shared counter, respectively. Use synchronization to ensure that these operations are thread-safe.

**Example:**  
Input: `synchronizedIncrement()`, `synchronizedIncrement()`, `synchronizedDecrement()`  
Output: Counter value is 1

**Task 3**  
**Topic:** Inter-thread Communication

**Problem:** Implement two methods, `produce(int n)` and `consume()`. The `produce` method should add `n` items to a shared queue, and the `consume` method should remove an item from the queue. Use inter-thread communication to ensure that `consume` waits if the queue is empty and `produce` notifies `consume` when it adds an item to the queue.

**Example:**  
Input: `produce(3)`, `consume()`, `consume()`, `consume()`, `consume()`  
Output: "Produced 3 items", "Consumed item", "Consumed item", "Consumed item", "Waiting for production"

**Task 4**  
**Topic:** Thread Pools

**Problem:** Implement three methods, `initThreadPool(int n)`, `executeTasks(int m)`, and `shutdownThreadPool()`. The `initThreadPool` method should initialize a thread pool with `n` threads. The `executeTasks` method should submit `m` tasks to the thread pool, where each task is a simple print statement. The `shutdownThreadPool` method should gracefully shutdown the thread pool.

**Example:**  
Input: `initThreadPool(3)`, `executeTasks(5)`, `shutdownThreadPool()`  
Output: "Thread pool initialized with 3 threads", "Task 1 executed", "Task 2 executed", "Task 3 executed", "Task 4 executed", "Task 5 executed", "Thread pool shutdown"