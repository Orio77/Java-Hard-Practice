package oop.exercise5_overloadingAndOverriding.scenario3;

public class CalculatorManager {
    private AdvancedCalculator advCalc;

    public double manageCalculator(double a, double b, double c, String calculatorDetail) {
        switch (calculatorDetail.toLowerCase()) {
            case "add":
                return advCalc.add(a, b, c);
            case "substract":
                return advCalc.substract(a, b, c);
            case "multiply":
                return advCalc.multiply(a, b, c);
            case "divide":
                return advCalc.divide(a, b, c);
            default:
                return 0;
        }
    }
}
