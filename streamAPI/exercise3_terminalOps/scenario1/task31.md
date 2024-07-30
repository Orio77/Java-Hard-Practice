## Problem Statement

You are given a list of `Customer` objects. Each `Customer` has the following properties:

- `id`: An integer representing the customer's ID.
- `name`: A string representing the customer's name.
- `isActive`: A boolean representing whether the customer is active or not.
- `region`: A string representing the region where the customer lives.

Your task is to perform several operations on this list using the Java Stream API.

### Level 1

Filter out all inactive customers. Return a list of active customers.

### Level 2

From the active customers, filter out all customers who live outside the region "North". Return a list of active customers who live in the "North" region.

### Level 3

Sort the list of active customers from the "North" region by their names in ascending order. Return the sorted list.

### Level 4

Transform the sorted list of active customers from the "North" region into a map where the key is the customer's ID and the value is the customer's name. Return the map.

### Level 5

Find the customer with the longest name among the active customers from the "North" region. Return the customer's name.

### Level 6

Calculate the average length of the names of the active customers from the "North" region. Return the average length as a double.

### Constraints

- The list of customers will have at least 1 and at most 10^5 elements.
- The customer's ID will be a positive integer and unique.
- The customer's name will have at least 1 and at most 100 characters.
- The customer's region will be a non-empty string