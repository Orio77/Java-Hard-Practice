Task 1

Background: You are given a list of SensorData objects. Each SensorData object has a `type` (soil moisture, weather station, crop growth), `value` (a double representing the reading from the sensor), and `timestamp` (a LocalDateTime object representing when the reading was taken).

Functionalities:

1. `filterAndSortData`: This method should take in a list of SensorData and a sensor type. It should filter the data for the given sensor type, map the data to its value, sort the data in descending order, and collect the result into a list.
    
2. `averageSensorData`: This method should take in a list of SensorData and a sensor type. It should filter the data for the given sensor type, map the data to its value, calculate the average of the values, and return the result.
    

Example Input:

List<SensorData> data = Arrays.asList(

    new SensorData("soil moisture", 45.0, LocalDateTime.now()),

    new SensorData("weather station", 30.0, LocalDateTime.now()),

    new SensorData("soil moisture", 50.0, LocalDateTime.now()),

    new SensorData("crop growth", 20.0, LocalDateTime.now())

);

String type = "soil moisture";

Example Output:

filterAndSortData(data, type) => [50.0, 45.0]

averageSensorData(data, type) => 47.5

Task 2

Topic: Stream Performance

Background: You are given a list of SensorData objects. Each SensorData object has a `type` (soil moisture, weather station, crop growth), `value` (a double representing the reading from the sensor), and `timestamp` (a LocalDateTime object representing when the reading was taken).

Functionalities:

1. `filterAndSortDataParallel`: This method should do the same as `filterAndSortData` in Task 1, but it should use parallel streams to improve performance.
    
2. `averageSensorDataParallel`: This method should do the same as `averageSensorData` in Task 1, but it should use parallel streams to improve performance.
    

Example Input and Output: Same as Task 1.

Task 3

Topic: Error Handling Strategies

Background: You are given a list of SensorData objects. Each SensorData object has a `type` (soil moisture, weather station, crop growth), `value` (a double representing the reading from the sensor), and `timestamp` (a LocalDateTime object representing when the reading was taken).

Functionalities:

1. `filterAndSortDataWithErrorHandling`: This method should do the same as `filterAndSortData` in Task 1, but it should handle any potential exceptions that might occur during the stream operations.
    
2. `averageSensorDataWithErrorHandling`: This method should do the same as `averageSensorData` in Task 1, but it should handle any potential exceptions that might occur during the stream operations.
    

Example Input and Output: Same as Task 1.

Task 4

Topic: Stream API with Data Structures

Background: You are given a list of SensorData objects. Each SensorData object has a `type` (soil moisture, weather station, crop growth), `value` (a double representing the reading from the sensor), and `timestamp` (a LocalDateTime object representing when the reading was taken).

Functionalities:

1. `filterAndSortDataWithStructures`: This method should do the same as `filterAndSortData` in Task 1, but it should collect the result into a PriorityQueue instead of a list.
    
2. `averageSensorDataWithStructures`: This method should do the same as `averageSensorData` in Task 1, but it should return an OptionalDouble instead of a double.
    
3. `groupDataByType`: This method should take in a list of SensorData and group the data by its type. It should return a Map where the keys are the sensor types and the values are lists of SensorData.
    

Example Input and Output: Same as Task 1 for the first two methods. For `groupDataByType`, the output should be a Map grouping the SensorData by type.