**Task 1: Thread Priorities and Synchronization**

You are given a task to implement two methods related to thread management and synchronization in Java. The first method, `setPriorityAndStart()`, should create two threads, set their priorities, and start them. The second method, `synchronizedIncrement()`, should increment a shared variable in a synchronized manner.

**Method 1: setPriorityAndStart()**

- Input: None
- Output: None
- This method should create two threads. Set the priority of the first thread to MAX_PRIORITY and the second one to MIN_PRIORITY. Both threads should print their name and priority when they start.

**Method 2: synchronizedIncrement()**

- Input: None
- Output: None
- This method should increment a shared integer variable 1000 times. The increment operation should be synchronized to avoid race conditions.

**Example:**

- After calling `setPriorityAndStart()`, the output should show that the thread with MAX_PRIORITY started before the one with MIN_PRIORITY.
- After calling `synchronizedIncrement()` from two threads simultaneously, the shared variable should be 2000.

---

**Task 2: Inter-thread Communication**

For this task, you need to implement two methods that demonstrate the use of inter-thread communication in Java. The first method, `produce()`, should add elements to a shared queue. The second method, `consume()`, should remove elements from the queue.

**Method 1: produce()**

- Input: An integer `n`
- Output: None
- This method should add integers from 1 to `n` to a shared queue. If the queue is full, it should wait until there's space.

**Method 2: consume()**

- Input: None
- Output: None
- This method should remove an element from the queue and print it. If the queue is empty, it should wait until there's an element.

**Example:**

- After calling `produce(5)` from one thread and `consume()` from another thread, the output should show the numbers 1 to 5 being printed.

---

**Task 3: ThreadLocal Usage**

This task requires you to implement two methods that demonstrate the use of ThreadLocal in Java. The first method, `setThreadLocal()`, should set a ThreadLocal variable. The second method, `printThreadLocal()`, should print the ThreadLocal variable.

**Method 1: setThreadLocal()**

- Input: A string `s`
- Output: None
- This method should set a ThreadLocal variable to the input string.

**Method 2: printThreadLocal()**

- Input: None
- Output: None
- This method should print the ThreadLocal variable.

**Example:**

- After calling `setThreadLocal("Hello")` from one thread and `printThreadLocal()` from the same thread, the output should be "Hello".

---

**Task 4: Executors Framework and Concurrency Utilities**

This task requires you to implement three methods that demonstrate the use of the Executors framework and concurrency utilities in Java. The first method, `executeTasks()`, should execute a list of tasks using an ExecutorService. The second method, `scheduleTask()`, should schedule a task to run after a delay. The third method, `shutdownAndAwaitTermination()`, should shutdown the ExecutorService and wait for all tasks to complete.

**Method 1: executeTasks()**

- Input: A list of `Runnable` tasks
- Output: None
- This method should execute the input tasks using an ExecutorService.

**Method 2: scheduleTask()**

- Input: A `Runnable` task, a long `delay`
- Output: None
- This method should schedule the input task to run after the input delay.

**Method 3: shutdownAndAwaitTermination()**

- Input: None
- Output: None
- This method should shutdown the ExecutorService and wait for all tasks to complete.

**Example:**

- After calling `executeTasks(tasks)` with a list of tasks that print "Task executed", the output should show "Task executed" for each task.
- After calling `scheduleTask(task, 5)` with a task that prints "Task scheduled" and a delay of 5 seconds, the output should show "Task scheduled" after 5 seconds.
- After calling `shutdownAndAwaitTermination()`, the ExecutorService should be shutdown and all tasks should have completed.