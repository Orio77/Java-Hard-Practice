package oop.exercise11_staticAndFinal.scenario3;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int booksInPosession;
    private List<Book> books;

    public User() {
        booksInPosession = 0;
        books = new ArrayList<>();
    }

    public int getBooksInPosession() {
        return booksInPosession;
    }
    public List<Book> getBooks() {
        return books;
    }
}
