Task 1

You are given a list of `Destination` objects. Each `Destination` has a `name` (String), `distance` (int, in miles), `popularity` (int, on a scale of 1 to 10), and `reviews` (List of `Review` objects). Each `Review` has a `rating` (int, on a scale of 1 to 5) and `comment` (String).

Function 1: `filterDestinationsByDistanceAndPopularity(List<Destination> destinations, int maxDistance, int minPopularity) -> List<Destination>`

This function should return a list of destinations that are within the `maxDistance` and have a popularity of at least `minPopularity`. The list should be sorted by distance in ascending order. If two destinations have the same distance, sort them by popularity in descending order. Handle any exceptions that may occur during the stream operations.

Function 2: `calculateAverageReviewRating(List<Destination> destinations) -> Map<String, Double>`

This function should return a map where the key is the destination name and the value is the average review rating for that destination. If a destination has no reviews, its average rating should be 0. Handle any exceptions that may occur during the stream operations.

Example Input:

List<Destination> destinations = Arrays.asList(

    new Destination("Paris", 5000, 9, Arrays.asList(new Review(5, "Great!"), new Review(4, "Good"))),

    new Destination("New York", 3000, 8, Arrays.asList(new Review(5, "Awesome!"), new Review(4, "Nice"))),

    new Destination("London", 4000, 7, Arrays.asList(new Review(3, "Okay"), new Review(2, "Bad"))),

    new Destination("Tokyo", 6000, 10, Arrays.asList(new Review(5, "Excellent!"), new Review(4, "Good"))),

    new Destination("Sydney", 7000, 6, new ArrayList<>())

);

Example Output:

filterDestinationsByDistanceAndPopularity(destinations, 5000, 8) -> ["New York", "Paris"]

calculateAverageReviewRating(destinations) -> {"Paris": 4.5, "New York": 4.5, "London": 2.5, "Tokyo": 4.5, "Sydney": 0.0}


Task 2

Main Topic: Exception Handling in Stream Operations

Drawn Topic: Stream API with Data Structures

Background: A travel agency has a list of destinations and wants to create optimized itineraries based on distance, popularity, and reviews.

Function 1: `findTopDestinationsByReviewScore(List<Destination> destinations, int topN) -> List<Destination>`

This function should return a list of top `N` destinations sorted by the average review score in descending order. If two destinations have the same average review score, sort them by popularity in descending order. Handle any exceptions that may occur during the stream operations.

Function 2: `groupDestinationsByPopularity(List<Destination> destinations) -> Map<Integer, List<Destination>>`

This function should return a map where the key is the popularity and the value is a list of destinations that have that popularity. The destinations in each list should be sorted by distance in ascending order. Handle any exceptions that may occur during the stream operations.

Example Input:

List<Destination> destinations = Arrays.asList(

    new Destination("Paris", 5000, 9, Arrays.asList(new Review(5, "Great!"), new Review(4, "Good"))),

    new Destination("New York", 3000, 8, Arrays.asList(new Review(5, "Awesome!"), new Review(4, "Nice"))),

    new Destination("London", 4000, 7, Arrays.asList(new Review(3, "Okay"), new Review(2, "Bad"))),

    new Destination("Tokyo", 6000, 10, Arrays.asList(new Review(5, "Excellent!"), new Review(4, "Good"))),

    new Destination("Sydney", 7000, 6, new ArrayList<>())

);

Example Output:

findTopDestinationsByReviewScore(destinations, 3) -> ["Tokyo", "Paris", "New York"]

groupDestinationsByPopularity(destinations) -> {6: ["Sydney"], 7: ["London"], 8: ["New York"], 9: ["Paris"], 10: ["Tokyo"]}

Task 3

Main Topic: Exception Handling in Stream Operations

Drawn Topic: Stream Performance

Background: A travel agency has a list of destinations and wants to create optimized itineraries based on distance, popularity, and reviews.

Function 1: `findClosestPopularDestination(List<Destination> destinations, int minPopularity) -> Optional<Destination>`

This function should return the closest destination that has a popularity of at least `minPopularity`. If there are no such destinations, return an empty Optional. This function should be optimized for performance and handle any exceptions that may occur during the stream operations.

Function 2: `findFarthestUnpopularDestination(List<Destination> destinations, int maxPopularity) -> Optional<Destination>`

This function should return the farthest destination that has a popularity of at most `maxPopularity`. If there are no such destinations, return an empty Optional. This function should be optimized for performance and handle any exceptions that may occur during the stream operations.

Example Input:

List<Destination> destinations = Arrays.asList(

    new Destination("Paris", 5000, 9, Arrays.asList(new Review(5, "Great!"), new Review(4, "Good"))),

    new Destination("New York", 3000, 8, Arrays.asList(new Review(5, "Awesome!"), new Review(4, "Nice"))),

    new Destination("London", 4000, 7, Arrays.asList(new Review(3, "Okay"), new Review(2, "Bad"))),

    new Destination("Tokyo", 6000, 10, Arrays.asList(new Review(5, "Excellent!"), new Review(4, "Good"))),

    new Destination("Sydney", 7000, 6, new ArrayList<>())

);

Example Output:

findClosestPopularDestination(destinations, 8) -> Optional["New York"]

findFarthestUnpopularDestination(destinations, 7) -> Optional["Sydney"]

Task 4

Main Topic: Exception Handling in Stream Operations

Drawn Topic: Stream Ordering

Background: A travel agency has a list of destinations and wants to create optimized itineraries based on distance, popularity, and reviews.

Function 1: `sortDestinationsByDistanceAndPopularity(List<Destination> destinations) -> List<Destination>`

This function should return a list of destinations sorted by distance in ascending order. If two destinations have the same distance, sort them by popularity in descending order. Handle any exceptions that may occur during the stream operations.

Function 2: `sortDestinationsByReviewScoreAndPopularity(List<Destination> destinations) -> List<Destination>`

This function should return a list of destinations sorted by the average review score in descending order. If two destinations have the same average review score, sort them by popularity in descending order. Handle any exceptions that may occur during the stream operations.

Function 3: `sortDestinationsByPopularityAndReviewScore(List<Destination> destinations) -> List<Destination>`

This function should return a list of destinations sorted by popularity in descending order. If two destinations have the same popularity, sort them by the average review score in descending order. Handle any exceptions that may occur during the stream operations.

Example Input:

List<Destination> destinations = Arrays.asList(

    new Destination("Paris", 5000, 9, Arrays.asList(new Review(5, "Great!"), new Review(4, "Good"))),

    new Destination("New York", 3000, 8, Arrays.asList(new Review(5, "Awesome!"), new Review(4, "Nice"))),

    new Destination("London", 4000, 7, Arrays.asList(new Review(3, "Okay"), new Review(2, "Bad"))),

    new Destination("Tokyo", 6000, 10, Arrays.asList(new Review(5, "Excellent!"), new Review(4, "Good"))),

    new Destination("Sydney", 7000, 6, new ArrayList<>())

);

Example Output:

sortDestinationsByDistanceAndPopularity(destinations) -> ["New York", "London", "Paris", "Tokyo", "Sydney"]

sortDestinationsByReviewScoreAndPopularity(destinations) -> ["Tokyo", "Paris", "New York", "London", "Sydney"]

sortDestinationsByPopularityAndReviewScore(destinations) -> ["Tokyo", "Paris", "New York", "London", "Sydney"]