package oop.exercise19_bestPractises.scenario1;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public boolean addBook(Book book) {
        return books.add(book);
    }

    public boolean addMember(Member memeber) {
        return members.add(memeber);
    }

    public void lendBook(Member member, Book book) {
        member.borrowBook(book);
    }
}
