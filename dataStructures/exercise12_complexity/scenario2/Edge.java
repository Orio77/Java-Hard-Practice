package dataStructures.exercise12_complexity.scenario2;

public class Edge {
    private int i;
    private int j;
    private double value;

    public Edge(int i, int j, double value) {
        this.i = i;
        this.j = j;
        this.value = value;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public double getValue() {
        return value;
    }
}
