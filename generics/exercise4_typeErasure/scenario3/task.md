You are a Senior Java Developer at a software company that specializes in building high-performance web applications. Your current project involves building a generic caching framework for a high-traffic web application. The caching framework should be able to handle different types of objects, and it should be efficient and flexible.

### Task 1: Understanding Generics and Type Erasure

Create a class `Cache<K, V>` that represents a simple cache. The cache should have methods `put(K key, V value)` and `get(K key)`. However, due to type erasure, you realize that you cannot directly check the type of `V` at runtime. Find a way to handle this limitation.

### Task 2: Understanding Generics, Type Erasure, and Wildcard Types

Extend your cache to handle wildcard types. Create a method `putAll(Map<? extends K, ? extends V> entries)` that adds all entries from the given map to the cache. Remember that due to type erasure, you cannot directly check the type of `? extends V` at runtime.

### Task 3: Wildcard Types and Type Erasure

Create a method `getAll(Set<? extends K> keys)` that returns a `Map<K, V>` containing all entries in the cache that match the given keys. Again, handle the limitations of type erasure.

### Task 4: Understanding Generics, Wildcard Types, and Type Erasure

Finally, create a method `match(Predicate<? super V> predicate)` that returns a `Map<K, V>` containing all entries in the cache whose values match the given predicate. This task combines all three topics: you need to understand generics to create the method, handle wildcard types to accept a predicate of any supertype of `V`, and address the limitations of type erasure when working with the predicate.



# Documentation

## Classes to Create

1. `Cache`

## Class Methods to Implement

### Class: `Cache`

1. `put`: This method should take a key and a value. It should store the value in the cache, associated with the given key.
    
2. `get`: This method should take a key and return the associated value from the cache. If the key is not present in the cache, it should return null or an equivalent.
    
3. `putAll`: This method should take a map of entries and add all of them to the cache. The keys and values in the map could be of any type that extends the key and value types of the cache.
    
4. `getAll`: This method should take a set of keys and return a map containing all entries in the cache that match the given keys.
    
5. `match`: This method should take a predicate and return a map containing all entries in the cache whose values match the given predicate. The predicate should be applicable to any supertype of the value type of the cache.
    

## General Overview

The `Cache` class is a generic class that can store key-value pairs of any types. It uses Java Generics to allow for this flexibility. However, due to type erasure in Java, the runtime types of the keys and values are not directly accessible. This limitation is handled in the methods that accept wildcard types (`putAll`, `getAll`, `match`).

The `put` and `get` methods are straightforward: they simply add and retrieve entries from the cache. The `putAll` method is a bit more complex: it accepts a map of entries where the keys and values could be of any type that extends the key and value types of the cache. The `getAll` method is similar, but it accepts a set of keys and returns a map of matching entries. The `match` method is the most complex: it accepts a predicate that can be applied to any supertype of the value type of the cache, and it returns a map of entries whose values match the predicate.

## Example Workflow

1. Create a `Cache` object, specifying the types of the keys and values. For example, the keys could be `String` and the values could be `Integer`.
    
2. Use the `put` method to add some entries to the cache.
    
3. Use the `get` method to retrieve a value from the cache.
    
4. Use the `putAll` method to add multiple entries to the cache at once.
    
5. Use the `getAll` method to retrieve multiple entries from the cache at once.
    
6. Use the `match` method to find all entries in the cache whose values match a certain condition. For example, you could find all entries whose values are even numbers.
    
7. The output of the `match` method is a map of all matching entries.