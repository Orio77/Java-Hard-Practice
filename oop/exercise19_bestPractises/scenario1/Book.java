package oop.exercise19_bestPractises.scenario1;

public class Book {
    private String title;
    private String author;
    private int availability;

    public void borrowBook() {
        if (availability > 0)
            System.out.println("You borrowed a book");
    }

    public void returnBook() {
        availability++;
        System.out.println("Thank you for having the book");
    }

    public String getAuthor() {
        return author;
    }
    public int getAvailability() {
        return availability;
    }
    public String getTitle() {
        return title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setAvailability(int availability) {
        this.availability = availability;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
