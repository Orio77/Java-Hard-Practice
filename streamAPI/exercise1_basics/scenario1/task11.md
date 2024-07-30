### Problem Set: Basics of Java 8 Streams

#### Problem 1: Filtering a List of Strings

- **Problem Description:** Create a method that takes a list of strings and returns a list containing only the strings that start with a certain letter, using Java 8 Streams.
- **Focus:** Understanding `stream()`, `filter()`, and `collect()`.
- **Method Description:**
    - `filterStrings(List<String> strings, char startChar)`: Filters the list `strings`, returning only those that start with `startChar`.

#### Problem 2: Transforming List Items

- **Problem Description:** Write a method that converts all strings in a list to uppercase using Java 8 Streams.
- **Focus:** Mastering `map()` operation in Streams.
- **Method Description:**
    - `toUpperCaseList(List<String> strings)`: Transforms each string in `strings` to uppercase.

#### Problem 3: Summing Numbers in a List

- **Problem Description:** Implement a method to calculate the sum of a list of integers using Java 8 Streams.
- **Focus:** Using `reduce()` operation in Streams.
- **Method Description:**
    - `sumNumbers(List<Integer> numbers)`: Calculates the sum of the integers in `numbers`.

#### Problem 4: Sorting a List of Custom Objects

- **Problem Description:** Develop a method to sort a list of custom objects (e.g., `Person` objects) by a specific property (e.g., age) using Java 8 Streams.
- **Focus:** Utilizing `sorted()` in Streams.
- **Method Description:**
    - `sortPersonsByAge(List<Person> persons)`: Sorts the list `persons` by the age property.

#### Problem 5: Finding the First Element

- **Problem Description:** Create a method to find the first string in a list that meets a specific condition (e.g., length greater than 3) using Java 8 Streams.
- **Focus:** Understanding `findFirst()` in Streams.
- **Method Description:**
    - `findFirstLongString(List<String> strings)`: Finds the first string in `strings` that has a length greater than 3.

#### Problem 6: Processing Data with `forEach`

- **Problem Description:** Write a method that processes elements of a list (e.g., prints each string) using Java 8 Streams.
- **Focus:** Learning to use `forEach()` in Streams.
- **Method Description:**
    - `printStrings(List<String> strings)`: Prints each string in the list `strings`.

#### Problem 7: Grouping Elements

- **Problem Description:** Implement a method to group a list of strings by their first character using Java 8 Streams.
- **Focus:** Applying `Collectors.groupingBy()` in Streams.
- **Method Description:**
    - `groupByFirstChar(List<String> strings)`: Groups the strings in `strings` by their first character.

#### Problem 8: Combining Streams

- **Problem Description:** Create a method to merge two lists of integers into one sorted list using Java 8 Streams.
- **Focus:** Combining and sorting Streams with `Stream.concat()` and `sorted()`.
- **Method Description:**
    - `mergeAndSortLists(List<Integer> list1, List<Integer> list2)`: Merges `list1` and `list2` into a single sorted list.