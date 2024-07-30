package oop.exercise13_garbageCollection.scenario1;

public class ProcessedData {
    private int newValue;

    public ProcessedData(Data data) {
        newValue = data.getValue();
    }
    public int getNewValue() {
        return newValue;
    }
    public void setNewValue(int newValue) {
        this.newValue = newValue;
    }
}
