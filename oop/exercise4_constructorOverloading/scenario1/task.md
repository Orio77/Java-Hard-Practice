1. Design a `Book` class with overloaded constructors for different book attributes.

   - Your `Book` class should have at least three constructors: a default constructor, a constructor that takes only the book's title and author, and a constructor that takes all book attributes (title, author, publication year, genre, etc.). Additionally, implement a copy constructor that creates a new book instance from an existing one.
   - _Potential input_: `Book book4 = new Book(book3);`
   - _Desired Output_: A new `Book` instance that is a copy of `book3`.
   - _Coach Suggestions_: The copy constructor should take a `Book` object as a parameter and use its attributes to initialize the new `Book` object. Make sure to handle the case where the input book object is null.

2. Implement methods to add new books to the library with varying details.

   - Implement a `addBook` method in your `Library` class that takes a `Book` object as a parameter and adds it to the library's collection. Additionally, implement an overloaded `addBook` method that takes book details as parameters, creates a new `Book` object, and adds it to the collection.
   - _Potential input_: `library.addBook("Moby Dick", "Herman Melville", 1851, "Fiction");`
   - _Desired Output_: The library's collection should be updated with the new book.
   - _Coach Suggestions_: The overloaded `addBook` method should create a new `Book` object using the provided details and then add it to the collection.

3. Ensure that the system can handle books with different properties.

   - Test your system by creating `Book` objects with different constructors and adding them to the library. Then, implement a method to display all books in the library to verify that all book details are handled correctly. Additionally, implement a method to search for a book by title and return all matching books.
   - _Potential input_: `library.searchBooks("1984");`
   - _Desired Output_: A list of all books in the library with the title "1984".
   - _Coach Suggestions_: Implement a `searchBooks` method in your `Library` class that iterates over the collection of books and adds any book with a matching title to a new list. This method should return the list of matching books.
