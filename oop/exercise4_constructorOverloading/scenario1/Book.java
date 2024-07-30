package oop.exercise4_constructorOverloading.scenario1;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private String genre;

    public Book() {
        title = "James Bond";
        author = "James Bond";
        publicationYear = 2000;
        genre = "action";
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book(String title, String author, int publicationYear, String genre) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.genre = genre;
    }

    public Book(Book book) {
        if (book == null)
            return;

        book = new Book(book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getGenre());
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getTitle() {
        return title;
    }
}
