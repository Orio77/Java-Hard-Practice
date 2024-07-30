package oop.exercise19_bestPractises.scenario2;

import java.util.ArrayList;
import java.util.List;

public class OverDueLoanReport extends Report {
    
    @Override
    public void generateReport(Member member) {
        List<String> report = new ArrayList<>();
        for (Loan loan : member.getLoans()) {
            if (loan.isOverdue()) {
                report.add("Overdue loan for: " + loan.getBook().getTitle() + ", the due date was " + loan.getDaysLeftToReturn() + " days ago");
            }
        }
    }
}
