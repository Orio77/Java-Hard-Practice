# Documentation for the Inventory Management System Exercise

## Classes to Create

1. `Item<T>`: This class will represent a generic item with a type parameter `T` to hold various item properties.
    
2. `ItemProcessor<T extends Property>`: This class will use bounded type parameters to work only with subclasses of `Property`.
    

## Class Methods

### Item

1. `updateItem`: This method will update properties of type `T` for the item. It ensures flexibility by allowing for the updating of properties of any type for the item.
    
2. `queryItem`: This method will retrieve properties of type `T` for the item. It demonstrates how generics can manage different property types with type safety.
    

### ItemProcessor

1. `process`: This method will process item properties, ensuring it adheres to the `Property` type. It demonstrates the practical use of bounded generics and reinforces the concept of type safety in operations.

## General Overview

The `Item<T>` class is responsible for managing an item that can hold properties of any type `T`. It ensures type safety and flexibility by allowing for the updating and retrieval of properties of any type for the item.

The `ItemProcessor<T extends Property>` class is responsible for processing properties that are subclasses of `Property`. It ensures type safety by restricting the generic type `T` to subclasses of `Property`.

## Example Workflow

1. An `Item<T>` object is created. This could represent an item with any type `T` of property.
    
2. The `updateItem` method of the `Item<T>` object is called. This updates a property of type `T` for the item.
    
3. The `queryItem` method of the `Item<T>` object is called. This retrieves a property of type `T` for the item.
    
4. An `ItemProcessor<T extends Property>` object is created. This could represent a processor for any subclass of `Property`.
    
5. The `process` method of the `ItemProcessor<T extends Property>` object is called. This processes a property that is a subclass of `Property`.