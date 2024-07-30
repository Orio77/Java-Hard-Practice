Topic: Testing Generics

**Problem: Generic Data Structures Testing**

You are contributing to an open-source library that provides generic data structures for the Java community. Your task is to implement a comprehensive testing strategy that covers all aspects of the library's generic classes and methods.

The library includes two main generic classes: `GenericList<T>` and `GenericMap<K, V>`.

`GenericList<T>` has the following methods:

- `void add(T item)`: Adds an item to the list.
- `T get(int index)`: Returns the item at the specified index.
- `int size()`: Returns the size of the list.

`GenericMap<K, V>` has the following methods:

- `void put(K key, V value)`: Adds a key-value pair to the map.
- `V get(K key)`: Returns the value associated with the specified key.
- `int size()`: Returns the size of the map.

Your task is to implement the following functionalities:

1. **Type Safety Tests**: Write tests to ensure that the generic classes maintain type safety. For example, if a `GenericList<String>` is created, it should only accept `String` objects.
    
2. **Boundary Condition Tests**: Write tests to check the behavior of the `get` methods in both classes when they are called with indices or keys that do not exist in the data structures.

**Topic: Generics and Type Erasure**

**Problem: Understanding and Testing Type Erasure in Generic Data Structures**

Building upon your previous task of implementing a comprehensive testing strategy for the generic data structures `GenericList<T>` and `GenericMap<K, V>`, your new task is to delve deeper into the concept of Type Erasure in Java Generics and how it affects these data structures.

Type Erasure is a concept in Java where the compiler removes all information related to type parameters and type arguments within a class or method to ensure that no new classes are created for parameterized types. Consequently, it can lead to potential issues when working with generics.

Your task is to implement the following functionalities:

1. **Understanding Type Erasure**: Write a brief explanation of what Type Erasure is and how it works in Java. Include an example demonstrating Type Erasure with the `GenericList<T>` and `GenericMap<K, V>` classes.
    
2. **Type Erasure Tests**: Write tests to demonstrate the effects of Type Erasure on the `GenericList<T>` and `GenericMap<K, V>` classes. For instance, show what happens when you try to get the class of a generic parameter.
    
3. **Type Safety Tests**: Continue from your previous task and write tests to ensure that the generic classes maintain type safety. For example, if a `GenericList<String>` is created, it should only accept `String` objects.
    
4. **Boundary Condition Tests**: Write tests to check the behavior of the `get` methods in both classes when they are called with indices or keys that do not exist in the data structures.
    
5. **Handling Type Erasure**: Propose and implement a strategy to handle potential issues caused by Type Erasure in the `GenericList<T>` and `GenericMap<K, V>` classes. This could involve using methods like `instanceof`, or using super or extends wildcards.

**Topic: Generics in Collections**

**Problem: Integrating and Testing Generics in Collections**

Building upon your previous tasks of implementing a comprehensive testing strategy for the generic data structures `GenericList<T>` and `GenericMap<K, V>`, and understanding and testing Type Erasure in Java Generics, your new task is to delve deeper into the concept of Generics in Collections in Java and how it affects these data structures.

Java Collections Framework provides many interfaces (Set, List, Queue, Deque) and classes (ArrayList, LinkedList, PriorityQueue, HashSet, LinkedHashSet, TreeSet). These interfaces and classes use Generics to allow operations on objects of various types.

Your task is to implement the following functionalities:

1. **Understanding Generics in Collections**: Write a brief explanation of what Generics in Collections is and how it works in Java. Include an example demonstrating Generics in Collections with the `GenericList<T>` and `GenericMap<K, V>` classes.
    
2. **Generics in Collections Tests**: Write tests to demonstrate the use of Generics in Collections with the `GenericList<T>` and `GenericMap<K, V>` classes. For instance, show what happens when you try to use a `GenericList<T>` as a parameter in a Java Collection class like `ArrayList<T>`.
    
3. **Type Safety Tests**: Continue from your previous tasks and write tests to ensure that the generic classes and their usage in Collections maintain type safety. For example, if a `GenericList<String>` is used within an `ArrayList<GenericList<String>>`, it should only accept `GenericList<String>` objects.
    
4. **Boundary Condition Tests**: Write tests to check the behavior of the `get` methods in both classes when they are used within Collections and are called with indices or keys that do not exist in the data structures.
    
5. **Handling Type Erasure in Collections**: Propose and implement a strategy to handle potential issues caused by Type Erasure in the `GenericList<T>` and `GenericMap<K, V>` classes when they are used within Collections. This could involve using methods like `instanceof`, or using super or extends wildcards.
    
6. **Performance Considerations**: Analyze and document the performance implications of using Generics in Collections with `GenericList<T>` and `GenericMap<K, V>`. Propose optimizations if necessary.








### List of concepts:
[Understanding Generics, Parameterized Types, Wildcard Types, Type Erasure, Generic Methods, Bounded Type Parameters, Generics Best Practises, Generics in Collections, Type Casting and Type Checking, Generic Interfaces and Classes, Generics in Streams, Handling Generics Errors, Generics in Design Patterns, Performance Considerations, Testing Generics, Documentation]