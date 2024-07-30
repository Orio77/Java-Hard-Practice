# Advanced Stream API Application

## Background
A marketing team at XYZ Corporation needs to analyze the response to various campaigns by region and demographic. They have collected a vast amount of data from these campaigns, including the region, demographic details, and the response to the campaign. The data is stored in a large CSV file, with each row representing a response to a campaign. Each row contains the following fields: campaignId, region, age, gender, response.

The team needs to analyze this data to understand the effectiveness of their campaigns. They want to use Java's Stream API to process and analyze this data due to its efficiency and ability to handle large datasets. They also need to handle cases where some fields may be missing or null, using Java's Optional class to avoid NullPointerExceptions.

Your task is to help the marketing team analyze their campaign data using Java's Stream API and Optional class. You will need to write a series of increasingly complex programs that read the data from the CSV file, process it using Stream operations, and output the results.

## Level 1: Difficulty 5/10
Your first task is to load the data from the CSV file and create a Stream of objects representing each response. Each object should have fields for campaignId, region, age, gender, and response. You should use Java's BufferedReader and Stream API to read the file and create the Stream.

Next, you need to filter the data to only include responses from a specific region, let's say "North America". Use the filter operation of the Stream API to achieve this.

Finally, you need to count the number of responses from this region. Use the count operation of the Stream API to get this number.

Remember to handle cases where some fields may be missing or null. Use Java's Optional class to wrap the fields of your response object, and use the orElse method to provide default values when necessary.

## Level 2: Difficulty 6/10
Now that you have filtered responses from "North America" and counted them, let's add more complexity to your task.

In this level, you are required to group the responses by age and gender. This will help the marketing team understand which demographic is responding more to their campaigns in North America.

You will need to use the collect operation of the Stream API, along with Collectors.groupingBy to group the responses.

Additionally, for each age and gender group, calculate the average response. This will require the use of Collectors.averagingInt or Collectors.averagingDouble, depending on the type of your response field.

## Level 3: Difficulty 7/10
For this level, you are required to further analyze the responses by calculating the percentage of positive responses for each campaign in North America. A positive response can be defined as per your dataset, for example, a response value above a certain threshold.

This will require you to use the Stream API's filter, map, and reduce operations. You will also need to use Collectors.groupingBy to group the responses by campaign, and Collectors.counting to count the total number of responses for each campaign.

## Level 4: Difficulty 8/10
For this level, you are required to merge multiple data sources. The marketing team has another CSV file that contains additional information about the campaigns, such as the campaign's start date, end date, and target demographic. This file has the following fields: campaignId, startDate, endDate, targetAge, targetGender.

Your task is to merge the data from the two CSV files based on the campaignId. This will allow the team to analyze the response data in the context of the additional campaign information.

## Level 5: Difficulty 9/10
For the final level, you are required to perform a comprehensive analysis of the campaign data. The marketing team wants to know the effectiveness of their campaigns based on the target demographic and the actual responses received.

First, you need to group the merged data from the Response and Campaign objects by campaignId, targetAge, and targetGender. This will give you an idea of the target demographic for each campaign.

Next, within each group, you need to further group the data by age and gender of the respondents. This will give you an idea of the actual demographic that responded to each campaign.

For each group, calculate the average response and the percentage of positive responses. This will give you an idea of how well the campaign performed for each demographic.

Finally, compare the target demographic with the actual demographic that responded to each campaign. This will require a complex use of the Stream API, involving multiple groupingBy, averaging, and filtering operations.