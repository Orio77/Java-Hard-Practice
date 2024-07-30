Background: A retail chain aims to analyze customer purchase histories to predict future buying preferences.

Main Topic: Stream API collectors
  
List: [Stream Basics, Lambda Expressions, Stream Terminating Operations, Stream Collectors, Handling Null Values, Parallel Stream, Exception Handling, Stream Performance, Stream API with Data Structures, Custom Collectors, Method References, Optional, Stream Ordering, Error Handling Strategies, Testing Stream Code, Code Readability, Documentation, Performance Optimization]

**Problem: Advanced Stream API Application**

# Problem Introduction

A retail chain, ShopRight, has a vast amount of customer purchase data. They want to leverage this data to predict future buying preferences of their customers. This will help them to stock their stores more efficiently and provide personalized offers to their customers.

The IT department of ShopRight has decided to use Java's Stream API to analyze this data. They chose Stream API because of its ability to handle large data sets in a functional, declarative manner, which can greatly simplify the code and make it more readable and maintainable.

Your task as a software developer at ShopRight is to create a series of applications using Stream API to analyze the customer purchase data. You will start with some basic operations and gradually move to more complex tasks, involving advanced Stream API concepts and operations.

**Level 1: Difficulty 5/10**

Your first task is to create a Java application that uses Stream API to analyze the customer purchase data. The data is stored in a CSV file with the following columns: CustomerID, ProductID, Quantity, and PurchaseDate.

You need to perform the following operations:

1. Load the data from the CSV file into a list of `Purchase` objects. Each `Purchase` object should have fields corresponding to the columns in the CSV file.
    
2. Use Stream API to filter out purchases that were made more than a year ago.
    
3. Use Stream API to group the purchases by CustomerID.
    
4. For each customer, calculate the total quantity of products they have purchased.
    
5. Sort the customers by the total quantity of products purchased in descending order.
    
6. Print the top 10 customers with the highest total quantity of products purchased.

**Level 2: Difficulty 6/10**

Your second task is to enhance the Java application you created in Level 1 by adding more complex analysis using Stream Collectors.

You need to perform the following operations:

1. Use Stream API to group the purchases by ProductID.
    
2. For each product, calculate the total quantity sold.
    
3. Use a Collector to transform the results into a Map where the keys are the ProductIDs and the values are the total quantities sold.
    
4. Find the top 10 products with the highest total quantity sold.
    
5. Print the ProductID and total quantity sold for these top 10 products.
    
6. Additionally, use Stream API to calculate the average quantity of products purchased per transaction. Use a Collector to calculate this average.

**Level 3: Difficulty 7/10**

Your third task is to further enhance the Java application by handling potential null values in the purchase data and improving the performance of your Stream operations using parallel streams.

You need to perform the following operations:

1. Modify your `Purchase` object loading operation to handle potential null values in the CSV data. If a null value is encountered, skip that record and continue with the next one.
    
2. Use Stream API to filter out purchases that have a null `ProductID` or `Quantity`.
    
3. Use parallel streams to speed up the grouping of purchases by `CustomerID` and `ProductID`.
    
4. For each customer and product, calculate the total quantity purchased using parallel streams.
    
5. Use a Collector to transform the results into a Map where the keys are the `CustomerID` or `ProductID` and the values are the total quantities purchased.
    
6. Find the top 10 customers and products with the highest total quantity purchased using parallel streams.
    
7. Print the `CustomerID` or `ProductID` and total quantity purchased for these top 10 customers and products.

**Level 4: Difficulty 8/10**

Your fourth task is to further enhance the Java application by handling exceptions that may occur during the stream operations and optimizing the performance of your Stream operations.

You need to perform the following operations:

1. Modify your `Purchase` object loading operation to handle potential exceptions that may occur during the reading of the CSV file. If an exception is encountered, log the error and continue with the next record.
    
2. Use Stream API to filter out purchases that have a null `ProductID` or `Quantity`. Handle any exceptions that may occur during this operation.
    
3. Use parallel streams to speed up the grouping of purchases by `CustomerID` and `ProductID`. Handle any exceptions that may occur during this operation.
    
4. For each customer and product, calculate the total quantity purchased using parallel streams. Handle any exceptions that may occur during this operation.
    
5. Use a Collector to transform the results into a Map where the keys are the `CustomerID` or `ProductID` and the values are the total quantities purchased. Handle any exceptions that may occur during this operation.
    
6. Find the top 10 customers and products with the highest total quantity purchased using parallel streams. Handle any exceptions that may occur during this operation.
    
7. Print the `CustomerID` or `ProductID` and total quantity purchased for these top 10 customers and products. Handle any exceptions that may occur during this operation.
    
8. Optimize the performance of your Stream operations by using appropriate Stream methods and techniques. For example, use the `findFirst` or `findAny` methods when searching for a single element instead of filtering the entire stream.
    
9. Test your Stream operations to ensure they are working correctly and efficiently. Use JUnit to create unit tests for your Stream operations.
    
10. Document your code and Stream operations to ensure they are understandable and maintainable. Use JavaDoc to create documentation for your code.