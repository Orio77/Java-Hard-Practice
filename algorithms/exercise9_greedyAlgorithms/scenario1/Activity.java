package algorithms.exercise9_greedyAlgorithms.scenario1;

public class Activity {
    private int startTime;
    private int endTime;

    public int getEndTime() {
        return endTime;
    }
    public int getStartTime() {
        return startTime;
    }

    public int egtDuration() {
        return endTime - startTime;
    }
}
