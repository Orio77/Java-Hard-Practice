package generics.exercise2_parameterizedTypes.scenario2;

import java.util.ArrayList;
import java.util.List;

public class ItemProcessor<T extends Property> {
    private List<Item<T>> items;

    public ItemProcessor() {
        items = new ArrayList<>();
    }

    public void process(T property) {
        if (!property.isValid()) {
            throw new IllegalArgumentException("Invalid property");
        }
        for (Item<T> item : items) {
            System.out.println(item.queryItem());
        } 
    }

    public List<Item<T>> getItems() {
        return items;
    }
}
