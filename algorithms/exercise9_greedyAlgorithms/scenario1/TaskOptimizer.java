package algorithms.exercise9_greedyAlgorithms.scenario1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TaskOptimizer {
    private PriorityQueue<Task> tasks;
    private PriorityQueue<Task> localOptima;
    private PriorityQueue<Task> globalOptimum;

    public TaskOptimizer(Task[] taskArray) {
        tasks = new PriorityQueue<>();
        tasks.addAll(Arrays.asList(taskArray));
    }

    public void findLocalOptima() {
        localOptima = new PriorityQueue<>(Comparator.comparing(Task::getDeadline).reversed());
        localOptima.addAll(tasks);
    }

    public void findGlobalOptimum() {
        globalOptimum = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return Double.compare(t2.getDeadline() / (double) t2.getDuration(), t1.getDeadline() / (double) t2.getDuration());
            }
        });
        globalOptimum.addAll(tasks);
    }
}
