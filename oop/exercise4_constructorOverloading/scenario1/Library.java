package oop.exercise4_constructorOverloading.scenario1;

import java.util.ArrayList;
import java.util.List;

public class Library {
    ArrayList<Book> bookBase;

    public Library() {
        bookBase = new ArrayList<>();
    }

    public boolean addBook(Book book) {
        if (book == null) {
            return false;
        }

        bookBase.add(book);
        return true;
    }

    public boolean addBook(String title, String author, int publicationYear, String genre) {
        if (title.matches("") || author.matches("") || publicationYear < 0 || genre.matches("")) {
            return false;
        }

        bookBase.add(new Book(title, author, publicationYear, genre));
        return true;
    }

    public List<Book> findBooks(String title) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book : bookBase) {
            if (book.getTitle().matches(title)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public void showBooks() {
        System.out.println(bookBase);
    }
}
