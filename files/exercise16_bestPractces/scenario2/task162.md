## Task 1

**Problem: Media File Metadata Extraction and Modification**

You are given a directory of media files. Your task is to implement two methods:

1. `extractMetadata(String directoryPath)`: This method should read all the files in the given directory, extract metadata like file size, creation time, last modified time, and file type, and return a Map where the key is the file name and the value is another Map with keys as metadata names and values as the corresponding metadata.
    
2. `modifyMetadata(String filePath, Map<String, Object> newMetadata)`: This method should take a file path and a Map of new metadata. It should modify the metadata of the file with the new values provided in the Map.
    

Example:

Input:

extractMetadata("C:/Users/user/MediaFiles");

modifyMetadata("C:/Users/user/MediaFiles/video1.mp4", Map.of("lastModifiedTime", LocalDateTime.now()));

Output:

{

  "video1.mp4": {"fileSize": "15 MB", "creationTime": "2022-01-01T10:00:00", "lastModifiedTime": "2022-01-02T10:00:00", "fileType": "mp4"},

  "audio1.mp3": {"fileSize": "5 MB", "creationTime": "2022-01-01T10:00:00", "lastModifiedTime": "2022-01-02T10:00:00", "fileType": "mp3"},

  ...

}

The `modifyMetadata` method modifies the last modified time of the file "video1.mp4" to the current time.

## Task 2

**Topic: File Permissions**

**Problem: Media File Permission Management**

You are given a directory of media files. Your task is to implement two methods:

1. `checkPermissions(String directoryPath)`: This method should read all the files in the given directory, check their permissions (read, write, execute), and return a Map where the key is the file name and the value is another Map with keys as permission types and values as boolean indicating whether the permission is granted.
    
2. `changePermissions(String filePath, Map<String, Boolean> newPermissions)`: This method should take a file path and a Map of new permissions. It should change the permissions of the file according to the Map.
    

Example:

Input:

checkPermissions("C:/Users/user/MediaFiles");

changePermissions("C:/Users/user/MediaFiles/video1.mp4", Map.of("read", true, "write", false, "execute", false));

Output:

{

  "video1.mp4": {"read": true, "write": true, "execute": false},

  "audio1.mp3": {"read": true, "write": false, "execute": false},

  ...

}

The `changePermissions` method changes the permissions of the file "video1.mp4" to read-only.

## Task 3

**Topic: File Performance**

**Problem: Media File Compression and Decompression**

You are given a directory of media files. Your task is to implement two methods:

1. `compressFiles(String directoryPath, String outputPath)`: This method should read all the files in the given directory, compress them into a single file, and write the compressed file to the outputPath.
    
2. `decompressFile(String filePath, String outputPath)`: This method should take a compressed file path and an output directory path. It should decompress the file and write the decompressed files to the output directory.
    

Example:

Input:

compressFiles("C:/Users/user/MediaFiles", "C:/Users/user/Compressed/compressed.zip");

decompressFile("C:/Users/user/Compressed/compressed.zip", "C:/Users/user/Decompressed");

Output: The `compressFiles` method compresses all the files in the "MediaFiles" directory into a single file "compressed.zip". The `decompressFile` method decompresses the "compressed.zip" file into the "Decompressed" directory.

## Task 4

**Topic: File Handling with Data Structures**

**Problem: Media File Categorization and Search**

You are given a directory of media files. Your task is to implement three methods:

1. `categorizeFiles(String directoryPath)`: This method should read all the files in the given directory, categorize them based on file type (audio, video, image), and return a Map where the key is the file type and the value is a List of file names of that type.
    
2. `searchFile(String directoryPath, String fileType, String fileName)`: This method should take a directory path, a file type, and a file name. It should search for the file in the given directory and return the file path if found, or "File not found" if not found.
    
3. `sortFiles(String directoryPath, String fileType)`: This method should take a directory path and a file type. It should sort the files of the given type in the directory based on file size in ascending order and return a List of sorted file names.
    

Example:

Input:

categorizeFiles("C:/Users/user/MediaFiles");

searchFile("C:/Users/user/MediaFiles", "video", "video1.mp4");

sortFiles("C:/Users/user/MediaFiles", "audio");

Output:

{

  "video": ["video1.mp4", "video2.mp4", ...],

  "audio": ["audio1.mp3", "audio2.mp3", ...],

  "image": ["image1.jpg", "image2.jpg", ...]

}

The `searchFile` method returns "C:/Users/user/MediaFiles/video1.mp4". The `sortFiles` method returns a List of audio file names sorted by file size in ascending order.