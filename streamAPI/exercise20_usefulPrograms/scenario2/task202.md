Task 1

Problem: You are given a list of programmers, each with a different number of projects they have completed. Your task is to implement two methods:

1. `findTopProgrammers(List<Programmer> programmers)`: This method should return a list of top 3 programmers who have completed the most projects. If there are more than 3 programmers with the same number of projects, return any 3 of them.
    
2. `findMostCommonProjectCount(List<Programmer> programmers)`: This method should return the most common number of projects that programmers have completed.
    

Each method should use Stream API and include at least 4 operations.

Example:

Input:
```java
List<Programmer> programmers = Arrays.asList(

    new Programmer("Alice", 5),

    new Programmer("Bob", 3),

    new Programmer("Charlie", 5),

    new Programmer("Dave", 2),

    new Programmer("Eve", 5),

    new Programmer("Frank", 3)

);

Output:

findTopProgrammers(programmers) -> ["Alice", "Charlie", "Eve"]

findMostCommonProjectCount(programmers) -> 5
```
Task 2

Topic: Stream Collectors

Problem: You are given a list of programmers, each with a different number of projects they have completed and their respective programming languages. Your task is to implement two methods:

1. `groupByLanguage(List<Programmer> programmers)`: This method should return a map where the keys are programming languages and the values are lists of programmers who use that language.
    
2. `findMostPopularLanguage(List<Programmer> programmers)`: This method should return the most popular programming language among the programmers.
    

Each method should use Stream API and include at least 4 operations.

Example:
```java
Input:

List<Programmer> programmers = Arrays.asList(

    new Programmer("Alice", "Java", 5),

    new Programmer("Bob", "Python", 3),

    new Programmer("Charlie", "Java", 5),

    new Programmer("Dave", "C++", 2),

    new Programmer("Eve", "Java", 5),

    new Programmer("Frank", "Python", 3)

);

Output:

groupByLanguage(programmers) -> {"Java": ["Alice", "Charlie", "Eve"], "Python": ["Bob", "Frank"], "C++": ["Dave"]}

findMostPopularLanguage(programmers) -> "Java"
```
Note: The order of programmers in the lists and the order of keys in the map do not matter.

Task 3

Topic: Handling Null Values

Problem: You are given a list of programmers, each with a different number of projects they have completed and their respective programming languages. However, some programmers may not have a programming language specified (null). Your task is to implement two methods:

1. `filterNullLanguages(List<Programmer> programmers)`: This method should return a list of programmers who have a specified programming language (not null).
    
2. `defaultNullLanguages(List<Programmer> programmers, String defaultLanguage)`: This method should return a list of programmers where programmers with no specified language (null) are given a default language.
    

Each method should use Stream API and include at least 4 operations.

Example:
```java
Input:

List<Programmer> programmers = Arrays.asList(

    new Programmer("Alice", "Java", 5),

    new Programmer("Bob", null, 3),

    new Programmer("Charlie", "Java", 5),

    new Programmer("Dave", "C++", 2),

    new Programmer("Eve", null, 5),

    new Programmer("Frank", "Python", 3)

);

Output:

filterNullLanguages(programmers) -> ["Alice", "Charlie", "Dave", "Frank"]

defaultNullLanguages(programmers, "JavaScript") -> ["Alice", "Bob", "Charlie", "Dave", "Eve", "Frank"]
```
Task 4

Topic: Stream Performance

Problem: You are given a list of programmers, each with a different number of projects they have completed and their respective programming languages. Your task is to implement three methods:

1. `findFastestLanguage(List<Programmer> programmers)`: This method should return the programming language that is used by the programmer who has completed the most projects.
    
2. `findSlowestLanguage(List<Programmer> programmers)`: This method should return the programming language that is used by the programmer who has completed the least projects.
    
3. `averageProjectsPerLanguage(List<Programmer> programmers)`: This method should return a map where the keys are programming languages and the values are the average number of projects completed by programmers who use that language.
    

Each method should use Stream API and include at least 4 operations.

Example:
```java
Input:

List<Programmer> programmers = Arrays.asList(

    new Programmer("Alice", "Java", 5),

    new Programmer("Bob", "Python", 3),

    new Programmer("Charlie", "Java", 5),

    new Programmer("Dave", "C++", 2),

    new Programmer("Eve", "Java", 5),

    new Programmer("Frank", "Python", 3)

);

Output:

findFastestLanguage(programmers) -> "Java"

findSlowestLanguage(programmers) -> "C++"

averageProjectsPerLanguage(programmers) -> {"Java": 5.0, "Python": 3.0, "C++": 2.0}