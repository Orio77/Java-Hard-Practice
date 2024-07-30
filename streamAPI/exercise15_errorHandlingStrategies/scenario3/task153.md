Task 1

Background: A retail chain is looking to improve their inventory management system. The challenge is to use Java Stream API to process and analyze sales data across multiple locations to optimize stock levels and reduce waste.

Main Topic: Error Handling Strategies in Stream Operations

Problem: You are given a list of sales data from multiple locations. Each sale is represented as an object with properties: location (String), item (String), quantity (int), and price (double). Some sales data might be corrupted and throw an exception when accessed. Your task is to implement two methods:

1. `filterAndSumSales(List<Sale> sales)`: This method should filter out sales that are not from the location "New York", map each sale to its total value (quantity * price), handle any exceptions that occur during processing (log the exception and skip the problematic sale), and finally sum all the sales values.
    
2. `findMostSoldItem(List<Sale> sales)`: This method should find the item that has the highest total quantity sold across all locations. It should handle any exceptions that occur during processing (log the exception and skip the problematic sale).
    

Example:

Input:

sales = [

  {location: "New York", item: "Apple", quantity: 10, price: 1.0},

  {location: "New York", item: "Banana", quantity: 5, price: 0.5},

  {location: "Los Angeles", item: "Apple", quantity: 20, price: 1.0},

  {location: "New York", item: "Corrupted Data", quantity: 0, price: 0.0} // throws exception when accessed

]

Output:

filterAndSumSales(sales) -> 10.5

findMostSoldItem(sales) -> "Apple"

Note: The methods should be implemented using Java Stream API and should handle exceptions gracefully. The pipeline for each method should include at least 4 operations.

Task 2

Main Topic: Error Handling Strategies in Stream Operations Drawn Topic: Stream Collectors

Problem: You are given a list of sales data from multiple locations. Each sale is represented as an object with properties: location (String), item (String), quantity (int), and price (double). Some sales data might be corrupted and throw an exception when accessed. Your task is to implement two methods:

1. `groupByItemAndSumQuantity(List<Sale> sales)`: This method should group sales by item, sum the quantity for each item, handle any exceptions that occur during processing (log the exception and skip the problematic sale), and return a map where the key is the item and the value is the total quantity.
    
2. `groupByLocationAndCalculateAveragePrice(List<Sale> sales)`: This method should group sales by location, calculate the average price for each location, handle any exceptions that occur during processing (log the exception and skip the problematic sale), and return a map where the key is the location and the value is the average price.
    

Example:

Input:

sales = [

  {location: "New York", item: "Apple", quantity: 10, price: 1.0},

  {location: "New York", item: "Banana", quantity: 5, price: 0.5},

  {location: "Los Angeles", item: "Apple", quantity: 20, price: 1.0},

  {location: "New York", item: "Corrupted Data", quantity: 0, price: 0.0} // throws exception when accessed

]

Output:

groupByItemAndSumQuantity(sales) -> {"Apple": 30, "Banana": 5}

groupByLocationAndCalculateAveragePrice(sales) -> {"New York": 0.75, "Los Angeles": 1.0}

Task 3

Main Topic: Error Handling Strategies in Stream Operations Drawn Topic: Stream Performance

Problem: You are given a list of sales data from multiple locations. Each sale is represented as an object with properties: location (String), item (String), quantity (int), and price (double). Some sales data might be corrupted and throw an exception when accessed. Your task is to implement two methods:

1. `findMostExpensiveItem(List<Sale> sales)`: This method should find the item with the highest price across all locations. It should handle any exceptions that occur during processing (log the exception and skip the problematic sale). The method should be optimized for performance.
    
2. `findLeastSoldItem(List<Sale> sales)`: This method should find the item that has the lowest total quantity sold across all locations. It should handle any exceptions that occur during processing (log the exception and skip the problematic sale). The method should be optimized for performance.
    

Example:

Input:

sales = [

  {location: "New York", item: "Apple", quantity: 10, price: 1.0},

  {location: "New York", item: "Banana", quantity: 5, price: 0.5},

  {location: "Los Angeles", item: "Apple", quantity: 20, price: 1.0},

  {location: "New York", item: "Corrupted Data", quantity: 0, price: 0.0} // throws exception when accessed

]

Output:

findMostExpensiveItem(sales) -> "Apple"

findLeastSoldItem(sales) -> "Banana"

Task 4

Main Topic: Error Handling Strategies in Stream Operations Drawn Topic: Stream API with Data Structures

Problem: You are given a list of sales data from multiple locations. Each sale is represented as an object with properties: location (String), item (String), quantity (int), and price (double). Some sales data might be corrupted and throw an exception when accessed. Your task is to implement three methods:

1. `findItemsSoldInMostLocations(List<Sale> sales)`: This method should find the items that are sold in the most number of locations. It should handle any exceptions that occur during processing (log the exception and skip the problematic sale), and return a set of items.
    
2. `findLocationsWithMostItems(List<Sale> sales)`: This method should find the locations that sell the most number of unique items. It should handle any exceptions that occur during processing (log the exception and skip the problematic sale), and return a set of locations.
    
3. `findItemWithHighestPricePerLocation(List<Sale> sales)`: This method should find the item with the highest price in each location. It should handle any exceptions that occur during processing (log the exception and skip the problematic sale), and return a map where the key is the location and the value is the item.
    

Example:

Input:

sales = [

  {location: "New York", item: "Apple", quantity: 10, price: 1.0},

  {location: "New York", item: "Banana", quantity: 5, price: 0.5},

  {location: "Los Angeles", item: "Apple", quantity: 20, price: 1.0},

  {location: "New York", item: "Corrupted Data", quantity: 0, price: 0.0} // throws exception when accessed

]

Output:

findItemsSoldInMostLocations(sales) -> {"Apple"}

findLocationsWithMostItems(sales) -> {"New York"}

findItemWithHighestPricePerLocation(sales) -> {"New York": "Apple", "Los Angeles": "Apple"}