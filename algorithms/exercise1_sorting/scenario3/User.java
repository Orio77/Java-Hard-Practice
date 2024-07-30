package algorithms.exercise1_sorting.scenario3;

import java.util.ArrayList;
import java.util.Random;

public class User {
    private ArrayList<Task> toDoList;
    private String name;
    private int ID;

    public User(String name) {
        this.name = name;
        ID = name.hashCode();
        toDoList = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public ArrayList<Task> getToDoList() {
        return toDoList;
    }

    //My take
    // Check if the List is already sorted
    // Get Median of Three tasks
    // Set the median as pivot
    // Get all the elements smaller than pivot to the left and greater to the right
    // Use Quick sort recursively with updated indeces
    public void QuickSort(ArrayList<Task> toDoList, int startIndex, int endIndex)  {
        if (startIndex > endIndex)
            return;
        
        int pivot = partition(toDoList, startIndex, endIndex);
        QuickSort(toDoList, pivot + 1, endIndex);
        QuickSort(toDoList, startIndex, pivot - 1);
    }

    private int getMedianOfThree(ArrayList<Task> toDoList, int startIndex, int endIndex) {
        Task first = toDoList.get(startIndex);
        Task last = toDoList.get(endIndex);
        Task mid = toDoList.get(startIndex + (endIndex - startIndex) / 2);

        if ((first.getPriority() > last.getPriority() && first.getPriority() < mid.getPriority()) || first.getPriority() < last.getPriority() && first.getPriority() > mid.getPriority())
            return startIndex;
        else if ((last.getPriority() > first.getPriority() && last.getPriority() > mid.getPriority()) || last.getPriority() < first.getPriority() && last.getPriority() < mid.getPriority())
            return endIndex;
        else 
            return startIndex + (endIndex - startIndex) / 2;
    }

    private int partition(ArrayList<Task> toDoList, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return 0;

        int pivot = getMedianOfThree(toDoList, startIndex, endIndex);
        int i = startIndex;
        int j = endIndex;

        while (i < j) {
            while (toDoList.get(i).getPriority() < toDoList.get(pivot).getPriority()) {
                i++;
            }
            while (toDoList.get(j).getPriority() > toDoList.get(pivot).getPriority()) {
                j--;
            }

            if (i < j) {
                Task temp = toDoList.get(i);
                toDoList.set(i, toDoList.get(j));
                toDoList.set(j, temp);
                i++;
                j--;
            }
        }
        return i;
    }

    //My take
    // Check if the startIndex is greater than endIndex (base case)
    // Divide the list in halves
    // create left and right list
    // fill them with elements that are contained within the halves
    // perform mergeSort on those lists recursively
    // merge the lists into one list by copying the elements
    public void mergeSort(ArrayList<Task> toDoList, int startIndex, int endIndex ) {
        if (startIndex >= endIndex)
            return;

        int midIndex = startIndex + (endIndex - startIndex) / 2;

        mergeSort(toDoList, startIndex, midIndex);
        mergeSort(toDoList, midIndex, endIndex);
        merge(toDoList, startIndex, midIndex, endIndex);
    }

    private void merge(ArrayList<Task> toDoList, int startIndex, int midIndex, int endIndex) {
        ArrayList<Task> L = new ArrayList<>(toDoList.subList(startIndex, midIndex + 1));
        ArrayList<Task> R = new ArrayList<>(toDoList.subList(midIndex + 1, endIndex + 1));

        Task task1 = null;
        Task task2 = null;
        int i = 0;
        int j = 0;

        while (i < L.size() && j < R.size()) {
            task1 = L.get(i);
            task2 = R.get(j);

            if (task1.getPriority() > task2.getPriority())  {
                toDoList.add(task1);
                i++;
            }
            else {
                toDoList.add(task2);
                j++;
            }
        }

        while (i < L.size()) {
            toDoList.add(task1);
            i++;
        }
        while (j < R.size()) {
            toDoList.add(task2);
            j++;
        }
    }

    public void generateTasksForTests(int number) {
        Random random = new Random();

        for (int i = 0; i < number; i++) {
            toDoList.add(new Task("Task" + i, random.nextInt(100000)));
        }
    } 

    public void showTasks() {
        System.out.println(toDoList);
    }

    public void bubbleSort() {
        for (int i = 0; i < toDoList.size() - 1; i++) {
            for (int j = 0; j < toDoList.size() - 1; j++) {
                if (toDoList.get(j + 1).getPriority() > toDoList.get(j).getPriority()) {
                    Task temp = toDoList.get(j + 1);
                    toDoList.set(j, toDoList.get(j + 1));
                    toDoList.set(j + 1, temp);
                }
            }
        }
    }
}
