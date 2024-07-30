Background: An environmental agency is aggregating data from various sensors to monitor air quality in different city zones.

Main Topic: lambda expressions
  
List: [Stream Basics, Lambda Expressions, Stream Terminating Operations, Stream Collectors, Handling Null Values, Parallel Stream, Exception Handling, Stream Performance, Stream API with Data Structures, Custom Collectors, Method References, Optional, Stream Ordering, Error Handling Strategies, Testing Stream Code, Code Readability, Documentation, Performance Optimization]

**Problem: Advanced Stream API Application**

# Problem Introduction

The environmental agency has been collecting air quality data from various sensors across the city. This data is crucial in monitoring and improving the city's air quality. However, the data from these sensors is raw and needs to be processed to extract meaningful information.

The agency has decided to use the Stream API in Java, which is a powerful tool for processing collections of objects, like the data from these sensors. The Stream API, combined with lambda expressions, can provide a concise and efficient way to process this data.

Your task is to develop a Java application that uses the Stream API and lambda expressions to process this sensor data. The application should be able to filter, sort, and perform various calculations on the data. This will involve handling null values, using custom collectors, and optimizing performance among other things.

This will be a challenging task, but it will give you a deep understanding of the Stream API and lambda expressions in Java.

**Level 1: Difficulty 5/10**

The environmental agency has provided you with a list of `SensorData` objects. Each `SensorData` object contains the following fields:

- `zone`: a String representing the city zone where the sensor is located.
- `airQualityIndex`: an Integer representing the air quality index recorded by the sensor. The air quality index is a number between 0 and 500, where 0 represents the best possible air quality and 500 represents the worst.

Your task is to write a Java method named `processSensorData` that takes a List of `SensorData` objects as input and performs the following operations using the Stream API and lambda expressions:

1. Filter out any `SensorData` objects where the `airQualityIndex` is null.
2. Sort the remaining `SensorData` objects in ascending order based on the `airQualityIndex`.
3. Calculate the average `airQualityIndex` of the remaining `SensorData` objects.
4. Return the average `airQualityIndex` as a double.

Your method should have the following signature:

public static double processSensorData(List<SensorData> sensorDataList)

## Example

Consider the following list of `SensorData` objects:

List<SensorData> sensorDataList = Arrays.asList(

    new SensorData("Zone A", 100),

    new SensorData("Zone B", null),

    new SensorData("Zone C", 200),

    new SensorData("Zone D", 150)

);

The `processSensorData` method should return `150.0` as the average `airQualityIndex` of the valid `SensorData` objects.

## Constraints

- The `sensorDataList` will contain between 1 and 10^5 `SensorData` objects.
- The `airQualityIndex` of each `SensorData` object, if not null, will be between 0 and 500.
- The `zone` of each `SensorData` object will be a non-empty string of length up to 100.

**Level 2: Difficulty 6/10**

Continuing from the previous task, the environmental agency now wants to group the `SensorData` objects by `zone` and calculate the average `airQualityIndex` for each zone.

Your task is to write a Java method named `averageAirQualityByZone` that takes a List of `SensorData` objects as input and performs the following operations using the Stream API and lambda expressions:

1. Filter out any `SensorData` objects where the `airQualityIndex` is null.
2. Group the remaining `SensorData` objects by `zone`.
3. For each group, calculate the average `airQualityIndex`.
4. Return a Map where the keys are the zones and the values are the average `airQualityIndex` for each zone.

Your method should have the following signature:

public static Map<String, Double> averageAirQualityByZone(List<SensorData> sensorDataList)

## Example

Consider the following list of `SensorData` objects:

List<SensorData> sensorDataList = Arrays.asList(

    new SensorData("Zone A", 100),

    new SensorData("Zone B", null),

    new SensorData("Zone A", 200),

    new SensorData("Zone B", 150),

    new SensorData("Zone A", 150)

);

The `averageAirQualityByZone` method should return a Map with the following entries:

- "Zone A" -> 150.0
- "Zone B" -> 150.0

## Constraints

- The `sensorDataList` will contain between 1 and 10^5 `SensorData` objects.
- The `airQualityIndex` of each `SensorData` object, if not null, will be between 0 and 500.
- The `zone` of each `SensorData` object will be a non-empty string of length up to 100.

**Level 3: Difficulty 7/10**

The environmental agency now wants to identify the zones with the worst air quality. They define the worst zones as those with an average `airQualityIndex` above a certain threshold.

Your task is to write a Java method named `worstAirQualityZones` that takes a List of `SensorData` objects and a threshold as input and performs the following operations using the Stream API and lambda expressions:

1. Filter out any `SensorData` objects where the `airQualityIndex` is null.
2. Group the remaining `SensorData` objects by `zone`.
3. For each group, calculate the average `airQualityIndex`.
4. Filter out any groups where the average `airQualityIndex` is below the threshold.
5. Return a Set of the zones that have an average `airQualityIndex` above the threshold.

Your method should have the following signature:

public static Set<String> worstAirQualityZones(List<SensorData> sensorDataList, double threshold)

## Example

Consider the following list of `SensorData` objects and a threshold of 150:

List<SensorData> sensorDataList = Arrays.asList(

    new SensorData("Zone A", 100),

    new SensorData("Zone B", null),

    new SensorData("Zone A", 200),

    new SensorData("Zone B", 150),

    new SensorData("Zone A", 150),

    new SensorData("Zone C", 160)

);

The `worstAirQualityZones` method should return a Set with the following entries:

- "Zone A"
- "Zone C"

## Constraints

- The `sensorDataList` will contain between 1 and 10^5 `SensorData` objects.
- The `airQualityIndex` of each `SensorData` object, if not null, will be between 0 and 500.
- The `zone` of each `SensorData` object will be a non-empty string of length up to 100.
- The `threshold` will be a double between 0 and 500.

**Level 4: Difficulty 8/10**

Your task is to modify the `worstAirQualityZones` method to use a parallel stream instead of a sequential stream. This will allow the application to process the sensor data in parallel, which can significantly improve performance on multi-core systems.

In addition, the agency wants to handle any potential exceptions that may occur during the processing of the sensor data. They want the application to continue processing the remaining data even if an exception occurs.

Your task is to modify the `worstAirQualityZones` method to handle exceptions in the following way:

1. If a `SensorData` object cannot be processed due to an exception, the application should log the exception and continue processing the remaining data.
2. The application should return the same result as before, i.e., a Set of the zones that have an average `airQualityIndex` above the threshold.

Your method should have the following signature:

public static Set<String> worstAirQualityZones(List<SensorData> sensorDataList, double threshold)

## Example

Consider the following list of `SensorData` objects and a threshold of 150:

List<SensorData> sensorDataList = Arrays.asList(

    new SensorData("Zone A", 100),

    new SensorData("Zone B", null),

    new SensorData("Zone A", 200),

    new SensorData("Zone B", 150),

    new SensorData("Zone A", 150),

    new SensorData("Zone C", 160)

);

The `worstAirQualityZones` method should return a Set with the following entries:

- "Zone A"
- "Zone C"

## Constraints

- The `sensorDataList` will contain between 1 and 10^5 `SensorData` objects.
- The `airQualityIndex` of each `SensorData` object, if not null, will be between 0 and 500.
- The `zone` of each `SensorData` object will be a non-empty string of length up to 100.
- The `threshold` will be a double between 0 and 500.
- The application should be able to handle any exceptions that may occur during the processing of the sensor data.