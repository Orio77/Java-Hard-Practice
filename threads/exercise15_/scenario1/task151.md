**Task 1**

**Problem:** Implement a Priority Task Scheduler using Java Threads. The scheduler should have two functionalities:

1. `addTask(Runnable task, int priority)`: This method should add a new task to the scheduler. The task should be represented as a Runnable object and the priority as an integer. The higher the integer, the higher the priority.
    
2. `executeTasks()`: This method should execute all tasks in the scheduler. Tasks with higher priority should be executed before tasks with lower priority. If two tasks have the same priority, they should be executed in the order they were added.
    

**Example:**

PriorityTaskScheduler scheduler = new PriorityTaskScheduler();

scheduler.addTask(new Task("Task1"), 1);

scheduler.addTask(new Task("Task2"), 2);

scheduler.executeTasks();

**Expected Output:**

Task2

Task1

**Task 2**

**Topic:** Synchronization

**Problem:** Implement a Priority Task Scheduler with Synchronization. The scheduler should have two functionalities:

1. `synchronizedAddTask(Runnable task, int priority)`: This method should add a new task to the scheduler in a thread-safe manner.
    
2. `synchronizedExecuteTasks()`: This method should execute all tasks in the scheduler in a thread-safe manner.
    

**Example:**

PriorityTaskScheduler scheduler = new PriorityTaskScheduler();

scheduler.synchronizedAddTask(new Task("Task1"), 1);

scheduler.synchronizedAddTask(new Task("Task2"), 2);

scheduler.synchronizedExecuteTasks();

**Expected Output:**

Task2

Task1

**Task 3**

**Topic:** ThreadLocal Usage

**Problem:** Implement a Priority Task Scheduler using ThreadLocal. The scheduler should have two functionalities:

1. `threadLocalAddTask(Runnable task, int priority)`: This method should add a new task to the scheduler. The task should be stored in a ThreadLocal variable.
    
2. `threadLocalExecuteTasks()`: This method should execute all tasks in the scheduler. The tasks should be retrieved from the ThreadLocal variable.
    

**Example:**

PriorityTaskScheduler scheduler = new PriorityTaskScheduler();

scheduler.threadLocalAddTask(new Task("Task1"), 1);

scheduler.threadLocalAddTask(new Task("Task2"), 2);

scheduler.threadLocalExecuteTasks();

**Expected Output:**

Task2

Task1

**Task 4**

**Topic:** Executors Framework

**Problem:** Implement a Priority Task Scheduler using the Executors Framework. The scheduler should have three functionalities:

1. `executorAddTask(Runnable task, int priority)`: This method should add a new task to the scheduler.
    
2. `executorExecuteTasks()`: This method should execute all tasks in the scheduler.
    
3. `shutdown()`: This method should shutdown the executor service after all tasks have been executed.
    

**Example:**

PriorityTaskScheduler scheduler = new PriorityTaskScheduler();

scheduler.executorAddTask(new Task("Task1"), 1);

scheduler.executorAddTask(new Task("Task2"), 2);

scheduler.executorExecuteTasks();

scheduler.shutdown();

**Expected Output:**

Task2

Task1