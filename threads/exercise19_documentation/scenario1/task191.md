**Task 1**

**Problem:** Implement a `SimulationManager` class that manages multiple simulations of autonomous vehicles. The class should have two methods:

1. `runSimulations(List<Simulation> simulations)`: This method should take a list of `Simulation` objects and run them in parallel using threads. Each `Simulation` object has a `run()` method that runs the simulation. Ensure that no two simulations run at the same time.
    
2. `getResults()`: This method should return a list of `SimulationResult` objects. Each `SimulationResult` object should contain the result of a simulation. This method should block until all simulations have completed.
    

**Example:**

SimulationManager manager = new SimulationManager();

manager.runSimulations(Arrays.asList(simulation1, simulation2, simulation3));

List<SimulationResult> results = manager.getResults(); // This should block until all simulations have completed

**Task 2**

**Topic:** Synchronization

**Problem:** Implement a `SynchronizedSimulationManager` class that manages multiple simulations of autonomous vehicles. The class should have two methods:

1. `runSimulations(List<Simulation> simulations)`: This method should take a list of `Simulation` objects and run them in parallel using threads. Each `Simulation` object has a `run()` method that runs the simulation. Use synchronization to ensure that no two simulations run at the same time.
    
2. `getResults()`: This method should return a list of `SimulationResult` objects. Each `SimulationResult` object should contain the result of a simulation. This method should block until all simulations have completed. Use synchronization to ensure that this method returns correct results even when called from multiple threads.
    

**Example:**

SynchronizedSimulationManager manager = new SynchronizedSimulationManager();

manager.runSimulations(Arrays.asList(simulation1, simulation2, simulation3));

List<SimulationResult> results = manager.getResults(); // This should block until all simulations have completed

**Task 3**

**Topic:** Thread Pools

**Problem:** Implement a `ThreadPoolSimulationManager` class that manages multiple simulations of autonomous vehicles. The class should have two methods:

1. `runSimulations(List<Simulation> simulations)`: This method should take a list of `Simulation` objects and run them in parallel using a thread pool. Each `Simulation` object has a `run()` method that runs the simulation.
    
2. `getResults()`: This method should return a list of `SimulationResult` objects. Each `SimulationResult` object should contain the result of a simulation. This method should block until all simulations have completed.
    

**Example:**

ThreadPoolSimulationManager manager = new ThreadPoolSimulationManager();

manager.runSimulations(Arrays.asList(simulation1, simulation2, simulation3));

List<SimulationResult> results = manager.getResults(); // This should block until all simulations have completed

**Task 4**

**Topic:** Executors Framework

**Problem:** Implement a `ExecutorsSimulationManager` class that manages multiple simulations of autonomous vehicles. The class should have three methods:

1. `runSimulations(List<Simulation> simulations)`: This method should take a list of `Simulation` objects and run them in parallel using an executor service. Each `Simulation` object has a `run()` method that runs the simulation.
    
2. `getResults()`: This method should return a list of `SimulationResult` objects. Each `SimulationResult` object should contain the result of a simulation. This method should block until all simulations have completed.
    
3. `shutdown()`: This method should shutdown the executor service.
    

**Example:**

ExecutorsSimulationManager manager = new ExecutorsSimulationManager();

manager.runSimulations(Arrays.asList(simulation1, simulation2, simulation3));

List<SimulationResult> results = manager.getResults(); // This should block until all simulations have completed

manager.shutdown();