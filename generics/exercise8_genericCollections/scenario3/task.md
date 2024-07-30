## Problem Statement

You are working on a project for a library management system. The system needs to handle different types of media including books, DVDs, and journals.

### Task 1: Generic Methods

Create a class `Library` with the following methods:

1. `addItem(T item)`: This is a generic method that accepts an item of any type and adds it to the library's collection.
    
2. `removeItem(T item)`: This is a generic method that accepts an item of any type and removes it from the library's collection.
    

### Task 2: Generic Methods + Generics in Collections

Extend the `Library` class to include the following methods:

1. `getItems(Class<T> type)`: This method should return a list of items in the library's collection that are of the specified type.
    
2. `sortItems()`: This method should sort the items in the library's collection. The sorting criteria is up to you.
    

### Task 3: Generic Methods + Bounded Type Parameters

Create a class `Media` and its subclasses `Book`, `DVD`, and `Journal`. Extend the `Library` class to include the following methods:

1. `addMedia(T media)`: This method should accept a media item of type `T`, where `T` is a subclass of `Media`, and add it to the library's collection.
    
2. `removeMedia(T media)`: This method should accept a media item of type `T`, where `T` is a subclass of `Media`, and remove it from the library's collection.
    

### Task 4: All Concepts Combined

Extend the `Library` class to include the following methods:

1. `getMediaItems(Class<T> type)`: This method should return a list of media items in the library's collection that are of the specified type.
    
2. `sortMediaItems()`: This method should sort the media items in the library's collection. The sorting criteria is up to you.
    

Remember to use generics where appropriate to ensure type safety and to maximize code reusability



# Documentation

## Classes to Create

1. `Library<T>`
2. `Media`
3. `Book extends Media`
4. `DVD extends Media`
5. `Journal extends Media`

## Class Methods to Implement

### Class: `Library<T>`

1. `addItem(T item)`: This method should accept an item of any type and add it to the library's collection.
    
2. `removeItem(T item)`: This method should accept an item of any type and remove it from the library's collection.
    
3. `getItems(Class<T> type)`: This method should return a list of items in the library's collection that are of the specified type.
    
4. `sortItems()`: This method should sort the items in the library's collection. The sorting criteria is up to you.
    
5. `addMedia(T media)`: This method should accept a media item of type `T`, where `T` is a subclass of `Media`, and add it to the library's collection.
    
6. `removeMedia(T media)`: This method should accept a media item of type `T`, where `T` is a subclass of `Media`, and remove it from the library's collection.
    
7. `getMediaItems(Class<T> type)`: This method should return a list of media items in the library's collection that are of the specified type.
    
8. `sortMediaItems()`: This method should sort the media items in the library's collection. The sorting criteria is up to you.
    

### Class: `Media`

This class does not need any methods, but it should be extended by `Book`, `DVD`, and `Journal`.

### Classes: `Book`, `DVD`, `Journal`

These classes should extend `Media`. They do not need any methods, but they may need properties depending on your sorting criteria for the `Library` class methods.

## General Overview

The `Library` class is a generic class that can handle different types of items, including subclasses of `Media` such as `Book`, `DVD`, and `Journal`. It has methods to add and remove items, get items of a specific type, and sort items.

The `Media` class is a superclass for `Book`, `DVD`, and `Journal`. These subclasses do not need any methods, but they may need properties depending on your sorting criteria for the `Library` class methods.

## Example Workflow

1. Create a `Library` object.
    
2. Use the `addItem` method to add items to the library's collection.
    
3. Use the `removeItem` method to remove items from the library's collection.
    
4. Use the `getItems` method to get items of a specific type from the library's collection.
    
5. Use the `sortItems` method to sort the items in the library's collection.
    
6. Create `Media` objects (i.e., `Book`, `DVD`, `Journal`).
    
7. Use the `addMedia` method to add media items to the library's collection.
    
8. Use the `removeMedia` method to remove media items from the library's collection.
    
9. Use the `getMediaItems` method to get media items of a specific type from the library's collection.
    
10. Use the `sortMediaItems` method to sort the media items in the library's collection.