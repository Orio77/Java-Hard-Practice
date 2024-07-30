**Task 1**

**Problem:** Implement a thread pool in Java that can execute tasks in parallel. The thread pool should have the following functionalities:

1. `submitTask(Runnable task)`: This method should accept a task and add it to the queue of tasks to be executed. If there are idle threads, it should immediately assign the task to one of them. If all threads are busy, it should queue the task and execute it as soon as a thread becomes available.
    
2. `shutdown()`: This method should stop accepting new tasks and allow all submitted tasks to finish execution. After all tasks have finished, it should terminate all threads.
    

**Example:**

ThreadPool threadPool = new ThreadPool(3); // create a thread pool with 3 threads

threadPool.submitTask(new Task()); // submit a new task to the thread pool

threadPool.shutdown(); // shutdown the thread pool

**Task 2**

**Topic:** Synchronization

**Problem:** Modify the thread pool implemented in Task 1 to ensure thread safety using synchronization. The thread pool should have the following functionalities:

1. `submitTask(Runnable task)`: This method should be thread-safe. Multiple threads should be able to call this method simultaneously without causing any race conditions.
    
2. `shutdown()`: This method should also be thread-safe. It should ensure that no new tasks are accepted after it is called, even if `submitTask()` is called simultaneously from another thread.
    

**Example:**

ThreadPool threadPool = new ThreadPool(3); // create a thread pool with 3 threads

threadPool.submitTask(new Task()); // submit a new task to the thread pool

threadPool.shutdown(); // shutdown the thread pool

**Task 3**

**Topic:** Concurrency Utilities

**Problem:** Implement a thread pool using Java's concurrency utilities. The thread pool should have the following functionalities:

1. `submitTask(Callable<T> task)`: This method should accept a task and return a Future representing the result of the task. It should add the task to the queue of tasks to be executed. If there are idle threads, it should immediately assign the task to one of them. If all threads are busy, it should queue the task and execute it as soon as a thread becomes available.
    
2. `shutdown()`: This method should stop accepting new tasks and allow all submitted tasks to finish execution. After all tasks have finished, it should terminate all threads.
    

**Example:**

ThreadPool threadPool = new ThreadPool(3); // create a thread pool with 3 threads

Future<Integer> future = threadPool.submitTask(new Task()); // submit a new task to the thread pool

threadPool.shutdown(); // shutdown the thread pool

**Task 4**

**Topic:** Executors Framework

**Problem:** Implement a thread pool using Java's Executors framework. The thread pool should have the following functionalities:

1. `submitTask(Callable<T> task)`: This method should accept a task and return a Future representing the result of the task. It should add the task to the queue of tasks to be executed. If there are idle threads, it should immediately assign the task to one of them. If all threads are busy, it should queue the task and execute it as soon as a thread becomes available.
    
2. `shutdown()`: This method should stop accepting new tasks and allow all submitted tasks to finish execution. After all tasks have finished, it should terminate all threads.
    
3. `awaitTermination(long timeout, TimeUnit unit)`: This method should block until all tasks have completed execution after a shutdown request, or the timeout occurs, or the current thread is interrupted, whichever happens first.
    

**Example:**

ThreadPool threadPool = new ThreadPool(3); // create a thread pool with 3 threads

Future<Integer> future = threadPool.submitTask(new Task()); // submit a new task to the thread pool

threadPool.shutdown(); // shutdown the thread pool

threadPool.awaitTermination(1, TimeUnit.MINUTES); // wait for all tasks to finish