# Advanced Stream API Application

## Background
A retail company, "RetailX", has a large inventory of products across multiple categories. They have recently noticed that some of their products are frequently running out of stock, causing potential loss in sales. To address this issue, they want to generate a report of products with low inventory levels.

## Main Topic
Stream API with Data Structures

## Problem Introduction
Your task is to use the Java Stream API to process a dataset of all their products, each with an associated inventory count. The dataset includes information such as the product ID, product name, category, and current inventory count. You will need to filter, sort, and analyze the data to identify products with low inventory levels.

## Levels

### Level 1: Difficulty 5/10
Load the dataset into a list of Product objects. Use the Stream API to filter out all products that have an inventory count of less than 100. Sort the resulting list in ascending order based on the inventory count. Print out the product ID, product name, and inventory count of each product in the sorted list.

### Level 2: Difficulty 6/10
Group the products by their categories using the Stream API. Sort each category's product list in ascending order based on the inventory count. Print out each category along with the product ID, product name, and inventory count of each product in the sorted list for that category.

### Level 3: Difficulty 7/10
Identify the top 5 categories with the most products having an inventory count of less than 100. For each of these top 5 categories, identify the product with the lowest inventory count. Print out each of the top 5 categories, along with the product ID, product name, and inventory count of the product with the lowest inventory count in each category.

### Level 4: Difficulty 8/10
Merge the sales data with the existing product inventory data. Filter out all products that have an inventory count of less than 100 and have sold more than 50 units in the last month. Sort the resulting list in ascending order based on the inventory count. Print out the product ID, product name, category, inventory count, number of units sold, and date of sale for each product in the sorted list.

### Level 5: Difficulty 9/10
Merge the supplier data with the existing product and sales data. Filter out all products that have an inventory count of less than 100, have sold more than 50 units in the last month, and are supplied by a supplier located more than 1000 miles away. Sort the resulting list in ascending order based on the inventory count. Print out the product ID, product name, category, inventory count, number of units sold, date of sale, supplier name, and supplier location for each product in the sorted list.