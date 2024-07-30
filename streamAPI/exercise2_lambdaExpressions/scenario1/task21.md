### Problem Set: Lambda Expressions in Java

#### Problem 1: Implementing a Simple Lambda

- **Problem Description:** Create a lambda expression that adds two integers and use it in a method.
- **Focus:** Understanding the basic syntax and usage of lambda expressions.
- **Method Description:**
    - `performAddition(int a, int b, BiFunction<Integer, Integer, Integer> adder)`: Uses the `adder` lambda to add `a` and `b`.

#### Problem 2: Sorting with a Lambda Comparator

- **Problem Description:** Write a method that sorts a list of `String` objects by their length using a lambda expression.
- **Focus:** Lambda expressions in sorting with custom comparator logic.
- **Method Description:**
    - `sortStringsByLength(List<String> strings)`: Sorts `strings` by their length using a lambda expression as a comparator.

#### Problem 3: Processing List Items with `forEach` and Lambda

- **Problem Description:** Implement a method that prints each element of a `List<String>` using a lambda expression with `forEach`.
- **Focus:** Using lambda expressions with `forEach` for list processing.
- **Method Description:**
    - `printListItems(List<String> items)`: Prints each item in `items` using a lambda expression in `forEach`.

#### Problem 4: Using Lambdas with Functional Interfaces

- **Problem Description:** Create a functional interface `StringOperation` with a method `operate`. Implement this method using a lambda expression that converts a string to uppercase.
- **Focus:** Custom functional interfaces and lambda expressions.
- **Method Description:**
    - `applyStringOperation(String str, StringOperation operation)`: Applies the `operation` lambda to the string `str`.

#### Problem 5: Lambda Expression for Thread Execution

- **Problem Description:** Use a lambda expression to create and start a new thread that prints a message.
- **Focus:** Lambda expressions in concurrent programming.
- **Method Description:**
    - `startNewThread()`: Starts a new thread that prints a message using a lambda expression.

#### Problem 6: Filtering with Lambda Expressions

- **Problem Description:** Write a method that filters a list of integers, keeping only those which are even, using a lambda expression.
- **Focus:** Filtering collections using lambda expressions.
- **Method Description:**
    - `filterEvenNumbers(List<Integer> numbers)`: Filters `numbers`, keeping only the even ones using a lambda expression.

#### Problem 7: Mapping with Lambdas

- **Problem Description:** Implement a method that transforms a list of integers to their square values using a lambda expression with `map`.
- **Focus:** Transforming collections using `map` and lambda expressions.
- **Method Description:**
    - `squareNumbers(List<Integer> numbers)`: Transforms `numbers` into their squares using a lambda expression in `map`.

#### Problem 8: Lambda Expressions with Stream API

- **Problem Description:** Use a lambda expression in combination with Java Streams to find the maximum value in a list of integers.
- **Focus:** Integrating lambda expressions with Java Streams.
- **Method Description:**
    - `findMaxValue(List<Integer> numbers)`: Finds the maximum value in `numbers` using a lambda expression with Streams.