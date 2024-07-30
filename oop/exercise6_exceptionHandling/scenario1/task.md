1. Develop a file handling module with methods for reading and writing files.

   - Your `FileHandler` class should have methods `readFile(String filePath)` and `writeFile(String filePath, String content)`. The `readFile` method should return the content of the file as a string, and the `writeFile` method should write the given content to the file at the specified path.
   - _Potential input_: `FileHandler handler = new FileHandler(); handler.readFile("path/to/file.txt"); handler.writeFile("path/to/file.txt", "Hello, world!");`
   - _Desired Output_: The content of the file, and no output for the `writeFile` method.
   - _Coach Suggestions_: Use the `java.nio.file` package for file operations. The `Files.readAllLines` and `Files.write` methods can be used for reading and writing files, respectively.

2. Implement exception handling to address file not found or permission issues.

   - Wrap your file operations in a try-catch block to handle `IOException`. In the catch block, print a user-friendly error message and rethrow the exception.
   - _Potential input_: `handler.readFile("nonexistent/path.txt");`
   - _Desired Output_: "Error: File not found at path nonexistent/path.txt"
   - _Coach Suggestions_: Use a try-catch block to handle `IOException` when reading and writing files. In the catch block, print an error message that includes the file path and the exception message, then rethrow the exception.

3. Ensure robust error handling to prevent data loss.

   - Implement a backup mechanism in your `writeFile` method. Before writing to the file, create a backup of the current file content. If writing fails, restore the backup.
   - _Potential input_: `handler.writeFile("path/with/no/permission.txt", "Hello, world!");`
   - _Desired Output_: "Error: Unable to write to file at path path/with/no/permission.txt. Data has been restored from backup."
   - _Coach Suggestions_: Before writing to the file, read its current content and store it in a variable. In the catch block of your try-catch statement, write this backup content back to the file.
