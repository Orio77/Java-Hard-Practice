1. **Task 1: Employee Record Management**
    
    Create a class named `Employee` to manage employee records. This class should encapsulate the employee's data and provide methods for accessing and modifying this data. The class should have the following methods:
    
    - `Employee(int id, String name, String position)`: Initializes a new instance of the `Employee` class.
    - `getId()`: Returns the employee's ID.
    - `getName()`: Returns the employee's name.
    - `getPosition()`: Returns the employee's position.
    - `setName(String name)`: Sets the employee's name.
    - `setPosition(String position)`: Sets the employee's position.
2. **Task 2: Search Strategy Implementation**
    
    Create an interface named `SearchStrategy` that defines a method for searching employee records. Then, implement at least two classes that conform to this interface, each representing a different search algorithm. The `SearchStrategy` interface should have the following method:
    
    - `search(List<Employee> employees, String term)`: Searches the list of employees for the given term and returns the matching employees.
    
    The classes implementing this interface can use different algorithms, such as linear search and binary search.
    
3. **Task 3: Employee Type Hierarchy**
    
    Extend the `Employee` class to create specialized employee types. For example, create classes named `Manager` and `Engineer` that inherit from the `Employee` class. These classes should override or add methods as necessary to handle their specific functionalities. For instance, the `Manager` class could have a method for adding employees to their team.