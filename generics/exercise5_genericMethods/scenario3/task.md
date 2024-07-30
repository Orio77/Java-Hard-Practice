**Problem: Generic Data Processor**

You are a senior developer in a company that processes large amounts of data. Your task is to create a generic data processing system that can handle different types of data (e.g., integers, strings, custom objects) and perform various operations on them.

**Task 1: Generic Methods**

Create a class `DataProcessor` with a generic method `processData`. This method should accept a list of data and a `Function` that defines how to process each element. The method should return a list of processed data.

**Task 2: Generic Methods + Generics in Collections**

Extend your `DataProcessor` class with a method `filterData`. This method should accept a list of data and a `Predicate` that defines which elements to keep. The method should return a filtered list.

**Task 3: Generic Methods + Bounded Type Parameters**

Create a class `ComparableDataProcessor` that extends `DataProcessor`. This class should only work with data that implements `Comparable`. Add a method `sortData` that accepts a list of data and returns a sorted list.

**Task 4: All Concepts Combined**

In the `ComparableDataProcessor` class, add a method `processAndSortData`. This method should accept a list of data, a `Function` for processing, and a `Comparator` for sorting. The method should process the data, sort it, and then return the result.


# Pseudocode

## Class: `DataProcessor<T>`

1. Method: `processData(List<T> data, Function<T, R> function) -> List<R>`
    
    1. Create an empty list `processedData` for storing the processed data.
    2. For each element `e` in `data`, apply `function` to `e` and add the result to `processedData`.
    3. Return `processedData`.
2. Method: `filterData(List<T> data, Predicate<T> predicate) -> List<T>`
    
    1. Create an empty list `filteredData` for storing the filtered data.
    2. For each element `e` in `data`, if `predicate` applied to `e` is true, add `e` to `filteredData`.
    3. Return `filteredData`.

## Class: `ComparableDataProcessor<T extends Comparable<T>> extends DataProcessor<T>`

1. Method: `sortData(List<T> data) -> List<T>`
    
    1. Create a copy `sortedData` of `data`.
    2. Sort `sortedData`.
    3. Return `sortedData`.
2. Method: `processAndSortData(List<T> data, Function<T, R> function, Comparator<R> comparator) -> List<R>`
    
    1. Process `data` using `function` by calling `processData(data, function)`. Store the result in `processedData`.
    2. Sort `processedData` using `comparator`.
    3. Return `processedData`.