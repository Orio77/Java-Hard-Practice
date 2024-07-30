## Task 1

**Problem: Log File Analyzer**

You are given a large log file (log.txt) that contains various types of logs. Your task is to create two methods:

1. `readAndFilterErrors(String filePath)`: This method should read the log file line by line, filter out the lines that contain the word "ERROR", and return these lines as a List of Strings. Handle any file-related exceptions appropriately.
    
2. `writeErrorsToFile(List<String> errorLines, String filePath)`: This method should take a List of error lines and a file path as input, write these lines to a new file at the given path, and return the number of lines written. Handle any file-related exceptions appropriately.
    

Example:

Input: log.txt (file path), errorLog.txt (file path) Output: 100 (number of error lines written to errorLog.txt)

## Task 2

**Topic: File Permissions**

**Problem: Secure Log File Analyzer**

In addition to the previous task, now you need to ensure that the error log file you create is secure. Draw from the topic of File Permissions and create two methods:

1. `checkAndSetPermissions(String filePath)`: This method should check if the file at the given path is readable and writable. If not, it should set the permissions accordingly. Handle any file-related exceptions appropriately.
    
2. `writeSecureErrorsToFile(List<String> errorLines, String filePath)`: This method should first call `checkAndSetPermissions(filePath)`, then write the error lines to the file at the given path, and return the number of lines written. Handle any file-related exceptions appropriately.
    

Example:

Input: log.txt (file path), secureErrorLog.txt (file path) Output: 100 (number of error lines written to secureErrorLog.txt)

## Task 3

**Topic: File Performance**

**Problem: Efficient Log File Analyzer**

Considering the performance, modify your log file analyzer to efficiently process large log files. Create two methods:

1. `readAndFilterErrorsEfficiently(String filePath)`: This method should read the log file line by line, filter out the lines that contain the word "ERROR", and return these lines as a List of Strings. Use buffering to improve the performance. Handle any file-related exceptions appropriately.
    
2. `writeErrorsToFileEfficiently(List<String> errorLines, String filePath)`: This method should take a List of error lines and a file path as input, write these lines to a new file at the given path using buffering, and return the number of lines written. Handle any file-related exceptions appropriately.
    

Example:

Input: largeLog.txt (file path), efficientErrorLog.txt (file path) Output: 10000 (number of error lines written to efficientErrorLog.txt)

## Task 4

**Topic: File Handling with Data Structures**

**Problem: Structured Log File Analyzer**

Now, instead of simply filtering and writing the error lines, you need to structure them for better analysis. Create three methods:

1. `readAndFilterErrors(String filePath)`: This method should read the log file line by line, filter out the lines that contain the word "ERROR", and return these lines as a List of Strings. Handle any file-related exceptions appropriately.
    
2. `structureErrors(List<String> errorLines)`: This method should take a List of error lines, parse each line into a custom ErrorLog object (you need to create this class) that contains properties like timestamp, error level, message etc., and return a List of ErrorLog objects.
    
3. `writeStructuredErrorsToFile(List<ErrorLog> errorLogs, String filePath)`: This method should take a List of ErrorLog objects and a file path as input, write these objects to a new file at the given path in a structured format (like JSON), and return the number of lines written. Handle any file-related exceptions appropriately.
    

Example:

Input: log.txt (file path), structuredErrorLog.txt (file path) Output: 100 (number of error lines written to structuredErrorLog.txt)