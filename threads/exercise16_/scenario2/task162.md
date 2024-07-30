**Task 1**

**Problem:** Implement a class `DataProcessor` that simulates the processing of sports data from various sources concurrently using threads in Java. The class should have two methods:

1. `void processData(List<String> data)`: This method should take a list of data strings and process them concurrently. Each string represents a piece of data from a source. The processing of each data string should be done in a separate thread. The processing simply involves printing the data string and the name of the thread processing it.
    
2. `void waitForAll()`: This method should block until all data has been processed.
    

**Example:**

DataProcessor dp = new DataProcessor();

dp.processData(Arrays.asList("data1", "data2", "data3"));

dp.waitForAll();

**Expected Output:**

Thread-0: data1

Thread-1: data2

Thread-2: data3

**Note:** The order of the output can vary.

**Task 2**

**Topic:** Synchronization

**Problem:** Extend the `DataProcessor` class from Task 1 to ensure that the data processing is thread-safe. Add two methods:

1. `void synchronizedProcessData(List<String> data)`: This method should do the same as `processData`, but it should ensure that only one thread prints at a time.
    
2. `void waitForAllSynchronized()`: This method should block until all data has been processed.
    

**Example:**

DataProcessor dp = new DataProcessor();

dp.synchronizedProcessData(Arrays.asList("data1", "data2", "data3"));

dp.waitForAllSynchronized();

**Expected Output:**

Thread-0: data1

Thread-1: data2

Thread-2: data3

**Note:** The order of the output can vary, but the prints from different threads should not interleave.

**Task 3**

**Topic:** Thread Pools

**Problem:** Extend the `DataProcessor` class from Task 2 to use a thread pool instead of creating new threads for each piece of data. Add two methods:

1. `void pooledProcessData(List<String> data)`: This method should do the same as `synchronizedProcessData`, but it should use a thread pool to process the data.
    
2. `void waitForAllPooled()`: This method should block until all data has been processed.
    

**Example:**

DataProcessor dp = new DataProcessor();

dp.pooledProcessData(Arrays.asList("data1", "data2", "data3"));

dp.waitForAllPooled();

**Expected Output:**

pool-1-thread-1: data1

pool-1-thread-2: data2

pool-1-thread-3: data3

**Note:** The order of the output can vary, but the prints from different threads should not interleave.

**Task 4**

**Topic:** Executors Framework

**Problem:** Extend the `DataProcessor` class from Task 3 to use the Executors framework. Add three methods:

1. `void executorProcessData(List<String> data)`: This method should do the same as `pooledProcessData`, but it should use the Executors framework to process the data.
    
2. `void shutdownAndAwaitTermination()`: This method should shutdown the executor and block until all tasks have completed execution.
    
3. `void cancelAll()`: This method should attempt to stop all actively executing tasks, halt the processing of waiting tasks, and return a list of the tasks that were awaiting execution.
    

**Example:**

DataProcessor dp = new DataProcessor();

dp.executorProcessData(Arrays.asList("data1", "data2", "data3"));

dp.shutdownAndAwaitTermination();

**Expected Output:**

pool-1-thread-1: data1

pool-1-thread-2: data2

pool-1-thread-3: data3

**Note:** The order of the output can vary, but the prints from different threads should not interleave.