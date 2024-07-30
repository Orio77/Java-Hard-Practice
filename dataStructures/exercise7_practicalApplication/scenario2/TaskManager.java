package dataStructures.exercise7_practicalApplication.scenario2;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class TaskManager {
    PriorityQueue<Task> tasks;
    LinkedList<LinkedList<Task>> taskGraph;
    LinkedList<Task> nodes;

    public TaskManager() {
        tasks = new PriorityQueue<>(Comparator.comparing(t -> ((Task) t).getDeadline()).reversed());
        taskGraph = new LinkedList<>();
    }

    public Task getMostImportantTask() {
        return tasks.poll();
    }

    public void addTask(Task task) {
        nodes.add(task);
        Iterator<Task> iterator = nodes.iterator();
        LinkedList<Task> newTaskList = new LinkedList<>();

        while (iterator.hasNext()) {
            Task currTask = iterator.next();

            if (currTask.getDeadline() - 1 == task.getDeadline()) {
                newTaskList.add(currTask);
            }
        }

        taskGraph.add(newTaskList);
    }

    public void addTasks(LinkedList<Task> taskList) {
        for (Task task : taskList) {
            nodes.add(task);
            Iterator<Task> iterator = nodes.iterator();
            LinkedList<Task> newTaskList = new LinkedList<>();

            while (iterator.hasNext()) {
                Task currTask = iterator.next();

                if (currTask.getDeadline() - 1 == task.getDeadline()) {
                    newTaskList.add(currTask);
                }
            }
            taskGraph.add(newTaskList);
        }
    }

    public void finishTask(Task task) {
        if (task == null)
            return;

        task.setStatus(TaskStatus.FINISHED);

        if (tasks.contains(task)) {
            tasks.remove(task);
        }

        for (LinkedList<Task> taskList : taskGraph) {
            if (taskList.contains(task))
                taskList.remove(task);
        }
    }
}
