# Advanced Stream API Application

## Background
The finance department of a multinational corporation deals with a large number of transactions daily. These transactions are recorded in various formats and stored in different databases. The department needs to consolidate these records for auditing purposes. The task is challenging due to the volume of the data and the need for accurate consolidation.

The department has decided to use Java's Stream API to handle this task. The Stream API provides a set of sequence operations, which can be used to perform computations upon data in a functional manner. This approach is particularly useful for processing large datasets, as it can be easily parallelized for improved performance.

In this series of tasks, you will be using the Stream API to manipulate and analyze the transaction data. You will start with basic operations, such as filtering and mapping, and gradually move on to more complex tasks, such as reducing and collecting. By the end of these tasks, you should be able to use the Stream API to handle large datasets and perform complex data processing tasks.

## Tasks

### Level 1: Difficulty 5/10
The finance department has provided you with a list of transactions. Each transaction record is an object with the following fields: id (a unique identifier), amount (the transaction amount), type (the type of transaction, such as "credit" or "debit"), and date (the date of the transaction).

Your task is to perform the following operations using Java's Stream API:
- Filter out all transactions that are of type "debit".
- Convert each transaction to a string in the following format: "Transaction ID: [id], Amount: [amount], Date: [date]".
- Collect the results into a list.

### Level 2: Difficulty 6/10
Building on the previous task, the finance department now wants you to perform more complex operations on the transaction data.

Your task is to perform the following operations using Java's Stream API:
- Filter out all transactions that are of type "debit" and have an amount greater than 500.
- Sort the transactions by date in ascending order.
- Convert each transaction to a string in the following format: "Transaction ID: [id], Amount: [amount], Date: [date]".
- Collect the results into a list.

### Level 3: Difficulty 7/10
For this level, the finance department wants you to perform more advanced operations on the transaction data. They want to analyze the transactions based on the month in which they occurred.

Your task is to perform the following operations using Java's Stream API:
- Filter out all transactions that are of type "debit" and have an amount greater than 500.
- Group the transactions by the month of the transaction date.
- For each month, calculate the total amount of transactions.
- Convert each month's transactions to a string in the following format: "Month: [month], Total Amount: [total amount]".
- Collect the results into a map where the key is the month and the value is the corresponding string.

### Level 4: Difficulty 8/10
For this level, the finance department has provided you with another list of transactions from a different database. These transactions also have the fields: id, amount, type, and date. However, the date is in a different format.

Your task is to perform the following operations using Java's Stream API:
- Merge the two lists of transactions into one.
- Convert the date of the transactions from the second list to match the format of the first list.
- Filter out all transactions that are of type "debit" and have an amount greater than 500.
- Group the transactions by the month of the transaction date.
- For each month, calculate the total amount of transactions.
- Convert each month's transactions to a string in the following format: "Month: [month], Total Amount: [total amount]".
- Collect the results into a map where the key is the month and the value is the corresponding string.

### Level 5: Difficulty 9/10
For this final level, the finance department wants you to perform a comprehensive analysis of the transaction data. They have provided you with multiple lists of transactions from different databases. Each list has transactions with the fields: id, amount, type, and date. However, the date is in different formats in different lists.

Your task is to perform the following operations using Java's Stream API:
- Merge all the lists of transactions into one.
- Convert the date of the transactions from all lists to a common format.
- Filter out all transactions that are of type "debit" and have an amount greater than 500.
- Group the transactions by the month of the transaction date.
- For each month, calculate the total amount of transactions.
- For each month, find the transaction with the highest amount.
- Convert each month's transactions to a string in the following format: "Month: [month], Total Amount: [total amount], Highest Transaction: [id of the transaction with the highest amount]".
- Collect the results into a map where the key is the month and the value is the corresponding string.

This task will require you to use all the skills and knowledge you have acquired in the previous levels. You will need to handle complex scenarios, perform sophisticated data analysis, and use intricate Stream API operations. The goal is to synthesize all the aspects of the main topic and background into a final, intricate application of the Stream API.