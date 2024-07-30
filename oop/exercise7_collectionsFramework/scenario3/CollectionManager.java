package oop.exercise7_collectionsFramework.scenario3;

import java.util.ArrayList;
import java.util.List;

public class CollectionManager {
    private List<Object> collection; // example collection

    public CollectionManager() {
        collection = new ArrayList<>();
    }
    
    public boolean add(Object item) {
        return collection.add(item);
    }

    public boolean remove(Object item) {
        return collection.remove(item);
    }

    public Object find(int index) {
        return collection.get(index);
    }

    public Object clear() {
        this.collection = new ArrayList<>();
        return null;
    }

    public List<Object> getCollection() {
        return collection;
    }

    public Object manageCollection(CollectionDetail detail, Object item) {
        switch (detail.getOperation()) {
            case "add":
                add(item);
                break;
            case "remove":
                remove(item);
                break;
            case "find":
                return find(detail.getIndex());
            case "clear":
                clear();
                break;
            default:
                break;
        }
        return null;
    }
}
