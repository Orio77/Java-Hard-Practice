package oop.exercise19_bestPractises.scenario2;

public class ShortTermLoan extends Loan implements LoanType{
    
    public ShortTermLoan(Member member, Book book, int daysLeftToReturn) {
        super(member, book, daysLeftToReturn);
    }

    @Override
    public int calculateDueDate() {
        return getDaysLeftToReturn();
    }
}
