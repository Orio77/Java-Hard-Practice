Task 1

Problem: You are given a list of `Employee` objects. Each `Employee` has a `name`, `age`, `department` and `salary`. Your task is to implement two methods:

1. `findTopPaidEmployeesByDepartment(List<Employee> employees, int topN)`: This method should return a `Map<String, List<Employee>>` where the key is the department name and the value is a list of top N employees (based on salary) in that department. The employees in the list should be sorted in descending order of their salary.
    
2. `findAverageSalaryByAgeRange(List<Employee> employees, int lowerAge, int upperAge)`: This method should return the average salary of employees whose age is between `lowerAge` and `upperAge` (inclusive).
    

Example:

Input:

List<Employee> employees = Arrays.asList(

    new Employee("John", 25, "IT", 5000),

    new Employee("Jane", 30, "IT", 6000),

    new Employee("Bob", 35, "HR", 7000),

    new Employee("Alice", 40, "HR", 8000),

    new Employee("Charlie", 45, "IT", 9000)

);

Output:

findTopPaidEmployeesByDepartment(employees, 2);

// Output: {"IT": [Employee("Charlie", 45, "IT", 9000), Employee("Jane", 30, "IT", 6000)], "HR": [Employee("Alice", 40, "HR", 8000), Employee("Bob", 35, "HR", 7000)]}

findAverageSalaryByAgeRange(employees, 30, 40);

// Output: 7000.0

Task 2 (Topic: Stream Collectors)

Problem: You are given a list of `Product` objects. Each `Product` has a `name`, `category`, `price` and `rating`. Your task is to implement two methods:

1. `groupByCategoryAndFindMostExpensiveProduct(List<Product> products)`: This method should return a `Map<String, Product>` where the key is the category name and the value is the most expensive product in that category.
    
2. `calculateAverageRatingByCategory(List<Product> products)`: This method should return a `Map<String, Double>` where the key is the category name and the value is the average rating of products in that category.
    

Example:

Input:

List<Product> products = Arrays.asList(

    new Product("Product1", "Electronics", 1000, 4.5),

    new Product("Product2", "Electronics", 2000, 4.0),

    new Product("Product3", "Books", 500, 4.8),

    new Product("Product4", "Books", 300, 4.9),

    new Product("Product5", "Electronics", 1500, 4.7)

);

Output:

groupByCategoryAndFindMostExpensiveProduct(products);

// Output: {"Electronics": Product("Product2", "Electronics", 2000, 4.0), "Books": Product("Product3", "Books", 500, 4.8)}

calculateAverageRatingByCategory(products);

// Output: {"Electronics": 4.4, "Books": 4.85}

Task 3 (Topic: Stream Performance)

Problem: You are given a large list of `Integer` objects. Your task is to implement two methods:

1. `findSquareOfEvenNumbers(List<Integer> numbers)`: This method should return a list of squares of even numbers in the input list. The output list should be sorted in ascending order.
    
2. `findCubeOfPrimeNumbers(List<Integer> numbers)`: This method should return a list of cubes of prime numbers in the input list. The output list should be sorted in ascending order.
    

Note: For this task, consider the performance of your solution. Try to use parallel streams if possible.

Example:

Input:

List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

Output:

findSquareOfEvenNumbers(numbers);

// Output: [4, 16, 36, 64, 100]

findCubeOfPrimeNumbers(numbers);

// Output: [1, 8, 27, 125, 343]

Task 4 (Topic: Error Handling Strategies)

Problem: You are given a list of `String` objects representing potential URLs. Your task is to implement three methods:

1. `filterValidUrls(List<String> urls)`: This method should return a list of valid URLs. A valid URL is one that starts with "http://" or "https://".
    
2. `findDomainNames(List<String> urls)`: This method should return a list of domain names extracted from the valid URLs. The domain name is the part of the URL between "//" and the next "/". If there is no next "/", then the domain name is the part of the URL after "//".
    
3. `countUrlsByDomain(List<String> urls)`: This method should return a `Map<String, Long>` where the key is the domain name and the value is the count of URLs with that domain name.
    

Note: For this task, consider the error handling strategies. If an invalid URL is encountered, the method should continue processing the remaining URLs.

Example:

Input:

List<String> urls = Arrays.asList(

    "http://example.com",

    "https://example.com/foo",

    "http://foo.com",

    "invalid",

    "https://bar.com/baz"

);

Output:

filterValidUrls(urls);

// Output: ["http://example.com", "https://example.com/foo", "http://foo.com", "https://bar.com/baz"]

findDomainNames(urls);

// Output: ["example.com", "example.com", "foo.com", "bar.com"]

countUrlsByDomain(urls);

// Output: {"example.com": 2, "foo.com": 1, "bar.com": 1}