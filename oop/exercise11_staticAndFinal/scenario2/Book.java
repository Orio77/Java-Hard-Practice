package oop.exercise11_staticAndFinal.scenario2;

public class Book {
    private String author;
    private String title;
    private String edition;
    private static int totalBooks;


    public Book(String author, String title, String edition) {
        this.author = author;
        this.title = title;
        this.edition = edition;
        totalBooks++;
    }

    public String getAuthor() {
        return author;
    }
    public String getEdition() {
        return edition;
    }
    public String getTitle() {
        return title;
    }
    public static int getTotalBooks() {
        return totalBooks;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setEdition(String edition) {
        this.edition = edition;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public static void setTotalBooks(int totalBooks) {
        Book.totalBooks = totalBooks;
    }
}
