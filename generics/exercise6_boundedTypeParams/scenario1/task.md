**Refined Scenario:** Scenario 1: Develop a library for geometric shapes using Java Generics, creating a generic method that calculates the area of shapes, but restricts the method to accept only shapes that implement a specific `Shape` interface.

1. **Define a Generic Method for Area Calculation:**
    
    - **Methods to Implement:**
        - Define a generic method `calculateArea` with a bounded type parameter `T extends Shape` to represent different shapes.
    - **Description:**
        - The `calculateArea` method demonstrates how to use bounded type parameters to restrict the types that can be used with it.
        - This method can calculate the area of any shape that implements the `Shape` interface, showcasing the flexibility of generics.
2. **Specify the Bounding Interface `Shape`:**
    
    - **Methods to Implement:**
        - Define an interface `Shape` with a method `getArea` to be implemented by any shape.
    - **Description:**
        - The `Shape` interface ensures type safety by forcing any class that implements it to provide an implementation for the `getArea` method.
        - This interface is used as a bounding type in the `calculateArea` method to restrict the types that can be used with it.
3. **Implement the Method to Calculate Areas:**
    
    - **Methods to Implement:**
        - Implement the `calculateArea` method to calculate areas for classes that implement the `Shape` interface.
    - **Description:**
        - The implementation of the `calculateArea` method showcases how a generic method can be used with different types that extend or implement a specific class or interface.
        - This method calculates the area of any shape that implements the `Shape` interface, reinforcing the concept of bounded type parameters.