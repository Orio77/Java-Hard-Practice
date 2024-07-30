## Exercise Documentation

### List of Classes to Create

1. `SocialData<T>`
2. `DataProcessor<T>`
3. `SocialDataProcessor<T extends SocialData<?>>`
4. `AnalyticsEngine`

### List of Classes and Their Methods

#### `SocialData<T>`

- `getData()`: This method should return the social data.
- `setData(T data)`: This method should set the social data.

#### `DataProcessor<T>`

- `process(T data)`: This method should simulate processing a piece of social data and print a message.

#### `SocialDataProcessor<T extends SocialData<?>>`

- `process(T data)`: This method should simulate processing a piece of social data and print a message.

#### `AnalyticsEngine`

- `setDataProcessor(DataProcessor<?> dataProcessor)`: This method should allow the data processor to be changed at runtime.
- `processData(SocialData<?> data)`: This method should process the data using the current data processor. This method should handle possible errors and print a message if the data cannot be processed.
- `analyze(String id)`: This method should retrieve the data using the current data processor and perform some analysis. This method should handle possible errors and print a message if the data cannot be analyzed.

### General Overview

The exercise is designed to practice using Java Generics and wildcard types in different scenarios, particularly in the context of a social media analytics tool. The `SocialData` class encapsulates a piece of social data. The `DataProcessor` interface defines a method for processing a piece of social data. The `SocialDataProcessor` class implements the `DataProcessor` interface and ensures that the social data can be processed. The `AnalyticsEngine` class uses a `DataProcessor` and allows the data processor to be changed at runtime.

### Example Workflow

1. A `SocialData` object is created, representing a piece of social data to be processed.
2. A `SocialDataProcessor` object is created, which implements the `DataProcessor` interface.
3. An `AnalyticsEngine` object is created, which uses a `DataProcessor`.
4. The `setDataProcessor` method of the `AnalyticsEngine` object is called, passing in the `SocialDataProcessor` object.
5. The `processData` method of the `AnalyticsEngine` object is called, passing in the `SocialData` object.
6. If the data can be processed, the `process` method of the `SocialDataProcessor` object is called, printing a message.
7. If the data cannot be processed, a message is printed indicating that the data cannot be processed.
8. The `analyze` method of the `AnalyticsEngine` object is called, passing in an id.
9. If the data can be analyzed, the analysis is performed and the results are returned.
10. If the data cannot be analyzed, a message is printed indicating that the data cannot be analyzed.