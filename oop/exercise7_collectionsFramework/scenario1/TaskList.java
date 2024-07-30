package oop.exercise7_collectionsFramework.scenario1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TaskList {
    ArrayList<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<>();
    }

    public boolean addTask(Task task) {
        return taskList.add(task);
    }

    public boolean removeTask(Task task) {
        return taskList.remove(task);
    }

    public Task getTask(int index) {
        return taskList.get(index);
    }

    public void sortTask(Comparator<Task> comparator) {
        taskList.sort(comparator);
    }

    public List<Task> filterTask(Predicate<Task> predicate) {
        return taskList.stream().filter(predicate).collect(Collectors.toList());
    }
}
