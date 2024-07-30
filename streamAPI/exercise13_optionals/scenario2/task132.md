Task 1

---------

Background: A city's public transportation authority wants to analyze ridership data to improve service efficiency and route planning.

Main Topic: Optionals

You are given a list of `Ride` objects. Each `Ride` has a `startStation`, `endStation`, `startTime`, `endTime`, and `passengerCount`. Some rides may have null values for `endStation` and `endTime` if the ride is still ongoing.

Function 1: `Optional<Ride> findLongestRide(List<Ride> rides)`

- This function should find the longest ride based on the duration (endTime - startTime). If there are ongoing rides (endTime is null), ignore them. If there are no completed rides, return an empty Optional.

Function 2: `Optional<Station> findMostPopularEndStation(List<Ride> rides)`

- This function should find the most popular end station (the station where most rides end). If there are ongoing rides (endStation is null), ignore them. If there are no completed rides, return an empty Optional.

Example: Input:
```java
List<Ride> rides = Arrays.asList(

    new Ride("Station A", "Station B", LocalTime.of(10, 0), LocalTime.of(10, 30), 5),

    new Ride("Station B", "Station C", LocalTime.of(10, 0), LocalTime.of(10, 45), 3),

    new Ride("Station A", null, LocalTime.of(11, 0), null, 2)

);

Output:

findLongestRide(rides); // Optional[Ride{startStation='Station B', endStation='Station C', startTime=10:00, endTime=10:45, passengerCount=3}]

findMostPopularEndStation(rides); // Optional[Station B]
```
Note: The `Ride` and `Station` classes are not provided. You need to create them as part of your solution. The `Station` class can be a simple wrapper around a String. The `Ride` class should include appropriate constructors and getters.

Task 2

---------

Main Topic: Optionals Drawn Topic: Stream Collectors

You are given a list of `Ride` objects. Each `Ride` has a `startStation`, `endStation`, `startTime`, `endTime`, and `passengerCount`. Some rides may have null values for `endStation` and `endTime` if the ride is still ongoing.

Function 1: `Optional<Map<Station, Long>> countRidesPerStation(List<Ride> rides)`

- This function should return a map where the keys are stations and the values are the number of rides that started from that station. If there are no rides, return an empty Optional.

Function 2: `Optional<Double> averageRideDuration(List<Ride> rides)`

- This function should calculate the average duration of all completed rides (endTime - startTime). If there are ongoing rides (endTime is null), ignore them. If there are no completed rides, return an empty Optional.

Example: Input:
```java
List<Ride> rides = Arrays.asList(

    new Ride("Station A", "Station B", LocalTime.of(10, 0), LocalTime.of(10, 30), 5),

    new Ride("Station B", "Station C", LocalTime.of(10, 0), LocalTime.of(10, 45), 3),

    new Ride("Station A", null, LocalTime.of(11, 0), null, 2)

);

Output:

countRidesPerStation(rides); // Optional[{Station A=2, Station B=1}]

averageRideDuration(rides); // Optional[37.5]
```
Task 3

---------

Main Topic: Optionals

Drawn Topic: Stream Performance

You are given a list of `Ride` objects. Each `Ride` has a `startStation`, `endStation`, `startTime`, `endTime`, and `passengerCount`. Some rides may have null values for `endStation` and `endTime` if the ride is still ongoing.

Function 1: `Optional<Ride> findBusiestRide(List<Ride> rides)`

- This function should find the ride with the highest passenger count. If there are ongoing rides (endTime is null), ignore them. If there are no completed rides, return an empty Optional.

Function 2: `Optional<Station> findLeastPopularStartStation(List<Ride> rides)`

- This function should find the least popular start station (the station where the fewest rides start). If there are ongoing rides (startStation is null), ignore them. If there are no rides, return an empty Optional.

Example:

Input: 

```java

List<Ride> rides = Arrays.asList(

    new Ride("Station A", "Station B", LocalTime.of(10, 0), LocalTime.of(10, 30), 5),

    new Ride("Station B", "Station C", LocalTime.of(10, 0), LocalTime.of(10, 45), 3),

    new Ride("Station A", null, LocalTime.of(11, 0), null, 2)

);

Output:

findBusiestRide(rides); // Optional[Ride{startStation='Station A', endStation='Station B', startTime=10:00, endTime=10:30, passengerCount=5}]

findLeastPopularStartStation(rides); // Optional[Station B]
```
Task 4

---------

Main Topic: Optionals

Drawn Topic: Stream API with Data Structures

You are given a list of `Ride` objects. Each `Ride` has a `startStation`, `endStation`, `startTime`, `endTime`, and `passengerCount`. Some rides may have null values for `endStation` and `endTime` if the ride is still ongoing.

Function 1: `Optional<List<Ride>> findRidesWithMoreThanAveragePassengers(List<Ride> rides)`

- This function should find all rides that have more passengers than the average number of passengers per ride. If there are ongoing rides (endTime is null), ignore them. If there are no completed rides, return an empty Optional.

Function 2: `Optional<Set<Station>> findStationsWithOnlyOneRide(List<Ride> rides)`

- This function should find all stations where only one ride started. If there are ongoing rides (startStation is null), ignore them. If there are no rides, return an empty Optional.

Function 3: `Optional<Map<Station, List<Ride>>> groupRidesByStartStation(List<Ride> rides)`

- This function should group all rides by their start station. If there are ongoing rides (startStation is null), ignore them. If there are no rides, return an empty Optional.

Example:

Input: 

```java

List<Ride> rides = Arrays.asList(

    new Ride("Station A", "Station B", LocalTime.of(10, 0), LocalTime.of(10, 30), 5),

    new Ride("Station B", "Station C", LocalTime.of(10, 0), LocalTime.of(10, 45), 3),

    new Ride("Station A", null, LocalTime.of(11, 0), null, 2)

);

Output:

findRidesWithMoreThanAveragePassengers(rides); // Optional[[Ride{startStation='Station A', endStation='Station B', startTime=10:00, endTime=10:30, passengerCount=5}]]

findStationsWithOnlyOneRide(rides); // Optional[[Station B]]

groupRidesByStartStation(rides); // Optional[{Station A=[Ride{startStation='Station A', endStation='Station B', startTime=10:00, endTime=10:30, passengerCount=5}], Station B=[Ride{startStation='Station B', endStation='Station C', startTime=10:00, endTime=10:45, passengerCount=3}]}]