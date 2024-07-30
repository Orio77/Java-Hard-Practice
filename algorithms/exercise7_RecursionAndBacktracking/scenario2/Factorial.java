package algorithms.exercise7_RecursionAndBacktracking.scenario2;
// subtle hints from AI
public class Factorial {
    private int number;

    public Factorial(int number) {
        this.number = number;
    }

    public int calculate() {
        int result = 1;
        result = calculate(number);
        return result;
    }

    public int calculate(int number) {

        if ((number - 1) < 0)
            return 1;

        int result = number * calculate(number - 1);
        return result;
    }
}
