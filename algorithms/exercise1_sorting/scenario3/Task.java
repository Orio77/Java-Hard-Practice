package algorithms.exercise1_sorting.scenario3;

public class Task {
    private int priority;
    private String name;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }
    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return name;
    }
}
