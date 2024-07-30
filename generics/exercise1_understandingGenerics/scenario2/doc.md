# Documentation for the Shopping Cart Exercise

## Classes to Create

1. `ShoppingCart<T>`: This class will represent a generic shopping cart with a type parameter `T` to hold various product types.
    
2. `ProductProcessor<T extends Product>`: This class will use bounded type parameters to work only with subclasses of `Product`.
    

## Class Methods

### ShoppingCart

1. `addToCart`: This method will add products of type `T` to the cart. It ensures flexibility by allowing for the addition of products of any type to the cart.
    
2. `removeFromCart`: This method will remove products of type `T` from the cart. It demonstrates how generics can manage different product types with type safety.
    

### ProductProcessor

1. `calculateTotal`: This method will calculate the total cost of products in the cart. It ensures it adheres to the `Product` type, demonstrating the practical use of bounded generics and reinforcing the concept of type safety in operations.

## General Overview

The `ShoppingCart<T>` class is responsible for managing a shopping cart that can hold products of any type `T`. It ensures type safety and flexibility by allowing for the addition and removal of products of any type to and from the cart.

The `ProductProcessor<T extends Product>` class is responsible for processing products that are subclasses of `Product`. It ensures type safety by restricting the generic type `T` to subclasses of `Product`.

## Example Workflow

1. A `ShoppingCart<T>` object is created. This could represent a shopping cart for any type `T` of product.
    
2. The `addToCart` method of the `ShoppingCart<T>` object is called. This adds a product of type `T` to the cart.
    
3. The `removeFromCart` method of the `ShoppingCart<T>` object is called. This removes a product of type `T` from the cart.
    
4. A `ProductProcessor<T extends Product>` object is created. This could represent a processor for any subclass of `Product`.
    
5. The `calculateTotal` method of the `ProductProcessor<T extends Product>` object is called. This calculates the total cost of the products in the cart.