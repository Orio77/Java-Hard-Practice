**Problem: Stream API Collectors Mastery**

**Level 1: Difficulty 5/10**

You have a list of `Product` objects. Each `Product` has a `name` (String) and a `price` (double). Your task is to use the Stream API to sort the products in descending order by price.

**Level 2: Difficulty 6/10**

Now, the e-commerce platform wants to group the products by their price. Use the Stream API to group the products into a `Map<Double, List<Product>>` where the key is the price and the value is a list of products with that price.


**Level 3: Difficulty 7/10**

The platform wants to know the average price of all products, but this time, they want the average price for each category of products. Each `Product` has a `category` (String) field. Use the Stream API to calculate the average price of the products in each category. Remember to handle the case where the list of products is empty.

**Level 4: Difficulty 8/10**

The platform wants to know the most expensive and the least expensive product in each category. Use the Stream API to find these two products for each category. Remember to handle the case where the list of products is empty. You should return a `Map<String, Pair<Product, Product>>` where the key is the category and the value is a pair of products (most expensive, least expensive).

**Level 5: Difficulty 9/10**

The platform wants to know the total revenue if all products are sold. Use the Stream API to calculate the total price of all products. Additionally, they want to know the count of products that are above the average price. Use the Stream API to calculate this count.