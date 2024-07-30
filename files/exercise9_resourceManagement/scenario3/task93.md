Task 1

Problem: Implement a system that reads environmental data from a file, processes it, and writes the processed data to another file. The processing should involve calculating the average of the data and filtering out any data points that are above a certain threshold.

Function 1: `readAndProcessData(String inputFile, double threshold)`

- Read data from the file specified by `inputFile`. The data will be in the format of one data point per line.
- Calculate the average of the data.
- Filter out any data points that are above the `threshold`.
- Return a list of the processed data points.

Function 2: `writeDataToFile(List<Double> data, String outputFile)`

- Write the data points from `data` to the file specified by `outputFile`. Write one data point per line.
- If the file already exists, overwrite it. If it does not exist, create it.
- Return the number of data points written.

Example: Input: `inputFile` contains "10\n20\n30\n40\n50\n", `threshold` is 25 Output: `outputFile` contains "10\n20\n"

---

Task 2 (Topic: File Permissions)

Problem: Implement a system that checks the permissions of a file before reading and writing environmental data.

Function 1: `checkPermissions(String filePath)`

- Check if the file at `filePath` exists.
- If it exists, check if the program has read and write permissions for the file.
- Return a boolean indicating whether the program has the necessary permissions.

Function 2: `readAndWriteData(String inputFile, String outputFile)`

- Use `checkPermissions` to check if the program has the necessary permissions for `inputFile` and `outputFile`.
- If it does, read the data from `inputFile`, process it (calculate the average), and write it to `outputFile`.
- If it does not, throw an exception.
- Return the number of data points written.

Example: Input: `inputFile` is a file with read and write permissions, `outputFile` is a file without write permissions Output: An exception is thrown

---

Task 3 (Topic: File Attributes)

Problem: Implement a system that reads environmental data from a file, processes it, and writes the processed data to another file. The system should also keep track of the file attributes (size and modification time) of the input and output files.

Function 1: `readAndProcessData(String inputFile, double threshold)`

- Same as in Task 1, but also return the file attributes of `inputFile`.

Function 2: `writeDataToFile(List<Double> data, String outputFile)`

- Same as in Task 1, but also return the file attributes of `outputFile`.

Function 3: `compareFileAttributes(FileAttributes inputAttributes, FileAttributes outputAttributes)`

- Compare the size and modification time of `inputAttributes` and `outputAttributes`.
- Return a boolean indicating whether the size has increased and the modification time has been updated.

Example: Input: `inputFile` contains "10\n20\n30\n40\n50\n", `threshold` is 25 Output: `outputFile` contains "10\n20\n", the size has increased, and the modification time has been updated

---

Task 4 (Topic: File Performance)

Problem: Implement a system that reads environmental data from a file, processes it, and writes the processed data to another file. The system should also measure the time it takes to perform these operations.

Function 1: `readAndProcessData(String inputFile, double threshold)`

- Same as in Task 1, but also return the time it took to perform the operation.

Function 2: `writeDataToFile(List<Double> data, String outputFile)`

- Same as in Task 1, but also return the time it took to perform the operation.

Function 3: `measureTotalTime(String inputFile, double threshold, String outputFile)`

- Call `readAndProcessData` and `writeDataToFile` and measure the total time it takes to perform both operations.
- Return the total time.

Example: Input: `inputFile` contains "10\n20\n30\n40\n50\n", `threshold` is 25 Output: `outputFile` contains "10\n20\n", the total time is less than 1 second