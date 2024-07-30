## Task 1

**Problem Statement:**

You are tasked with creating a secure file transmission system. Implement two methods:

1. `serializeObjectToFile(Object obj, String filePath)`: This method should serialize the given object to a file at the specified file path. The object should be encrypted before writing to the file. Use a simple Caesar cipher for encryption.
    
2. `deserializeObjectFromFile(String filePath)`: This method should read the file from the given file path, decrypt the contents using the same Caesar cipher, and then deserialize the object.
    

**Example:**

Input: `serializeObjectToFile("Hello, World!", "path/to/file")` Output: File at "path/to/file" contains encrypted version of "Hello, World!"

Input: `deserializeObjectFromFile("path/to/file")` Output: "Hello, World!"

---

## Task 2

**Topic: File Permissions**

**Problem Statement:**

In addition to the previous task, now you need to ensure that the files are secure. Implement two methods:

1. `setFilePermissions(String filePath, Set<PosixFilePermission> permissions)`: This method should set the given permissions to the file at the specified file path.
    
2. `getFilePermissions(String filePath)`: This method should return the current permissions of the file at the given file path.
    

**Example:**

Input: `setFilePermissions("path/to/file", PosixFilePermissions.fromString("rwxr-x---"))` Output: The file at "path/to/file" now has permissions "rwxr-x---".

Input: `getFilePermissions("path/to/file")` Output: "rwxr-x---"

---

## Task 3

**Topic: File Handling with Data Structures**

**Problem Statement:**

Now, you need to handle multiple files. Implement two methods:

1. `serializeObjectsToFiles(Map<String, Object> objects, String directoryPath)`: This method should serialize each object in the map to a separate file in the specified directory. The key in the map should be the name of the file.
    
2. `deserializeObjectsFromFiles(String directoryPath)`: This method should read all the files in the given directory, decrypt and deserialize each object, and return a map where the key is the file name and the value is the deserialized object.
    

**Example:**

Input: `serializeObjectsToFiles({"file1": "Hello, World!", "file2": "Goodbye, World!"}, "path/to/directory")` Output: Two files "file1" and "file2" in the directory "path/to/directory" each containing the encrypted version of "Hello, World!" and "Goodbye, World!" respectively.

Input: `deserializeObjectsFromFiles("path/to/directory")` Output: `{"file1": "Hello, World!", "file2": "Goodbye, World!"}`

---

## Task 4

**Topic: Performance Optimization**

**Problem Statement:**

The current implementation is not efficient for large files. Implement three methods:

1. `serializeLargeObjectToFile(Object obj, String filePath)`: This method should serialize the given object to a file at the specified file path. The object should be encrypted before writing to the file. Use a simple Caesar cipher for encryption. This method should be optimized for large objects.
    
2. `deserializeLargeObjectFromFile(String filePath)`: This method should read the file from the given file path, decrypt the contents using the same Caesar cipher, and then deserialize the object. This method should be optimized for large files.
    
3. `comparePerformance(String smallFilePath, String largeFilePath)`: This method should compare the performance of serializing and deserializing a small file and a large file. It should return a string describing which method is faster and by how much.
    

**Example:**

Input: `serializeLargeObjectToFile("Hello, World!", "path/to/file")` Output: File at "path/to/file" contains encrypted version of "Hello, World!"

Input: `deserializeLargeObjectFromFile("path/to/file")` Output: "Hello, World!"

Input: `comparePerformance("path/to/smallFile", "path/to/largeFile")` Output: "Deserializing the large file is slower than the small file by 2 seconds."