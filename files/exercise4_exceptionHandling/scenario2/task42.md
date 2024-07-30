## Task 1

**Problem Statement:**

You are given a directory of animation assets. Each asset is a file that may contain references to other assets in its content. These references are file paths. Your task is to create two methods:

1. `findBrokenReferences(String directoryPath)`: This method should scan all files in the given directory, identify file paths in the content, and check if the referenced file exists. If a file does not exist, it should add the file path to a list. The method should return this list of broken references.
    
2. `fixBrokenReferences(String directoryPath, Map<String, String> replacements)`: This method should take the directory path and a map of broken references to their replacements. It should replace all occurrences of each broken reference in the file contents with its corresponding replacement. The method should return the number of replacements made.
    

**Input:**

- `findBrokenReferences("/path/to/directory")`
- `fixBrokenReferences("/path/to/directory", {"broken/path": "fixed/path"})`

**Output:**

- `findBrokenReferences`: `["broken/path"]`
- `fixBrokenReferences`: `3`

## Task 2

**Drawn Topic: File Permissions**

**Problem Statement:**

In addition to the previous task, the animation studio also wants to ensure that all asset files have the correct permissions. Your task is to create two methods:

1. `checkFilePermissions(String directoryPath)`: This method should scan all files in the given directory and return a list of files that do not have read and write permissions.
    
2. `fixFilePermissions(String directoryPath)`: This method should take the directory path and fix the permissions of all files in the directory to ensure they have read and write permissions. The method should return the number of files for which permissions were fixed.
    

**Input:**

- `checkFilePermissions("/path/to/directory")`
- `fixFilePermissions("/path/to/directory")`

**Output:**

- `checkFilePermissions`: `["file1", "file2"]`
- `fixFilePermissions`: `2`

## Task 3

**Drawn Topic: File Attributes**

**Problem Statement:**

The animation studio wants to keep track of when each asset was last modified. Your task is to create two methods:

1. `getLastModifiedTimes(String directoryPath)`: This method should return a map where each key is a file path and the corresponding value is the last modified time of the file.
    
2. `updateLastModifiedTime(String filePath, long newTime)`: This method should update the last modified time of the specified file to the new time provided. The method should return true if the operation was successful and false otherwise.
    

**Input:**

- `getLastModifiedTimes("/path/to/directory")`
- `updateLastModifiedTime("/path/to/file", 1633024800)`

**Output:**

- `getLastModifiedTimes`: `{"/path/to/file1": 1633024800, "/path/to/file2": 1633024800}`
- `updateLastModifiedTime`: `true`

## Task 4

**Drawn Topic: File Performance**

**Problem Statement:**

The animation studio is concerned about the performance of file operations. Your task is to create three methods:

1. `measureReadPerformance(String filePath)`: This method should measure the time it takes to read the specified file and return the time in milliseconds.
    
2. `measureWritePerformance(String filePath, String content)`: This method should measure the time it takes to write the specified content to the specified file and return the time in milliseconds.
    
3. `comparePerformance(String filePath1, String filePath2)`: This method should compare the read and write performance of the two specified files. It should return a map where each key is a file path and the corresponding value is a map with two keys, "read" and "write", and their corresponding times in milliseconds.
    

**Input:**

- `measureReadPerformance("/path/to/file")`
- `measureWritePerformance("/path/to/file", "new content")`
- `comparePerformance("/path/to/file1", "/path/to/file2")`

**Output:**

- `measureReadPerformance`: `15`
- `measureWritePerformance`: `20`
- `comparePerformance`: `{"/path/to/file1": {"read": 15, "write": 20}, "/path/to/file2": {"read": 10, "write": 15}}`