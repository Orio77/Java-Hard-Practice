Background: A marketing team needs to analyze the response to various campaigns by region and demographic.

Main Topic: Error Handling Strategies in Stream API
  
List: [Stream Basics, Lambda Expressions, Stream Terminating Operations, Stream Collectors, Handling Null Values, Parallel Stream, Exception Handling, Stream Performance, Stream API with Data Structures, Custom Collectors, Method References, Optional, Stream Ordering, Error Handling Strategies, Testing Stream Code, Code Readability, Documentation, Performance Optimization]

**Problem: Advanced Stream API Application**

## Background

A marketing team at XYZ Corporation has recently launched several campaigns across different regions and demographics. They have collected a large amount of data from these campaigns, including the region, demographic, and response to each campaign. The data is stored in a large list of objects, where each object represents a single response to a campaign. The team needs to analyze this data using the Stream API in Java, specifically focusing on handling any potential errors that may occur during the processing of the stream.

## Problem Levels

### Level 1: Difficulty 5/10

Your task is to create a Java program that uses the Stream API to process the marketing campaign data. The data is stored in a list of `CampaignResponse` objects, where each `CampaignResponse` has properties for region, demographic, and response.

First, create a method `processCampaignData` that takes a `List<CampaignResponse>` as input. This method should return a `Map<String, Long>` where the key is the region and the value is the count of responses for that region.

Use the Stream API to process the list. Use the filter operation to exclude any `CampaignResponse` objects where the response is null or empty.

Use the collect operation with `Collectors.groupingBy` and `Collectors.counting` to create the output map.

Implement error handling in your stream processing. If an error occurs during the processing of the stream (for example, a null `CampaignResponse` object in the list), the program should not crash. Instead, it should handle the error gracefully and continue processing the rest of the stream.

### Level 2: Difficulty 6/10

Your task is to optimize the Java program you created in Level 1 for better performance. The data is still stored in a list of `CampaignResponse` objects, where each `CampaignResponse` has properties for region, demographic, and response.

First, modify the method `processCampaignData` to use parallel streams for processing the marketing campaign data. This should help to improve the performance of the program when dealing with large amounts of data.

Next, implement a mechanism to measure the execution time of the stream processing. This could be done by recording the system time before and after the stream processing and calculating the difference.

Finally, test the performance of your program with both sequential and parallel streams. Compare the execution times and analyze the results.

### Level 3: Difficulty 7/10

Your task is to modify the `processCampaignData` method to not only process the data but also collect the results into a more complex data structure. Specifically, you should collect the data into a `Map<String, List<CampaignResponse>>`, where the key is the region and the value is a list of `CampaignResponse` objects for that region.

To achieve this, you will need to use the `Collectors.groupingBy` method, which is a powerful tool for grouping data in streams. This method takes a classification function as an argument, which determines how the data should be grouped.

Once you have collected the data into a map, add a functionality to print out the total number of responses for each region. This will require you to transform the map into another map where the key is the region and the value is the count of responses for that region. You can achieve this by using the `Collectors.counting` method.

Finally, test your program to ensure that it correctly groups and counts the campaign responses by region.

### Level 4: Difficulty 8/10

Your task is to enhance the `processCampaignData` method to handle null values and exceptions gracefully. In the real world, data is often messy and incomplete, and your program should be able to handle this.

First, modify the stream operations to filter out any null `CampaignResponse` objects before processing. You can do this using the filter method of the Stream API.

Next, implement exception handling in your stream operations. If an exception occurs while processing a `CampaignResponse` object (for example, if a property of the object is null), your program should not crash. Instead, it should log the error and continue processing the rest of the data.

To achieve this, you will need to use the try-catch block inside the lambda expressions of your stream operations. However, keep in mind that lambda expressions in Java cannot throw checked exceptions, so you will need to wrap any checked exceptions in an unchecked exception.