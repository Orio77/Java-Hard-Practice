## Task 1

You are given a directory of athlete performance data files. Each file contains sensor data for a single athlete's performance in a specific event. The data is in CSV format with the following columns: timestamp, sensor1, sensor2, ..., sensorN.

Your task is to implement two methods:

1. `readAndSortFiles(directory: String): List<File>`: This method should read all the files in the given directory, and return a list of File objects sorted by the file size in descending order. Use concurrency to speed up the file reading process.
    
2. `aggregateSensorData(files: List<File>): Map<String, List<Double>>`: This method should take the sorted list of files from the previous method, read the sensor data from each file concurrently, and return a map where the key is the sensor name and the value is a list of all sensor readings across all files, sorted in ascending order.
    

Example:

Input: Directory with 3 files, each containing sensor data in CSV format.

Output: A map with sensor names as keys and sorted lists of sensor readings as values.

## Task 2

Topic: File Permissions

You are given a directory of athlete performance data files. Some of these files may have incorrect permissions that prevent them from being read.

Your task is to implement two methods:

1. `checkAndFixPermissions(directory: String): List<File>`: This method should check all files in the given directory, fix their permissions to ensure they can be read, and return a list of File objects. Use concurrency to speed up the process.
    
2. `readFiles(files: List<File>): Map<String, List<Double>>`: This method should take the list of files from the previous method, read the sensor data from each file concurrently, and return a map where the key is the file name and the value is a list of all sensor readings.
    

Example:

Input: Directory with 3 files, some of which have incorrect permissions.

Output: A map with file names as keys and lists of sensor readings as values.

## Task 3

Topic: File Attributes

You are given a directory of athlete performance data files. Each file has a creation time attribute.

Your task is to implement two methods:

1. `sortFilesByCreationTime(directory: String): List<File>`: This method should read all files in the given directory, sort them by their creation time in ascending order, and return a list of File objects. Use concurrency to speed up the file reading process.
    
2. `readAndAverageSensorData(files: List<File>): Map<String, Double>`: This method should take the sorted list of files from the previous method, read the sensor data from each file concurrently, and return a map where the key is the sensor name and the value is the average of all sensor readings across all files.
    

Example:

Input: Directory with 3 files, each containing sensor data in CSV format.

Output: A map with sensor names as keys and averages of sensor readings as values.

## Task 4

Topic: File Handling with Data Structures

You are given a directory of athlete performance data files. Each file contains sensor data for a single athlete's performance in a specific event. The data is in CSV format with the following columns: timestamp, sensor1, sensor2, ..., sensorN.

Your task is to implement three methods:

1. `readFiles(directory: String): List<File>`: This method should read all files in the given directory and return a list of File objects. Use concurrency to speed up the file reading process.
    
2. `parseSensorData(files: List<File>): Map<String, List<Double>>`: This method should take the list of files from the previous method, parse the sensor data from each file concurrently, and return a map where the key is the sensor name and the value is a list of all sensor readings.
    
3. `findPeakPerformance(sensorData: Map<String, List<Double>>): Map<String, Double>`: This method should take the map from the previous method and return a new map where the key is the sensor name and the value is the peak (maximum) sensor reading.
    

Example:

Input: Directory with 3 files, each containing sensor data in CSV format.

Output: A map with sensor names as keys and peak sensor readings as values.