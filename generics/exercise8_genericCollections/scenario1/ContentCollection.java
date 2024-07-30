package generics.exercise8_genericCollections.scenario1;

import java.util.ArrayList;
import java.util.List;

public class ContentCollection<T> {
    private List<T> items;

    public ContentCollection() {
        items = new ArrayList<>();
    }

    public boolean addContent(T content) {
        if (!isTypeSafe(content))
            return false;
        
        return items.add(content);
    }

    public T getContent(int index) {
        return items.get(index);
    }

    public T updateContent(T content, int index) {
        return items.set(index, content);
    }

    public boolean isTypeSafe(Object content) {
        return content.getClass().equals(items.get(0).getClass());
    }
}
