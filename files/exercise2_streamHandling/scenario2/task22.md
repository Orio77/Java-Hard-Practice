Task 1: Stream Handling with Buffer and File Channels

Problem: You are given a large text file. Your task is to implement two methods:

1. `bufferedRead(String filePath)`: This method should read the file using a buffer. It should return a list of strings, where each string is a line from the file. The buffer size should be adjustable.
    
2. `writeWithChannel(String filePath, List<String> data)`: This method should write the given data to a file using a FileChannel. Each string in the list should be a new line in the file.
    

Example:

Input:

bufferedRead("input.txt");

writeWithChannel("output.txt", Arrays.asList("Hello", "World"));

Output:

["This is line 1", "This is line 2", ...] // output of bufferedRead

// output.txt now contains:

// Hello

// World

Task 2: Stream Handling with File Permissions

Problem: You are given a file path. Your task is to implement two methods:

1. `checkPermissions(String filePath)`: This method should return a map with the file's permissions. The keys should be "read", "write", and "execute", and the values should be boolean.
    
2. `setPermissions(String filePath, Map<String, Boolean> permissions)`: This method should set the file's permissions based on the given map.
    

Example:

Input:

checkPermissions("input.txt");

setPermissions("input.txt", Map.of("read", true, "write", false, "execute", false));

Output:

{"read": true, "write": true, "execute": false} // output of checkPermissions

// input.txt now has read permissions but not write or execute

Task 3: Stream Handling with File Attributes

Problem: You are given a file path. Your task is to implement two methods:

1. `getFileAttributes(String filePath)`: This method should return a map with the file's attributes. The keys should be "size", "creationTime", and "lastModifiedTime", and the values should be the corresponding attribute values.
    
2. `setLastModifiedTime(String filePath, FileTime time)`: This method should set the file's last modified time to the given time.
    

Example:

Input:

getFileAttributes("input.txt");

setLastModifiedTime("input.txt", FileTime.fromMillis(System.currentTimeMillis()));

Output:

{"size": 1024, "creationTime": "2022-01-01T00:00:00Z", "lastModifiedTime": "2022-01-02T00:00:00Z"} // output of getFileAttributes

// input.txt's last modified time is now the current time

Task 4: Stream Handling with File Path Operations

Problem: You are given a file path. Your task is to implement three methods:

1. `getAbsolutePath(String filePath)`: This method should return the absolute path of the file.
    
2. `getRelativePath(String filePath, String basePath)`: This method should return the relative path of the file from the given base path.
    
3. `renameFile(String filePath, String newName)`: This method should rename the file to the given new name.
    

Example:

Input:

getAbsolutePath("input.txt");

getRelativePath("input.txt", "/home/user");

renameFile("input.txt", "newName.txt");

Output:

"/home/user/documents/input.txt" // output of getAbsolutePath

"documents/input.txt" // output of getRelativePath

// input.txt is now named newName.txt