Task 1

Problem: Given a list of UserClick objects, each representing a user's click on the e-commerce platform, implement two methods:

1. `findTopClickedProduct(List<UserClick> clicks)`: This method should return the Product object that has been clicked the most by the users. In case of a tie, return any one of the top clicked products. Use a custom collector to group the clicks by product and count them.
    
2. `findMostActiveUser(List<UserClick> clicks)`: This method should return the User object who has clicked the most on the platform. In case of a tie, return any one of the most active users. Use a custom collector to group the clicks by user and count them.
    

Example:

Input:

List<UserClick> clicks = Arrays.asList(

    new UserClick(user1, product1),

    new UserClick(user1, product2),

    new UserClick(user2, product1),

    new UserClick(user2, product1),

    new UserClick(user3, product3)

);

Output:

findTopClickedProduct(clicks) returns product1

findMostActiveUser(clicks) returns user1 or user2

Task 2

Topic: Stream Performance

Problem: Given the same list of UserClick objects, implement two methods:

1. `findTopClickedProductParallel(List<UserClick> clicks)`: Similar to the first task, but this time, use parallel streams to improve performance.
    
2. `findMostActiveUserParallel(List<UserClick> clicks)`: Similar to the first task, but use parallel streams to improve performance.
    

Task 3

Topic: Stream API with Data Structures

Problem: Given a Map where keys are User objects and values are Lists of Product objects representing the products clicked by the user, implement two methods:

1. `findTopClickedProductFromMap(Map<User, List<Product>> userClicks)`: This method should return the Product object that has been clicked the most by the users. Use a custom collector to group the clicks by product and count them.
    
2. `findMostActiveUserFromMap(Map<User, List<Product>> userClicks)`: This method should return the User object who has clicked the most on the platform. Use a custom collector to group the clicks by user and count them.
    

Task 4

Topic: Error Handling Strategies

Problem: Given the same list of UserClick objects, implement three methods:

1. `findTopClickedProductSafe(List<UserClick> clicks)`: Similar to the first task, but this time, handle the possibility that the list of clicks might be null or contain null elements.
    
2. `findMostActiveUserSafe(List<UserClick> clicks)`: Similar to the first task, but handle the possibility that the list of clicks might be null or contain null elements.
    
3. `validateClicks(List<UserClick> clicks)`: This method should return a boolean indicating whether the list of clicks is valid (i.e., it is not null and does not contain null elements).