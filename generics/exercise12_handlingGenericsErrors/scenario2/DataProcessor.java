package generics.exercise12.scenario2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DataProcessor<T> {
    private Class<T> type;
    private Stack<Error> errorHistory;
    private List<T> savedData;

    public DataProcessor() {
        errorHistory = new Stack<>();
        savedData = new ArrayList<>();
    }

    public void processData(T data) throws TypeMismatchException{
        if (data == null) {
            return;
        }
        if (data.getClass().equals(type)) {
            System.out.println("Processed data of type: " + data.getClass());
        }
        else 
            throw new TypeMismatchException("Provided data type: " + data.getClass() +
                                            "\nExpected data type: " + type);
    }

    public void handleTypeMismatchException(TypeMismatchException e) {
        System.out.println(e.getMessage());
        System.out.println(e.getStackTrace());
    }

    public void logError(Error e) {
        errorHistory.push(e);
    }

    public void notifyError(Error e) {
        System.out.println("ERROR OCCURED");
        System.out.println("Starting the notification process");
        // notifying all the parts necessary
        System.out.println("Notification process completed successfully");
    }

    public void recoverFromError(Error e, T data) {
        notifyError(e);
        savedData.add(data);
        logError(e);
    }

    public Stack<Error> getErrorHistory() {
        return errorHistory;
    }
    public List<T> getSavedData() {
        return Collections.unmodifiableList(savedData);
    }
    public Class<T> getType() {
        return type;
    }
}
