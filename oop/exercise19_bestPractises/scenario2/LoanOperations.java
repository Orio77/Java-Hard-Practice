package oop.exercise19_bestPractises.scenario2;

public interface LoanOperations {
    
    void issueLoan(Member member, Book book);
    Loan returnLoan(Member member, Book book);
}
