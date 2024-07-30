package oop.exercise19_bestPractises.scenario2;

public class LibraryUsageStatistics {
    private int totalBooksLoaned;
    private double averageLoanDuration;

    public double getAverageLoanDuration() {
        return averageLoanDuration;
    }
    public int getTotalBooksLoaned() {
        return totalBooksLoaned;
    }
    public void setAverageLoanDuration(double averageLoanDuration) {
        this.averageLoanDuration = averageLoanDuration;
    }
    public void setTotalBooksLoaned(int totalBooksLoaned) {
        this.totalBooksLoaned = totalBooksLoaned;
    }
}
