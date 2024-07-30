**Task 1**

**Problem:** Implement a `SimulationRunner` class that manages multiple simulations of autonomous vehicles. The class should have two methods:

1. `runSimulations(int n)`: This method should start `n` simulations, each in its own thread. Each simulation is a simple loop that runs for a random number of iterations (between 1 and 100), and each iteration takes 1 millisecond. The method should wait for all simulations to finish before returning.
    
2. `stopSimulations()`: This method should stop all currently running simulations immediately.
    

**Example:**

SimulationRunner runner = new SimulationRunner();

runner.runSimulations(10); // Starts 10 simulations

Thread.sleep(5000); // Wait for 5 seconds

runner.stopSimulations(); // Stops all simulations

**Task 2**

**Topic:** Synchronization

**Problem:** Implement a `SynchronizedSimulationRunner` class that extends `SimulationRunner`. This class should ensure that no two simulations can run at the same time. It should have two methods:

1. `runSimulations(int n)`: This method should start `n` simulations, each in its own thread. However, it should ensure that no two simulations run at the same time.
    
2. `stopSimulations()`: This method should stop all currently running simulations immediately.
    

**Example:**

SynchronizedSimulationRunner runner = new SynchronizedSimulationRunner();

runner.runSimulations(10); // Starts 10 simulations, but only one runs at a time

Thread.sleep(5000); // Wait for 5 seconds

runner.stopSimulations(); // Stops all simulations

**Task 3**

**Topic:** Thread Pools

**Problem:** Implement a `ThreadPoolSimulationRunner` class that extends `SimulationRunner`. This class should use a thread pool to manage the simulations. It should have two methods:

1. `runSimulations(int n)`: This method should start `n` simulations, each in its own thread. However, it should use a thread pool to limit the number of concurrent simulations to 5.
    
2. `stopSimulations()`: This method should stop all currently running simulations immediately.
    

**Example:**

ThreadPoolSimulationRunner runner = new ThreadPoolSimulationRunner();

runner.runSimulations(10); // Starts 10 simulations, but only five run at a time

Thread.sleep(5000); // Wait for 5 seconds

runner.stopSimulations(); // Stops all simulations

**Task 4**

**Topic:** Deadlock Avoidance

**Problem:** Implement a `DeadlockFreeSimulationRunner` class that extends `SimulationRunner`. This class should ensure that deadlocks cannot occur. It should have three methods:

1. `runSimulations(int n)`: This method should start `n` simulations, each in its own thread. However, it should ensure that deadlocks cannot occur.
    
2. `stopSimulations()`: This method should stop all currently running simulations immediately.
    
3. `isDeadlocked()`: This method should return `true` if a deadlock is currently occurring, and `false` otherwise.
    

**Example:**

DeadlockFreeSimulationRunner runner = new DeadlockFreeSimulationRunner();

runner.runSimulations(10); // Starts 10 simulations

Thread.sleep(5000); // Wait for 5 seconds

runner.isDeadlocked(); // Returns false

runner.stopSimulations(); // Stops all simulations