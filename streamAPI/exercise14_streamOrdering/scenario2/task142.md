Task 1

Problem: You are given a list of properties, each having a price and a neighborhood. Implement two methods:

1. `findAveragePriceByNeighborhood(List<Property> properties)`: This method should return a Map where the key is the neighborhood and the value is the average price of properties in that neighborhood. The map should be sorted in descending order by the average price.
    
2. `findTopThreeExpensiveNeighborhoods(List<Property> properties)`: This method should return a list of the top three neighborhoods with the highest average property price.
    

Example:

Input:

[

  { "neighborhood": "A", "price": 100 },

  { "neighborhood": "A", "price": 200 },

  { "neighborhood": "B", "price": 150 },

  { "neighborhood": "B", "price": 250 },

  { "neighborhood": "C", "price": 300 }

]

Output for `findAveragePriceByNeighborhood`:

{

  "C": 300,

  "B": 200,

  "A": 150

}

Output for `findTopThreeExpensiveNeighborhoods`:

["C", "B", "A"]

Task 2

Main Topic: Stream Ordering Drawn Topic: Stream Performance

Problem: Implement two methods:

1. `findMostCommonNeighborhood(List<Property> properties)`: This method should return the neighborhood that appears most frequently in the list. If there are multiple neighborhoods with the same highest frequency, return the one that comes first when sorted alphabetically.
    
2. `findLeastCommonNeighborhood(List<Property> properties)`: This method should return the neighborhood that appears least frequently in the list. If there are multiple neighborhoods with the same lowest frequency, return the one that comes first when sorted alphabetically.
    

Both methods should be optimized for performance.

Example:

Input:

[

  { "neighborhood": "A" },

  { "neighborhood": "B" },

  { "neighborhood": "A" },

  { "neighborhood": "C" },

  { "neighborhood": "B" },

  { "neighborhood": "A" }

]

Output for `findMostCommonNeighborhood`:

"A"

Output for `findLeastCommonNeighborhood`:

"C"

Task 3

Main Topic: Stream Ordering Drawn Topic: Optional

Problem: Implement two methods:

1. `findFirstPropertyOverPrice(List<Property> properties, int price)`: This method should return an Optional of the first property that has a price over the given price. The properties should be considered in the order they appear in the list.
    
2. `findLastPropertyUnderPrice(List<Property> properties, int price)`: This method should return an Optional of the last property that has a price under the given price. The properties should be considered in the order they appear in the list.
    

Example:

Input:

[

  { "price": 100 },

  { "price": 200 },

  { "price": 150 },

  { "price": 250 },

  { "price": 300 }

]

Output for `findFirstPropertyOverPrice(properties, 200)`:

Optional[{ "price": 250 }]

Output for `findLastPropertyUnderPrice(properties, 200)`:

Optional[{ "price": 150 }]

Task 4

Main Topic: Stream Ordering Drawn Topic: Stream API with Data Structures

Problem: Implement three methods:

1. `sortByPriceThenNeighborhood(List<Property> properties)`: This method should return a list of properties sorted by price in ascending order, and then by neighborhood in alphabetical order.
    
2. `groupByNeighborhoodThenSortByPrice(List<Property> properties)`: This method should return a Map where the key is the neighborhood and the value is a list of properties in that neighborhood, sorted by price in ascending order.
    
3. `findCheapestPropertyInEachNeighborhood(List<Property> properties)`: This method should return a Map where the key is the neighborhood and the value is the property with the lowest price in that neighborhood.
    

Example:

Input:

[

  { "neighborhood": "A", "price": 200 },

  { "neighborhood": "B", "price": 150 },

  { "neighborhood": "A", "price": 100 },

  { "neighborhood": "B", "price": 250 },

  { "neighborhood": "C", "price": 300 }

]

Output for `sortByPriceThenNeighborhood`:

[

  { "neighborhood": "A", "price": 100 },

  { "neighborhood": "B", "price": 150 },

  { "neighborhood": "A", "price": 200 },

  { "neighborhood": "B", "price": 250 },

  { "neighborhood": "C", "price": 300 }

]

Output for `groupByNeighborhoodThenSortByPrice`:

{

  "A": [

    { "neighborhood": "A", "price": 100 },

    { "neighborhood": "A", "price": 200 }

  ],

  "B": [

    { "neighborhood": "B", "price": 150 },

    { "neighborhood": "B", "price": 250 }

  ],

  "C": [

    { "neighborhood": "C", "price": 300 }

  ]

}

Output for `findCheapestPropertyInEachNeighborhood`:

{

  "A": { "neighborhood": "A", "price": 100 },

  "B": { "neighborhood": "B", "price": 150 },

  "C": { "neighborhood": "C", "price": 300 }

}