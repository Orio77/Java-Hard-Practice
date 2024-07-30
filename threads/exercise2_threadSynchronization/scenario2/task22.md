**Task 1: Resource Allocation Monitor**

**Problem:** Implement a `ResourceMonitor` class that simulates the dynamic allocation of resources in a cloud computing environment. The class should have two methods:

1. `allocateResources(int resources)`: This method should allocate a certain number of resources. If the requested resources are not available, the method should wait until they become available.
    
2. `releaseResources(int resources)`: This method should release a certain number of resources back to the pool.
    

Use Java's `synchronized` keyword and `wait`/`notify` methods to ensure thread safety.

**Example:**

ResourceMonitor monitor = new ResourceMonitor(10);

monitor.allocateResources(5); // Allocates 5 resources

monitor.releaseResources(3); // Releases 3 resources

monitor.allocateResources(8); // Waits until 8 resources are available

**Task 2: Thread Pool Management**

**Problem:** Implement a `ThreadPool` class that manages a pool of worker threads. The class should have two methods:

1. `submitTask(Runnable task)`: This method should submit a new task to be executed by the thread pool. If all threads are currently busy, the task should be queued until a thread becomes available.
    
2. `shutdown()`: This method should stop the thread pool and wait for all currently executing tasks to finish.
    

Use Java's `ExecutorService` and `Future` classes to implement this.

**Example:**

ThreadPool pool = new ThreadPool(5);

pool.submitTask(() -> System.out.println("Hello, world!"));

pool.shutdown(); // Waits for all tasks to finish and then shuts down the pool

**Task 3: Deadlock Avoidance**

**Problem:** Implement a `Bank` class that simulates a simple banking system with multiple accounts. The class should have two methods:

1. `transfer(Account from, Account to, int amount)`: This method should transfer a certain amount of money from one account to another. If the source account does not have enough funds, the method should wait until it does.
    
2. `deposit(Account account, int amount)`: This method should deposit a certain amount of money into an account.
    

Use Java's `Lock` and `Condition` classes to avoid deadlocks and ensure thread safety.

**Example:**

Bank bank = new Bank();

Account account1 = bank.createAccount(1000);

Account account2 = bank.createAccount(500);

bank.transfer(account1, account2, 700); // Waits until account1 has 700 units

bank.deposit(account1, 800); // Deposits 800 units into account1

**Task 4: Parallel Algorithms Implementation**

**Problem:** Implement a `ParallelSorter` class that sorts a large array of integers in parallel. The class should have three methods:

1. `sort(int[] array)`: This method should sort the array in ascending order using a parallel sorting algorithm.
    
2. `split(int[] array)`: This method should split the array into roughly equal-sized sub-arrays.
    
3. `merge(int[][] arrays)`: This method should merge several sorted arrays into one sorted array.
    

Use Java's `ForkJoinPool` and `RecursiveTask` classes to implement this.

**Example:**

ParallelSorter sorter = new ParallelSorter();

int[] array = {5, 3, 1, 4, 2};

sorter.sort(array); // Returns {1, 2, 3, 4, 5}