Task 1

Problem: Given a list of Shipment objects, each with properties `id (String)`, `location (GPSLocation)`, `status (ShipmentStatus)`, and `deliveryTime (LocalDateTime)`, implement two methods:

1. `findDelayedShipments(List<Shipment> shipments)`: This method should return a list of IDs of shipments that are delayed. A shipment is considered delayed if the current time is after the deliveryTime and the status is not DELIVERED. Use parallel streams for processing.
    
2. `calculateAverageDeliveryTime(List<Shipment> shipments)`: This method should return the average delivery time in hours for all delivered shipments. The delivery time of a shipment is the difference between the deliveryTime and the current time when the status became DELIVERED. Use parallel streams for processing.
    

Example:

Input:

List<Shipment> shipments = Arrays.asList(

    new Shipment("1", new GPSLocation(40.7128, 74.0060), ShipmentStatus.IN_TRANSIT, LocalDateTime.of(2022, 1, 1, 10, 0)),

    new Shipment("2", new GPSLocation(34.0522, 118.2437), ShipmentStatus.DELIVERED, LocalDateTime.of(2022, 1, 1, 9, 0)),

    new Shipment("3", new GPSLocation(51.5074, 0.1278), ShipmentStatus.DELIVERED, LocalDateTime.of(2022, 1, 1, 8, 0))

);

Output:

findDelayedShipments(shipments) -> ["1"]

calculateAverageDeliveryTime(shipments) -> 1.5

Note: Assume that the current time is `LocalDateTime.of(2022, 1, 1, 10, 0)` for this example.

Task 2

Topic: Stream Collectors

Problem: Extend the Shipment class with a `route (List<GPSLocation>)` property. Implement two methods:

1. `findMostVisitedLocation(List<Shipment> shipments)`: This method should return the GPSLocation that appears most frequently in the routes of all shipments. Use parallel streams and collectors for processing.
    
2. `groupShipmentsByStatus(List<Shipment> shipments)`: This method should return a map where the keys are ShipmentStatus values and the values are lists of Shipment IDs with that status. Use parallel streams and collectors for processing.
    

Example:

Input:

List<Shipment> shipments = Arrays.asList(

    new Shipment("1", new GPSLocation(40.7128, 74.0060), ShipmentStatus.IN_TRANSIT, LocalDateTime.of(2022, 1, 1, 10, 0), Arrays.asList(new GPSLocation(40.7128, 74.0060), new GPSLocation(34.0522, 118.2437))),

    new Shipment("2", new GPSLocation(34.0522, 118.2437), ShipmentStatus.DELIVERED, LocalDateTime.of(2022, 1, 1, 9, 0), Arrays.asList(new GPSLocation(34.0522, 118.2437), new GPSLocation(51.5074, 0.1278))),

    new Shipment("3", new GPSLocation(51.5074, 0.1278), ShipmentStatus.DELIVERED, LocalDateTime.of(2022, 1, 1, 8, 0), Arrays.asList(new GPSLocation(51.5074, 0.1278), new GPSLocation(34.0522, 118.2437)))

);

Output:

findMostVisitedLocation(shipments) -> new GPSLocation(34.0522, 118.2437)

groupShipmentsByStatus(shipments) -> {ShipmentStatus.IN_TRANSIT=["1"], ShipmentStatus.DELIVERED=["2", "3"]}

Task 3

Topic: Stream Performance

Problem: Given a list of Shipment objects, implement two methods:

1. `findNearestShipment(List<Shipment> shipments, GPSLocation location)`: This method should return the ID of the shipment that is currently nearest to the given location. Use the Euclidean distance for calculating the distance between two GPSLocations. Use parallel streams for processing.
    
2. `sortShipmentsByDistance(List<Shipment> shipments, GPSLocation location)`: This method should return a list of shipment IDs sorted by their distance to the given location, from nearest to farthest. Use parallel streams for processing.
    

Example:

Input:

List<Shipment> shipments = Arrays.asList(

    new Shipment("1", new GPSLocation(40.7128, 74.0060), ShipmentStatus.IN_TRANSIT, LocalDateTime.of(2022, 1, 1, 10, 0)),

    new Shipment("2", new GPSLocation(34.0522, 118.2437), ShipmentStatus.DELIVERED, LocalDateTime.of(2022, 1, 1, 9, 0)),

    new Shipment("3", new GPSLocation(51.5074, 0.1278), ShipmentStatus.DELIVERED, LocalDateTime.of(2022, 1, 1, 8, 0))

);

GPSLocation location = new GPSLocation(40.7128, 74.0060);

Output:

findNearestShipment(shipments, location) -> "1"

sortShipmentsByDistance(shipments, location) -> ["1", "2", "3"]

Task 4

Topic: Error Handling Strategies

Problem: Given a list of Shipment objects, implement three methods:

1. `validateShipments(List<Shipment> shipments)`: This method should return a list of shipment IDs that have invalid data. A shipment is considered invalid if its location is null or its status is null. Use parallel streams for processing.
    
2. `handleInvalidShipments(List<Shipment> shipments)`: This method should return a list of valid shipments. Invalid shipments should be logged and not included in the returned list. Use parallel streams for processing.
    
3. `findShipmentById(List<Shipment> shipments, String id)`: This method should return the Shipment object with the given ID. If no such shipment exists, it should throw a custom NoShipmentFoundException. Use parallel streams for processing.
    

Example:

Input:

List<Shipment> shipments = Arrays.asList(

    new Shipment("1", null, ShipmentStatus.IN_TRANSIT, LocalDateTime.of(2022, 1, 1, 10, 0)),

    new Shipment("2", new GPSLocation(34.0522, 118.2437), null, LocalDateTime.of(2022, 1, 1, 9, 0)),

    new Shipment("3", new GPSLocation(51.5074, 0.1278), ShipmentStatus.DELIVERED, LocalDateTime.of(2022, 1, 1, 8, 0))

);

Output:

validateShipments(shipments) -> ["1", "2"]

handleInvalidShipments(shipments) -> [new Shipment("3", new GPSLocation(51.5074, 0.1278), ShipmentStatus.DELIVERED, LocalDateTime.of(2022, 1, 1, 8, 0))]

findShipmentById(shipments, "3") -> new Shipment("3", new GPSLocation(51.5074, 0.1278), ShipmentStatus.DELIVERED, LocalDateTime.of(2022, 1, 1, 8, 0))

findShipmentById(shipments, "4") -> throws NoShipmentFoundException