package generics.exercise1_understandingGenerics.scenario3;

import java.util.HashMap;
import java.util.Map;

public class ContentStorage<T extends Content<?>> implements Storage<T>{
    private Map<String, T> storage;

    public ContentStorage() {
        storage = new HashMap<>();
    }

    @Override
    public boolean store(T content) {
        if (storage.containsValue(content))
            return false;

        storage.put(Integer.toString(content.hashCode()), content);
        return true;
    }

    public Map<String, T> getStorage() {
        return storage;
    }

    @Override
    public T retrieveContent(String id) {
        return storage.get(id);
    }
}
