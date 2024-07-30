package oop.exercise5_overloadingAndOverriding.scenario3;

public class AdvancedCalculator extends Calculator{

    
    public int add(int a, int b, int c) {
        return a+b+c;
    }

    public int substract(int a, int b, int c) {
        return a-b-c;
    }

    public int multiply(int a, int b, int c) {
        return a*b*c;
    }

    public int divide(int a, int b, int c) {
        return a/b/c;
    }

    public double add(double a, double b, double c) {
        return a+b+c;
    }

    public double substract(double a, double b, double c) {
        return a-b-c;
    }

    public double multiply(double a, double b, double c) {
        return a*b*c;
    }

    public double divide(double a, double b, double c) {
        return a/b/c;
    }

    public boolean isEligibleForAdvancedCalculator(int a, int b, int c) {
        return (!(a != 0 && b != 0 && c == 0));
    }

    public boolean isEligibleForAdvancedCalculator(double a, double b, double c) {
        return (!(a != 0 && b != 0 && c == 0));
    }
}
