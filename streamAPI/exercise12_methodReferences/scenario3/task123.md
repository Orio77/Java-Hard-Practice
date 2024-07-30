Task 1

Given a list of Flight objects, each Flight has properties: `flightNumber (String)`, `departureTime (LocalDateTime)`, `arrivalTime (LocalDateTime)`, `origin (String)`, `destination (String)`, `price (double)`, `availability (boolean)`.

1. Implement a method `filterAvailableFlights` that takes a list of flights and returns a list of available flights sorted by price in ascending order. Use method references wherever possible. The pipeline should include filtering, sorting, and mapping operations.

Example: Input:

[

  Flight("FN123", LocalDateTime.of(2022, 12, 1, 10, 30), LocalDateTime.of(2022, 12, 1, 14, 30), "NYC", "LAX", 500.0, true),

  Flight("FN456", LocalDateTime.of(2022, 12, 1, 11, 30), LocalDateTime.of(2022, 12, 1, 15, 30), "NYC", "LAX", 450.0, false),

  Flight("FN789", LocalDateTime.of(2022, 12, 1, 12, 30), LocalDateTime.of(2022, 12, 1, 16, 30), "NYC", "LAX", 550.0, true)

]

Output:

[

  Flight("FN123", LocalDateTime.of(2022, 12, 1, 10, 30), LocalDateTime.of(2022, 12, 1, 14, 30), "NYC", "LAX", 500.0, true),

  Flight("FN789", LocalDateTime.of(2022, 12, 1, 12, 30), LocalDateTime.of(2022, 12, 1, 16, 30), "NYC", "LAX", 550.0, true)

]

2. Implement a method `groupFlightsByDestination` that takes a list of flights and returns a map where the key is the destination and the value is a list of flights to that destination. The flights in the list should be sorted by departure time in ascending order. Use method references wherever possible. The pipeline should include filtering, sorting, and grouping operations.

Example: Input:

[

  Flight("FN123", LocalDateTime.of(2022, 12, 1, 10, 30), LocalDateTime.of(2022, 12, 1, 14, 30), "NYC", "LAX", 500.0, true),

  Flight("FN456", LocalDateTime.of(2022, 12, 1, 11, 30), LocalDateTime.of(2022, 12, 1, 15, 30), "NYC", "LAX", 450.0, false),

  Flight("FN789", LocalDateTime.of(2022, 12, 1, 12, 30), LocalDateTime.of(2022, 12, 1, 16, 30), "NYC", "SFO", 550.0, true)

]

Output:

{

  "LAX": [

    Flight("FN123", LocalDateTime.of(2022, 12, 1, 10, 30), LocalDateTime.of(2022, 12, 1, 14, 30), "NYC", "LAX", 500.0, true)

  ],

  "SFO": [

    Flight("FN789", LocalDateTime.of(2022, 12, 1, 12, 30), LocalDateTime.of(2022, 12, 1, 16, 30), "NYC", "SFO", 550.0, true)

  ]

}

Note: The tasks are designed to test your understanding of Java Stream API and method references. You should aim to use method references wherever possible in your solution.

Task 2

Main Topic: Method References in Stream API Operation Drawn Topic: Stream Collectors

Given a list of Flight objects, each Flight has properties: `flightNumber (String)`, `departureTime (LocalDateTime)`, `arrivalTime (LocalDateTime)`, `origin (String)`, `destination (String)`, `price (double)`, `availability (boolean)`.

1. Implement a method `collectFlightsByOrigin` that takes a list of flights and returns a map where the key is the origin and the value is a list of flights from that origin. The flights in the list should be sorted by departure time in ascending order. Use method references wherever possible. The pipeline should include filtering, sorting, and collecting operations.

Example: Input:

[

  Flight("FN123", LocalDateTime.of(2022, 12, 1, 10, 30), LocalDateTime.of(2022, 12, 1, 14, 30), "NYC", "LAX", 500.0, true),

  Flight("FN456", LocalDateTime.of(2022, 12, 1, 11, 30), LocalDateTime.of(2022, 12, 1, 15, 30), "NYC", "LAX", 450.0, false),

  Flight("FN789", LocalDateTime.of(2022, 12, 1, 12, 30), LocalDateTime.of(2022, 12, 1, 16, 30), "SFO", "LAX", 550.0, true)

]

Output:

{

  "NYC": [

    Flight("FN123", LocalDateTime.of(2022, 12, 1, 10, 30), LocalDateTime.of(2022, 12, 1, 14, 30), "NYC", "LAX", 500.0, true),

    Flight("FN456", LocalDateTime.of(2022, 12, 1, 11, 30), LocalDateTime.of(2022, 12, 1, 15, 30), "NYC", "LAX", 450.0, false)

  ],

  "SFO": [

    Flight("FN789", LocalDateTime.of(2022, 12, 1, 12, 30), LocalDateTime.of(2022, 12, 1, 16, 30), "SFO", "LAX", 550.0, true)

  ]

}

