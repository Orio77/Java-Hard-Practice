package algorithms.exercise5_dynamicProgramming.scenario1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LoadBalancingAlgorithm {
    PriorityQueue<Server> servers;

    public LoadBalancingAlgorithm() {
        servers = new PriorityQueue<>(Comparator.comparing(s -> s.getLoad()));
    }

    public void assignTasks(ArrayList<Task> tasks) {
        for (Task task : tasks) {
            servers.poll().addTask(task);
        }
    }
}
