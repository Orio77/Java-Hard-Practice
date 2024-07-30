Background: A travel agency has a list of destinations and wants to create optimized itineraries based on distance and popularity.

Main Topic: Streams Terminal Operations
  
List: [Stream Basics, Lambda Expressions, Stream Terminating Operations, Stream Collectors, Handling Null Values, Parallel Stream, Exception Handling, Stream Performance, Stream API with Data Structures, Custom Collectors, Method References, Optional, Stream Ordering, Error Handling Strategies, Testing Stream Code, Code Readability, Documentation, Performance Optimization]

**Problem: Advanced Stream API Application**

# Problem Introduction

A travel agency, "Wanderlust Travel", has a list of destinations they offer to their customers. Each destination has a popularity score and a distance from the agency's main location. The agency wants to create optimized itineraries for their customers that balance the popularity of the destinations and the total travel distance.

They have decided to use the Stream API in Java to handle this problem due to its powerful capabilities in handling collections of data. The agency needs a system that can filter, sort, and manipulate the data to create the best possible itineraries.

Your task is to help "Wanderlust Travel" by using the Stream API to create this system. You will need to use various terminal operations to process the data and generate the optimized itineraries.

**Level 1: Difficulty 5/10**

Your first task is to create a method that will filter and sort the list of destinations. The agency has a list of `Destination` objects, where each `Destination` has a `name`, `popularityScore`, and `distanceFromAgency`.

The method should do the following:

1. Filter out any destinations that are more than 1000 miles away.
2. Sort the remaining destinations in descending order of popularity.
3. If two destinations have the same popularity score, the destination with the shorter distance should come first.
4. Return the sorted list of destinations.

**Level 2: Difficulty 6/10**

Your next task is to create a method that will group the destinations by their popularity score. The agency wants to know how many destinations fall into each popularity score. This will help them to understand the distribution of the popularity of their destinations.

The method should do the following:

1. Use the Stream API to process the list of `Destination` objects.
2. Group the destinations by their `popularityScore`.
3. For each popularity score, count the number of destinations with that score.
4. Return a Map where the keys are the popularity scores and the values are the counts of destinations with that score.

**Level 3: Difficulty 7/10**

Your third task is to create a method that will calculate the average distance of destinations for each popularity score. The agency wants to know the average distance of destinations for each popularity score to better understand the correlation between distance and popularity.

The method should do the following:

1. Use the Stream API to process the list of `Destination` objects.
2. Group the destinations by their `popularityScore`.
3. For each popularity score, calculate the average `distanceFromAgency` of destinations with that score.
4. Return a Map where the keys are the popularity scores and the values are the average distances of destinations with that score.

**Level 4: Difficulty 8/10**

Your final task is to create a method that will generate the optimized itineraries for the customers. The agency wants to provide itineraries that offer the most popular destinations within a certain distance limit. For this task, you will need to combine your knowledge of Stream terminal operations with handling null values.

The method should do the following:

1. Use the Stream API to process the list of `Destination` objects.
2. Filter out any destinations that are null or have null properties.
3. Group the destinations by their `popularityScore`.
4. For each popularity score, sort the destinations in ascending order of `distanceFromAgency`.
5. For each popularity score, create an itinerary that includes destinations up to a total distance of 1000 miles. If adding a destination would exceed this limit, it should be skipped.
6. Return a Map where the keys are the popularity scores and the values are the itineraries for that score. Each itinerary should be a List of `Destination` objects.

This task will require careful handling of null values and efficient use of Stream operations to generate the itineraries. Remember to test your code thoroughly to ensure it works as expected.