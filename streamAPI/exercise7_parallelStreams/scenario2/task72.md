Task 1

Problem: Given a list of SensorData objects, each containing a zone (String), a sensorId (String), and a pollutionLevel (double), implement two methods:

1. `findMaxPollutedZonesParallel(List<SensorData> data, int n)`: This method should return a list of n zones with the highest average pollution level. Use parallel streams for this task. The steps should include: converting the list to a parallel stream, grouping by zone, calculating the average pollution level for each zone, sorting the zones by average pollution level in descending order, and limiting the result to the top n zones.
    
2. `findSensorsWithHighVarianceParallel(List<SensorData> data, double threshold)`: This method should return a list of sensorIds that have a pollution level variance greater than the given threshold. Use parallel streams for this task. The steps should include: converting the list to a parallel stream, grouping by sensorId, calculating the variance of pollution level for each sensor, filtering the sensors with variance greater than the threshold, and collecting the result into a list.
    

Example Input:

List<SensorData> data = Arrays.asList(

    new SensorData("Zone1", "Sensor1", 10.0),

    new SensorData("Zone1", "Sensor2", 20.0),

    new SensorData("Zone2", "Sensor3", 30.0),

    new SensorData("Zone2", "Sensor4", 40.0),

    new SensorData("Zone1", "Sensor1", 50.0),

    new SensorData("Zone2", "Sensor3", 60.0)

);

int n = 2;

double threshold = 10.0;

Example Output:

findMaxPollutedZonesParallel(data, n); // Returns ["Zone2", "Zone1"]

findSensorsWithHighVarianceParallel(data, threshold); // Returns ["Sensor1", "Sensor3"]

Note: The SensorData class is defined as follows:

public class SensorData {

    private String zone;

    private String sensorId;

    private double pollutionLevel;

    // constructor, getters and setters

}

Task 2

Main Topic: Parallel Streams Drawn Topic: Stream Performance

Problem: Given a list of SensorData objects, implement two methods:

1. `findFastestGrowingPollutionZonesParallel(List<SensorData> data, int n)`: This method should return a list of n zones where the pollution level is growing the fastest. Use parallel streams for this task. The steps should include: converting the list to a parallel stream, grouping by zone, calculating the rate of growth of pollution level for each zone, sorting the zones by rate of growth in descending order, and limiting the result to the top n zones.
    
2. `compareStreamPerformance(List<SensorData> data)`: This method should compare the performance of sequential and parallel streams in executing the `findFastestGrowingPollutionZonesParallel` method. It should return the time difference between the execution of the two.
    

Example Input:

List<SensorData> data = Arrays.asList(

    new SensorData("Zone1", "Sensor1", 10.0),

    new SensorData("Zone1", "Sensor2", 20.0),

    new SensorData("Zone2", "Sensor3", 30.0),

    new SensorData("Zone2", "Sensor4", 40.0),

    new SensorData("Zone1", "Sensor1", 50.0),

    new SensorData("Zone2", "Sensor3", 60.0)

);

int n = 2;

Example Output:

findFastestGrowingPollutionZonesParallel(data, n); // Returns ["Zone2", "Zone1"]

compareStreamPerformance(data); // Returns a positive or negative long value

Task 3

Main Topic: Parallel Streams Drawn Topic: Error Handling Strategies

Problem: Given a list of SensorData objects, implement two methods:

1. `findZonesWithMissingDataParallel(List<SensorData> data)`: This method should return a list of zones that have missing data (null values). Use parallel streams for this task. The steps should include: converting the list to a parallel stream, filtering the data where any field is null, grouping by zone, and collecting the result into a list.
    
2. `handleMissingDataParallel(List<SensorData> data, String defaultValue)`: This method should replace any missing data (null values) with the provided defaultValue. Use parallel streams for this task. The steps should include: converting the list to a parallel stream, replacing null values with the defaultValue, and collecting the result into a list.
    

Example Input:

List<SensorData> data = Arrays.asList(

    new SensorData("Zone1", "Sensor1", 10.0),

    new SensorData(null, "Sensor2", 20.0),

    new SensorData("Zone2", null, 30.0),

    new SensorData("Zone2", "Sensor4", null),

    new SensorData("Zone1", "Sensor1", 50.0),

    new SensorData("Zone2", "Sensor3", 60.0)

);

String defaultValue = "Unknown";

Example Output:

findZonesWithMissingDataParallel(data); // Returns ["Unknown", "Zone2"]

handleMissingDataParallel(data, defaultValue); // Returns a list of SensorData with no null values

Task 4

Main Topic: Parallel Streams Drawn Topic: Stream API with Data Structures

Problem: Given a Map where keys are zone names (String) and values are lists of SensorData objects, implement three methods:

1. `findZoneWithMostSensorsParallel(Map<String, List<SensorData>> data)`: This method should return the zone with the most sensors. Use parallel streams for this task. The steps should include: converting the map to a parallel stream, mapping each entry to the number of unique sensors in the zone, finding the maximum, and returning the corresponding zone.
    
2. `findSensorWithHighestAveragePollutionParallel(Map<String, List<SensorData>> data)`: This method should return the sensorId of the sensor with the highest average pollution level across all zones. Use parallel streams for this task. The steps should include: converting the map to a parallel stream, flattening the lists of SensorData into a single stream, grouping by sensorId, calculating the average pollution level for each sensor, finding the maximum, and returning the corresponding sensorId.
    
3. `groupSensorsByPollutionLevelParallel(Map<String, List<SensorData>> data, double threshold)`: This method should return a map where keys are sensorIds and values are 'High' or 'Low' depending on whether the average pollution level of the sensor is above or below the given threshold. Use parallel streams for this task. The steps should include: converting the map to a parallel stream, flattening the lists of SensorData into a single stream, grouping by sensorId, calculating the average pollution level for each sensor, mapping each sensor to 'High' or 'Low', and collecting the result into a map.
    

Example Input:

Map<String, List<SensorData>> data = new HashMap<>();

data.put("Zone1", Arrays.asList(new SensorData("Zone1", "Sensor1", 10.0), new SensorData("Zone1", "Sensor2", 20.0)));

data.put("Zone2", Arrays.asList(new SensorData("Zone2", "Sensor3", 30.0), new SensorData("Zone2", "Sensor4", 40.0)));

double threshold = 25.0;

Example Output:

findZoneWithMostSensorsParallel(data); // Returns "Zone1" or "Zone2"

findSensorWithHighestAveragePollutionParallel(data); // Returns "Sensor4"

groupSensorsByPollutionLevelParallel(data, threshold); // Returns {"Sensor1": "Low", "Sensor2": "Low", "Sensor3": "High", "Sensor4": "High"}