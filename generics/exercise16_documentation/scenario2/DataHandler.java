package generics.exercise16.scenario2;

import java.util.HashMap;
import java.util.Map;

public class DataHandler<T> {
    private Map<String, T> data;

    public DataHandler() {
        data = new HashMap<>();
    }

    public void save(T data) {
        this.data.put(Integer.toString(data.hashCode()), data);
    }

    public T load(String id) {
        return data.get(id);
    }
}
