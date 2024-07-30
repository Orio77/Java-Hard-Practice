## Task 1

**Problem Statement:**

You are given a directory of legal documents. Each document is encoded in a different character encoding. Your task is to implement two methods:

1. `detectEncoding(String filePath)`: This method should take the file path as input and return the character encoding of the file. Use a library like ICU4J to detect the encoding.
    
2. `convertEncoding(String filePath, String targetEncoding)`: This method should take the file path and a target encoding as input. It should convert the file to the target encoding and save it with the same name in a new directory.
    

**Example:**

Input:

detectEncoding("/documents/case1.txt")

convertEncoding("/documents/case1.txt", "UTF-8")

Output:

"ISO-8859-1"

File "/converted_documents/case1.txt" is saved in UTF-8 encoding.

## Task 2

**Topic: File Permissions**

**Problem Statement:**

You need to ensure that only authorized personnel can access the legal documents. Implement two methods:

1. `setPermissions(String filePath, Set<PosixFilePermission> permissions)`: This method should take a file path and a set of POSIX file permissions. It should set these permissions on the file.
    
2. `checkPermission(String filePath, PosixFilePermission permission)`: This method should take a file path and a POSIX file permission. It should return whether the file has this permission.
    

**Example:**

Input:

setPermissions("/documents/case1.txt", PosixFilePermissions.fromString("rwxr-----"))

checkPermission("/documents/case1.txt", PosixFilePermission.OWNER_READ)

Output:

Permissions set for "/documents/case1.txt".

true

## Task 3

**Topic: File Handling with Data Structures**

**Problem Statement:**

You need to keep track of the encoding of each file. Implement two methods:

1. `buildEncodingMap(String directoryPath)`: This method should take a directory path. It should return a map where the keys are file paths and the values are their encodings.
    
2. `getEncoding(String filePath, Map<String, String> encodingMap)`: This method should take a file path and the map built by the previous method. It should return the encoding of the file.
    

**Example:**

Input:

buildEncodingMap("/documents")

getEncoding("/documents/case1.txt", encodingMap)

Output:

{"/documents/case1.txt": "ISO-8859-1", "/documents/case2.txt": "UTF-8"}

"ISO-8859-1"

## Task 4

**Topic: Error Handling Strategies**

**Problem Statement:**

You need to handle errors that may occur during file operations. Implement three methods:

1. `tryOpen(String filePath)`: This method should try to open a file. If the file does not exist, it should throw a custom exception.
    
2. `tryRead(String filePath)`: This method should try to read a file. If the file cannot be read (e.g., due to lack of permissions), it should throw a custom exception.
    
3. `tryWrite(String filePath, String content)`: This method should try to write to a file. If the file cannot be written to (e.g., due to lack of permissions), it should throw a custom exception.
    

**Example:**

Input:

tryOpen("/documents/case1.txt")

tryRead("/documents/case1.txt")

tryWrite("/documents/case1.txt", "New content")

Output:

File "/documents/case1.txt" opened successfully.

File "/documents/case1.txt" read successfully.

Exception: Lack of permissions to write to "/documents/case1.txt".