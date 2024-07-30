**Advanced File Management System**

- **Task 1**: Create a class `FileManager` with methods for `openFile(String filePath)`, `readFile(String filePath)`, `writeFile(String filePath, String content)`, and `closeFile(String filePath)`. Each method should throw an appropriate exception if an error occurs.
    
    - `openFile(String filePath)`: This method should throw a `FileNotFoundException` if the file does not exist.
    - `readFile(String filePath)`: This method should throw an `IOException` if an error occurs while reading the file.
    - `writeFile(String filePath, String content)`: This method should throw an `IOException` if an error occurs while writing to the file.
    - `closeFile(String filePath)`: This method should throw an `IOException` if an error occurs while closing the file.
- **Task 2**: Implement a method `manageFile(String filePath, String operation, String content)` that performs the specified operation (`open`, `read`, `write`, or `close`) on the specified file. This method should catch any exceptions thrown by the `FileManager` methods and handle them appropriately.
    
    - In `manageFile(String filePath, String operation, String content)`, use a `try-catch` block to catch any exceptions thrown by the `FileManager` methods. In the `catch` block, print an error message and rethrow the exception.
- **Task 3**: Design a class `FileManagementSystem` that uses the `FileManager` class to manage files. Implement a method `manageFiles(List<FileDetail> fileDetails)` that manages multiple files based on the provided `FileDetail` objects.
    
    - In `manageFiles(List<FileDetail> fileDetails)`, iterate over the `FileDetail` objects and for each one, call `manageFile(String filePath, String operation, String content)` with the details from the `FileDetail` object.

**Further practise**:

1. **Advanced File Management – Enhanced Details**:
    
    - Implement `isEligibleForWrite(File file)` to check if the file is eligible for write operations based on its details (e.g., permissions, size).
2. **Tier-Based File Operation Logic – Enhanced Details**:
    
    - Implement different operation logic for different tiers of files. For example, small files may support all operations, while large files may only support read and write operations.
3. **Customizable File Operation Policy – Enhanced Details**:
    
    - **Functionality Description**: Integrate the Strategy pattern into the file operation logic. Define a `FileOperationStrategy` interface with a method `performOperation(File file, String operation)`.
    - **SmallFileOperation**: Implement this strategy to perform operations on small files. This strategy should be used when the file is small.
    - **LargeFileOperation**: Implement this strategy to perform operations on large files. This strategy should be used when the file is large.