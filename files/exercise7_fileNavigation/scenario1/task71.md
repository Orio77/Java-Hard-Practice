Task 1:

Problem: Implement a file navigation system that allows users to efficiently store and retrieve image files.

Functionality 1: `storeImageFile(String directory, String filename, byte[] imageData)`

- This method should take a directory path, a filename, and a byte array representing image data as input.
- It should check if the directory exists, and if not, create it.
- It should then write the image data to a file with the given filename in the specified directory.
- If the file already exists, it should throw an exception.

Functionality 2: `retrieveImageFile(String directory, String filename)`

- This method should take a directory path and a filename as input.
- It should check if the file exists in the specified directory.
- If the file exists, it should read the file and return the image data as a byte array.
- If the file does not exist, it should throw an exception.

Example: Input: `storeImageFile("/images", "image1.jpg", imageData)` Output: No output, but a new file named "image1.jpg" is created in the "/images" directory.

Input: `retrieveImageFile("/images", "image1.jpg")` Output: Returns the byte array of the image data.

---

Task 2:

Topic: File Permissions

Problem: Implement a file navigation system that allows users to manage file permissions for image files.

Functionality 1: `setFilePermissions(String directory, String filename, Set<PosixFilePermission> permissions)`

- This method should take a directory path, a filename, and a set of POSIX file permissions as input.
- It should check if the file exists in the specified directory.
- If the file exists, it should set the file permissions as specified.
- If the file does not exist, it should throw an exception.

Functionality 2: `getFilePermissions(String directory, String filename)`

- This method should take a directory path and a filename as input.
- It should check if the file exists in the specified directory.
- If the file exists, it should return the file's permissions as a set of POSIX file permissions.
- If the file does not exist, it should throw an exception.

Example: Input: `setFilePermissions("/images", "image1.jpg", permissions)` Output: No output, but the permissions of the file "image1.jpg" in the "/images" directory are changed.

Input: `getFilePermissions("/images", "image1.jpg")` Output: Returns the set of POSIX file permissions of the file.

---

Task 3:

Topic: File Attributes

Problem: Implement a file navigation system that allows users to manage file attributes for image files.

Functionality 1: `setFileAttributes(String directory, String filename, FileAttribute<?>... attrs)`

- This method should take a directory path, a filename, and one or more file attributes as input.
- It should check if the file exists in the specified directory.
- If the file exists, it should set the file attributes as specified.
- If the file does not exist, it should throw an exception.

Functionality 2: `getFileAttributes(String directory, String filename)`

- This method should take a directory path and a filename as input.
- It should check if the file exists in the specified directory.
- If the file exists, it should return the file's attributes as a Map<String, Object>.
- If the file does not exist, it should throw an exception.

Example: Input: `setFileAttributes("/images", "image1.jpg", attrs)` Output: No output, but the attributes of the file "image1.jpg" in the "/images" directory are changed.

Input: `getFileAttributes("/images", "image1.jpg")` Output: Returns the attributes of the file as a Map<String, Object>.

---

Task 4:

Topic: File Path Operations

Problem: Implement a file navigation system that allows users to perform operations on file paths.

Functionality 1: `getAbsolutePath(String directory, String filename)`

- This method should take a directory path and a filename as input.
- It should return the absolute path of the file.

Functionality 2: `getRelativePath(String directory, String filename)`

- This method should take a directory path and a filename as input.
- It should return the relative path of the file from the current working directory.

Functionality 3: `renameFile(String directory, String oldFilename, String newFilename)`

- This method should take a directory path, an old filename, and a new filename as input.
- It should rename the file with the old filename to the new filename in the specified directory.
- If the file does not exist, it should throw an exception.

Example: Input: `getAbsolutePath("/images", "image1.jpg")` Output: Returns the absolute path of the file "image1.jpg" in the "/images" directory.

Input: `getRelativePath("/images", "image1.jpg")` Output: Returns the relative path of the file "image1.jpg" from the current working directory.

Input: `renameFile("/images", "image1.jpg", "image2.jpg")` Output: No output, but the file "image1.jpg" in the "/images" directory is renamed to "image2.jpg".