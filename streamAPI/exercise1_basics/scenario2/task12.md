Background: An educational institution wants to categorize student performance data into different segments for targeted improvement programs.

Main Topic: Stream basics
  
List: [Stream Basics, Lambda Expressions, Stream Terminating Operations, Stream Collectors, Handling Null Values, Parallel Stream, Exception Handling, Stream Performance, Stream API with Data Structures, Custom Collectors, Method References, Optional, Stream Ordering, Error Handling Strategies, Testing Stream Code, Code Readability, Documentation, Performance Optimization]

**Problem: Advanced Stream API Application**

# Problem Introduction

In the context of our educational institution, we have a large dataset of student performance data. This data includes scores from various tests, attendance records, and other relevant metrics. We want to analyze this data to identify patterns and trends, and categorize students into different segments for targeted improvement programs.
The challenge is that the dataset is large and complex, making it difficult to process and analyze manually. To solve this problem, we will use the Stream API in Java. The Stream API provides a set of tools for processing sequences of data elements, particularly in a functional programming style. It allows us to perform complex data processing tasks in a declarative way, making our code more readable and maintainable.
In the following tasks, we will explore different aspects of the Stream API, and apply them to our student performance data. We will start with basic operations, and gradually move on to more advanced topics. By the end of these tasks, you should have a solid understanding of how to use the Stream API to process and analyze large datasets.

**Level 1: Difficulty 5/10**

Task: Basic Stream Operations and Lambda Expressions

Given a list of Student objects, each with properties for name, test scores, and attendance records, your task is to perform the following operations using the Stream API:

1. Filter out students who have an attendance record of less than 80%.
2. Transform the filtered list into a list of names of the remaining students.
3. Sort the list of names in alphabetical order.
4. Print out the sorted list of names.

This task requires you to use basic Stream operations such as `filter`, `map`, and `sorted`. You will also need to use lambda expressions to specify the conditions for the `filter` and `map` operations. This will give you a good introduction to the core concepts of the Stream API and functional programming in Java.

**Level 2: Difficulty 6/10**

Topic: Stream Terminating Operations

Task: Counting Students and Collecting to a Map

Given the list of Student objects from the previous task, your task is to perform the following operations using the Stream API:

1. Count the number of students who have a test score of 85% or higher.
2. Collect the students who have a test score of 85% or higher into a Map. The key should be the student's name and the value should be the student's test score.

**Level 3: Difficulty 7/10**

Topic: Handling Null Values

Task: Handling Null Values in Student Data

Given the list of Student objects from the previous tasks, your task is to perform the following operations using the Stream API:

1. Filter out any students who have null values in their test scores or attendance records.
2. Count the number of students who have a test score of 85% or higher and an attendance record of 80% or higher.
3. Collect the students who meet the above criteria into a Map. The key should be the student's name and the value should be a pair of the student's test score and attendance record.

**Level 4: Difficulty 8/10**

Topic: Stream Performance

Task: Improving Stream Performance with Parallel Streams

Given the list of Student objects from the previous tasks, your task is to perform the following operations using the Stream API:

1. Convert the stream of students into a parallel stream.
2. Filter out any students who have null values in their test scores or attendance records.
3. Count the number of students who have a test score of 90% or higher and an attendance record of 90% or higher.
4. Collect the students who meet the above criteria into a Map. The key should be the student's name and the value should be a pair of the student's test score and attendance record.