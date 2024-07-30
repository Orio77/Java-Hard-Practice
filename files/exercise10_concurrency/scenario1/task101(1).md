Task 1

Problem: Implement a concurrent file backup system.

You need to implement two methods:

1. `backupFiles(List<String> filePaths, String backupDirectory)`: This method takes a list of file paths and a backup directory as input. It should read each file concurrently, create a backup in the specified directory, and return a list of the backup file paths. Handle any file reading and writing exceptions appropriately.
    
2. `restoreFiles(List<String> backupFilePaths, String restoreDirectory)`: This method takes a list of backup file paths and a restore directory as input. It should restore each file concurrently to the specified directory and return a list of the restored file paths. Handle any file reading and writing exceptions appropriately.
    

Example:

Input: `backupFiles(["/user/data/file1.txt", "/user/data/file2.txt"], "/user/backup")` Output: `["/user/backup/file1.txt", "/user/backup/file2.txt"]`

Input: `restoreFiles(["/user/backup/file1.txt", "/user/backup/file2.txt"], "/user/restore")` Output: `["/user/restore/file1.txt", "/user/restore/file2.txt"]`

Task 2

Topic: File Permissions

Problem: Implement a system that checks and modifies file permissions concurrently.

You need to implement two methods:

1. `checkPermissions(List<String> filePaths)`: This method takes a list of file paths as input. It should check the permissions of each file concurrently and return a map where the key is the file path and the value is a boolean indicating if the file is writable.
    
2. `makeWritable(List<String> filePaths)`: This method takes a list of file paths as input. It should change the permissions of each file concurrently to make them writable. The method should return a list of file paths that were successfully changed.
    

Example:

Input: `checkPermissions(["/user/data/file1.txt", "/user/data/file2.txt"])` Output: `{"/user/data/file1.txt": true, "/user/data/file2.txt": false}`

Input: `makeWritable(["/user/data/file1.txt", "/user/data/file2.txt"])` Output: `["/user/data/file2.txt"]`

Task 3

Topic: File Attributes

Problem: Implement a system that retrieves and modifies file attributes concurrently.

You need to implement two methods:

1. `getCreationTimes(List<String> filePaths)`: This method takes a list of file paths as input. It should retrieve the creation time of each file concurrently and return a map where the key is the file path and the value is the creation time.
    
2. `setLastModifiedTime(List<String> filePaths, LocalDateTime time)`: This method takes a list of file paths and a time as input. It should set the last modified time of each file to the specified time concurrently. The method should return a list of file paths that were successfully modified.
    

Example:

Input: `getCreationTimes(["/user/data/file1.txt", "/user/data/file2.txt"])` Output: `{"/user/data/file1.txt": 2022-01-01T00:00, "/user/data/file2.txt": 2022-01-02T00:00}`

Input: `setLastModifiedTime(["/user/data/file1.txt", "/user/data/file2.txt"], 2022-01-03T00:00)` Output: `["/user/data/file1.txt", "/user/data/file2.txt"]`

Task 4

Topic: File Handling with Data Structures

Problem: Implement a system that reads and writes data from files into data structures concurrently.

You need to implement three methods:

1. `readFilesIntoMap(List<String> filePaths)`: This method takes a list of file paths as input. It should read each file concurrently and store its content into a map where the key is the file path and the value is the content of the file.
    
2. `writeMapIntoFiles(Map<String, String> fileContents, String directory)`: This method takes a map of file contents and a directory as input. It should write the content of each entry in the map into a file in the specified directory concurrently. The name of the file should be the key of the entry. The method should return a list of the created file paths.
    
3. `readFilesIntoList(List<String> filePaths)`: This method takes a list of file paths as input. It should read each file concurrently and store its content into a list. The method should return the list of file contents.
    

Example:

Input: `readFilesIntoMap(["/user/data/file1.txt", "/user/data/file2.txt"])` Output: `{"/user/data/file1.txt": "content1", "/user/data/file2.txt": "content2"}`

Input: `writeMapIntoFiles({"/file1.txt": "content1", "/file2.txt": "content2"}, "/user/newDirectory")` Output: `["/user/newDirectory/file1.txt", "/user/newDirectory/file2.txt"]`

Input: `readFilesIntoList(["/user/data/file1.txt", "/user/data/file2.txt"])` Output: `["content1", "content2"]`