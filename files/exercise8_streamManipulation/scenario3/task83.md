Task 1

Problem: You are tasked with creating a system that reads environmental data from a file, processes it, and writes the processed data to another file. The data is in CSV format with the following columns: Date, Location, Temperature, Humidity, Air Quality Index.

Function 1: `readAndProcessData(String inputFile)`

- Read the data from the input file.
- For each row, convert the Temperature from Fahrenheit to Celsius.
- Calculate the average Air Quality Index.
- Return a list of data where each item is a dictionary with keys as column names and values as the corresponding data.

Function 2: `writeProcessedData(String outputFile, List<Dictionary<String, String>> data)`

- Write the processed data to the output file in CSV format.
- The first row should be the column names.
- The last row should be the average Air Quality Index.

Example Input:

Date,Location,Temperature,Humidity,Air Quality Index

2022-01-01,Location1,32,45,100

2022-01-02,Location2,35,50,110

Example Output:

Date,Location,Temperature,Humidity,Air Quality Index

2022-01-01,Location1,0,45,100

2022-01-02,Location2,1.67,50,110

Average Air Quality Index,105

Task 2

Topic: File Permissions

Problem: You need to ensure that the environmental data files have the correct permissions.

Function 1: `checkPermissions(String filePath)`

- Check if the file at the given path exists.
- If it exists, check if the file has read and write permissions.
- Return a boolean indicating whether the file has the correct permissions.

Function 2: `setPermissions(String filePath)`

- If the file at the given path exists, set its permissions to allow read and write operations.
- If the file does not exist, create it and set the permissions.
- Return a boolean indicating whether the operation was successful.

Example Input: `checkPermissions("data.csv")` Example Output: `true`

Task 3

Topic: File Handling with Data Structures

Problem: You need to store the environmental data in a data structure for efficient access and manipulation.

Function 1: `loadData(String filePath)`

- Load the data from the file at the given path.
- Store the data in a suitable data structure (e.g., a list of dictionaries).
- Return the data structure.

Function 2: `queryData(List<Dictionary<String, String>> data, String date)`

- Query the data structure for data from the given date.
- Return the data for the given date, or null if no data is available for that date.

Example Input: `queryData(data, "2022-01-01")` Example Output: `{Date: "2022-01-01", Location: "Location1", Temperature: "0", Humidity: "45", Air Quality Index: "100"}`

Task 4

Topic: Error Handling Strategies

Problem: You need to ensure that your file handling code is robust and can handle errors gracefully.

Function 1: `safeRead(String filePath)`

- Try to read the file at the given path.
- If the file does not exist, return an empty list.
- If an error occurs during reading, log the error and return an empty list.

Function 2: `safeWrite(String filePath, List<Dictionary<String, String>> data)`

- Try to write the data to the file at the given path.
- If an error occurs during writing, log the error and return false.
- If the writing is successful, return true.

Function 3: `processData(List<Dictionary<String, String>> data)`

- Process the data as in Task 1.
- If an error occurs during processing, log the error and return an empty list.

Example Input: `safeRead("nonexistent.csv")` Example Output: `[]`