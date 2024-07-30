package oop.exercise19_bestPractises.scenario2;

public class Loan {
    private Member member;
    private Book book;
    private int daysLeftToReturn;
    private boolean isOverdue;

    public Loan(Member member, Book book, int daysLeftToReturn) {
        this.member = member;
        this.book = book;
        this.daysLeftToReturn = daysLeftToReturn;
        isOverdue = false;
    }

    public String getLoanDetails() {
        return "Owner of the loan: " + member.getName() + "\n Book that was borrowed: " + book.getTitle() + "\nDays left to return the book: " + daysLeftToReturn;
    }
    public boolean isOverdue() {
        return isOverdue;
    }

    public Book getBook() {
        return book;
    }
    public int getDaysLeftToReturn() {
        return daysLeftToReturn;
    }
    public Member getMember() {
        return member;
    }
}
