package oop.exercise11_staticAndFinal.scenario2;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public int totalBooks() {
        return Book.getTotalBooks();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public boolean createUser(String username, String password) {
        return users.add(new User(username, password));
    }
}
