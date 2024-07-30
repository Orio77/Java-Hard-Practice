## Task 1

You are tasked with creating a robust file handling system for the digital learning platform. Your task is to implement two methods: `readFileWithExceptionHandling` and `writeFileWithExceptionHandling`.

The `readFileWithExceptionHandling` method should:

1. Accept a file path as a parameter.
2. Open the file using a `FileReader`.
3. Read the file line by line using a `BufferedReader`.
4. Implement error handling to catch `FileNotFoundException` and `IOException`.
5. If an exception is caught, it should print a custom error message and return an empty string.
6. If no exception is caught, it should return the content of the file as a string.

The `writeFileWithExceptionHandling` method should:

1. Accept a file path and a string content as parameters.
2. Open the file using a `FileWriter`.
3. Write the content to the file using a `BufferedWriter`.
4. Implement error handling to catch `IOException`.
5. If an exception is caught, it should print a custom error message and return `false`.
6. If no exception is caught, it should return `true` indicating the operation was successful.

Example:

readFileWithExceptionHandling("nonexistent.txt"); // Output: "Error: File not found."

writeFileWithExceptionHandling("readonly.txt", "Hello, world!"); // Output: "Error: Unable to write to file."

## Task 2

Drawn Topic: File Permissions

Your task is to implement two methods: `checkFilePermissions` and `changeFilePermissions`.

The `checkFilePermissions` method should:

1. Accept a file path as a parameter.
2. Use the `Files` class to check if the file is readable, writable, and executable.
3. Implement error handling to catch `SecurityException`.
4. If an exception is caught, it should print a custom error message and return `null`.
5. If no exception is caught, it should return a boolean array with three elements indicating if the file is readable, writable, and executable respectively.

The `changeFilePermissions` method should:

1. Accept a file path and three boolean values indicating the desired read, write, and execute permissions respectively.
2. Use the `Files` class to change the file permissions.
3. Implement error handling to catch `IOException` and `SecurityException`.
4. If an exception is caught, it should print a custom error message and return `false`.
5. If no exception is caught, it should return `true` indicating the operation was successful.

Example:

checkFilePermissions("readonly.txt"); // Output: [true, false, false]

changeFilePermissions("readonly.txt", true, true, false); // Output: "Error: Unable to change file permissions."

## Task 3

Drawn Topic: File Attributes

Your task is to implement two methods: `getFileAttributes` and `setFileAttributes`.

The `getFileAttributes` method should:

1. Accept a file path as a parameter.
2. Use the `Files` class to get the size, creation time, and last modified time of the file.
3. Implement error handling to catch `IOException`.
4. If an exception is caught, it should print a custom error message and return `null`.
5. If no exception is caught, it should return a map with keys "size", "creationTime", and "lastModifiedTime" and their corresponding values.

The `setFileAttributes` method should:

1. Accept a file path and a map with keys "creationTime" and "lastModifiedTime" and their corresponding `FileTime` values.
2. Use the `Files` class to set the creation time and last modified time of the file.
3. Implement error handling to catch `IOException`.
4. If an exception is caught, it should print a custom error message and return `false`.
5. If no exception is caught, it should return `true` indicating the operation was successful.

Example:

getFileAttributes("file.txt"); // Output: {"size": 1024, "creationTime": "2022-01-01T00:00:00Z", "lastModifiedTime": "2022-01-02T00:00:00Z"}

setFileAttributes("file.txt", {"creationTime": "2022-01-03T00:00:00Z", "lastModifiedTime": "2022-01-04T00:00:00Z"}); // Output: "Error: Unable to set file attributes."

## Task 4

Drawn Topic: File Path Operations

Your task is to implement three methods: `getFilePathDetails`, `renameFile`, and `moveFile`.

The `getFilePathDetails` method should:

1. Accept a file path as a parameter.
2. Use the `Path` class to get the parent directory, file name, and file extension.
3. Implement error handling to catch `InvalidPathException`.
4. If an exception is caught, it should print a custom error message and return `null`.
5. If no exception is caught, it should return a map with keys "parentDirectory", "fileName", and "fileExtension" and their corresponding values.

The `renameFile` method should:

1. Accept a file path and a new file name as parameters.
2. Use the `Files` class to rename the file.
3. Implement error handling to catch `IOException`.
4. If an exception is caught, it should print a custom error message and return `false`.
5. If no exception is caught, it should return `true` indicating the operation was successful.

The `moveFile` method should:

1. Accept a source file path and a destination file path as parameters.
2. Use the `Files` class to move the file from the source to the destination.
3. Implement error handling to catch `IOException`.
4. If an exception is caught, it should print a custom error message and return `false`.
5. If no exception is caught, it should return `true` indicating the operation was successful.

Example:

getFilePathDetails("C:\\Users\\User\\Documents\\file.txt"); // Output: {"parentDirectory": "C:\\Users\\User\\Documents", "fileName": "file", "fileExtension": "txt"}

renameFile("C:\\Users\\User\\Documents\\file.txt", "newfile.txt"); // Output: "Error: Unable to rename file."

moveFile("C:\\Users\\User\\Documents\\file.txt", "C:\\Users\\User\\Desktop\\file.txt"); // Output: "Error: Unable to move file."