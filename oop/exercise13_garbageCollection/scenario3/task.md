1. **Task Refinement**: Implement a Java program that creates multiple instances of a class.
    
    - **Classes to Create**:
        - Class: `DemoClass`
    - **Methods to Implement**:
        - In `DemoClass`: No specific methods are mentioned in this task, but you might consider methods like `displayInstanceCount()`.
    - **Method Descriptions**:
        - `displayInstanceCount()`: This method should display the number of instances created for `DemoClass`.
2. **Task Refinement**: Modify the Java program to make some of the created objects eligible for garbage collection.
    
    - **Methods to Implement**:
        - Implement a method `nullifyInstances()` in the main program that makes some of the created objects eligible for garbage collection.
    - **Method Descriptions**:
        - `nullifyInstances()`: This method should nullify some of the references to the instances of `DemoClass`, making them eligible for garbage collection.
3. **Task Refinement**: Implement a Java program that invokes the garbage collector and demonstrates its effect.
    
    - **Methods to Implement**:
        - Override the `finalize()` method in `DemoClass` to demonstrate the effect of garbage collection.
    - **Method Descriptions**:
        - `finalize()`: This method should be overridden in `DemoClass` to display a message when an instance is garbage collected. This will demonstrate the effect of invoking the garbage collector.