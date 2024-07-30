Task 1

Problem: Given a list of Student objects, each with fields for id, name, list of courses taken, and a map of course grades, implement two methods:

1. `findTopPerformers(List<Student> students, int n)`: This method should return a list of the top 'n' students with the highest average grade across all their courses. The average grade should be calculated as the sum of all course grades divided by the number of courses. If two students have the same average, the student with fewer courses should be ranked higher. If there is still a tie, sort them by their names in alphabetical order.
    
2. `recommendCourse(List<Student> students, String studentId)`: This method should return a list of courses not yet taken by the student with the given id, sorted by the average grade of the course across all students. The course with the highest average grade should be recommended first.
    

Example:

Input:

List<Student> students = Arrays.asList(

    new Student("1", "Alice", Arrays.asList("Math", "Science"), Map.of("Math", 90, "Science", 95)),

    new Student("2", "Bob", Arrays.asList("Math", "English"), Map.of("Math", 85, "English", 92)),

    new Student("3", "Charlie", Arrays.asList("Science", "English"), Map.of("Science", 88, "English", 90))

);

findTopPerformers(students, 2);

recommendCourse(students, "1");

Output:

["Alice", "Bob"]

["English"]

Task 2

Topic: Stream API with Data Structures

Problem: Given a list of Student objects, each with fields for id, name, list of courses taken, and a map of course grades, implement two methods:

1. `findMostPopularCourse(List<Student> students)`: This method should return the course which has been taken by the most number of students. If there is a tie, return all such courses.
    
2. `findLeastScoringCourse(List<Student> students)`: This method should return the course which has the lowest average grade across all students. If there is a tie, return all such courses.
    

Example:

Input:

List<Student> students = Arrays.asList(

    new Student("1", "Alice", Arrays.asList("Math", "Science"), Map.of("Math", 90, "Science", 95)),

    new Student("2", "Bob", Arrays.asList("Math", "English"), Map.of("Math", 85, "English", 92)),

    new Student("3", "Charlie", Arrays.asList("Science", "English"), Map.of("Science", 88, "English", 90))

);

findMostPopularCourse(students);

findLeastScoringCourse(students);

Output:

["Math", "Science"]

["Math"]

Task 3

Topic: Stream Performance

Problem: Given a list of Student objects, each with fields for id, name, list of courses taken, and a map of course grades, implement two methods:

1. `findFailedStudents(List<Student> students)`: This method should return a list of students who have failed in any of their courses. A student is considered to have failed if they have a grade less than 50 in any course.
    
2. `findTopCourse(List<Student> students)`: This method should return the course with the highest average grade across all students. If there is a tie, return all such courses.
    

Example:

Input:

List<Student> students = Arrays.asList(

    new Student("1", "Alice", Arrays.asList("Math", "Science"), Map.of("Math", 90, "Science", 45)),

    new Student("2", "Bob", Arrays.asList("Math", "English"), Map.of("Math", 85, "English", 92)),

    new Student("3", "Charlie", Arrays.asList("Science", "English"), Map.of("Science", 88, "English", 90))

);

findFailedStudents(students);

findTopCourse(students);

Output:

["Alice"]

["English"]

Task 4

Topic: Error Handling Strategies

Problem: Given a list of Student objects, each with fields for id, name, list of courses taken, and a map of course grades, implement three methods:

1. `findStudentById(List<Student> students, String id)`: This method should return the Student object with the given id. If no such student exists, it should throw a custom `StudentNotFoundException`.
    
2. `calculateAverageGrade(List<Student> students, String id)`: This method should return the average grade of the student with the given id. If no such student exists, it should throw a custom `StudentNotFoundException`. If the student has not taken any courses, it should throw a custom `NoCoursesTakenException`.
    
3. `recommendNextCourse(List<Student> students, String id)`: This method should return the course which the student with the given id should take next. This should be the course which the student has not taken yet and which has the highest average grade across all students who have taken it. If no such student exists, it should throw a custom `StudentNotFoundException`. If the student has taken all courses, it should throw a custom `NoCoursesLeftException`.
    

Example:

Input:

List<Student> students = Arrays.asList(

    new Student("1", "Alice", Arrays.asList("Math", "Science"), Map.of("Math", 90, "Science", 95)),

    new Student("2", "Bob", Arrays.asList("Math", "English"), Map.of("Math", 85, "English", 92)),

    new Student("3", "Charlie", Arrays.asList("Science", "English"), Map.of("Science", 88, "English", 90))

);

findStudentById(students, "4");

calculateAverageGrade(students, "1");

recommendNextCourse(students, "1");

Output:

StudentNotFoundException

92.5

"English"