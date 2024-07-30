package algorithms.exercise5_dynamicProgramming.scenario1;

import java.util.ArrayList;

public class Server {
    private final int capacity;
    private final int load;
    private ArrayList<Task> tasks;

    public Server(int capacity, int load) {
        this.capacity = capacity;
        this.load = load;
        tasks = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public int getLoad() {
        return load;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void updateLoad() {

    }
}
