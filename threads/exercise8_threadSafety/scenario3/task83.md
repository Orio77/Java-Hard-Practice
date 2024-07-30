**Task 1**

**Title:** Real-time Market Sentiment Analysis - Thread Management

**Problem:** You are tasked with creating a system that analyzes social media, news feeds, and financial reports in parallel to gauge market sentiment in real time. Implement two methods:

1. `startAnalysisThreads()`: This method should create and start three threads, each responsible for analyzing a different source (social media, news feeds, financial reports). Each thread should simulate the analysis process by sleeping for a random period of time (between 1 to 5 seconds).
    
2. `waitForThreadsToComplete()`: This method should ensure that all analysis threads have completed their execution before the main thread proceeds.
    

**Example:**

startAnalysisThreads();

waitForThreadsToComplete();

**Expected Output:** The main thread should only proceed after all analysis threads have completed their execution.

---

**Task 2**

**Topic:** Synchronization

**Title:** Real-time Market Sentiment Analysis - Synchronization

**Problem:** Building on the previous task, now you need to ensure that the analysis results from each thread are safely stored in a shared data structure. Implement two methods:

1. `analyzeAndStoreResults()`: This method should be called by each analysis thread. It should simulate the analysis process (as before), and then store the result (a random integer) in a shared data structure. Use synchronization to ensure thread safety.
    
2. `printResults()`: This method should be called by the main thread after all analysis threads have completed. It should print the results stored in the shared data structure.
    

**Example:**

startAnalysisThreads();

waitForThreadsToComplete();

printResults();

**Expected Output:** The results from all analysis threads, printed in no particular order.

---

**Task 3**

**Topic:** Executors Framework

**Title:** Real-time Market Sentiment Analysis - Executors Framework

**Problem:** Now, instead of manually managing threads, use the Executors framework. Implement two methods:

1. `startAnalysisTasks()`: This method should create and start three tasks (similar to the threads in Task 1), using a fixed thread pool executor.
    
2. `shutdownAndAwaitTermination()`: This method should shutdown the executor and wait for all tasks to complete before the main thread proceeds.
    

**Example:**

startAnalysisTasks();

shutdownAndAwaitTermination();

printResults();

**Expected Output:** The results from all analysis tasks, printed in no particular order.

---

**Task 4**

**Topic:** Fork/Join Framework

**Title:** Real-time Market Sentiment Analysis - Fork/Join Framework

**Problem:** Finally, use the Fork/Join framework to divide the analysis process into smaller tasks that can be executed in parallel. Implement three methods:

1. `divideAndConquer()`: This method should divide the analysis process into smaller tasks (e.g., analyzing different parts of a single source), and then use a ForkJoinPool to execute these tasks.
    
2. `combineResults()`: This method should be called by `divideAndConquer()`. It should combine the results from all subtasks.
    
3. `printFinalResult()`: This method should print the final result after all subtasks have completed and their results have been combined.
    

**Example:**

divideAndConquer();

printFinalResult();

**Expected Output:** The final result, obtained by combining the results from all subtasks.