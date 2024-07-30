Task 1: File Reading and Writing with Performance Optimization

You are given a large meteorological data file (e.g., "data.txt"). Your task is to implement two methods:

1. `readAndFilterData(String filePath, String outputFilePath, double temperatureThreshold)`: This method should read the data from the file, filter out any records where the temperature is below the given threshold, and write the filtered data to a new file. The data file has the following format: each line contains a record with the date and temperature, separated by a comma (e.g., "2022-01-01,15.2").
    
2. `calculateAverageTemperature(String filePath)`: This method should read the data from the file and return the average temperature.
    

Example:

Input: `readAndFilterData("data.txt", "filtered_data.txt", 15.0)`, `calculateAverageTemperature("filtered_data.txt")`

Output: `16.5` (average temperature of the filtered data)

---

Task 2: File Permissions and Performance Optimization

You are given a directory of meteorological data files. Your task is to implement two methods:

1. `setReadPermissions(String directoryPath)`: This method should set the read permissions for all files in the given directory.
    
2. `readAllFiles(String directoryPath)`: This method should read all files in the directory and return a list of all records. Each record is a string with the date and temperature, separated by a comma.
    

Example:

Input: `setReadPermissions("/data")`, `readAllFiles("/data")`

Output: `["2022-01-01,15.2", "2022-01-02,16.3", ...]` (list of all records)

---

Task 3: File Attributes and Performance Optimization

You are given a large meteorological data file. Your task is to implement two methods:

1. `getFileAttributes(String filePath)`: This method should return the file attributes (size, creation time, last access time, last modified time) of the given file.
    
2. `filterByDate(String filePath, String startDate, String endDate)`: This method should read the data from the file, filter out any records outside the given date range, and return the filtered records. The date is in the format "yyyy-MM-dd".
    

Example:

Input: `getFileAttributes("data.txt")`, `filterByDate("data.txt", "2022-01-01", "2022-01-31")`

Output: `FileAttributes{size=1024, creationTime=2022-01-01T00:00:00Z, lastAccessTime=2022-01-31T23:59:59Z, lastModifiedTime=2022-01-31T23:59:59Z}`, `["2022-01-01,15.2", "2022-01-02,16.3", ...]` (filtered records)

---

Task 4: File Handling with Data Structures and Performance Optimization

You are given a large meteorological data file. Your task is to implement three methods:

1. `readDataIntoMap(String filePath)`: This method should read the data from the file and store it in a map where the key is the date and the value is the temperature.
    
2. `getTemperatureOnDate(String date)`: This method should return the temperature on the given date.
    
3. `getAverageTemperature()`: This method should return the average temperature of all records in the map.
    

Example:

Input: `readDataIntoMap("data.txt")`, `getTemperatureOnDate("2022-01-01")`, `getAverageTemperature()`

Output: `15.2` (temperature on 2022-01-01), `16.5` (average temperature)