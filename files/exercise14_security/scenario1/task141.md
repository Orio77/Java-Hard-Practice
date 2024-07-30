Task 1

Problem: Implement a secure logging system for the diagnostic software. The system should be able to read data from vehicle sensors and write it to a log file. The log file should be encrypted to ensure security.

Function 1: `readSensorData(sensorId: String): SensorData`

- This function takes a sensor ID as input.
- It reads data from the sensor associated with the given ID.
- It returns the sensor data.

Function 2: `writeToLogFile(data: SensorData, key: String): void`

- This function takes sensor data and an encryption key as input.
- It encrypts the sensor data using the key.
- It writes the encrypted data to a log file.
- It does not return anything.

Example:

SensorData data = readSensorData("sensor1");

writeToLogFile(data, "encryptionKey");

After running the above code, the log file should contain the encrypted sensor data.

---

Task 2 (Topic: File Permissions)

Problem: Implement a system that manages file permissions for the log files. The system should be able to set permissions and check if a user has the necessary permissions to access a log file.

Function 1: `setLogFilePermissions(logFile: File, permissions: Set<Permission>): void`

- This function takes a log file and a set of permissions as input.
- It sets the given permissions for the log file.
- It does not return anything.

Function 2: `checkAccess(logFile: File, user: User): boolean`

- This function takes a log file and a user as input.
- It checks if the user has the necessary permissions to access the log file.
- It returns true if the user has access, false otherwise.

Example:

setLogFilePermissions(logFile, EnumSet.of(Permission.READ, Permission.WRITE));

boolean hasAccess = checkAccess(logFile, user);

After running the above code, the log file should have read and write permissions, and `hasAccess` should be true if the user has these permissions.

---

Task 3 (Topic: Exception Handling)

Problem: Implement a system that handles exceptions during file operations. The system should be able to handle exceptions when reading from a sensor and when writing to a log file.

Function 1: `safeReadSensorData(sensorId: String): Optional<SensorData>`

- This function takes a sensor ID as input.
- It tries to read data from the sensor associated with the given ID.
- If an exception occurs, it returns an empty Optional.
- Otherwise, it returns an Optional containing the sensor data.

Function 2: `safeWriteToLogFile(data: SensorData, key: String): boolean`

- This function takes sensor data and an encryption key as input.
- It tries to encrypt the sensor data and write it to a log file.
- If an exception occurs, it returns false.
- Otherwise, it returns true.

Example:

Optional<SensorData> data = safeReadSensorData("sensor1");

if (data.isPresent()) {

    boolean success = safeWriteToLogFile(data.get(), "encryptionKey");

}

After running the above code, if no exceptions occur, the log file should contain the encrypted sensor data and `success` should be true.

---

Task 4 (Topic: File Handling with Data Structures)

Problem: Implement a system that uses a data structure to manage multiple log files. The system should be able to add a log file to the data structure, remove a log file from the data structure, and write sensor data to all log files in the data structure.

Function 1: `addLogFile(logFiles: Set<File>, logFile: File): void`

- This function takes a set of log files and a log file as input.
- It adds the log file to the set.
- It does not return anything.

Function 2: `removeLogFile(logFiles: Set<File>, logFile: File): void`

- This function takes a set of log files and a log file as input.
- It removes the log file from the set.
- It does not return anything.

Function 3: `writeToAllLogFiles(logFiles: Set<File>, data: SensorData, key: String): void`

- This function takes a set of log files, sensor data, and an encryption key as input.
- It writes the encrypted sensor data to all log files in the set.
- It does not return anything.

Example:

addLogFile(logFiles, logFile1);

removeLogFile(logFiles, logFile2);

SensorData data = readSensorData("sensor1");

writeToAllLogFiles(logFiles, data, "encryptionKey");

After running the above code, `logFile1` should be in the set of log files, `logFile2` should not be in the set, and all log files in the set should contain the encrypted sensor data.****