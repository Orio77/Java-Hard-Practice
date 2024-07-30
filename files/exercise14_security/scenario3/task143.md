Task 1

Problem: Implement a secure file handling system for the non-profit organization's donation records.

Functionality 1: `encryptFileData(filePath: String, key: String): Boolean` This method should take a file path and a key as input. It should read the file, encrypt the data using the key, and then write the encrypted data back to the file. The method should return true if the operation was successful and false otherwise.

Functionality 2: `decryptFileData(filePath: String, key: String): Boolean` This method should take a file path and a key as input. It should read the file, decrypt the data using the key, and then write the decrypted data back to the file. The method should return true if the operation was successful and false otherwise.

Example:

encryptFileData("donations.txt", "secretKey"); // returns true

decryptFileData("donations.txt", "secretKey"); // returns true

Task 2

Topic: File Permissions

Problem: Implement a system to manage file permissions to enhance the security of the donation records.

Functionality 1: `setFilePermissions(filePath: String, permissions: String): Boolean` This method should take a file path and a string representing permissions as input. It should set the permissions of the file according to the input string. The method should return true if the operation was successful and false otherwise.

Functionality 2: `getFilePermissions(filePath: String): String` This method should take a file path as input and return a string representing the file's permissions.

Example:

setFilePermissions("donations.txt", "rwxr--r--"); // returns true

getFilePermissions("donations.txt"); // returns "rwxr--r--"

Task 3

Topic: File Performance

Problem: Implement a system to optimize the performance of file operations on the donation records.

Functionality 1: `readFileWithBuffer(filePath: String): String` This method should take a file path as input. It should read the file using a buffer to improve performance. The method should return the file's contents as a string.

Functionality 2: `writeFileWithBuffer(filePath: String, data: String): Boolean` This method should take a file path and a string of data as input. It should write the data to the file using a buffer to improve performance. The method should return true if the operation was successful and false otherwise.

Example:

writeFileWithBuffer("donations.txt", "Donor1: $100\nDonor2: $200"); // returns true

readFileWithBuffer("donations.txt"); // returns "Donor1: $100\nDonor2: $200"

Task 4

Topic: Error Handling Strategies

Problem: Implement a system to handle errors during file operations on the donation records.

Functionality 1: `safeReadFile(filePath: String): Optional<String>` This method should take a file path as input. It should attempt to read the file and return an Optional containing the file's contents as a string. If an error occurs during the operation, it should return an empty Optional.

Functionality 2: `safeWriteFile(filePath: String, data: String): Boolean` This method should take a file path and a string of data as input. It should attempt to write the data to the file. If the operation is successful, it should return true. If an error occurs, it should return false.

Functionality 3: `logFileError(filePath: String, error: Exception): Void` This method should take a file path and an Exception as input. It should log the error along with the file path and the time the error occurred.

Example:

safeWriteFile("donations.txt", "Donor1: $100\nDonor2: $200"); // returns true

safeReadFile("nonexistent.txt"); // returns Optional.empty

logFileError("nonexistent.txt", new FileNotFoundException()); // logs the error