# Exercise Documentation

## Classes and Interfaces to Create

1. `Phenomenon<T>`
2. `SimulationEngine<T extends Phenomenon<?>>`
3. `Scenario`

## Class and Interface Methods to Implement

### `Phenomenon<T>`

This interface represents a generic physical phenomenon. It should contain the following method:

- `T simulate()`: This method should simulate the phenomenon and return a result of type `T`.

### `SimulationEngine<T extends Phenomenon<?>>`

This class is responsible for running simulations of various physical phenomena. It should contain the following methods:

- `runSimulation(T phenomenon)`: This method should run a simulation of any phenomenon that extends `Phenomenon`.
    
- `addPhenomenon(T phenomenon)`: This method should add a new phenomenon to the simulation engine.
    
- `simulateScenario(Scenario scenario)`: This method should take a `Scenario` object and simulate it using the appropriate `Phenomenon`.
    

### `Scenario`

This class represents a scenario to be simulated. It should contain necessary information about the scenario such as the phenomenon to be simulated and the parameters for the simulation.

## General Overview

The `SimulationEngine` class is the main class in this exercise. It uses Java Generics with bounded type parameters to ensure compatibility with specific phenomena types and type safety. The `Phenomenon` interface is the base interface for different physical phenomena.

The `SimulationEngine` class has methods to run simulations, add phenomena, and simulate scenarios. It uses the generic type `T` in method parameters, allowing for flexibility in handling different physical phenomena.

## Example Workflow

1. Define a class that implements the `Phenomenon` interface with necessary information.
2. Create an object of the class that implements the `Phenomenon` interface.
3. Create a `SimulationEngine` object.
4. Call the `addPhenomenon` method of the `SimulationEngine` object with the `Phenomenon` object as a parameter.
5. The `SimulationEngine` adds the phenomenon to its collection.
6. Call the `runSimulation` method of the `SimulationEngine` object with the `Phenomenon` object as a parameter.
7. The `SimulationEngine` runs the simulation of the phenomenon.
8. Create a `Scenario` object with necessary information.
9. Call the `simulateScenario` method of the `SimulationEngine` object with the `Scenario` object as a parameter.
10. The `SimulationEngine` simulates the scenario using the appropriate `Phenomenon`.