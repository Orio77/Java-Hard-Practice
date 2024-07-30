Task 1

You are given a list of `Property` objects, each having `price`, `sales`, and `demographics` as attributes. Implement the following methods:

1. `findTopSellingNeighborhoods(List<Property> properties, int n)`: This method should return a list of top `n` neighborhoods with the highest number of properties sold. Use Stream API to filter out properties that were not sold, map to their neighborhoods, and then collect them into a map where keys are neighborhoods and values are counts of sold properties. Finally, sort the map entries by their values in descending order and collect the top `n` neighborhoods.
    
2. `calculateAveragePricePerNeighborhood(List<Property> properties)`: This method should return a map where keys are neighborhoods and values are the average property prices in those neighborhoods. Use Stream API to map each property to a pair of its neighborhood and price, then collect them into a map where keys are neighborhoods and values are the averages of property prices.
    

Example:

Input:

List<Property> properties = Arrays.asList(

    new Property("Neighborhood1", 100000, true, "Demographics1"),

    new Property("Neighborhood1", 200000, true, "Demographics2"),

    new Property("Neighborhood2", 150000, false, "Demographics3"),

    new Property("Neighborhood2", 250000, true, "Demographics4"),

    new Property("Neighborhood3", 300000, true, "Demographics5")

);

Output:

findTopSellingNeighborhoods(properties, 2) returns ["Neighborhood1", "Neighborhood3"]

calculateAveragePricePerNeighborhood(properties) returns {"Neighborhood1": 150000, "Neighborhood2": 200000, "Neighborhood3": 300000}

Note: The `Property` class is defined as follows:

public class Property {

    String neighborhood;

    int price;

    boolean isSold;

    String demographics;

    // constructor, getters and setters

}

Task 2

Topic: Stream Collectors

You are given a list of `Property` objects, each having `price`, `sales`, and `demographics` as attributes. Implement the following methods:

1. `groupByPriceRange(List<Property> properties)`: This method should return a map where keys are price ranges and values are lists of properties in those price ranges. Use Stream API to collect properties into a map where keys are price ranges (for example, "100k-200k", "200k-300k", etc.) and values are lists of properties. Use a custom collector to achieve this.
    
2. `calculateMedianPricePerNeighborhood(List<Property> properties)`: This method should return a map where keys are neighborhoods and values are the median property prices in those neighborhoods. Use Stream API to map each property to a pair of its neighborhood and price, then collect them into a map where keys are neighborhoods and values are the medians of property prices. Use a custom collector to calculate the median.
    

Example:

Input:

List<Property> properties = Arrays.asList(

    new Property("Neighborhood1", 100000, true, "Demographics1"),

    new Property("Neighborhood1", 200000, true, "Demographics2"),

    new Property("Neighborhood2", 150000, false, "Demographics3"),

    new Property("Neighborhood2", 250000, true, "Demographics4"),

    new Property("Neighborhood3", 300000, true, "Demographics5")

);

Output:

groupByPriceRange(properties) returns {"100k-200k": [Property1, Property3], "200k-300k": [Property2, Property4], "300k-400k": [Property5]}

calculateMedianPricePerNeighborhood(properties) returns {"Neighborhood1": 150000, "Neighborhood2": 200000, "Neighborhood3": 300000}

Task 3

Topic: Parallel Stream

You are given a list of `Property` objects, each having `price`, `sales`, and `demographics` as attributes. Implement the following methods:

1. `findMostExpensiveProperties(List<Property> properties, int n)`: This method should return a list of top `n` most expensive properties. Use parallel Stream API to sort the properties by their prices in descending order and collect the top `n` properties.
    
2. `calculateTotalSalesPerNeighborhood(List<Property> properties)`: This method should return a map where keys are neighborhoods and values are the total sales in those neighborhoods. Use parallel Stream API to filter out properties that were not sold, map each sold property to a pair of its neighborhood and price, then collect them into a map where keys are neighborhoods and values are the sums of property prices.
    

Example:

Input:

List<Property> properties = Arrays.asList(

    new Property("Neighborhood1", 100000, true, "Demographics1"),

    new Property("Neighborhood1", 200000, true, "Demographics2"),

    new Property("Neighborhood2", 150000, false, "Demographics3"),

    new Property("Neighborhood2", 250000, true, "Demographics4"),

    new Property("Neighborhood3", 300000, true, "Demographics5")

);

Output:

findMostExpensiveProperties(properties, 2) returns [Property5, Property4]

calculateTotalSalesPerNeighborhood(properties) returns {"Neighborhood1": 300000, "Neighborhood2": 250000, "Neighborhood3": 300000}

Task 4

Topic: Error Handling Strategies

You are given a list of `Property` objects, each having `price`, `sales`, and `demographics` as attributes. Implement the following methods:

1. `findPropertiesWithInvalidPrice(List<Property> properties)`: This method should return a list of properties with invalid prices (for example, negative prices). Use Stream API to filter out properties with invalid prices and collect them into a list. Handle any exceptions that may occur during the process.
    
2. `calculateAveragePricePerNeighborhoodWithExceptionHandling(List<Property> properties)`: This method should return a map where keys are neighborhoods and values are the average property prices in those neighborhoods. Use Stream API to map each property to a pair of its neighborhood and price, then collect them into a map where keys are neighborhoods and values are the averages of property prices. Handle any exceptions that may occur during the process.
    
3. `findMostExpensivePropertiesWithExceptionHandling(List<Property> properties, int n)`: This method should return a list of top `n` most expensive properties. Use Stream API to sort the properties by their prices in descending order and collect the top `n` properties. Handle any exceptions that may occur during the process.
    

Example:

Input:

List<Property> properties = Arrays.asList(

    new Property("Neighborhood1", 100000, true, "Demographics1"),

    new Property("Neighborhood1", -200000, true, "Demographics2"),

    new Property("Neighborhood2", 150000, false, "Demographics3"),

    new Property("Neighborhood2", 250000, true, "Demographics4"),

    new Property("Neighborhood3", 300000, true, "Demographics5")

);

Output:

findPropertiesWithInvalidPrice(properties) returns [Property2]

calculateAveragePricePerNeighborhoodWithExceptionHandling(properties) returns {"Neighborhood1": 100000, "Neighborhood2": 200000, "Neighborhood3": 300000}

findMostExpensivePropertiesWithExceptionHandling(properties, 2) returns [Property5, Property4]