package oop.exercise19_bestPractises.scenario2;

public class Book {
    private String title;
    private String author;
    private int ISBN;
    private boolean loanStatus;
    private boolean isReserved;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        ISBN = title.hashCode();
        loanStatus = false;
    }

    public String getAuthor() {
        return author;
    }
    public int getISBN() {
        return ISBN;
    }
    public String getTitle() {
        return title;
    }
    public boolean getLoanStatus() {
        return loanStatus;
    }
    public boolean isLoanStatus() {
        return loanStatus;
    }
    public boolean isReserved() {
        return isReserved;
    }
    public void setReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }
}
