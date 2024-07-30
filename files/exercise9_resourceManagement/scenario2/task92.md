## Task 1

**Problem:** You are tasked with creating a system that can read and write user-generated content. The system should be able to handle large amounts of data and ensure data longevity.

**Function 1:** `readContent(String filePath)`

This function should:

1. Take a file path as input.
2. Open the file using a Buffered Reader.
3. Read the file line by line.
4. Return the content of the file as a String.

**Function 2:** `writeContent(String filePath, String content)`

This function should:

1. Take a file path and content as input.
2. Open the file using a Buffered Writer.
3. Write the content to the file.
4. Close the file.

**Example:**

Input: `readContent("/path/to/file.txt")` Output: `"This is the content of the file"`

Input: `writeContent("/path/to/file.txt", "New content")` Output: `null` (The file at the given path should now contain "New content")

## Task 2

**Topic:** File Permissions

**Problem:** You need to ensure that only authorized users can access certain files.

**Function 1:** `checkPermission(String filePath)`

This function should:

1. Take a file path as input.
2. Check the file's permissions.
3. Return a boolean indicating whether the current user has read and write permissions.

**Function 2:** `changePermission(String filePath, boolean canRead, boolean canWrite)`

This function should:

1. Take a file path, a read permission, and a write permission as input.
2. Change the file's permissions based on the input.
3. Return a boolean indicating whether the operation was successful.

**Example:**

Input: `checkPermission("/path/to/file.txt")` Output: `true`

Input: `changePermission("/path/to/file.txt", false, false)` Output: `true` (The current user should now not have read or write permissions for the file)

## Task 3

**Topic:** File Attributes

**Problem:** You need to retrieve and update the attributes of a file.

**Function 1:** `getFileAttributes(String filePath)`

This function should:

1. Take a file path as input.
2. Retrieve the file's attributes.
3. Return a map with the file's attributes.

**Function 2:** `updateFileAttributes(String filePath, Map<String, Object> attributes)`

This function should:

1. Take a file path and a map of attributes as input.
2. Update the file's attributes based on the input.
3. Return a boolean indicating whether the operation was successful.

**Example:**

Input: `getFileAttributes("/path/to/file.txt")` Output: `{size: 1024, creationTime: 1632879123, lastModifiedTime: 1632879123}`

Input: `updateFileAttributes("/path/to/file.txt", {lastModifiedTime: 1632879124})` Output: `true` (The file's last modified time should now be 1632879124)

## Task 4

**Topic:** File Performance

**Problem:** You need to optimize the performance of file operations.

**Function 1:** `readFileFast(String filePath)`

This function should:

1. Take a file path as input.
2. Open the file using a Mapped Byte Buffer.
3. Read the file.
4. Return the content of the file as a String.

**Function 2:** `writeFileFast(String filePath, String content)`

This function should:

1. Take a file path and content as input.
2. Open the file using a File Channel.
3. Write the content to the file.
4. Close the file.

**Function 3:** `copyFileFast(String sourceFilePath, String destinationFilePath)`

This function should:

1. Take a source file path and a destination file path as input.
2. Open the source file using a File Channel.
3. Copy the content of the source file to the destination file.
4. Close the file.

**Example:**

Input: `readFileFast("/path/to/file.txt")` Output: `"This is the content of the file"`

Input: `writeFileFast("/path/to/file.txt", "New content")` Output: `null` (The file at the given path should now contain "New content")

Input: `copyFileFast("/path/to/sourceFile.txt", "/path/to/destinationFile.txt")` Output: `null` (The destination file should now contain the content of the source file)