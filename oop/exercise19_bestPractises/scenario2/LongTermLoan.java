package oop.exercise19_bestPractises.scenario2;

public class LongTermLoan extends Loan implements LoanType {

    public LongTermLoan(Member member, Book book, int daysLeftToReturn) {
        super(member, book, daysLeftToReturn);
    }

    @Override
    public int calculateDueDate() {
        return getDaysLeftToReturn();
    }
    
    
}
