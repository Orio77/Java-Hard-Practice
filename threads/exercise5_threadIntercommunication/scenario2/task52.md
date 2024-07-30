**Task 1**  
**Title:** Thread Synchronization for Resource Allocation  
**Problem:** Implement two methods, `allocateResource()` and `releaseResource()`. The `allocateResource()` method should allocate resources to a thread if available. If resources are not available, the thread should wait until resources are released. The `releaseResource()` method should release resources and notify waiting threads. Use synchronization mechanisms to ensure thread safety.  
**Example:** If thread1 calls `allocateResource()` and resources are available, it should successfully allocate resources. If thread2 calls `allocateResource()` while resources are already allocated to thread1, it should wait until thread1 calls `releaseResource()`.

**Task 2**  
**Topic:** Concurrency Utilities  
**Title:** Executor Service for Resource Allocation  
**Problem:** Implement two methods, `startExecutorService()` and `stopExecutorService()`. The `startExecutorService()` method should start an ExecutorService with a fixed thread pool. Each thread should simulate resource allocation by sleeping for a random period of time. The `stopExecutorService()` method should stop the ExecutorService gracefully, waiting for all threads to finish their current tasks.  
**Example:** If `startExecutorService()` is called with a thread pool size of 5, it should start 5 threads. If `stopExecutorService()` is called, it should wait for all 5 threads to finish their tasks before stopping the ExecutorService.

**Task 3**  
**Topic:** Atomic Variables  
**Title:** Atomic Resource Allocation  
**Problem:** Implement two methods, `atomicAllocateResource()` and `atomicReleaseResource()`. The `atomicAllocateResource()` method should allocate resources to a thread if available, using an AtomicInteger to keep track of resource availability. If resources are not available, the thread should wait until resources are released. The `atomicReleaseResource()` method should release resources and notify waiting threads.  
**Example:** If thread1 calls `atomicAllocateResource()` and resources are available, it should successfully allocate resources. If thread2 calls `atomicAllocateResource()` while resources are already allocated to thread1, it should wait until thread1 calls `atomicReleaseResource()`.

**Task 4**  
**Topic:** Fork/Join Framework  
**Title:** Parallel Resource Allocation  
**Problem:** Implement three methods, `startForkJoinPool()`, `allocateResourceTask()` and `stopForkJoinPool()`. The `startForkJoinPool()` method should start a ForkJoinPool. The `allocateResourceTask()` method should be a RecursiveTask that simulates resource allocation by sleeping for a random period of time. The `stopForkJoinPool()` method should stop the ForkJoinPool gracefully, waiting for all tasks to finish.  
**Example:** If `startForkJoinPool()` is called with a parallelism level of 5, it should start a ForkJoinPool with 5 threads. If `allocateResourceTask()` is called, it should create a new task in the ForkJoinPool. If `stopForkJoinPool()` is called, it should wait for all tasks to finish before stopping the ForkJoinPool.