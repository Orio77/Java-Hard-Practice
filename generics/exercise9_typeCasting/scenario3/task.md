## Problem Statement

You are part of a team developing a chatbot for a customer support platform. Your tasks involve implementing Java Generics, focusing on "Type Casting and Type Checking", "Generics in Collections", and "Generic Interfaces and Classes".

### Task 1: Type Casting and Type Checking

Create a class `QueryHandler` with a method `handleQuery`. This method should accept a user query and return an appropriate response. The query can be of different types (e.g., `BillingQuery`, `TechnicalQuery`, `GeneralQuery`), and each type should be handled differently.

### Task 2: Type Casting and Type Checking + Generics in Collections

Extend your `QueryHandler` class to handle a list of queries. Create a method `handleQueries` that accepts a list of queries and returns a list of responses. Ensure that the list can handle different types of queries.

### Task 3: Type Casting and Type Checking + Generic Interfaces and Classes

Create a generic interface `SupportAgent<T>` where `T` is a type of query. This interface should have a method `handleQuery` that accepts a query of type `T` and returns a response. Implement this interface in different classes (e.g., `BillingAgent`, `TechnicalAgent`, `GeneralAgent`) to handle different types of queries.

### Task 4: Merging All Concepts

Extend your `QueryHandler` class to use instances of `SupportAgent` to handle queries. The `handleQuery` and `handleQueries` methods should delegate the handling of queries to the appropriate `SupportAgent` based on the type of the query.

Remember, each task should be implemented in a way that it can be tested independently. Avoid using getter and setter methods for these tasks. Instead, focus on the functionalities described above.


# Documentation

## Classes and Interfaces to Create

1. `Query`
2. `Response`
3. `BillingQuery extends Query`
4. `TechnicalQuery extends Query`
5. `GeneralQuery extends Query`
6. `QueryHandler`
7. `SupportAgent<T extends Query>`

## Class and Interface Methods to Implement

### Class: `Query`

This class does not need any methods, but it should be extended by `BillingQuery`, `TechnicalQuery`, and `GeneralQuery`.

### Class: `Response`

This class represents the response to a query. It can have properties such as `message` and `status`.

### Classes: `BillingQuery`, `TechnicalQuery`, `GeneralQuery`

These classes should extend `Query`. They do not need any methods, but they may need properties depending on how you want to handle different types of queries.

### Class: `QueryHandler`

1. `handleQuery(Query query)`: This method should accept a query of any type and return an appropriate response. The handling of different types of queries should be done using type checking and type casting.
    
2. `handleQueries(List<Query> queries)`: This method should accept a list of queries of any type and return a list of responses. The handling of different types of queries should be done using type checking and type casting.
    
3. `setAgent(SupportAgent agent)`: This method should accept a `SupportAgent` and set it as the agent to handle queries.
    
4. `handleQueryWithAgent(Query query)`: This method should delegate the handling of a query to the appropriate `SupportAgent` based on the type of the query.
    
5. `handleQueriesWithAgent(List<Query> queries)`: This method should delegate the handling of a list of queries to the appropriate `SupportAgent` based on the type of the queries.
    

### Interface: `SupportAgent<T extends Query>`

1. `handleQuery(T query)`: This method should accept a query of type `T` and return a response.

## General Overview

The `Query` class is a superclass for `BillingQuery`, `TechnicalQuery`, and `GeneralQuery`. These subclasses do not need any methods, but they may need properties depending on how you want to handle different types of queries.

The `QueryHandler` class has methods to handle individual queries and lists of queries. It uses type checking and type casting to handle different types of queries. It can also delegate the handling of queries to `SupportAgent` instances.

The `SupportAgent` interface is a generic interface that operates on objects of type `T`, where `T` extends `Query`. It has a method to handle a query of type `T`.

## Example Workflow

1. Create `Query` objects (i.e., `BillingQuery`, `TechnicalQuery`, `GeneralQuery`).
    
2. Create a `QueryHandler` object.
    
3. Use the `handleQuery` method to handle an individual query.
    
4. Use the `handleQueries` method to handle a list of queries.
    
5. Create `SupportAgent` objects.
    
6. Use the `setAgent` method to set a `SupportAgent` to handle queries.
    
7. Use the `handleQueryWithAgent` method to delegate the handling of an individual query to a `SupportAgent`.
    
8. Use the `handleQueriesWithAgent` method to delegate the handling of a list of queries to a `SupportAgent`.