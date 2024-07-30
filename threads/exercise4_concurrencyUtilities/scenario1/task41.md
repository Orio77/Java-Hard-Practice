**Task 1**

**Problem:** Implement a multi-threaded server that can process multiple client requests in parallel. The server should have two functionalities:

1. `processRequest(Request request)`: This method should process a given request. Use synchronization mechanisms to ensure that no two threads process the same request at the same time.
    
2. `addRequest(Request request)`: This method should add a new request to the server's queue of requests. If the server is currently idle (i.e., not processing any requests), it should start processing the new request immediately.
    

**Input:** A series of requests, each represented as an instance of the `Request` class. Each request has a unique ID.

**Output:** For each request, the server should print a message indicating that it has started processing the request, and another message indicating that it has finished processing the request.

---

**Task 2**

**Topic:** Thread Pools

**Problem:** Implement a thread pool that can process multiple tasks in parallel. The thread pool should have two functionalities:

1. `submitTask(Task task)`: This method should submit a new task to the thread pool. If there are idle threads in the pool, one of them should start executing the task immediately.
    
2. `shutdown()`: This method should stop the thread pool from accepting new tasks and allow all the currently executing tasks to finish.
    

**Input:** A series of tasks, each represented as an instance of the `Task` class. Each task has a unique ID and a duration (in milliseconds) that represents how long it takes to execute the task.

**Output:** For each task, the thread pool should print a message indicating that it has started executing the task, and another message indicating that it has finished executing the task.

---

**Task 3**

**Topic:** Atomic Variables

**Problem:** Implement a counter that can be incremented by multiple threads in parallel. The counter should have two functionalities:

1. `increment()`: This method should increment the counter. Use an atomic variable to ensure that increments are atomic (i.e., no two threads can increment the counter at the same time).
    
2. `getValue()`: This method should return the current value of the counter.
    

**Input:** A series of increment operations, each represented as a call to the `increment()` method.

**Output:** The final value of the counter, as returned by the `getValue()` method.

---

**Task 4**

**Topic:** Executors Framework

**Problem:** Implement a task executor that can execute multiple tasks in parallel. The task executor should have three functionalities:

1. `submitTask(Task task)`: This method should submit a new task to the executor. If there are idle threads in the executor, one of them should start executing the task immediately.
    
2. `shutdown()`: This method should stop the executor from accepting new tasks and allow all the currently executing tasks to finish.
    
3. `awaitTermination()`: This method should block until all tasks have finished executing.
    

**Input:** A series of tasks, each represented as an instance of the `Task` class. Each task has a unique ID and a duration (in milliseconds) that represents how long it takes to execute the task.

**Output:** For each task, the executor should print a message indicating that it has started executing the task, and another message indicating that it has finished executing the task.