2. Implement a method `calculateAveragePriceByDestination` that takes a list of flights and returns a map where the key is the destination and the value is the average price of flights to that destination. Use method references wherever possible. The pipeline should include filtering, mapping, and collecting operations.

Example: Input:

[

  Flight("FN123", LocalDateTime.of(2022, 12, 1, 10, 30), LocalDateTime.of(2022, 12, 1, 14, 30), "NYC", "LAX", 500.0, true),

  Flight("FN456", LocalDateTime.of(2022, 12, 1, 11, 30), LocalDateTime.of(2022, 12, 1, 15, 30), "NYC", "LAX", 450.0, false),

  Flight("FN789", LocalDateTime.of(2022, 12, 1, 12, 30), LocalDateTime.of(2022, 12, 1, 16, 30), "SFO", "LAX", 550.0, true)

]

Output:

{

  "LAX": 500.0

}

Note: The tasks are designed to test your understanding of Java Stream API, method references, and Stream Collectors. You should aim to use method references wherever possible in your solution.

Task 3

Main Topic: Method References in Stream API Operation Drawn Topic: Parallel Stream

Given a list of Flight objects, each Flight has properties: `flightNumber (String)`, `departureTime (LocalDateTime)`, `arrivalTime (LocalDateTime)`, `origin (String)`, `destination (String)`, `price (double)`, `availability (boolean)`.

1. Implement a method `findCheapestFlight` that takes a list of flights and a destination, and returns the cheapest available flight to that destination. The method should use a parallel stream to process the flights. Use method references wherever possible. The pipeline should include filtering, sorting, and finding operations.

Example: Input:

[

  Flight("FN123", LocalDateTime.of(2022, 12, 1, 10, 30), LocalDateTime.of(2022, 12, 1, 14, 30), "NYC", "LAX", 500.0, true),

  Flight("FN456", LocalDateTime.of(2022, 12, 1, 11, 30), LocalDateTime.of(2022, 12, 1, 15, 30), "NYC", "LAX", 450.0, true),

  Flight("FN789", LocalDateTime.of(2022, 12, 1, 12, 30), LocalDateTime.of(2022, 12, 1, 16, 30), "SFO", "LAX", 550.0, true)

], "LAX"

Output:

Flight("FN456", LocalDateTime.of(2022, 12, 1, 11, 30), LocalDateTime.of(2022, 12, 1, 15, 30), "NYC", "LAX", 450.0, true)

2. Implement a method `findFastestFlight` that takes a list of flights and a destination, and returns the flight with the shortest duration to that destination. The method should use a parallel stream to process the flights. Use method references wherever possible. The pipeline should include filtering, mapping, and reducing operations.

Example: Input:

[

  Flight("FN123", LocalDateTime.of(2022, 12, 1, 10, 30), LocalDateTime.of(2022, 12, 1, 14, 30), "NYC", "LAX", 500.0, true),

  Flight("FN456", LocalDateTime.of(2022, 12, 1, 11, 30), LocalDateTime.of(2022, 12, 1, 15, 30), "NYC", "LAX", 450.0, true),

  Flight("FN789", LocalDateTime.of(2022, 12, 1, 12, 30), LocalDateTime.of(2022, 12, 1, 16, 30), "SFO", "LAX", 550.0, true)

], "LAX"

Output:

Flight("FN123", LocalDateTime.of(2022, 12, 1, 10, 30), LocalDateTime.of(2022, 12, 1, 14, 30), "NYC", "LAX", 500.0, true)

Note: The tasks are designed to test your understanding of Java Stream API, method references, and parallel streams. You should aim to use method references wherever possible in your solution.

Task 4

Main Topic: Method References in Stream API Operation Drawn Topic: Stream Performance

Given a list of Flight objects, each Flight has properties: `flightNumber (String)`, `departureTime (LocalDateTime)`, `arrivalTime (LocalDateTime)`, `origin (String)`, `destination (String)`, `price (double)`, `availability (boolean)`.

1. Implement a method `findFlightsWithinBudget` that takes a list of flights, a destination, and a budget, and returns a list of available flights to that destination within the given budget. The flights in the list should be sorted by price in ascending order. The method should use a parallel stream to process the flights. Use method references wherever possible. The pipeline should include filtering, sorting, and collecting operations.
    
2. Implement a method `findFlightsWithinTimeframe` that takes a list of flights, a destination, and a timeframe (start and end time), and returns a list of available flights to that destination within the given timeframe. The flights in the list should be sorted by departure time in ascending order. The method should use a parallel stream to process the flights. Use method references wherever possible. The pipeline should include filtering, sorting, and collecting operations.
    
3. Implement a method `findDirectFlights` that takes a list of flights, an origin, and a destination, and returns a list of direct flights from the origin to the destination. The flights in the list should be sorted by departure time in ascending order. The method should use a parallel stream to process the flights. Use method references wherever possible. The pipeline should include filtering, sorting, and collecting operations.
    

Note: The tasks are designed to test your understanding of Java Stream API, method references, and stream performance. You should aim to use method references wherever possible in your solution.