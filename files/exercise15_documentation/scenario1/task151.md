Task 1

Problem: Implement a system for real-time tracking of shipping containers. The system should be able to read data from a GPS device attached to the container and write it to a file. The file should be updated in real-time as the container moves.

Function 1: `readGPSData(gpsDevice: GPSDevice): GPSData`

- This function takes a GPS device as input.
- It reads data from the GPS device.
- It returns the GPS data.

Function 2: `writeToTrackingFile(data: GPSData, trackingFile: File): void`

- This function takes GPS data and a tracking file as input.
- It writes the GPS data to the tracking file.
- It does not return anything.

Example:

GPSData data = readGPSData(gpsDevice);

writeToTrackingFile(data, trackingFile);

After running the above code, the tracking file should contain the GPS data.

---

Task 2 (Topic: File Permissions)

Problem: Implement a system that manages file permissions for the tracking files. The system should be able to set permissions and check if a user has the necessary permissions to access a tracking file.

Function 1: `setTrackingFilePermissions(trackingFile: File, permissions: Set<Permission>): void`

- This function takes a tracking file and a set of permissions as input.
- It sets the given permissions for the tracking file.
- It does not return anything.

Function 2: `checkAccess(trackingFile: File, user: User): boolean`

- This function takes a tracking file and a user as input.
- It checks if the user has the necessary permissions to access the tracking file.
- It returns true if the user has access, false otherwise.

Example:

setTrackingFilePermissions(trackingFile, EnumSet.of(Permission.READ, Permission.WRITE));

boolean hasAccess = checkAccess(trackingFile, user);

After running the above code, the tracking file should have read and write permissions, and `hasAccess` should be true if the user has these permissions.

---

Task 3 (Topic: Exception Handling)

Problem: Implement a system that handles exceptions during file operations. The system should be able to handle exceptions when reading from a GPS device and when writing to a tracking file.

Function 1: `safeReadGPSData(gpsDevice: GPSDevice): Optional<GPSData>`

- This function takes a GPS device as input.
- It tries to read data from the GPS device.
- If an exception occurs, it returns an empty Optional.
- Otherwise, it returns an Optional containing the GPS data.

Function 2: `safeWriteToTrackingFile(data: GPSData, trackingFile: File): boolean`

- This function takes GPS data and a tracking file as input.
- It tries to write the GPS data to the tracking file.
- If an exception occurs, it returns false.
- Otherwise, it returns true.

Example:

Optional<GPSData> data = safeReadGPSData(gpsDevice);

if (data.isPresent()) {

    boolean success = safeWriteToTrackingFile(data.get(), trackingFile);

}

After running the above code, if no exceptions occur, the tracking file should contain the GPS data and `success` should be true.

---

Task 4 (Topic: File Handling with Data Structures)

Problem: Implement a system that uses a data structure to manage multiple tracking files. The system should be able to add a tracking file to the data structure, remove a tracking file from the data structure, and write GPS data to all tracking files in the data structure.

Function 1: `addTrackingFile(trackingFiles: Set<File>, trackingFile: File): void`

- This function takes a set of tracking files and a tracking file as input.
- It adds the tracking file to the set.
- It does not return anything.

Function 2: `removeTrackingFile(trackingFiles: Set<File>, trackingFile: File): void`

- This function takes a set of tracking files and a tracking file as input.
- It removes the tracking file from the set.
- It does not return anything.

Function 3: `writeToAllTrackingFiles(trackingFiles: Set<File>, data: GPSData): void`

- This function takes a set of tracking files and GPS data as input.
- It writes the GPS data to all tracking files in the set.
- It does not return anything.

Example:

addTrackingFile(trackingFiles, trackingFile1);

removeTrackingFile(trackingFiles, trackingFile2);

GPSData data = readGPSData(gpsDevice);

writeToAllTrackingFiles(trackingFiles, data);

After running the above code, `trackingFile1` should be in the set of tracking files, `trackingFile2` should not be in the set, and all tracking files in the set should contain the GPS data.