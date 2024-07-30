package algorithms.exercise1_sorting.scenario3;

public class ToDoListsDemo {
    public static void main(String[] args) {
        User user = new User("user1");

        
        user.generateTasksForTests(100);
        user.showTasks();
        user.mergeSort(user.getToDoList(), 0, user.getToDoList().size() - 1);
        user.showTasks();
    }
}
