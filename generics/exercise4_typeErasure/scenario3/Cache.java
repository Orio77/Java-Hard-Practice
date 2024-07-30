package generics.exercise4_typeErasure.scenario3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class Cache<K, V> {
    private Map<K, V> cache;

    public Cache() {
        cache = new HashMap<>();
    }

    public V put(K key, V value) {
        if (key == null || value == null)
            return null;
        
        return cache.put(key, value);
    }

    public V get(K key) {
        if (key == null)
            return null;

        return cache.get(key);
    }

    public Map<K, V> getAll(Set<? extends K> keys) {
        Map<K, V> returnMap = new HashMap<>();

        for (K k : keys) {
            if (cache.containsKey(k)) {
                returnMap.put(k, cache.get(k));
            }
        }

        return returnMap;
    }

    public Map<K, V> match(Predicate<? super V> predicate) {
        Map<K, V> returnMap = new HashMap<>();

        // AI Helped
        for (Map.Entry<K, V> entry : cache.entrySet()) {
            if (predicate.test(entry.getValue())) {
                returnMap.put(entry.getKey(), entry.getValue());
            }
        }

        return returnMap;
    }
}
