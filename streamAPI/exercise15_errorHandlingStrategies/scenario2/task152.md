Task 1

You are given a list of Vehicle objects. Each Vehicle has a `name`, `mileage`, `lastMaintenanceDate` (in the format "yyyy-mm-dd"), and `status` (either "operational" or "maintenance required").

1. Implement a method `getVehiclesForMaintenance(List<Vehicle> vehicles)`. This method should return a list of vehicle names that require maintenance. The list should be sorted in descending order by the mileage of the vehicle. If two vehicles have the same mileage, sort them by their names in ascending order. Use Stream API to create a pipeline with at least 4 operations.

Example: Input:
```java
[

  {"name": "Vehicle1", "mileage": 10000, "lastMaintenanceDate": "2022-01-01", "status": "operational"},

  {"name": "Vehicle2", "mileage": 20000, "lastMaintenanceDate": "2022-02-01", "status": "maintenance required"},

  {"name": "Vehicle3", "mileage": 20000, "lastMaintenanceDate": "2022-03-01", "status": "maintenance required"}

]

Output: `["Vehicle3", "Vehicle2"]`
```
2. Implement a method `getOldestVehicleForMaintenance(List<Vehicle> vehicles)`. This method should return the name of the vehicle that requires maintenance and has the oldest `lastMaintenanceDate`. If there are multiple vehicles with the same `lastMaintenanceDate`, return the one with the highest mileage. If there are still multiple vehicles, return the one with the name that comes first in alphabetical order. Use Stream API to create a pipeline with at least 4 operations.

Example: Input:
```java
[

  {"name": "Vehicle1", "mileage": 10000, "lastMaintenanceDate": "2022-01-01", "status": "operational"},

  {"name": "Vehicle2", "mileage": 20000, "lastMaintenanceDate": "2022-02-01", "status": "maintenance required"},

  {"name": "Vehicle3", "mileage": 20000, "lastMaintenanceDate": "2022-01-01", "status": "maintenance required"}

]

- 
- 
- 

Output: `"Vehicle3"`
```
Task 2

Main Topic: Error Handling Strategies in Stream API Drawn Topic: Stream Performance

1. Implement a method `getVehicleStatus(List<Vehicle> vehicles, String vehicleName)`. This method should return the status of the vehicle with the given name. If the vehicle is not found, it should throw a custom exception `VehicleNotFoundException`. The method should be optimized for performance, especially when dealing with large lists of vehicles. Use Stream API to create a pipeline with at least 4 operations.

Example: Input:

[

  {"name": "Vehicle1", "mileage": 10000, "lastMaintenanceDate": "2022-01-01", "status": "operational"},

  {"name": "Vehicle2", "mileage": 20000, "lastMaintenanceDate": "2022-02-01", "status": "maintenance required"},

  {"name": "Vehicle3", "mileage": 20000, "lastMaintenanceDate": "2022-03-01", "status": "maintenance required"}

], "Vehicle2"

Output: `"maintenance required"`

2. Implement a method `getAverageMileage(List<Vehicle> vehicles)`. This method should return the average mileage of all vehicles. If the list is empty, it should throw a custom exception `NoVehiclesFoundException`. The method should be optimized for performance, especially when dealing with large lists of vehicles. Use Stream API to create a pipeline with at least 4 operations.

Example: Input:
```java
[

  {"name": "Vehicle1", "mileage": 10000, "lastMaintenanceDate": "2022-01-01", "status": "operational"},

  {"name": "Vehicle2", "mileage": 20000, "lastMaintenanceDate": "2022-02-01", "status": "maintenance required"},

  {"name": "Vehicle3", "mileage": 20000, "lastMaintenanceDate": "2022-03-01", "status": "maintenance required"}

]
```
Output: `16666.666666666668`

Task 3

Main Topic: Error Handling Strategies in Stream API Drawn Topic: Stream API with Data Structures

1. Implement a method `getVehicleMaintenanceDates(List<Vehicle> vehicles)`. This method should return a Map where the keys are vehicle names and the values are their last maintenance dates. The map should only include vehicles that require maintenance. Use Stream API to create a pipeline with at least 4 operations.

Example: Input:
```java
[

  {"name": "Vehicle1", "mileage": 10000, "lastMaintenanceDate": "2022-01-01", "status": "operational"},

  {"name": "Vehicle2", "mileage": 20000, "lastMaintenanceDate": "2022-02-01", "status": "maintenance required"},

  {"name": "Vehicle3", "mileage": 20000, "lastMaintenanceDate": "2022-03-01", "status": "maintenance required"}

]

Output: `{"Vehicle2": "2022-02-01", "Vehicle3": "2022-03-01"}`
```
2. Implement a method `getVehicleMileage(List<Vehicle> vehicles, String vehicleName)`. This method should return the mileage of the vehicle with the given name. If the vehicle is not found, it should throw a custom exception `VehicleNotFoundException`. Use Stream API to create a pipeline with at least 4 operations.

Example: Input:
```java
[

  {"name": "Vehicle1", "mileage": 10000, "lastMaintenanceDate": "2022-01-01", "status": "operational"},

  {"name": "Vehicle2", "mileage": 20000, "lastMaintenanceDate": "2022-02-01", "status": "maintenance required"},

  {"name": "Vehicle3", "mileage": 20000, "lastMaintenanceDate": "2022-03-01", "status": "maintenance required"}

], "Vehicle2"

Output: `20000`
```
Task 4

Main Topic: Error Handling Strategies in Stream API Drawn Topic: Optional

1. Implement a method `getVehicleByName(List<Vehicle> vehicles, String vehicleName)`. This method should return an Optional of Vehicle for the vehicle with the given name. If the vehicle is not found, it should return an empty Optional. Use Stream API to create a pipeline with at least 4 operations.
    
2. Implement a method `getVehicleWithHighestMileage(List<Vehicle> vehicles)`. This method should return an Optional of Vehicle for the vehicle with the highest mileage. If the list is empty, it should return an empty Optional. Use Stream API to create a pipeline with at least 4 operations.
    
3. Implement a method `getVehicleWithLowestMileage(List<Vehicle> vehicles)`. This method should return an Optional of Vehicle for the vehicle with the lowest mileage. If the list is empty, it should return an empty Optional. Use Stream API to create a pipeline with at least 4 operations.