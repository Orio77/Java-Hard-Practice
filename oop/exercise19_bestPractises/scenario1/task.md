**Refined Task Description:**

1. **Design the Class Structure:** Design the following classes with appropriate attributes and methods:
    
    - `Book`: This class should encapsulate the properties of a book.
        
        - Attributes: `title`, `author`, `availability`
        - Methods: `borrow_book()`, `return_book()`
    - `Member`: This class should encapsulate the properties of a library member.
        
        - Attributes: `name`, `max_books`
        - Methods: `borrow_book()`, `return_book()`
    - `Library`: This class should encapsulate the properties of a library.
        
        - Attributes: `books`, `members`
        - Methods: `add_book()`, `add_member()`, `lend_book()`
2. **Implement Inheritance:** Implement the following subclasses:
    
    - `Student`: This class should inherit from `Member` and have a lower `max_books` limit.
    - `Teacher`: This class should inherit from `Member` and have a higher `max_books` limit.
3. **Use Polymorphism:** Implement the `lend_book()` method in the `Library` class. This method should behave differently based on whether the `Member` is a `Student` or a `Teacher`.