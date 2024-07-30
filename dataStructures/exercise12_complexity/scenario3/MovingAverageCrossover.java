package dataStructures.exercise12_complexity.scenario3;

import java.util.Arrays;

public class MovingAverageCrossover {
    private double[] prices;
    private int shortWindow;
    private int longWindow;

    public MovingAverageCrossover(double[] prices, int shortWindow, int longWindow) {
        this.prices = prices;
        this.shortWindow = shortWindow;
        this.longWindow = longWindow;
    }

    // This method was iterating over the prices and getting the average, I was guided by AI
    private double calculateMovingAverage(int start, int end, double prevAvg) {
        double oldPrice = start > 0 ? prices[start - 1] : 0.0;
        double newPrice = prices[end - 1];
        return prevAvg - oldPrice / (end - start) + newPrice / (end - start);
    }

    public int[] generateSignals() {
        int[] signals = new int[prices.length];
        Arrays.fill(signals, 0);

        double shortMA = calculateMovingAverage(0, shortWindow, 0.0);
        double longMA = calculateMovingAverage(0, longWindow, 0.0);

        for (int i = longWindow; i < prices.length; i++) {
            shortMA = calculateMovingAverage(i - shortWindow + 1, i + 1, shortMA);
            longMA = calculateMovingAverage(i - longWindow + 1, i + 1, longMA);

            if (shortMA > longMA) {
                signals[i] = 1;  // buy signal
            } else if (shortMA < longMA) {
                signals[i] = -1;  // sell signal
            }
        }

        return signals;
    }

    public static void main(String[] args) {
        // Generate some random price data for testing
        double[] prices = new double[1000000];  // increased size to 1,000,000
        for (int i = 0; i < prices.length; i++) {
            prices[i] = Math.random();
        }

        // Create a MovingAverageCrossover object
        MovingAverageCrossover mac = new MovingAverageCrossover(prices, 50, 200);  // increased window sizes

        // Measure the time before the execution
        long startTime = System.nanoTime();

        mac.generateSignals();

        // Measure the time after the execution
        long endTime = System.nanoTime();

        // Calculate and print the execution time in milliseconds
        long duration = (endTime - startTime) / 1000000;  // convert to milliseconds
        System.out.println("Execution time: " + duration + " milliseconds");
    }
}
