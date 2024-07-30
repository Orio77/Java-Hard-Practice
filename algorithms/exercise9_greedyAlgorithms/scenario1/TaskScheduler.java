package algorithms.exercise9_greedyAlgorithms.scenario1;

import java.util.Arrays;
import java.util.Comparator;

public class TaskScheduler {
    private Task[] tasks;
    private Task[] sortedTasks;

    public void sortDuration() {
        this.sortedTasks = Arrays.stream(tasks).sorted(Comparator.comparing(Task::getDuration)).toArray(Task[]::new);
    }

    public void sortDeadline() {
        this.sortedTasks = Arrays.stream(tasks).sorted(Comparator.comparing(Task::getDeadline)).toArray(Task[]::new);
    }

    public void scheduleTasks() {
        System.out.println(Arrays.asList(sortedTasks));
    }
}