
**Task 1: Thread Synchronization and Inter-thread Communication**

You are working on a cloud-based video encoding service. Your task is to implement two methods: `encodeVideo()` and `notifyWhenDone()`.

The `encodeVideo()` method should take a video file as input and encode it into various formats. This process should be done in a separate thread.

The `notifyWhenDone()` method should be used to notify the main thread when the encoding process is finished. This method should use inter-thread communication to achieve this.

Example:

Input: A video file Output: The main thread is notified when the encoding process is finished.

**Task 2: Thread Pools and Atomic Variables**

Considering the same cloud-based video encoding service, your task is to implement two methods: `createThreadPool()` and `encodeVideos()`.

The `createThreadPool()` method should create a thread pool with a specified number of threads.

The `encodeVideos()` method should take a list of video files as input and encode them using the thread pool. This method should use atomic variables to keep track of the number of videos that have been encoded.

Example:

Input: A list of video files Output: All videos are encoded using the thread pool and the number of encoded videos is correctly tracked.

**Task 3: Executors Framework and Handling InterruptedException**

In the context of the same service, your task is to implement two methods: `createExecutorService()` and `encodeVideos()`.

The `createExecutorService()` method should create an executor service with a fixed number of threads.

The `encodeVideos()` method should take a list of video files as input and encode them using the executor service. This method should handle any InterruptedException that might occur during the encoding process.

Example:

Input: A list of video files Output: All videos are encoded using the executor service and any InterruptedException is properly handled.

**Task 4: Fork/Join Framework, Parallel Algorithms Implementation, and Performance Tuning for Threads**

Still working on the same service, your task is to implement three methods: `createForkJoinPool()`, `encodeVideos()`, and `tunePerformance()`.

The `createForkJoinPool()` method should create a fork/join pool.

The `encodeVideos()` method should take a list of video files as input and encode them using the fork/join pool. This method should implement a parallel algorithm for the encoding process.

The `tunePerformance()` method should tune the performance of the threads in the fork/join pool.

Example:

Input: A list of video files Output: All videos are encoded using the fork/join pool, a parallel algorithm is implemented for the encoding process, and the performance of the threads is tuned.