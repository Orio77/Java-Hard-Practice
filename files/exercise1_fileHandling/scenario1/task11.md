Task 1: File Handling with Buffer Handling and File Channels

Problem: Implement two methods, `bufferedFileRead(String filePath)` and `fileChannelCopy(String sourcePath, String destinationPath)`.

The `bufferedFileRead` method should read a file using a BufferedInputStream and return the content as a String. It should handle any exceptions and return an empty string if the file cannot be read.

The `fileChannelCopy` method should copy a file from the source path to the destination path using File Channels and Buffers. It should return a boolean indicating whether the copy was successful or not. It should handle any exceptions and return false if the copy operation fails.

Example:

bufferedFileRead("source.txt"); // Returns the content of source.txt as a String

fileChannelCopy("source.txt", "destination.txt"); // Returns true if the copy was successful, false otherwise

Task 2: File Handling with File Permissions

Problem: Implement two methods, `checkFilePermissions(String filePath)` and `setFilePermissions(String filePath, Set<PosixFilePermission> permissions)`.

The `checkFilePermissions` method should return a Set of PosixFilePermission indicating the current permissions of the file at the given path. It should handle any exceptions and return an empty set if the permissions cannot be retrieved.

The `setFilePermissions` method should set the permissions of the file at the given path to the provided Set of PosixFilePermission. It should return a boolean indicating whether the operation was successful or not. It should handle any exceptions and return false if the operation fails.

Example:

checkFilePermissions("file.txt"); // Returns the current permissions of file.txt as a Set of PosixFilePermission

setFilePermissions("file.txt", PosixFilePermissions.fromString("rwxrwxrwx")); // Returns true if the operation was successful, false otherwise

Task 3: File Handling with File Attributes

Problem: Implement two methods, `getFileAttributes(String filePath)` and `setFileAttributes(String filePath, FileTime lastModifiedTime)`.

The `getFileAttributes` method should return a BasicFileAttributes object representing the attributes of the file at the given path. It should handle any exceptions and return null if the attributes cannot be retrieved.

The `setFileAttributes` method should set the last modified time of the file at the given path to the provided FileTime. It should return a boolean indicating whether the operation was successful or not. It should handle any exceptions and return false if the operation fails.

Example:

getFileAttributes("file.txt"); // Returns the attributes of file.txt as a BasicFileAttributes object

setFileAttributes("file.txt", FileTime.fromMillis(System.currentTimeMillis())); // Returns true if the operation was successful, false otherwise

Task 4: File Handling with File Path Operations

Problem: Implement three methods, `getFilePath(String fileName)`, `getFileName(String filePath)` and `renameFile(String oldFilePath, String newFilePath)`.

The `getFilePath` method should return the absolute path of the file with the given name in the current directory. It should handle any exceptions and return an empty string if the path cannot be retrieved.

The `getFileName` method should return the name of the file at the given path. It should handle any exceptions and return an empty string if the name cannot be retrieved.

The `renameFile` method should rename the file at the old file path to the new file path. It should return a boolean indicating whether the operation was successful or not. It should handle any exceptions and return false if the operation fails.

Example:

getFilePath("file.txt"); // Returns the absolute path of file.txt in the current directory

getFileName("/path/to/file.txt"); // Returns "file.txt"

renameFile("/path/to/oldFile.txt", "/path/to/newFile.txt"); // Returns true if the operation was successful, false otherwise