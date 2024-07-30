package oop.exercise19_bestPractises.scenario2;

import java.util.List;

public class ReportGenerator {
    private List<Loan> loans;

    public ReportGenerator(List<Loan> loans) {
        this.loans = loans;
    }

    public LibraryUsageStatistics generateReport() {
        UsageStatisticCollector collector = new UsageStatisticCollector();
        LibraryUsageStatistics stats = loans.stream().collect(collector);

        System.out.println("Total books loaned: " + stats.getTotalBooksLoaned());
        System.out.println("Average loan duration: " + stats.getAverageLoanDuration());

        return stats;
    }
}
