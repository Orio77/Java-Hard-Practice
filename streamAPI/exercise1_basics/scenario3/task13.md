Background: A software development company needs to optimize their data processing application. They require a solution to efficiently filter and process large datasets of customer information using Java Stream API to improve performance and scalability.

Task 1

Problem: You are given a list of `Customer` objects. Each `Customer` has a `name`, `age`, `email`, and a list of `purchases`. Each `purchase` has a `product` and `price`. Implement two methods:

1. `getTopSpendingCustomers(List<Customer> customers, int n)`: This method should return a list of `n` customers who have spent the most. The list should be sorted in descending order of total spend. Use `Stream` API to create a pipeline that maps each customer to their total spend, sorts the customers by total spend, and collects the top `n`.
    
2. `getPopularProducts(List<Customer> customers, int n)`: This method should return a list of `n` most popular products (products with the most sales). The list should be sorted in descending order of popularity. Use `Stream` API to create a pipeline that flattens the list of purchases, maps each purchase to its product, counts the occurrences of each product, and collects the top `n`.
    

Example:
```java
Input:

List<Customer> customers = Arrays.asList(

    new Customer("John", 30, "john@example.com", Arrays.asList(new Purchase("Apple", 5), new Purchase("Banana", 3))),

    new Customer("Jane", 25, "jane@example.com", Arrays.asList(new Purchase("Apple", 10), new Purchase("Cherry", 7))),

    new Customer("Bob", 35, "bob@example.com", Arrays.asList(new Purchase("Banana", 2), new Purchase("Cherry", 5), new Purchase("Date", 4)))

);

int n = 2;

Output:
getTopSpendingCustomers(customers, n); // Returns ["Jane", "Bob"]
getPopularProducts(customers, n); // Returns ["Apple", "Cherry"]
```
Task 2

Problem: You are given a list of `Employee` objects. Each `Employee` has a `name`, `department`, `salary`, and a list of `projects`. Each `project` has a `name` and `hoursWorked`. Implement two methods:

1. `getTopPaidEmployees(List<Employee> employees, int n)`: This method should return a list of `n` employees who have the highest salaries. The list should be sorted in descending order of salary. Use `Stream` API to create a pipeline that maps each employee to their salary, sorts the employees by salary, and collects the top `n`.
    
2. `getMostTimeConsumingProjects(List<Employee> employees, int n)`: This method should return a list of `n` most time-consuming projects (projects with the most hours worked). The list should be sorted in descending order of hours worked. Use `Stream` API to create a pipeline that flattens the list of projects, maps each project to its hours worked, counts the total hours for each project, and collects the top `n`.
    

Example:
```java
Input:

List<Employee> employees = Arrays.asList(

    new Employee("John", "IT", 5000, Arrays.asList(new Project("Project A", 20), new Project("Project B", 30))),

    new Employee("Jane", "HR", 6000, Arrays.asList(new Project("Project A", 10), new Project("Project C", 40))),

    new Employee("Bob", "Finance", 7000, Arrays.asList(new Project("Project B", 15), new Project("Project C", 25), new Project("Project D", 35)))

);

int n = 2;

Output:

getTopPaidEmployees(employees, n); // Returns ["Bob", "Jane"]

getMostTimeConsumingProjects(employees, n); // Returns ["Project C", "Project D"]

Note: The `Employee` and `Project` classes are defined as follows:

class Employee {

    String name;

    String department;

    int salary;

    List<Project> projects;

    // constructor, getters, and setters omitted for brevity

}

class Project {

    String name;

    int hoursWorked;

    // constructor, getters, and setters omitted for brevity

}
```
Task 3

Problem: You are given a list of `Student` objects. Each `Student` has a `name`, `grade`, and a list of `courses`. Each `course` has a `name` and `score`. Implement two methods:

1. `getTopGradedStudents(List<Student> students, int n)`: This method should return a list of `n` students who have the highest grades. The list should be sorted in descending order of grade. Use `Stream` API to create a pipeline that maps each student to their grade, sorts the students by grade, and collects the top `n`.
    
2. `getHighestScoringCourses(List<Student> students, int n)`: This method should return a list of `n` highest scoring courses (courses with the highest scores). The list should be sorted in descending order of score. Use `Stream` API to create a pipeline that flattens the list of courses, maps each course to its score, counts the total score for each course, and collects the top `n`.
    

Example:
```java
Input:

List<Student> students = Arrays.asList(

    new Student("John", "A", Arrays.asList(new Course("Math", 90), new Course("English", 85))),

    new Student("Jane", "B", Arrays.asList(new Course("Math", 95), new Course("Science", 88))),

    new Student("Bob", "A", Arrays.asList(new Course("English", 80), new Course("Science", 92), new Course("History", 89)))

);

int n = 2;

Output:

getTopGradedStudents(students, n); // Returns ["John", "Bob"]

getHighestScoringCourses(students, n); // Returns ["Math", "Science"]

Note: The `Student` and `Course` classes are defined as follows:

class Student {

    String name;

    String grade;

    List<Course> courses;

    // constructor, getters, and setters omitted for brevity

}

class Course {

    String name;

    int score;

    // constructor, getters, and setters omitted for brevity

}
```
Task 4

Problem: You are given a list of `Product` objects. Each `Product` has a `name`, `category`, `price`, and `sales`. Implement three methods:

1. `getTopSellingProducts(List<Product> products, int n)`: This method should return a list of `n` products that have the highest sales. The list should be sorted in descending order of sales. Use `Stream` API to create a pipeline that maps each product to its sales, sorts the products by sales, and collects the top `n`.
    
2. `getMostExpensiveProducts(List<Product> products, int n)`: This method should return a list of `n` most expensive products. The list should be sorted in descending order of price. Use `Stream` API to create a pipeline that maps each product to its price, sorts the products by price, and collects the top `n`.
    
3. `getPopularCategories(List<Product> products, int n)`: This method should return a list of `n` most popular categories (categories with the most products). The list should be sorted in descending order of popularity. Use `Stream` API to create a pipeline that maps each product to its category, counts the occurrences of each category, and collects the top `n`.
    

Example:
```java
Input:

List<Product> products = Arrays.asList(

    new Product("Product A", "Category 1", 100, 500),

    new Product("Product B", "Category 2", 200, 400),

    new Product("Product C", "Category 1", 150, 600),

    new Product("Product D", "Category 3", 250, 300),

    new Product("Product E", "Category 2", 120, 700)

);

int n = 2;

Output:

getTopSellingProducts(products, n); // Returns ["Product E", "Product C"]

getMostExpensiveProducts(products, n); // Returns ["Product D", "Product B"]

getPopularCategories(products, n); // Returns ["Category 2", "Category 1"]

Note: The `Product` class is defined as follows:

class Product {

    String name;

    String category;

    int price;

    int sales;

    // constructor, getters, and setters omitted for brevity

}