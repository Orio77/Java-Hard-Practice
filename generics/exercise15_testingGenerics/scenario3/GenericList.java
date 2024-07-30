package generics.exercise15_testingGenerics.scenario3;

import java.util.List;

public class GenericList<T> {
    private List<T> items;
    
    public boolean add(T item) {
        return items.add(item);
    }

    public boolean remove(T item) {
        return items.remove(item);
    }

    public int size() {
        return items.size();
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
