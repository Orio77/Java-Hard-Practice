**Advanced Vehicle Management System**

- **Task 1**: Create an abstract class `Vehicle` with methods `startEngine()`, `stopEngine()`, `accelerate()`, and `brake()`. Implement concrete classes for different types of vehicles (e.g., `Car`, `Motorcycle`, `Truck`). Each class should override the methods with specific logic, including different engine behaviors and acceleration/braking characteristics.
    - `Car`: Override `startEngine()`, `stopEngine()`, `accelerate()`, and `brake()` to simulate behaviors specific to cars. For instance, `accelerate()` could increase the speed by a certain amount, while `brake()` decreases it.
    - `Motorcycle`: Override `startEngine()`, `stopEngine()`, `accelerate()`, and `brake()` to simulate behaviors specific to motorcycles. Consider the differences in acceleration and braking compared to cars.
    - `Truck`: Override `startEngine()`, `stopEngine()`, `accelerate()`, and `brake()` to simulate behaviors specific to trucks. Consider the differences in engine start/stop and acceleration/braking compared to cars and motorcycles.
- **Task 2**: Develop an interface `FuelConsumption` with a method `double calculateFuelConsumption(double distance)`. Integrate this interface into your vehicle classes. Implement fuel consumption calculation differently for each vehicle type, simulating real-world scenarios like different fuel efficiencies.
    - `Car`: Implement `calculateFuelConsumption(double distance)` to calculate fuel consumption based on a fixed fuel efficiency (e.g., 25 miles per gallon).
    - `Motorcycle`: Implement `calculateFuelConsumption(double distance)` to calculate fuel consumption based on a higher fuel efficiency compared to cars.
    - `Truck`: Implement `calculateFuelConsumption(double distance)` to calculate fuel consumption based on a lower fuel efficiency compared to cars and motorcycles.
- **Task 3**: Design a class `VehicleManager` that can handle multiple types of vehicles. Implement a method `manageVehicle(Vehicle vehicle)` that starts the engine, accelerates the vehicle, brakes the vehicle, and stops the engine. Ensure the solution leverages polymorphism and demonstrates efficient and effective use of inheritance.
    - Implement `manageVehicle(Vehicle vehicle)` to call `startEngine()`, `accelerate()`, `brake()`, and `stopEngine()` on the `Vehicle` object. The specific behaviors should depend on the actual type of the vehicle (car, motorcycle, or truck).

**Further practise**:

1. **Advanced Vehicle Management System – Enhanced Details**:
    
    - **Vehicle**: Implement `turnOnLights()` and `turnOffLights()` methods in the `Vehicle` class. Override these methods in the `Car`, `Motorcycle`, and `Truck` classes to simulate different behaviors (e.g., motorcycles might have different light behaviors compared to cars and trucks).
    - **Vehicle**: Implement a `honk()` method in the `Vehicle` class. Override this method in the `Car`, `Motorcycle`, and `Truck` classes to simulate different honking sounds.
2. **Vehicle Maintenance – Enhanced Details**:
    
    - **Vehicle**: Implement a `performMaintenance()` method in the `Vehicle` class. Override this method in the `Car`, `Motorcycle`, and `Truck` classes to simulate different maintenance procedures (e.g., trucks might require more extensive maintenance compared to cars and motorcycles).
3. **Customizable Vehicle Handling Strategy – Enhanced Details**:
    
    - **Functionality Description**: Integrate the Strategy pattern into the `Vehicle` class. Define a `DrivingStrategy` interface with a method `driveVehicle(Vehicle vehicle)`.
    - **EcoDriving**: Implement this strategy to drive the vehicle in an eco-friendly manner (e.g., slower acceleration, earlier braking).
    - **SportDriving**: Implement this strategy to drive the vehicle in a sporty manner (e.g., faster acceleration, later braking).
    - **NormalDriving**: Implement this strategy to drive the vehicle in a normal manner (e.g., moderate acceleration and braking). """ Notice how the problem is heavily focused on the specified topic. Notice how it's descriptive and precise, leaving no vague parts