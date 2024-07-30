**Refined Scenario 1:** You are developing a database access layer for a web application. Implement error handling mechanisms to gracefully manage generic-related compilation errors when querying the database with generic types, ensuring type safety and developer-friendly error messages.

**Sprint Tasks:**

1. **Create Error-Handling Strategies for Common Generic Compilation Issues:**
    
    - **Methods to Implement:**
        - Define a `handleGenericError` method that accepts an `Exception` and a `Class<T>` object, and returns a `DatabaseResult<T>`.
    - **Description:**
        - The `handleGenericError` method demonstrates how generics can be used in error handling to provide type-safe and flexible error handling strategies.
2. **Implement Clear Error Messages and Logging to Aid Developers in Identifying and Resolving Issues:**
    
    - **Methods to Implement:**
        - Implement a `logError` method that accepts an `Exception` and a `Class<T>` object, and logs the error message and the generic type that caused the error.
    - **Description:**
        - The `logError` method shows how generics can be used to provide clear and helpful error messages and logging, aiding developers in identifying and resolving issues.
3. **Ensure that the Database Access Layer Provides Helpful Feedback for Handling Generic-Related Errors:**
    
    - **Methods to Implement:**
        - Implement a `queryDatabase` method that accepts a `Query<T>` object and returns a `DatabaseResult<T>`. This method should catch any exceptions, log the error, and return a `DatabaseResult` with an error message.
    - **Description:**
        - The `queryDatabase` method demonstrates how generics can be used to provide helpful feedback when querying the database, showcasing the power and flexibility of generics in error handling.