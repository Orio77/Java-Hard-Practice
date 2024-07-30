## Task 1

You are tasked with creating a system to manage soil and crop data for an agricultural research center. The data is stored in text files where each line represents a record.

Functionality 1: `readAndParseFile(filePath: String) -> List<Record>`

- Read a file from the given file path.
- Each line in the file represents a record of soil or crop data. Parse each line into a `Record` object. A `Record` object has fields for each piece of data in a line.
- Handle any IO exceptions that may occur and return an empty list if the file cannot be read.
- Return a list of `Record` objects.

Functionality 2: `writeRecordsToFile(records: List<Record>, filePath: String)`

- Write a list of `Record` objects to a file at the given file path.
- Each `Record` should be written as a line in the file.
- Handle any IO exceptions that may occur and print an error message if the file cannot be written to.
- This method does not return anything.

Example Input: filePath = "soilData.txt" Example Output: List of `Record` objects representing the data in "soilData.txt"

## Task 2

Topic: File Permissions

Functionality 1: `checkFilePermissions(filePath: String) -> Map<String, Boolean>`

- Check the permissions of a file at the given file path.
- Return a map where the keys are "read", "write", and "execute", and the values are boolean values representing whether the file has that permission.

Functionality 2: `changeFilePermissions(filePath: String, permissions: Map<String, Boolean>)`

- Change the permissions of a file at the given file path.
- The `permissions` map has keys "read", "write", and "execute", and boolean values representing whether the file should have that permission.
- Handle any exceptions that may occur and print an error message if the permissions cannot be changed.
- This method does not return anything.

Example Input: filePath = "soilData.txt", permissions = {"read": true, "write": false, "execute": false} Example Output: No output, but the permissions of "soilData.txt" have been changed.

## Task 3

Topic: File Performance

Functionality 1: `readFileWithBuffer(filePath: String) -> List<String>`

- Read a file from the given file path using a buffer to improve performance.
- Return a list of strings, where each string is a line from the file.
- Handle any IO exceptions that may occur and return an empty list if the file cannot be read.

Functionality 2: `writeFileWithBuffer(filePath: String, data: List<String>)`

- Write a list of strings to a file at the given file path using a buffer to improve performance.
- Each string in the list should be written as a line in the file.
- Handle any IO exceptions that may occur and print an error message if the file cannot be written to.
- This method does not return anything.

Example Input: filePath = "soilData.txt", data = ["soil type: clay", "crop: wheat", "yield: 200"] Example Output: No output, but "soilData.txt" now contains the lines "soil type: clay", "crop: wheat", "yield: 200"

## Task 4

Topic: File Handling with Data Structures

Functionality 1: `readFileIntoMap(filePath: String) -> Map<String, List<Record>>`

- Read a file from the given file path.
- Each line in the file represents a record of soil or crop data. Parse each line into a `Record` object.
- Store the `Record` objects in a map where the keys are the types of soil and the values are lists of `Record` objects.
- Handle any IO exceptions that may occur and return an empty map if the file cannot be read.

Functionality 2: `writeMapToFile(map: Map<String, List<Record>>, filePath: String)`

- Write a map of `Record` objects to a file at the given file path.
- Each key-value pair in the map should be written as a line in the file, with the key and values separated by a colon.
- Handle any IO exceptions that may occur and print an error message if the file cannot be written to.
- This method does not return anything.

Functionality 3: `searchRecords(map: Map<String, List<Record>>, soilType: String) -> List<Record>`

- Search the map for records with the given soil type.
- Return a list of `Record` objects that match the soil type.

Example Input: filePath = "soilData.txt", soilType = "clay" Example Output: List of `Record` objects representing the data in "soilData.txt" for the soil type "clay"