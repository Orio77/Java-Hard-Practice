package oop.exercise19_bestPractises.scenario2;

import java.util.List;

public class Librarian implements LoanOperations, MemberManagement{
    private List<Member> members;
    private List<Book> books;
    
    public void checkOutBook(Book book, Member member) {
        if (!book.getLoanStatus()) {
            issueLoan(member, book);
        }
        else
            System.out.println("Book already sb's in posession");
    }

    public boolean returnBook(Book book) {
        return books.add(book);
    }

    @Override
    public void issueLoan(Member member, Book book) {
        member.borrowBook(book);
    }

    @Override
    public Loan returnLoan(Member member, Book book) {
        Loan removedLoan = null;
        for (Loan loan : member.getLoans()) {
            if (loan.getBook().equals(book)) {
                removedLoan = loan;
                member.removeLoan(loan);
            }
        }
        return removedLoan;
    }

    @Override
    public boolean addMember(Member member) {
        return members.add(member);
    }

    @Override
    public boolean removeMember(Member member) {
        return members.remove(member);
    }
}
