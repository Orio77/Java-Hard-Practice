**Refined Scenario:** Scenario 1: Develop a utility library for mathematical calculations using Java Generics, implementing generic methods for common mathematical operations on different numeric data types.

1. **Define Generic Methods for Mathematical Operations:**
    
    - **Methods to Implement:**
        - Define a generic class `MathOperations<T extends Number>` with a bounded type parameter `T` to represent different numeric types.
        - Implement generic methods for `add`, `subtract`, `multiply`, and `divide` operations.
    - **Description:**
        - The `MathOperations` class demonstrates how to use generics to handle different numeric types.
        - The `add`, `subtract`, `multiply`, and `divide` methods allow for performing mathematical operations on any numeric type, showcasing the flexibility of generics.
2. **Ensure Type Inference:**
    
    - **Methods to Implement:**
        - `performOperations`: A method that uses type inference to seamlessly perform operations on various numeric types.
    - **Description:**
        - The `performOperations` method demonstrates how to use type inference in Java Generics to handle different numeric types without explicit type declaration, ensuring seamless usage.
3. **Write Unit Tests for Generic Mathematical Operations:**
    
    - **Methods to Implement:**
        - `testAdd`, `testSubtract`, `testMultiply`, `testDivide`: Methods to test the correctness of the generic mathematical operations.
    - **Description:**
        - The `testAdd`, `testSubtract`, `testMultiply`, and `testDivide` methods are unit tests that validate the correctness of the generic mathematical operations, reinforcing the concept of type safety in operations.