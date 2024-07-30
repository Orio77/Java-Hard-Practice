package dataStructures.exercise7_practicalApplication.scenario2;

public class Task {
    int taskID;
    TaskStatus status;
    int deadline; // Finish by this many days

    public Task(TaskStatus status, int deadline) {
        taskID = hashCode();
        this.status = status;
        this.deadline = deadline;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    } 

    public void complete() {
        
    }
}
