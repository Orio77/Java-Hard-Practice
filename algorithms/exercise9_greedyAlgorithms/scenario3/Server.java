package algorithms.exercise9_greedyAlgorithms.scenario3;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Server {
    List<Task> tasks;
    int totalLoad;

    public int calculateTotalLoad(List<Integer> loads) {
        return loads.stream().mapToInt(i -> Integer.valueOf(i)).sum();
    }

    public void assignTasks(List<Server> servers, List<Task> tasks) {
        PriorityQueue<Server> pQueue = new PriorityQueue<>(Comparator.comparing(s -> s.getTotalLoad()));

        for (Task task : tasks) {
            Server priorityServer = pQueue.poll();
            priorityServer.getTasks().add(task);
            pQueue.add(priorityServer);
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }
    public int getTotalLoad() {
        return totalLoad;
    }
}
