Background: A service company wants to categorize customer feedback comments based on sentiment (positive, neutral, negative).

Main Topic: Custom Collectors

**Problem: Advanced Stream API Application**

# Problem Introduction

(A service company has been receiving customer feedback comments through various channels like emails, social media, and their website. They want to categorize these comments based on sentiment (positive, neutral, negative) to better understand their customers' satisfaction and improve their services.

The company has a large dataset of customer comments that they need to process. They decide to use Java's Stream API to handle this task due to its efficiency and flexibility in processing large data sets. The Stream API will allow them to filter, map, and collect the comments into different categories based on sentiment.

The company also wants to use custom collectors to perform more complex data processing tasks. Custom collectors in Stream API provide a way to perform mutable reduction operations, where we can accumulate input elements into a mutable result container, optionally transforming the accumulated result into a final representation.

In this series of tasks, you will help the company categorize the comments using Stream API and custom collectors. You will start with basic operations and gradually move to more complex tasks involving advanced Stream API applications.)

## Level 1: Difficulty 5/10

Your first task is to create a basic sentiment analysis system using Java's Stream API. You have a list of customer comments, each associated with a sentiment score. The sentiment score is a number between -1 and 1, where -1 represents a negative sentiment, 0 represents a neutral sentiment, and 1 represents a positive sentiment.

Here are your tasks:

1. Create a Comment class with two fields: String text and double sentimentScore. Implement appropriate constructors, getters, and setters for this class.
2. Create a list of Comment objects. You can create dummy data for this task.
3. Use the Stream API to filter out all comments with a neutral sentiment (i.e., comments with a sentiment score of 0).
4. Use the Stream API to transform the list of comments into a list of strings, where each string is the text of a comment.
5. Use the Stream API to group the comments into two categories: positive and negative. Comments with a sentiment score above 0 are considered positive, and comments with a sentiment score below 0 are considered negative. The result should be a Map<String, List>, where the key is the sentiment ("positive" or "negative"), and the value is the list of comments with that sentiment.

## Level 2: Difficulty 6/10

In this level, you will be required to further categorize the comments based on their intensity of sentiment. Comments with a sentiment score between -1 and -0.5 are considered strongly negative, between -0.5 and 0 are considered mildly negative, between 0 and 0.5 are considered mildly positive, and between 0.5 and 1 are considered strongly positive.

Here are your tasks:

1. Use the Stream API to group the comments into four categories: strongly negative, mildly negative, mildly positive, and strongly positive. The result should be a Map<String, List>, where the key is the sentiment intensity ("strongly negative", "mildly negative", "mildly positive", "strongly positive"), and the value is the list of comments with that sentiment intensity.
2. Create a method that calculates the average sentiment score for each category. The result should be a Map<String, Double>, where the key is the sentiment intensity and the value is the average sentiment score for that category.
3. Create a method that finds the comment with the highest sentiment score and the comment with the lowest sentiment score in each category. The result should be a Map<String, Pair<Comment, Comment>>, where the key is the sentiment intensity and the value is a pair of comments: the comment with the highest sentiment score and the comment with the lowest sentiment score in that category.

## Level 3: Difficulty 7/10

At this level, you will be required to perform more complex operations using the Stream API. You will be dealing with nested operations, complex filtering, and data transformations.

Here are your tasks:

1. Create a method that groups comments based on their sentiment and then within each sentiment group, further categorize them based on the first letter of the comment text. The result should be a Map<String, Map<String, List>>, where the first key is the sentiment ("positive" or "negative"), the second key is the first letter of the comment text, and the value is the list of comments that fall into both categories.
2. Create a method that calculates the total sentiment score for each category created in the previous task. The result should be a Map<String, Map<String, Double>>, where the first key is the sentiment, the second key is the first letter of the comment text, and the value is the total sentiment score for that category.
3. Create a method that finds the comment with the longest text in each category. The result should be a Map<String, Map<String, Comment>>, where the first key is the sentiment, the second key is the first letter of the comment text, and the value is the comment with the longest text in that category.

## Level 4: Difficulty 8/10

In this level, you will be required to handle multiple data sources and perform complex data aggregation using the Stream API and custom collectors. You will be dealing with large datasets and incorporating external factors such as time of the comment.

Here are your tasks:

1. Assume that the comments are coming from three different sources: emails, social media, and the company's website. Each source has its own list of Comment objects. Merge these three lists into one using the Stream API.
2. Create a method that groups comments based on their source and sentiment. The result should be a Map<String, Map<String, List>>, where the first key is the source ("email", "social media", "website"), the second key is the sentiment ("positive", "negative"), and the value is the list of comments that fall into both categories.
3. Assume that each Comment object now has an additional field: LocalDateTime commentTime, which represents the time when the comment was made. Create a method that finds the comment with the earliest and latest comment time in each category created in the previous task. The result should be a Map<String, Map<String, Pair<Comment, Comment>>>, where the first key is the source, the second key is the sentiment, and the value is a pair of comments: the comment with the earliest comment time and the comment with the latest comment time in that category.
4. Create a custom collector that calculates the total sentiment score and the count of comments for each category created in task 2. The result should be a Map<String, Map<String, Pair<Double, Long>>>, where the first key is the source, the second key is the sentiment, and the value is a pair: the total sentiment score and the count of comments in that category.
5. Use the custom collector created in task 4 to calculate the average sentiment score for each category. The result should be a Map<String, Map<String, Double>>, where the first key is the source, the second key is the sentiment, and the value is the average sentiment score for that category.


## Level 5: Difficulty 9/10

In this level, you will be required to handle multiple dimensions of categorization and perform complex data aggregation using the Stream API. Assume that each Comment object now has an additional field: String channel, which represents the channel through which the comment was made (e.g., "email", "social media", "website", "phone", "in-person").

Here are your tasks:

1. Create a method that groups comments based on their source, sentiment, and channel. The result should be a `Map<String, Map<String, Map<String, List<Comment>>>>`, where the first key is the source ("email", "social media", "website"), the second key is the sentiment ("positive", "negative"), the third key is the channel ("email", "social media", "website", "phone", "in-person"), and the value is the list of comments that fall into all three categories.

2. Create a method that calculates the average sentiment score for each category created in the previous task. The result should be a `Map<String, Map<String, Map<String, Double>>>`, where the first key is the source, the second key is the sentiment, the third key is the channel, and the value is the average sentiment score for that category.

3. Create a method that finds the comment with the highest sentiment score and the comment with the lowest sentiment score in each category created in task 1. The result should be a `Map<String, Map<String, Map<String, Pair<Comment, Comment>>>>`, where the first key is the source, the second key is the sentiment, the third key is the channel, and the value is a pair of comments: the comment with the highest sentiment score and the comment with the lowest sentiment score in that category.

4. Create a custom collector that calculates the total sentiment score and the count of comments for each category created in task 1. The result should be a `Map<String, Map<String, Map<String, Pair<Double, Long>>>>`, where the first key is the source, the second key is the sentiment, the third key is the channel, and the value is a pair: the total sentiment score and the count of comments in that category.

5. Use the custom collector created in task 4 to calculate the average sentiment score for each category. The result should be a `Map<String, Map<String, Map<String, Double>>>`, where the first key is the source, the second key is the sentiment, the third key is the channel, and the value is the average sentiment score for that category.