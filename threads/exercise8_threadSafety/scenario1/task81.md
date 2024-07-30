**Task 1: Thread Management and Synchronization**

Problem: You are given a task to implement a simulation of a traffic light system at a 4-way intersection using threads in Java. The traffic lights at the intersection are controlled in such a way that only one direction of traffic can move at a time. Implement two methods:

1. `public void changeLight(Direction direction)`: This method will be responsible for changing the traffic light for a given direction. It should ensure that no two directions are allowed to move at the same time using synchronization mechanisms.
    
2. `public Direction currentLight()`: This method will return the direction for which the traffic light is currently green.
    

Example: If the `changeLight(Direction.NORTH)` method is called, the `currentLight()` method should return `Direction.NORTH`. If immediately after, `changeLight(Direction.SOUTH)` is called, it should wait until the north direction is clear before allowing the south direction to move.

---

**Task 2: Thread Safety and Concurrency Utilities**

Problem: You are working on a multi-threaded application where multiple threads are incrementing a shared counter. Your task is to ensure that the counter is thread-safe and the final value of the counter is correct after all threads have finished execution. Choose the topic "Concurrency Utilities" from the list and implement two methods:

1. `public void incrementCounter()`: This method will be used by threads to increment the counter. It should use concurrency utilities to ensure thread safety.
    
2. `public int getCounter()`: This method will return the current value of the counter.
    

Example: If `incrementCounter()` is called 1000 times by different threads, `getCounter()` should return 1000.

---

**Task 3: Thread Safety and Atomic Variables**

Problem: You are developing a multi-threaded application where multiple threads are performing read and write operations on shared data. Your task is to ensure that these operations are atomic to prevent data inconsistency. Choose the topic "Atomic Variables" from the list and implement two methods:

1. `public void updateData(int value)`: This method will be used by threads to update the shared data. It should use atomic variables to ensure that the update operation is atomic.
    
2. `public int readData()`: This method will return the current value of the shared data.
    

Example: If `updateData(5)` is called by one thread and `updateData(10)` is called by another thread around the same time, `readData()` should return either 5 or 10, but not any other value.

---

**Task 4: Thread Safety and Executors Framework**

Problem: You are developing a multi-threaded application that processes tasks using a fixed size thread pool. Your task is to ensure that tasks are executed in a thread-safe manner and resources are managed efficiently. Choose the topic "Executors Framework" from the list and implement three methods:

1. `public void submitTask(Runnable task)`: This method will submit a task to be executed by the thread pool.
    
2. `public void shutdown()`: This method will initiate an orderly shutdown of the thread pool, rejecting new tasks and allowing existing tasks to complete.
    
3. `public boolean isShutdown()`: This method will return whether the thread pool has been shut down.
    

Example: If `submitTask()` is called to submit several tasks and then `shutdown()` is called, `isShutdown()` should return true. If `submitTask()` is called after `shutdown()`, it should reject the task.