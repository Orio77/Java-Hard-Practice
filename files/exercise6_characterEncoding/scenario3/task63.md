Task 1: You are to implement two methods: `encodeFile` and `decodeFile`. The `encodeFile` method should read a text file, convert the text to a specified character encoding (e.g., UTF-8, ISO-8859-1), and write the encoded text to a new file. The `decodeFile` method should read the encoded file, decode the text back to its original encoding, and write the decoded text to another new file.

Example: Input:

- Original file: "Hello, World!"
- Encoding: UTF-8 Output:
- Encoded file: (contains encoded text)
- Decoded file: "Hello, World!"

Task 2: Topic: File Permissions You are to implement two methods: `changeFilePermissions` and `checkFilePermissions`. The `changeFilePermissions` method should change the permissions of a given file to a specified set of permissions. The `checkFilePermissions` method should return the current permissions of a given file. Both methods should handle character encoding issues.

Example: Input:

- File: "document.txt"
- Permissions: "rwxr--r--" Output:
- `changeFilePermissions`: (changes permissions of "document.txt" to "rwxr--r--")
- `checkFilePermissions`: "rwxr--r--"

Task 3: Topic: File Performance You are to implement two methods: `readLargeFile` and `writeLargeFile`. The `readLargeFile` method should efficiently read a large file with a specified character encoding. The `writeLargeFile` method should efficiently write a large amount of text to a file with a specified character encoding.

Example: Input:

- Large file: (contains large amount of text)
- Encoding: UTF-8 Output:
- `readLargeFile`: (efficiently reads large file)
- `writeLargeFile`: (efficiently writes large amount of text to file)

Task 4: Topic: Error Handling Strategies You are to implement three methods: `safeReadFile`, `safeWriteFile`, and `logError`. The `safeReadFile` method should safely read a file with a specified character encoding, handling any errors that occur. The `safeWriteFile` method should safely write text to a file with a specified character encoding, handling any errors that occur. The `logError` method should log any errors that occur during file reading or writing.

Example: Input:

- File: "document.txt"
- Encoding: UTF-8 Output:
- `safeReadFile`: (safely reads "document.txt")
- `safeWriteFile`: (safely writes text to "document.txt")
- `logError`: (logs any errors that occur)