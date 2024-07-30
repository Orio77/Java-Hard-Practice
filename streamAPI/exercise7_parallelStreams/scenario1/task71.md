Background: A sales team has a list of sales transactions and needs to calculate the total sales amount for the month.

Main Topic: parallel streams

**Problem: Advanced Stream API Application**

# Problem Introduction

"In the bustling city of Techville, the local electronics store, "Gadget Garage", has been experiencing a surge in sales due to their wide range of cutting-edge products. The sales team, however, is struggling to keep up with the volume of sales transactions and needs a more efficient way to calculate the total sales amount for the month.

The sales transactions are recorded in a list, with each transaction containing the product sold, the quantity, and the price per unit. The sales team has been manually calculating the total sales amount, which is a time-consuming process given the high volume of transactions.

To streamline this process, the sales team has decided to use the Stream API in Java. They plan to use parallel streams to process the transactions concurrently, thereby reducing the computation time. The team is confident that this approach will allow them to calculate the total sales amount more efficiently, even as the number of transactions continues to grow."

**Level 1: Difficulty 5/10**

"The sales team at "Gadget Garage" has a list of sales transactions for the month. Each transaction is represented as an object of the Transaction class, which has the following fields: productName (String), quantity (int), pricePerUnit (double), and salesPerson (String).

Your task is to write a method calculateSalesByPerson that takes a list of these transactions as input and returns a Map where the keys are the names of the sales persons and the values are the total sales amount each person made for the month. Use the Stream API in Java to process the transactions. To introduce the concept of parallel streams, ensure your solution uses a parallel stream to calculate the totals."

**Level 2: Difficulty 6/10**

"Building on your previous work, the sales team at "Gadget Garage" now wants to analyze their sales data further. They want to know the total sales amount for each product sold by each salesperson, but this time, they also want to know the average price per unit for each product sold by each salesperson.

Your task is to write a method calculateSalesAndAveragePriceByPersonAndProduct that takes a list of transactions as input and returns a Map<String, Map<String, Pair<Double, Double>>>. The outer map's keys are the names of the salespersons, and the values are inner maps. Each inner map's keys are the product names, and the values are pairs. The first element in the pair is the total sales amount of each product sold by the corresponding salesperson, and the second element is the average price per unit of each product sold by the corresponding salesperson.

Use the Stream API in Java to process the transactions. Continue using parallel streams to calculate the totals and averages. This task requires you to use more advanced Stream operations, such as groupingBy, mapping, and averagingDouble. Remember to handle the case where a salesperson might have sold multiple units of the same product in different transactions."

**Level 3: Difficulty 7/10**

"Continuing with the sales data analysis, the "Gadget Garage" sales team now wants to identify the top-selling products for each salesperson. They are interested in knowing which product each salesperson sold the most units of.

Your task is to write a method findTopSellingProductByPerson that takes a list of transactions as input and returns a Map<String, String>. The keys of the map are the names of the salespersons, and the values are the names of the top-selling product for each salesperson.

In the case of a tie, where a salesperson has sold the same quantity of two or more products, return the product with the highest total sales amount. If there is still a tie, return any one of the top-selling products.

Use the Stream API in Java to process the transactions. Continue using parallel streams to calculate the quantities and totals. This task requires you to use advanced Stream operations, such as groupingBy, reducing, and collectingAndThen. Remember to handle the case where a salesperson might have sold multiple units of the same product in different transactions."

**Level 4: Difficulty 8/10**

"Expanding on your previous work, the sales team at "Gadget Garage" now wants to integrate their sales data with external product information. They have access to a separate list of Product objects, each containing the product name (String), category (String), and manufacturer (String).

The sales team wants to analyze their sales data in the context of these product categories and manufacturers. They want to know the total sales amount and the average price per unit for each product category sold by each salesperson, as well as the total sales amount and the average price per unit for each manufacturer's products sold by each salesperson.

Your task is to write two methods: calculateSalesAndAveragePriceByPersonAndCategory and calculateSalesAndAveragePriceByPersonAndManufacturer. Both methods take a list of transactions and a list of products as input and return a Map<String, Map<String, Pair<Double, Double>>>. The outer map's keys are the names of the salespersons, and the values are inner maps. Each inner map's keys are the product categories or manufacturers, and the values are pairs. The first element in the pair is the total sales amount of each category or manufacturer's products sold by the corresponding salesperson, and the second element is the average price per unit of each category or manufacturer's products sold by the corresponding salesperson.

Use the Stream API in Java to process the transactions and products. Continue using parallel streams to calculate the totals and averages. This task requires you to use advanced Stream operations, such as groupingBy, mapping, and averagingDouble. You will also need to merge the two data sources (transactions and products) based on the product name. Remember to handle the case where a salesperson might have sold multiple units of the same product in different transactions."

**Level 5: Difficulty 9/10**

"Finally, the sales team at "Gadget Garage" wants a comprehensive analysis of their sales data. They want to identify the top-performing salesperson for each product category and manufacturer. They also want to know the total sales amount, the average price per unit, and the top-selling product for each product category and manufacturer.

Your task is to write two methods: calculateTopPerformerAndSalesByCategory and calculateTopPerformerAndSalesByManufacturer. Both methods take a list of transactions and a list of products as input and return a Map<String, Map<String, Triple<String, Pair<Double, Double>, String>>>. The outer map's keys are the product categories or manufacturers, and the values are inner maps. Each inner map's keys are the product names, and the values are triples. The first element in the triple is the name of the top-performing salesperson for the corresponding product, the second element is a pair where the first element is the total sales amount of the product and the second element is the average price per unit, and the third element is the name of the top-selling product in the category or from the manufacturer.

Use the Stream API in Java to process the transactions and products. Continue using parallel streams to calculate the totals, averages, and top performers. This task requires you to use advanced Stream operations, such as groupingBy, mapping, reducing, collectingAndThen, and maxBy. You will also need to merge the two data sources (transactions and products) based on the product name. Remember to handle the case where a salesperson might have sold multiple units of the same product in different transactions.

This final task requires you to synthesize all the skills and knowledge you've acquired in the previous levels. It involves handling complex scenarios, sophisticated data analysis, and intricate Stream API operations. The goal is to provide a comprehensive and multifaceted application of the Stream API that meets the sales team's needs."