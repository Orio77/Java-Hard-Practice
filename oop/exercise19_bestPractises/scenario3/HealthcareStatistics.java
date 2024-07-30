package oop.exercise19_bestPractises.scenario3;

public class HealthcareStatistics {
    private int numberOfSurgeries;

    public int getNumberOfSurgeries() {
        return numberOfSurgeries;
    }

    public void add(int number) {
        numberOfSurgeries += number;
    }

    public void combine(int number) {
        numberOfSurgeries += number;
    }
}
