## Exercise Documentation

### List of Classes to Create

1. `Content<T>`
2. `Storage<T>`
3. `ContentStorage<T extends Content<?>>`
4. `ContentManager`

### List of Classes and Their Methods

#### `Content<T>`

- `getContent()`: This method should return the content.
- `setContent(T content)`: This method should set the content.

#### `Storage<T>`

- `store(T content)`: This method should simulate storing a piece of content and print a message.

#### `ContentStorage<T extends Content<?>>`

- `store(T content)`: This method should simulate storing a piece of content and print a message.

#### `ContentManager`

- `setStorage(Storage<?> storage)`: This method should allow the storage to be changed at runtime.
- `storeContent(Content<?> content)`: This method should store the content using the current storage. This method should handle possible errors and print a message if the content cannot be stored.
- `retrieveContent(String id)`: This method should retrieve the content using the current storage. This method should handle possible errors and print a message if the content cannot be retrieved. Also, implement type checking and casting where necessary to ensure the correct type of content is retrieved.

### General Overview

The exercise is designed to practice using Java Generics and wildcard types in different scenarios, particularly in the context of a content management system. The `Content` class encapsulates a piece of content. The `Storage` interface defines a method for storing a piece of content. The `ContentStorage` class implements the `Storage` interface and ensures that the content can be stored. The `ContentManager` class uses a `Storage` and allows the storage to be changed at runtime.

### Example Workflow

1. A `Content` object is created, representing a piece of content to be stored.
2. A `ContentStorage` object is created, which implements the `Storage` interface.
3. A `ContentManager` object is created, which uses a `Storage`.
4. The `setStorage` method of the `ContentManager` object is called, passing in the `ContentStorage` object.
5. The `storeContent` method of the `ContentManager` object is called, passing in the `Content` object.
6. If the content can be stored, the `store` method of the `ContentStorage` object is called, printing a message.
7. If the content cannot be stored, a message is printed indicating that the content cannot be stored.
8. The `retrieveContent` method of the `ContentManager` object is called, passing in an id.
9. If the content can be retrieved, the content is returned.
10. If the content cannot be retrieved, a message is printed indicating that the content cannot be retrieved.