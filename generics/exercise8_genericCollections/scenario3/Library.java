package generics.exercise8_genericCollections.scenario3;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Library<T extends Media> {
    private List<T> items;

    public boolean addItem(T media) {
        return items.add(media);
    }

    public boolean removeItem(T media) {
        return items.remove(media);
    }

    public List<T> getMediaItems(Class<T> type) {
        return Collections.unmodifiableList(items);
    }

    public void sortMediaItems() {
        items.sort(Comparator.comparing(i -> i.getTitle()));
    }

    
}
