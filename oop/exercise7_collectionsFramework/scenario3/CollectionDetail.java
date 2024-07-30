package oop.exercise7_collectionsFramework.scenario3;

public class CollectionDetail {
    private String operation;
    private int index;

    public CollectionDetail(String operation) {
        this.operation = operation;
    }

    public CollectionDetail(String operation, int index) {
        this(operation);
        this.index = index;
    }

    public String getOperation() {
        return operation;
    }
    public int getIndex() {
        return index;
    }
}
