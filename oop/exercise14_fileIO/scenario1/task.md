**Advanced File Management System**

- **Task 1**: Create a class `TextFile` with properties `name` and `content`. Implement a constructor that sets these properties and methods `read()` and `write(String newContent)` that get and set the `content` property, respectively.
- **Task 2**: Create a class `FileManager` with a property `files` (a list of `TextFile` objects). Implement methods `createFile(String name, String content)` that creates a new `TextFile` and adds it to `files`, and `findFile(String name)` that returns the `TextFile` with the given name.
- **Task 3**: Create a class `User` with properties `name` and `fileManager` (a `FileManager` object). Implement a constructor that sets the `name` property and initializes `fileManager` as a new `FileManager`. Implement methods `createFile(String name, String content)` and `editFile(String name, String newContent)` that create and edit files using the `FileManager`.

**Further practise**:

1. **Advanced File Management System – Enhanced Details**:
    - **TextFile**: Extend the `TextFile` class to include a method `append(String additionalContent)` that adds content to the end of the file.
    - **FileManager**: Extend the `FileManager` class to include a method `deleteFile(String name)` that removes the `TextFile` with the given name from `files`.
2. **File Management System with Directories – Enhanced Details**:
    - **Directory**: Create a class `Directory` with properties `name` and `files` (a list of `TextFile` objects). Implement methods `addFile(TextFile file)` and `removeFile(String name)` that add and remove files from the directory.
    - **FileManager**: Extend the `FileManager` class to include a property `directories` (a list of `Directory` objects) and methods `createDirectory(String name)` and `findDirectory(String name)` that create and find directories.
3. **Customizable File Management System – Enhanced Details**:
    - **FileManagementStrategy**: Create an interface `FileManagementStrategy` with methods `createFile(String name, String content)`, `findFile(String name)`, `deleteFile(String name)`, `createDirectory(String name)`, and `findDirectory(String name)`. Make `FileManager` a class that uses a `FileManagementStrategy` to perform these operations.
    - **User**: Extend the `User` class to include methods `createDirectory(String name)` and `moveFile(String fileName, String directoryName)` that create directories and move files between directories.