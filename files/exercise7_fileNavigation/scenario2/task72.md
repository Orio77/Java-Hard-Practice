Task 1

Problem: Implement a digital library system that can navigate through a vast collection of academic papers, journals, and books.

Function 1: `navigateToDirectory(String directoryPath)`

This function should take a directory path as input and navigate to that directory. It should perform the following operations:

1. Check if the directory exists.
2. If the directory does not exist, throw an exception.
3. If the directory exists, navigate to the directory.
4. Return a list of all files in the directory.

Example:

Input: `navigateToDirectory("/home/user/Documents/AcademicPapers")`

Output: `["paper1.pdf", "paper2.pdf", "journal1.pdf", "book1.pdf"]`

Function 2: `readFile(String filePath)`

This function should take a file path as input and read the file. It should perform the following operations:

1. Check if the file exists.
2. If the file does not exist, throw an exception.
3. If the file exists, open the file.
4. Read the file and return its content as a string.

Example:

Input: `readFile("/home/user/Documents/AcademicPapers/paper1.pdf")`

Output: `"This is the content of paper1.pdf"`

---

Task 2

Topic: File Permissions

Problem: Implement a system that can check and modify the permissions of the files in the digital library.

Function 1: `checkPermissions(String filePath)`

This function should take a file path as input and return the permissions of the file. It should perform the following operations:

1. Check if the file exists.
2. If the file does not exist, throw an exception.
3. If the file exists, retrieve the file's permissions.
4. Return the permissions as a string.

Example:

Input: `checkPermissions("/home/user/Documents/AcademicPapers/paper1.pdf")`

Output: `"rwxr--r--"`

Function 2: `changePermissions(String filePath, String permissions)`

This function should take a file path and a permissions string as input and change the permissions of the file. It should perform the following operations:

1. Check if the file exists.
2. If the file does not exist, throw an exception.
3. If the file exists, change the file's permissions.
4. Return a confirmation message.

Example:

Input: `changePermissions("/home/user/Documents/AcademicPapers/paper1.pdf", "rw-r--r--")`

Output: `"Permissions changed successfully"`

---

Task 3

Topic: File Performance

Problem: Implement a system that can measure the performance of file operations in the digital library.

Function 1: `measureReadPerformance(String filePath)`

This function should take a file path as input and measure the time it takes to read the file. It should perform the following operations:

1. Check if the file exists.
2. If the file does not exist, throw an exception.
3. If the file exists, start a timer.
4. Read the file.
5. Stop the timer and return the elapsed time.

Example:

Input: `measureReadPerformance("/home/user/Documents/AcademicPapers/paper1.pdf")`

Output: `"Reading time: 0.002 seconds"`

Function 2: `measureWritePerformance(String filePath, String content)`

This function should take a file path and a content string as input and measure the time it takes to write the content to the file. It should perform the following operations:

1. Check if the file exists.
2. If the file does not exist, create the file.
3. Start a timer.
4. Write the content to the file.
5. Stop the timer and return the elapsed time.

Example:

Input: `measureWritePerformance("/home/user/Documents/AcademicPapers/paper2.pdf", "This is some content")`

Output: `"Writing time: 0.001 seconds"`

---

Task 4

Topic: File Handling with Data Structures

Problem: Implement a system that can use data structures to manage the files in the digital library.

Function 1: `createFileIndex(String directoryPath)`

This function should take a directory path as input and create an index of all files in the directory. The index should be a map where the keys are the file names and the values are the file paths. It should perform the following operations:

1. Check if the directory exists.
2. If the directory does not exist, throw an exception.
3. If the directory exists, retrieve a list of all files in the directory.
4. Create a map where the keys are the file names and the values are the file paths.
5. Return the map.

Example:

Input: `createFileIndex("/home/user/Documents/AcademicPapers")`

Output: `{"paper1.pdf": "/home/user/Documents/AcademicPapers/paper1.pdf", "paper2.pdf": "/home/user/Documents/AcademicPapers/paper2.pdf"}`

Function 2: `searchFileIndex(Map<String, String> index, String fileName)`

This function should take an index map and a file name as input and search the index for the file. It should perform the following operations:

1. Check if the file name exists in the index.
2. If the file name does not exist in the index, throw an exception.
3. If the file name exists in the index, retrieve the file path from the index.
4. Return the file path.

Example:

Input: `searchFileIndex(index, "paper1.pdf")`

Output: `"/home/user/Documents/AcademicPapers/paper1.pdf"`

Function 3: `deleteFileFromIndex(Map<String, String> index, String fileName)`

This function should take an index map and a file name as input and delete the file from the index. It should perform the following operations:

1. Check if the file name exists in the index.
2. If the file name does not exist in the index, throw an exception.
3. If the file name exists in the index, delete the file name from the index.
4. Return a confirmation message.

Example:

Input: `deleteFileFromIndex(index, "paper1.pdf")`

Output: `"File deleted from index successfully"`