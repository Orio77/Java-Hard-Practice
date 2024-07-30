# Exercise Documentation

## Classes to Create

1. `DataProcessor<T>`
2. `TypeMismatchException`

## Class Methods to Implement

### `DataProcessor<T>`

This class represents a generic data processor. It should contain the following methods:

- `processData(T data)`: This method should process data of any type.
    
- `handleTypeMismatchException(TypeMismatchException e)`: This method should handle type mismatches during data processing.
    
- `logError(Error e)`: This method should log errors during data processing.
    
- `notifyError(Error e)`: This method should notify the relevant parties when an error occurs.
    
- `recoverFromError(Error e)`: This method should recover from errors without data loss.
    

### `TypeMismatchException`

This class extends the `Exception` class. It represents a specific type of exception that occurs when there is a type mismatch during data processing.

## General Overview

The `DataProcessor` class is the main class in this exercise. It uses Java Generics with bounded type parameters to ensure compatibility with various types of data and type safety. The `TypeMismatchException` class represents a specific type of exception that occurs when there is a type mismatch during data processing.

The `DataProcessor` class has methods to process data, handle type mismatches, log errors, notify about errors, and recover from errors. It uses the generic type `T` in method parameters, allowing for flexibility in processing data of different types.

## Example Workflow

1. Create a `DataProcessor` object with a specific type.
2. Call the `processData` method of the `DataProcessor` object with data of the specified type as a parameter.
3. If a `TypeMismatchException` occurs during data processing, call the `handleTypeMismatchException` method of the `DataProcessor` object with the `TypeMismatchException` object as a parameter.
4. The `handleTypeMismatchException` method handles the type mismatch.
5. If any other `Error` occurs during data processing, call the `logError` and `notifyError` methods of the `DataProcessor` object with the `Error` object as a parameter.
6. The `logError` method logs the error and the `notifyError` method notifies the relevant parties about the error.
7. Call the `recoverFromError` method of the `DataProcessor` object with the `Error` object as a parameter.
8. The `recoverFromError` method recovers from the error without data loss.