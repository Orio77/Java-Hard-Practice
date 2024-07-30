## Task 1

**Problem Statement:**

You are given a large dataset in a text file. Your task is to implement two methods:

1. `bufferedRead(String filePath)`: This method should read the file using a buffered reader and return the content as a String. You should handle any exceptions that might occur during the file reading process.
    
2. `bufferedWrite(String filePath, String content)`: This method should write the given content to the file at the specified path using a buffered writer. If the file does not exist, create it. Handle any exceptions that might occur during the file writing process.
    

**Example:**

Input:

bufferedRead("input.txt");

bufferedWrite("output.txt", "Hello, World!");

Output:

"Hello, World!"

## Task 2

**Problem Statement:**

Drawn Topic: File Permissions

You are given a file with restricted permissions. Your task is to implement two methods:

1. `checkPermissions(String filePath)`: This method should check and return the current permissions of the file.
    
2. `changePermissions(String filePath, Set<PosixFilePermission> permissions)`: This method should change the permissions of the file to the given set of permissions.
    

**Example:**

Input:

checkPermissions("restricted.txt");

changePermissions("restricted.txt", PosixFilePermissions.fromString("rw-r--r--"));

Output:

"r--r--r--"

## Task 3

**Problem Statement:**

Drawn Topic: File Attributes

You are given a file. Your task is to implement two methods:

1. `getFileAttributes(String filePath)`: This method should return the basic file attributes of the file.
    
2. `setLastModifiedTime(String filePath, FileTime time)`: This method should set the last modified time of the file to the given time.
    

**Example:**

Input:

getFileAttributes("file.txt");

setLastModifiedTime("file.txt", FileTime.fromMillis(System.currentTimeMillis()));

Output:

"BasicFileAttributes[creationTime=2022-01-01T00:00:00Z,lastAccessTime=2022-01-01T00:00:00Z,lastModifiedTime=2022-01-01T00:00:00Z,size=1024,isRegularFile=true,isDirectory=false,isSymbolicLink=false,isOther=false,fileKey=null]"

## Task 4

**Problem Statement:**

Drawn Topic: File Path Operations

You are given a file. Your task is to implement three methods:

1. `getAbsolutePath(String filePath)`: This method should return the absolute path of the file.
    
2. `getRelativePath(String filePath, String basePath)`: This method should return the relative path of the file from the given base path.
    
3. `normalizePath(String filePath)`: This method should normalize the file path and return it.
    

**Example:**

Input:

getAbsolutePath("file.txt");

getRelativePath("file.txt", "/home/user");

normalizePath("file.txt");

Output:

"/home/user/documents/file.txt"

"documents/file.txt"

"file.txt"