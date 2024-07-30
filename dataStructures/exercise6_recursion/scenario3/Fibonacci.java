package dataStructures.exercise6_recursion.scenario3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Fibonacci {
    private static ArrayList<Integer> fibNumbers = new ArrayList<>(Arrays.asList(0, 1));
    private static HashMap<Integer, Integer> hashFibNumbers = new HashMap<>();

    public Fibonacci() {
        fibNumbers.add(0);
        fibNumbers.add(1);
        hashFibNumbers.put(0, 0);
        hashFibNumbers.put(1, 1);
    }

    // My no base case implementation
    public static int calculateFibonacci(int num1, int num2) {
        

        int sum = num1 + num2;
        num1 = num2;
        num2 = sum;

        calculateFibonacci(num1, sum);

        return sum;
    }

    public static int fibonacciArray(int n) {

        if (n < 2)
            return n;
        else if (n < fibNumbers.size())
            return fibNumbers.get(n);
        else {
            int currentNumber = fibonacciArray(n - 1) + fibonacciArray(n - 2);
            fibNumbers.add(currentNumber);
            return currentNumber;
        }
    }

    public static int fibonacciHashMap(int n) {

        if (n < 2)
            return n;
        else if (hashFibNumbers.containsKey(n))
            return hashFibNumbers.get(n);
        else {
            int currentNumber = fibonacciHashMap(n - 1) + fibonacciHashMap(n - 2);
            hashFibNumbers.put(n, currentNumber);
            return currentNumber;
        }
    }

    public static void runFibonacciArray(int n) {
        long startTime = System.nanoTime();
        int result = fibonacciArray(n);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);  // compute the elapsed time in nanoseconds
        double durationInSeconds = duration / 1_000_000_000.0;  // convert to seconds

        System.out.println("fibonacciArray(" + n + ") = " + result);
        System.out.println("Execution time: " + durationInSeconds + " seconds");
    }

    public static void runFibonacciHashMap(int n) {
        long startTime = System.nanoTime();
        int result = fibonacciHashMap(n);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);  // compute the elapsed time in nanoseconds
        double durationInSeconds = duration / 1_000_000_000.0;  // convert to seconds

        System.out.println("fibonacciHashMap(" + n + ") = " + result);
        System.out.println("Execution time: " + durationInSeconds + " seconds");
    }
}
