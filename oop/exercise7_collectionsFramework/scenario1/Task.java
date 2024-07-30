package oop.exercise7_collectionsFramework.scenario1;

public class Task {
    private String title;
    private String description;
    private int dueDate;
    private int priority;

    public Task(String title, String description, int dueDate, int priority) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public int getDueDate() {
        return dueDate;
    }

    public int getPriority() {
        return priority;
    }

    public String getTitle() {
        return title;
    }
}
