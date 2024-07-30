package oop.exercise19_bestPractises.scenario2;

public class FeeCalculator {
    
    public double calculateFee(Member member) {
        if (member instanceof Student) {
            return 0.1;
        }
        else if (member instanceof Faculty) {
            return 0.05;
        }
        return 0;
    }
}
