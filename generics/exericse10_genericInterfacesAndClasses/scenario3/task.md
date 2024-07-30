# Exercise Documentation

## Classes to Create

1. `User`
2. `PremiumUser`
3. `RegularUser`
4. `RecommendationEngine<T extends User>`

## Class Methods to Implement

### `User`

This class represents a generic user. It should contain necessary information about a user such as user ID, purchase history, and browsing behavior.

### `PremiumUser` and `RegularUser`

These classes extend the `User` class. They represent specific types of users and should contain additional information specific to their type.

### `RecommendationEngine<T extends User>`

This class is responsible for generating product recommendations. It should contain the following methods:

- `generateRecommendations(T user)`: This method should generate product recommendations for any user type that extends `User`.
    
- `adaptAlgorithm(T user)`: This method should adapt the recommendation algorithm based on the user type.
    
- `testRecommendations(T user)`: This method should test the recommendation engine with various user data.
    

## General Overview

The `RecommendationEngine` class is the main class in this exercise. It uses Java Generics with bounded type parameters to ensure compatibility with specific user types and type safety. The `User` class is the base class for different users. The `PremiumUser` and `RegularUser` classes represent different types of users.

The `RecommendationEngine` class has methods to generate recommendations, adapt the recommendation algorithm, and test the recommendation engine. It uses the generic type `T` in method parameters, allowing for flexibility in handling users of different types.

## Example Workflow

1. Create a `PremiumUser` or `RegularUser` object with necessary information.
2. Create a `RecommendationEngine` object.
3. Call the `generateRecommendations` method of the `RecommendationEngine` object with the `PremiumUser` or `RegularUser` object as a parameter.
4. The `RecommendationEngine` generates product recommendations for the user.
5. Call the `adaptAlgorithm` method of the `RecommendationEngine` object with the `PremiumUser` or `RegularUser` object as a parameter.
6. The `adaptAlgorithm` method adapts the recommendation algorithm based on the user type.
7. Call the `testRecommendations` method of the `RecommendationEngine` object with the `PremiumUser` or `RegularUser` object as a parameter.
8. The `testRecommendations` method tests the recommendation engine with the user data.