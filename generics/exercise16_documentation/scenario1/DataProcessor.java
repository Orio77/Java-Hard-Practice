package generics.exercise16.scenario1;

import java.util.ArrayList;
import java.util.List;
/**
 * A generic class that processes any type of Number (Integer, Float, Double, etc.).
 * It contains all the data inside of a list. The class provides a funcionality to calculate the sum of all elements.
 * It's capable of providing the sum of all the elements.
 * 
 * @param <T> the type of data to be processed, which must be a subtype of Number
 */
                                                                                            // AI Helped
                                                                                            // I forgot about <T> param in class desxription
public class DataProcessor<T extends Number> {
    /**
     * A list that holds the data to work with
     */
    private List<T> data;

    /**
     * A constructor that creates an ArrayList object, when called
     */
    public DataProcessor() {
        this.data = new ArrayList<>();
    }

    /**
     * Adds data to the list
     * 
     * @param data the item to be added, which must be a subtype of Number
     */
    public void addData(T data) {
        this.data.add(data);
    }

    /**
     * Prints all the elements on the terminal
     */
    public void processData() {
        for (T item : data) {
            System.out.println(item);
        }
    }

    /**
     * Calculates and returns the sum of all items in the list
     * 
     * @return the sum of all elemnts inside of the list
     */
    public double calculateSum() {
        double sum = 0;
        for (T item : data) {
            sum += item.doubleValue();
        }
        return sum;
    }
}
