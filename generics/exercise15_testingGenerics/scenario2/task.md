## Exercise Documentation

### List of Classes to Create

1. `Data<T>`
2. `Processor<T>`
3. `ParallelProcessor<T extends Data<?>>`
4. `DataProcessingEngine`

### List of Classes and Their Methods

#### `Data<T>`

- `getValue()`: This method should return the current value of the data.
- `setValue(T value)`: This method should set the value of the data.

#### `Processor<T>`

- `process(T data)`: This method should simulate processing a unit of data and print a message.

#### `ParallelProcessor<T extends Data<?>>`

- `process(T data)`: This method should simulate processing a unit of data in parallel and print a message.

#### `DataProcessingEngine`

- `setProcessor(Processor<?> processor)`: This method should allow the processor to be changed at runtime.
- `execute(Data<?> data)`: This method should execute the processor on a unit of data and handle possible errors, printing a message if the data cannot be processed.

### General Overview

The exercise is designed to practice using Java Generics in different scenarios, particularly in the context of a distributed data processing system. The `Data` class encapsulates a unit of data to be processed. The `Processor` interface defines a method for processing a unit of data.

The `ParallelProcessor` class implements the `Processor` interface and uses the data to determine which messages to print. The `DataProcessingEngine` class uses the Strategy pattern to allow the processor to be changed at runtime and to execute the processor on a unit of data.

### Example Workflow

1. A `Data` object is created, representing a unit of data to be processed.
2. A `ParallelProcessor` object is created, which implements the `Processor` interface.
3. A `DataProcessingEngine` object is created, which uses the Strategy pattern.
4. The `setProcessor` method of the `DataProcessingEngine` object is called, passing in the `ParallelProcessor` object.
5. The `execute` method of the `DataProcessingEngine` object is called, passing in the `Data` object.
6. If the data can be processed, the `process` method of the `ParallelProcessor` object is called, printing a message.
7. If the data cannot be processed, a message is printed indicating that the data cannot be processed.
8. Concurrency tests are created for the `execute` method to ensure its correct and safe operation under parallel execution.