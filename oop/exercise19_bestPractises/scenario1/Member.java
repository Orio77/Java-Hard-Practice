package oop.exercise19_bestPractises.scenario1;

public class Member {
    private String name;
    private final int maxBooks = 5;

    public Member(String name) {
        this.name = name;
    }

    public void borrowBook(Book book) {
        book.borrowBook();
    }

    public void returnBook(Book book) {
        book.returnBook();
    }

    public int getMaxBooks() {
        return maxBooks;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
