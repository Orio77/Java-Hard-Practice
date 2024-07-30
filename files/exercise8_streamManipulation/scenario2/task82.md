## Task 1

**Problem Statement:**

You are given a directory of market data files. Each file contains a single line of comma-separated values representing market data for a specific day. The first value is the date, followed by various market indicators.

Write two methods:

1. `readAndAggregate(directory: String): Map<String, List<Double>>` - This method should read all the files in the directory, parse the data, and aggregate it by date. The map's key should be the date and the value should be a list of all market indicators for that date.
    
2. `writeAggregatedDataToFile(aggregatedData: Map<String, List<Double>>, outputFile: String): void` - This method should write the aggregated data to a new file. Each line should contain the date followed by the aggregated market indicators for that date.
    

**Example:**

Input: Directory with files:

- `file1.txt`: "2022-01-01,100,200,300"
- `file2.txt`: "2022-01-02,400,500,600"

Output: `output.txt`:

- "2022-01-01,100.0,200.0,300.0"
- "2022-01-02,400.0,500.0,600.0"

## Task 2

**Topic: File Permissions**

**Problem Statement:**

Continuing from the previous task, now you need to ensure that the output file has the correct permissions.

Write two methods:

1. `checkPermissions(filePath: String): Boolean` - This method should return true if the file at the given path has read, write, and execute permissions for the owner, and false otherwise.
    
2. `setPermissions(filePath: String): void` - This method should set the permissions of the file at the given path to allow read, write, and execute access for the owner.
    

**Example:**

Input: `output.txt`

Output: `checkPermissions("output.txt")` returns `true` after `setPermissions("output.txt")` is called.

## Task 3

**Topic: File Attributes**

**Problem Statement:**

Continuing from the previous tasks, now you need to ensure that the output file has the correct attributes.

Write two methods:

1. `checkIfHidden(filePath: String): Boolean` - This method should return true if the file at the given path is hidden, and false otherwise.
    
2. `setHidden(filePath: String): void` - This method should set the file at the given path to be hidden.
    

**Example:**

Input: `output.txt`

Output: `checkIfHidden("output.txt")` returns `true` after `setHidden("output.txt")` is called.

## Task 4

**Topic: File Performance**

**Problem Statement:**

Continuing from the previous tasks, now you need to ensure that the file operations are performed efficiently.

Write three methods:

1. `readFileWithBuffer(filePath: String): List<String>` - This method should read the file at the given path using a buffer to improve performance. It should return a list of all lines in the file.
    
2. `writeFileWithBuffer(filePath: String, data: List<String>): void` - This method should write the given data to the file at the given path using a buffer to improve performance.
    
3. `copyFileWithBuffer(sourcePath: String, destinationPath: String): void` - This method should copy the file at the source path to the destination path using a buffer to improve performance.
    

**Example:**

Input: `file1.txt`, `file2.txt`, `["2022-01-01,100.0,200.0,300.0", "2022-01-02,400.0,500.0,600.0"]`

Output: After calling `copyFileWithBuffer("file1.txt", "file2.txt")`, `file2.txt` is an exact copy of `file1.txt`. After calling `writeFileWithBuffer("file1.txt", data)`, `file1.txt` contains the given data. After calling `readFileWithBuffer("file1.txt")`, the returned list contains the lines of `file1.txt`.