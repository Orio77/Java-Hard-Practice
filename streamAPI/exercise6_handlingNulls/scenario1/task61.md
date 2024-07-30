Background: A HR department needs to analyze employee performance data to identify top performers based on various metrics.

Main Topic: "Handling Null Values with Stream API"

**Problem: Stream API Collectors Mastery**

# Problem Introduction
The HR department of a large corporation is tasked with analyzing a vast amount of employee performance data. This data is collected from various sources and includes metrics such as hours worked, projects completed, and peer reviews. However, due to the nature of data collection, some of the data points may be missing or null. The department needs to handle these null values appropriately to ensure accurate analysis. They have decided to use the Stream API in Java, which provides a clean and efficient way to handle large data sets. However, handling null values with Stream API can be tricky and requires a good understanding of the API's Collectors.

**Level 1: Difficulty 5/10**

Task: You are given a list of Employee objects. Each Employee has a name, hoursWorked, projectsCompleted, and peerReviewScore. Some of these fields may be null. Your task is to calculate the average hoursWorked and projectsCompleted for all employees, ignoring any null values.

**Level 2: Difficulty 6/10**

Task: Now, you are required to calculate the median peerReviewScore for all employees, ignoring any null values. Additionally, find the employee with the maximum hours worked. Remember, you need to handle null values appropriately.


**Level 3: Difficulty 7/10**

Task: Extend your previous solution to calculate the standard deviation of the hoursWorked and projectsCompleted for all employees, ignoring any null values. Additionally, find the employee with the minimum peerReviewScore. Remember, you need to handle null values appropriately. This will require you to perform more complex stream operations and make use of the Collectors in the Stream API.


**Level 4: Difficulty 8/10**

Task: Now, you are required to calculate the interquartile range (IQR) of the projectsCompleted for all employees, ignoring any null values. The IQR is a measure of statistical dispersion and is calculated as the difference between the upper and lower quartiles (Q3 - Q1). Additionally, find the employee with the maximum peerReviewScore. Remember, you need to handle null values appropriately. This will require you to perform more complex stream operations and make use of the Collectors in the Stream API.


**Level 5: Difficulty 9/10**

Task: For this final task, you are required to create a map where the key is the employee's name and the value is a pair of total hours worked and total projects completed by that employee. Ignore any null values in hoursWorked and projectsCompleted. Additionally, find the employee who has the least number of hours worked. This will require you to perform more complex stream operations and make use of the Collectors in the Stream API.