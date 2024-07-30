You are a senior developer at a software company that develops plugins for various applications. Your task is to create a system that can handle different types of plugins which may introduce new data types.

**Task 1: Wildcard Types**

Create a class `Plugin` with two properties: `name` of type `String` and `data` of type `Object`. Implement a method `getData()` that returns the data as a wildcard type.

**Task 2: Wildcard Types + Generics in Collections**

Create a class `PluginManager` that manages a collection of `Plugin` objects. Implement a method `getAllData()` that returns a collection of all data from the plugins using wildcard types.

**Task 3: Wildcard Types + Generic Interfaces and Classes**

Create a generic interface `PluginProcessor<T>` with a method `process(T plugin)`. Implement this interface in a class `PluginProcessorImpl` that processes plugins and returns the processed data as a wildcard type.

**Task 4: Wildcard Types + Generics in Collections + Generic Interfaces and Classes**

Modify the `PluginManager` class to use the `PluginProcessor` interface to process plugins. Implement a method `processAllPlugins()` that processes all plugins and returns a collection of the processed data using wildcard types.


# Pseudocode

## Task 1: Wildcard Types

1. Create a class `Plugin` with two properties: `name` of type `String` and `data` of type `Object`.
2. Implement a method `getData()` that returns the data as a wildcard type.

## Task 2: Wildcard Types + Generics in Collections

1. Create a class `PluginManager` that manages a collection of `Plugin` objects.
2. Implement a method `getAllData()` that returns a collection of all data from the plugins using wildcard types.

## Task 3: Wildcard Types + Generic Interfaces and Classes

1. Create a generic interface `PluginProcessor<T>` with a method `process(T plugin)`.
2. Implement this interface in a class `PluginProcessorImpl` that processes plugins and returns the processed data as a wildcard type.

## Task 4: Wildcard Types + Generics in Collections + Generic Interfaces and Classes

1. Modify the `PluginManager` class to use the `PluginProcessor` interface to process plugins.
2. Implement a method `processAllPlugins()` that processes all plugins and returns a collection of the processed data using wildcard types.