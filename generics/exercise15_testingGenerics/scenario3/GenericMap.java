package generics.exercise15_testingGenerics.scenario3;

import java.util.Map;

public class GenericMap<K, V> {
    private Map<K, V> items;

    public V put(K key, V value) {
        return items.put(key, value);
    }

    public V get(K key) {
        return items.get(key);
    }

    public int size() {
        return items.size();
    }

    public void setItems(Map<K, V> items) {
        this.items = items;
    }
}
