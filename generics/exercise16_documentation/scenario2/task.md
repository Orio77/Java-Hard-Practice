## Exercise Documentation

### List of Classes to Create

1. `DataHandler<T>`
2. `Repository<T>`
3. `DataRepository<T extends Serializable>`
4. `Application`

### List of Classes and Their Methods

#### `DataHandler<T>`

- `save(T data)`: This method should simulate saving data. The use of generics allows this method to accept any type of data.
- `load(String id)`: This method should simulate loading data. The id parameter is used to identify the data to be loaded.

#### `Repository<T>`

- `findById(String id)`: This method should simulate finding a data by its id. The use of generics allows this method to return any type of data.

#### `DataRepository<T extends Serializable>`

- `findById(String id)`: This method should simulate finding a data by its id. The use of generics allows this method to return any type of data. The bound `<T extends Serializable>` ensures that the data can be serialized.

#### `Application`

- `setRepository(Repository<?> repository)`: This method should allow the repository to be changed at runtime. The use of wildcard types allows this method to accept a repository of any type.
- `loadData(String id)`: This method should load the data using the current repository. This method should handle possible errors and print a message if the data cannot be loaded. The use of generics and wildcard types allows this method to work with a repository of any type.

### General Overview

The exercise is designed to practice using Java Generics and wildcard types in different scenarios, particularly in the context of a complex web application that relies heavily on generics for data handling. The `DataHandler` class encapsulates the logic for handling data in the application. The `Repository` interface defines a method for finding data by its id. The `DataRepository` class implements the `Repository` interface and ensures that the data can be serialized. The `Application` class uses a `Repository` and allows the repository to be changed at runtime.

### Example Workflow

1. A `DataHandler` object is created, representing the logic for handling data in the application.
2. A `DataRepository` object is created, which implements the `Repository` interface.
3. An `Application` object is created, which uses a `Repository`.
4. The `setRepository` method of the `Application` object is called, passing in the `DataRepository` object.
5. The `loadData` method of the `Application` object is called, passing in an id.
6. If the data can be loaded, the `findById` method of the `DataRepository` object is called, returning the data.
7. If the data cannot be loaded, a message is printed indicating that the data cannot be loaded.