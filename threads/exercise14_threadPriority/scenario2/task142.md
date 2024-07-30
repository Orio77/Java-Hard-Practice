**Task 1**

**Problem:** Implement a `PriorityTaskManager` class that manages tasks based on their priority. The class should have two methods:

1. `addTask(int priority, Runnable task)`: Adds a task to the manager with a given priority. Higher priority tasks should be executed before lower priority tasks. If two tasks have the same priority, they should be executed in the order they were added.
    
2. `runTasks()`: Runs all tasks in the manager in order of their priority and clears the task list.
    

**Example:**

PriorityTaskManager manager = new PriorityTaskManager();

manager.addTask(1, () -> System.out.println("Task 1"));

manager.addTask(3, () -> System.out.println("Task 2"));

manager.addTask(2, () -> System.out.println("Task 3"));

manager.runTasks();

**Expected Output:**

Task 2

Task 3

Task 1

**Task 2**

**Topic:** Thread Safety

**Problem:** Implement a `ThreadSafePriorityTaskManager` class that extends `PriorityTaskManager` and ensures that tasks can be safely added and run from multiple threads. The class should override the `addTask` and `runTasks` methods to ensure thread safety.

**Example:**

ThreadSafePriorityTaskManager manager = new ThreadSafePriorityTaskManager();

new Thread(() -> {

    manager.addTask(1, () -> System.out.println("Task 1"));

}).start();

new Thread(() -> {

    manager.addTask(3, () -> System.out.println("Task 2"));

}).start();

new Thread(() -> {

    manager.addTask(2, () -> System.out.println("Task 3"));

}).start();

new Thread(() -> {

    manager.runTasks();

}).start();

**Expected Output:**

Task 2

Task 3

Task 1

**Task 3**

**Topic:** Executors Framework

**Problem:** Implement a `PriorityTaskExecutor` class that manages tasks based on their priority using the Executors framework. The class should have two methods:

1. `submitTask(int priority, Callable<T> task)`: Submits a task to the executor with a given priority. Higher priority tasks should be executed before lower priority tasks. If two tasks have the same priority, they should be executed in the order they were added. The method should return a `Future<T>` that can be used to retrieve the result of the task.
    
2. `shutdown()`: Shuts down the executor and waits for all tasks to complete.
    

**Example:**

PriorityTaskExecutor executor = new PriorityTaskExecutor();

Future<String> future1 = executor.submitTask(1, () -> "Task 1");

Future<String> future2 = executor.submitTask(3, () -> "Task 2");

Future<String> future3 = executor.submitTask(2, () -> "Task 3");

executor.shutdown();

System.out.println(future1.get());

System.out.println(future2.get());

System.out.println(future3.get());

**Expected Output:**

Task 2

Task 3

Task 1

**Task 4**

**Topic:** Fork/Join Framework

**Problem:** Implement a `PriorityTaskForkJoinPool` class that manages tasks based on their priority using the Fork/Join framework. The class should have three methods:

1. `submitTask(int priority, RecursiveTask<T> task)`: Submits a task to the pool with a given priority. Higher priority tasks should be executed before lower priority tasks. If two tasks have the same priority, they should be executed in the order they were added. The method should return a `ForkJoinTask<T>` that can be used to retrieve the result of the task.
    
2. `invokeAllTasks()`: Invokes all tasks in the pool in order of their priority and clears the task list.
    
3. `shutdown()`: Shuts down the pool and waits for all tasks to complete.
    

**Example:**

PriorityTaskForkJoinPool pool = new PriorityTaskForkJoinPool();

ForkJoinTask<String> task1 = pool.submitTask(1, new RecursiveTask<String>() {

    @Override

    protected String compute() {

        return "Task 1";

    }

});

ForkJoinTask<String> task2 = pool.submitTask(3, new RecursiveTask<String>() {

    @Override

    protected String compute() {

        return "Task 2";

    }

});

ForkJoinTask<String> task3 = pool.submitTask(2, new RecursiveTask<String>() {

    @Override

    protected String compute() {

        return "Task 3";

    }

});

pool.invokeAllTasks();

pool.shutdown();

System.out.println(task1.join());

System.out.println(task2.join());

System.out.println(task3.join());

**Expected Output:**

Task 2

Task 3

Task 1