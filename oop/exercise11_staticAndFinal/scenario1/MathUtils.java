package oop.exercise11_staticAndFinal.scenario1;

public final class MathUtils {
    
    // methods are thread-safe
    public static int add(int n1, int n2) {
        return n1 + n2;
    }

    public static int substract(int n1, int n2) {
        return n1 - n2;
    }

    public static int multiply(int n1, int n2) {
        return n1*n2;
    }

    public static int divide(int n1, int n2) {
        return n1 / n2;
    } 
}
