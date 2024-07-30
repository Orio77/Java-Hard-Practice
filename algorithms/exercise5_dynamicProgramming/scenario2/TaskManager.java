package algorithms.exercise5_dynamicProgramming.scenario2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class TaskManager {
    List<Task> tasks;
    List<Character> resources;
    
    // My Greedy Approach
    public String findTaskSchedule(List<Task> tasks, List<Character> resources) {
        LinkedList<Task> schedule = new LinkedList<>();
        if (tasks == null || resources == null || resources.isEmpty() || tasks.isEmpty())
            return schedule.toString();

        tasks.sort(Comparator.comparing(t -> ((Task) t).getDuration()));

        for (Task task : tasks) {
            if (isSafe(task, resources)) {
                schedule.add(task);
                resources.removeAll(task.getRequiredResources());
            }
        }

        int duration = getDuration(schedule);

        return "(" + schedule.toString() + ", " +duration + ")";
    }

    private boolean isSafe(Task task, List<Character> resources) {
        LinkedList<Character> returnList = new LinkedList<>();
        for (Character resource : resources) {
            if (resources.contains(resource)) {
                returnList.add(resource);
                resources.remove(resource);
            }
            else
                return false;
        }
        while (!returnList.isEmpty()) {
            resources.add(returnList.poll());
        }
        return true;
    }

    private int getDuration(List<Task> tasks) {
        int duration = 0;

        for (Task task : tasks) {
            duration = duration + task.getDuration();
        }

        return duration;
    }

    // Dynamic Programming approach || AI Copied || Not entirely correct
    public void solveDynamically() {
        int[][] dp = new int[tasks.size() + 1][tasks.size() + 1];
        boolean[][] state = new boolean[tasks.size() + 1][tasks.size() + 1];
        for (int i = 0; i < tasks.size(); i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][0] = 0;
        }
        

        state[0][0] = true;
        for (int i = 0; i < tasks.size(); i++) {
            for (int j = 0; j < tasks.size(); j++) {
                if (state[i][j]) {
                    for (int j2 = 0; j2 < tasks.size(); j2++) {
                        if (isSafe(tasks.get(j2), resources)) {
                            resources.removeAll(tasks.get(j2).getRequiredResources());
                            if (dp[i][j] + tasks.get(j2).getDuration() < dp[i + 1][j + 1]) {
                                dp[i + 1][j + 1] = dp[i][j] + tasks.get(j2).getDuration();
                                state[i + 1][j + 1] = true;
                            }
                            resources.addAll(tasks.get(j2).getRequiredResources());
                        }
                    }
                }
            }
        }

        LinkedList<Task> schedule = new LinkedList<>();
        int i = tasks.size();
        int j = tasks.size();
        while (j > 0) {
            if (state[i][j] && dp[i][j] == dp[i - 1][j - 1] + tasks.get(j - 1).getDuration()) {
                schedule.addFirst(tasks.get(j - 1));
                j--;
            }
            i--;
        }
    }
}
