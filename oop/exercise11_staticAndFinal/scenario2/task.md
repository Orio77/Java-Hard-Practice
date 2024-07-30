**Advanced Library Management System**

- **Task 1**: Create a class `Book` with properties `title`, `author`, and `edition`. Also, include a static property `totalBooks` that keeps track of the total number of books created. Implement a constructor that increments `totalBooks` each time a new book is created.
- **Task 2**: Create a class `Library` with a property `books` (a list of `Book` objects). Implement a method `addBook(Book book)` that adds a book to the library and a method `totalBooks()` that returns the value of `Book.totalBooks`.
- **Task 3**: Create a class `LibraryCard` with properties `cardNumber` and `issuedTo`. Make `cardNumber` a final property that is set at the time of creation and cannot be changed afterwards. Implement a constructor that sets these properties.

**Further practise**:

1. **Advanced Library Management System – Enhanced Details**:
    - **Book**: Extend the `Book` class to include a static method `averagePages()` that calculates and returns the average number of pages in all created books.
    - **Library**: Extend the `Library` class to include a method `findBook(String title)` that returns the `Book` object with the given title. If no such book exists, it should return null.
2. **Library Management System with User Accounts – Enhanced Details**:
    - **User**: Create a class `User` with properties `username` and `password`. Make `password` a private property that can only be set through a `setPassword(String password)` method. This method should check if the password meets certain criteria (e.g., minimum length, contains a number) before setting it.
    - **Library**: Extend the `Library` class to include a method `createUser(String username, String password)` that creates a new `User` and adds it to a list of users.
3. **Customizable Library Management System – Enhanced Details**:
    - **LibrarySystem**: Create an abstract class `LibrarySystem` with methods `addBook(Book book)`, `totalBooks()`, `findBook(String title)`, and `createUser(String username, String password)`. Make `Library` a subclass of `LibrarySystem` and implement these methods.
    - **LibraryCard**: Extend the `LibraryCard` class to include a final method `expire()` that sets a `expiryDate` property to one year from the current date. This method cannot be overridden in subclasses.