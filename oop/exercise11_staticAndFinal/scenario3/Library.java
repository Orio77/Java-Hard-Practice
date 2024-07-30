package oop.exercise11_staticAndFinal.scenario3;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private static List<Book> books;
    private final static int maxBooksPerUser = 3;

    public Library() {
        books = new ArrayList<>();
    }

    public boolean addBook(Book book) {
        return books.add(book);
    }

    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    public static boolean lendBook(User user, Book book) {
        if (canBorrow(user)) {
            user.getBooks().add(book);
            return true;
        }
        return false;
    }

    public static boolean canBorrow(User user) {
        if (user.getBooksInPosession() < maxBooksPerUser) 
            return true;

        return false;
    }
}
