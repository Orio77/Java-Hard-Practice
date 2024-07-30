package algorithms.exercise5_dynamicProgramming.scenario1;

import java.util.ArrayList;
// AI copied
public class DPAAlgorithm {
    ArrayList<Server> servers;
    ArrayList<Task> tasks;
    Integer[][] memo;

    public DPAAlgorithm(ArrayList<Server> servers, ArrayList<Task> tasks) {
        this.tasks = tasks;
        this.servers = servers;
        this.memo = new Integer[tasks.size() + 1][servers.stream().mapToInt(s -> s.getCapacity()).sum()];
    }

    public void computeDP() {
        int numOfTasks = tasks.size();
        int totalCapacity = servers.stream().mapToInt(s -> s.getCapacity()).sum();

        System.out.println("Maximum value: " + memoize(numOfTasks, totalCapacity));

        int w = totalCapacity;
        ArrayList<Task> assignedTasks = new ArrayList<>();

        for (int i = numOfTasks; i > 0 ; i--) {
            if (memo[i][w] != null && memo[i][w] != memo[i - 1][w]) {
                assignedTasks.add(tasks.get(i - 1));
                w -= tasks.get(i - 1).getProcessingTime();
            }
        }
        System.out.println("Assigned tasks: " + assignedTasks);
    }

    public int memoize(int i, int w) {
        if (i == 0 || w == 0)
            return 0;

        if (memo[i][w] != null)
            return memo[i][w];

        Task currentTask = tasks.get(i - 1);

        if (currentTask.getProcessingTime() > w)
            memo[i][w] = memoize(i - 1, w);
        else
            memo[i][w] = Math.max(memoize(i - 1, w), currentTask.getValue() + memoize(i - 1, w - currentTask.getProcessingTime()));

        return memo[i][w];
    }
}

// I don't understand this algorithm