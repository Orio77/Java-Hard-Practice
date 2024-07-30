Task 1

You are given a list of Vehicle objects. Each Vehicle has a `model`, `year`, `mileage`, and a list of `SensorReading` objects. Each `SensorReading` has a `sensorType` and a `value`.

Your task is to implement two methods:

1. `Optional<Vehicle> findVehicleWithHighestMileage(List<Vehicle> vehicles)`: This method should return the Vehicle with the highest mileage. If the list is empty, return an empty Optional.
    
2. `Optional<SensorReading> findMostCommonSensorReading(List<Vehicle> vehicles)`: This method should return the most common SensorReading across all vehicles. If there are multiple SensorReadings with the same highest count, return any of them. If the list is empty or there are no SensorReadings, return an empty Optional.
    

Example:

Input:

vehicles = [

  Vehicle("Model1", 2010, 100000, [SensorReading("Temperature", 75), SensorReading("Pressure", 30)]),

  Vehicle("Model2", 2012, 120000, [SensorReading("Temperature", 70), SensorReading("Pressure", 32)]),

  Vehicle("Model3", 2015, 80000, [SensorReading("Temperature", 75), SensorReading("Pressure", 30)])

]

Output:

findVehicleWithHighestMileage(vehicles) -> Optional[Vehicle("Model2", 2012, 120000, [SensorReading("Temperature", 70), SensorReading("Pressure", 32)])]

findMostCommonSensorReading(vehicles) -> Optional[SensorReading("Temperature", 75)]

Note: For the second method, the "Temperature" sensor reading with a value of 75 is the most common, appearing in two vehicles.

Task 2

Main Topic: Optionals in Stream API Operations Drawn Topic: Stream Performance

In the context of the automotive company, consider the scenario where the company wants to analyze the performance of their vehicles' sensors. Implement the following methods:

1. `Optional<Double> averageSensorValue(List<Vehicle> vehicles, String sensorType)`: This method should return the average value of the specified sensor type across all vehicles. If the sensor type is not found or the list is empty, return an empty Optional.
    
2. `Optional<SensorReading> findSensorReadingWithHighestFrequency(List<Vehicle> vehicles)`: This method should return the SensorReading that appears most frequently across all vehicles. If there are multiple SensorReadings with the same highest count, return any of them. If the list is empty or there are no SensorReadings, return an empty Optional.
    

Task 3

Main Topic: Optionals in Stream API Operations Drawn Topic: Stream API with Data Structures

In the context of the automotive company, consider the scenario where the company wants to analyze the data structures used in their vehicles. Implement the following methods:

1. `Optional<Map<String, Double>> averageSensorValuesByType(List<Vehicle> vehicles)`: This method should return a map where the keys are sensor types and the values are the average sensor values for that type across all vehicles. If the list is empty, return an empty Optional.
    
2. `Optional<List<SensorReading>> findTopThreeMostCommonSensorReadings(List<Vehicle> vehicles)`: This method should return the top three most common SensorReadings across all vehicles. If there are less than three SensorReadings, return all of them. If the list is empty or there are no SensorReadings, return an empty Optional.
    

Task 4

Main Topic: Optionals in Stream API Operations Drawn Topic: Stream Collectors

In the context of the automotive company, consider the scenario where the company wants to use custom collectors for their Stream operations. Implement the following methods:

1. `Optional<Map<String, List<Vehicle>>> groupVehiclesByModel(List<Vehicle> vehicles)`: This method should return a map where the keys are vehicle models and the values are lists of vehicles of that model. If the list is empty, return an empty Optional.
    
2. `Optional<Map<String, Double>> averageSensorValuesByModel(List<Vehicle> vehicles, String sensorType)`: This method should return a map where the keys are vehicle models and the values are the average sensor values of the specified sensor type for that model. If the sensor type is not found or the list is empty, return an empty Optional.
    
3. `Optional<List<Vehicle>> sortVehiclesByYear(List<Vehicle> vehicles)`: This method should return a list of vehicles sorted by their year in ascending order. If the list is empty, return an empty Optional.