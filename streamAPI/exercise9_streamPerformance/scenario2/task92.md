## Task 1

You are given a list of `Customer` objects. Each `Customer` has a `name`, `age`, and a `List<Purchase>` representing their purchase history. Each `Purchase` has a `product`, `quantity`, and `price`.

Function 1: `findTopBuyers(List<Customer> customers, int n)` This function should return the names of the top `n` customers who have spent the most money. Use Stream API to create a pipeline that maps each customer to the total amount they have spent, sorts the customers in descending order of the amount spent, and then collects the top `n` customer names.

Function 2: `findPopularProducts(List<Customer> customers, int n)` This function should return the names of the top `n` most popular products (i.e., the products with the highest quantity sold). Use Stream API to create a pipeline that flattens the list of purchases, maps each purchase to its product and quantity, groups by product, sums the quantities, sorts in descending order of quantity, and then collects the top `n` product names.

Example Input:

List<Customer> customers = Arrays.asList(

    new Customer("Alice", 30, Arrays.asList(new Purchase("Apple", 2, 1.0), new Purchase("Banana", 3, 0.5))),

    new Customer("Bob", 25, Arrays.asList(new Purchase("Apple", 1, 1.0), new Purchase("Cherry", 5, 0.2))),

    new Customer("Charlie", 35, Arrays.asList(new Purchase("Banana", 2, 0.5), new Purchase("Cherry", 2, 0.2)))

);

int n = 2;

1 vulnerability

Example Output:

findTopBuyers(customers, n); // Returns ["Charlie", "Alice"]

findPopularProducts(customers, n); // Returns ["Cherry", "Banana"]

## Task 2

Main Topic: Stream API performance Drawn Topic: Stream Collectors

Similar to Task 1, but this time, you need to implement the following two methods using custom collectors.

Function 1: `findTopBuyersWithCollector(List<Customer> customers, int n)` Function 2: `findPopularProductsWithCollector(List<Customer> customers, int n)`

The input and output remain the same as in Task 1.

## Task 3

Main Topic: Stream API performance Drawn Topic: Parallel Stream

This task is similar to Task 1, but you need to implement the methods using parallel streams to improve performance.

Function 1: `findTopBuyersWithParallelStream(List<Customer> customers, int n)` Function 2: `findPopularProductsWithParallelStream(List<Customer> customers, int n)`

The input and output remain the same as in Task 1.

## Task 4

Main Topic: Stream API performance Drawn Topic: Stream Ordering

In this task, you need to implement three methods. The first two methods are similar to those in Task 1, but you need to ensure that the order of the customers and products is preserved.

Function 1: `findTopBuyersWithOrdering(List<Customer> customers, int n)` Function 2: `findPopularProductsWithOrdering(List<Customer> customers, int n)`

Function 3: `findTopBuyersForProduct(List<Customer> customers, String product, int n)` This function should return the names of the top `n` customers who have bought the most quantity of a given product. Use Stream API to create a pipeline that filters the purchases for the given product, maps each purchase to its customer and quantity, groups by customer, sums the quantities, sorts in descending order of quantity, and then collects the top `n` customer names.

The input and output for the first two functions remain the same as in Task 1. For the third function:

Example Input:

List<Customer> customers = Arrays.asList(

    new Customer("Alice", 30, Arrays.asList(new Purchase("Apple", 2, 1.0), new Purchase("Banana", 3, 0.5))),

    new Customer("Bob", 25, Arrays.asList(new Purchase("Apple", 1, 1.0), new Purchase("Cherry", 5, 0.2))),

    new Customer("Charlie", 35, Arrays.asList(new Purchase("Banana", 2, 0.5), new Purchase("Cherry", 2, 0.2)))

);

String product = "Apple";

int n = 2;

Example Output:

findTopBuyersForProduct(customers, product, n); // Returns ["Alice", "Bob"]