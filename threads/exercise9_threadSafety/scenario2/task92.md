**Task 1: Thread States and Management**  
You are given a system with multiple threads. Implement two methods:

1. `public synchronized void waitForThreads(Thread[] threads)`: This method should take an array of Threads and wait for all of them to reach the TERMINATED state. Use the `join()` method in your solution.
    
2. `public void checkThreadStates(Thread[] threads)`: This method should print the state of each thread in the array.
    

Example:  
Input: An array of 5 threads, each with a task that takes a different amount of time to complete.  
Output: The `waitForThreads` method should return only when all threads have completed their tasks. The `checkThreadStates` method should print the state of each thread at the time of invocation.

**Task 2: Thread States and Synchronization**  
Topic: Synchronization  
Implement two methods:

1. `public synchronized void synchronizedMethod()`: This method should print the name of the current thread and its state. Use the `synchronized` keyword to ensure that only one thread can access this method at a time.
    
2. `public void printThreadStates(Thread[] threads)`: This method should print the state of each thread in the array.
    

Example:  
Input: An array of 5 threads, each trying to access the `synchronizedMethod` at the same time.  
Output: The `synchronizedMethod` should print the name and state of each thread one by one, in the order they accessed the method. The `printThreadStates` method should print the state of each thread at the time of invocation.

**Task 3: Thread States and Concurrency Utilities**  
Topic: Concurrency Utilities  
Implement two methods:

1. `public void executeInThreadPool(ThreadPoolExecutor executor, Runnable task)`: This method should submit the given task to the provided ThreadPoolExecutor and print the state of the thread executing the task.
    
2. `public void shutdownAndAwaitTermination(ThreadPoolExecutor pool)`: This method should initiate a graceful shutdown of the ThreadPoolExecutor and wait until all tasks have completed execution, or a timeout occurs.
    

Example:  
Input: A ThreadPoolExecutor with a pool size of 5, and a task that prints the current thread's name and sleeps for 2 seconds.  
Output: The `executeInThreadPool` method should print the state of the thread executing the task. The `shutdownAndAwaitTermination` method should ensure that all tasks have completed before the program exits.

**Task 4: Thread States and Thread Pools**  
Topic: Thread Pools  
Implement three methods:

1. `public ThreadPoolExecutor createThreadPool(int corePoolSize, int maximumPoolSize)`: This method should create and return a ThreadPoolExecutor with the given parameters.
    
2. `public void executeTasks(ThreadPoolExecutor executor, Runnable[] tasks)`: This method should submit all tasks to the provided ThreadPoolExecutor and print the state of each thread in the pool.
    
3. `public void shutdownPool(ThreadPoolExecutor executor)`: This method should initiate a graceful shutdown of the ThreadPoolExecutor and print the state of each thread in the pool.
    

Example:  
Input: A `corePoolSize` of 5, a `maximumPoolSize` of 10, and an array of 7 tasks, each of which prints the current thread's name and sleeps for 2 seconds.  
Output: The `createThreadPool` method should return a ThreadPoolExecutor. The `executeTasks` method should print the state of each thread in the pool after submitting the tasks. The `shutdownPool` method should ensure that all tasks have completed before the program exits, and print the state of each thread in the pool.