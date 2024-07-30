package dataStructures.exercise12_complexity.scenario2;

import java.util.Arrays;
import java.util.LinkedList;

public class PageRank {
    private static final double DAMPING_FACTOR = 0.85;
    private static final int NUM_ITERATIONS = 100;

    // AI Guided (there was 2D Matrix here at first)
    public static double[] pagerank(double[][] M) {
        int N = M.length;
        double[] ranks = new double[N];
        Arrays.fill(ranks, 1.0 / N); // Initialize ranks

        LinkedList<Edge> graph = new LinkedList<>();

        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < N; j++) {
                if (M[i][j] != 0) {
                    graph.add(new Edge(i, j, M[i][j]));
                }
            }
        }

        for (int iter = 0; iter < NUM_ITERATIONS; iter++) {
            double[] newRanks = new double[N];

            for (Edge edge : graph) {
                newRanks[edge.getI()] += DAMPING_FACTOR * edge.getValue() * ranks[edge.getJ()];
            }

            for (int i = 0; i < N; i++) {
                newRanks[i] += (1 - DAMPING_FACTOR) / N;
            }
            ranks = newRanks;
        }
        return ranks;
    }

    public static void main(String[] args) {
        int size = 1000; // Adjust this value to create a larger matrix
        double[][] M = new double[size][size];

        // Fill the matrix with some values
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                M[i][j] = Math.random();
            }
        }

        // Normalize the columns to make it a valid transition matrix
        for (int j = 0; j < size; j++) {
            double sum = 0;
            for (int i = 0; i < size; i++) {
                sum += M[i][j];
            }
            for (int i = 0; i < size; i++) {
                M[i][j] /= sum;
            }
        }

        long startTime = System.nanoTime();
        pagerank(M);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("PageRank algorithm took " + duration/1000000 + " milliseconds");
    }
}