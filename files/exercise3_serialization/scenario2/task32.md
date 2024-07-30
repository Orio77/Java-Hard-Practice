## Task 1

You are to implement a system that serializes and deserializes property listings.

Function 1: `serializeProperty(Property property, String filePath)`

- This function takes a `Property` object and a file path as input.
- It should convert the `Property` object into a byte stream.
- Then, it should write this byte stream to a file at the given file path.
- Handle any exceptions that may occur during this process.

Function 2: `deserializeProperty(String filePath)`

- This function takes a file path as input.
- It should read the byte stream from the file at the given path.
- Then, it should convert this byte stream back into a `Property` object.
- It should return this `Property` object.
- Handle any exceptions that may occur during this process.

Example:

Property property = new Property("123 Main St", "3 BHK", 2000, "High-res-image.jpg");

serializeProperty(property, "property.ser");

Property deserializedProperty = deserializeProperty("property.ser");

In this example, `deserializedProperty` should be equal to `property`.

## Task 2

Topic: File Permissions

You are to implement a system that checks and modifies the permissions of the serialized property files.

Function 1: `checkFilePermission(String filePath)`

- This function takes a file path as input.
- It should check the permissions of the file at the given path.
- It should return a string representation of the file's permissions.

Function 2: `modifyFilePermission(String filePath, String permissions)`

- This function takes a file path and a string representation of permissions as input.
- It should change the permissions of the file at the given path to the given permissions.
- Handle any exceptions that may occur during this process.

Example:

String permissions = checkFilePermission("property.ser");

modifyFilePermission("property.ser", "rw-------");

In this example, the permissions of the file at "property.ser" should be changed to "rw-------".

## Task 3

Topic: File Performance

You are to implement a system that measures the performance of the serialization and deserialization processes.

Function 1: `timeSerialization(Property property, String filePath)`

- This function takes a `Property` object and a file path as input.
- It should measure the time it takes to serialize the `Property` object and write it to a file at the given path.
- It should return this time in milliseconds.

Function 2: `timeDeserialization(String filePath)`

- This function takes a file path as input.
- It should measure the time it takes to read a byte stream from a file at the given path and deserialize it into a `Property` object.
- It should return this time in milliseconds.

Example:

Property property = new Property("123 Main St", "3 BHK", 2000, "High-res-image.jpg");

long serializationTime = timeSerialization(property, "property.ser");

long deserializationTime = timeDeserialization("property.ser");

In this example, `serializationTime` and `deserializationTime` should be the time it takes to serialize and deserialize a `Property` object, respectively.

## Task 4

Topic: Error Handling Strategies

You are to implement a system that handles errors during the serialization and deserialization processes.

Function 1: `safeSerializeProperty(Property property, String filePath)`

- This function takes a `Property` object and a file path as input.
- It should try to serialize the `Property` object and write it to a file at the given path.
- If an error occurs during this process, it should log the error and return false.
- If no error occurs, it should return true.

Function 2: `safeDeserializeProperty(String filePath)`

- This function takes a file path as input.
- It should try to read a byte stream from a file at the given path and deserialize it into a `Property` object.
- If an error occurs during this process, it should log the error and return null.
- If no error occurs, it should return the `Property` object.

Function 3: `logError(Exception e)`

- This function takes an `Exception` object as input.
- It should write the details of the exception to a log file.

Example:

Property property = new Property("123 Main St", "3 BHK", 2000, "High-res-image.jpg");

boolean success = safeSerializeProperty(property, "property.ser");

Property deserializedProperty = safeDeserializeProperty("property.ser");

In this example, if an error occurs during the serialization or deserialization process, it should be logged and `success` should be false or `deserializedProperty` should be null.