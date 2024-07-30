Task 1

Problem: You are given a directory of architectural plans and 3D models. Each file represents a different project. Your task is to implement two methods:

1. `optimizeFileRead(String directory)`: This method should read all the files in the directory using a buffer to improve performance. It should return a Map where the key is the file name and the value is the content of the file.
    
2. `writeOptimizedFiles(Map<String, String> files, String outputDirectory)`: This method should write the content of each file in the Map to a new directory using a buffer to improve performance. The name of each file should be the same as the original file.
    

Example:

Input:

optimizeFileRead("C:\\Projects");

writeOptimizedFiles(files, "C:\\OptimizedProjects");

Output: All files in the "C:\Projects" directory are read and written to the "C:\OptimizedProjects" directory.

Task 2

Topic: File Permissions

Problem: Your task is to implement two methods:

1. `checkPermissions(String filePath)`: This method should check the permissions of a file. It should return a Map with the keys "read", "write", and "execute", and the corresponding values should be true if the operation is allowed and false if it is not.
    
2. `setPermissions(String filePath, Map<String, Boolean> permissions)`: This method should set the permissions of a file according to the given Map.
    

Example:

Input:

checkPermissions("C:\\Projects\\project1.txt");

setPermissions("C:\\Projects\\project1.txt", Map.of("read", true, "write", true, "execute", false));

Output: The permissions of the file "C:\Projects\project1.txt" are checked and then set.

Task 3

Topic: File Attributes

Problem: Your task is to implement two methods:

1. `getFileAttributes(String filePath)`: This method should return a Map with the file's attributes. The keys should be the attribute names and the values should be the attribute values.
    
2. `setFileAttributes(String filePath, Map<String, Object> attributes)`: This method should set the file's attributes according to the given Map.
    

Example:

Input:

getFileAttributes("C:\\Projects\\project1.txt");

setFileAttributes("C:\\Projects\\project1.txt", Map.of("creationTime", FileTime.fromMillis(System.currentTimeMillis())));

Output: The attributes of the file "C:\Projects\project1.txt" are retrieved and then set.

Task 4

Topic: File Path Operations

Problem: Your task is to implement three methods:

1. `getRelativePath(String baseDirectory, String filePath)`: This method should return the relative path from the base directory to the file.
    
2. `getAbsolutePath(String baseDirectory, String relativePath)`: This method should return the absolute path given the base directory and the relative path.
    
3. `moveFile(String sourceFilePath, String targetFilePath)`: This method should move a file from the source file path to the target file path.
    

Example:

Input:

getRelativePath("C:\\Projects", "C:\\Projects\\project1.txt");

getAbsolutePath("C:\\Projects", "project1.txt");

moveFile("C:\\Projects\\project1.txt", "C:\\ArchivedProjects\\project1.txt");

Output: The relative path, the absolute path, and the movement of the file are performed.