package generics.exercise16.scenario2;

import java.io.Serializable;

public class DataRepository<T extends Serializable> implements Repository<T> {
    private DataHandler<T> handler;

    public DataRepository() {
        handler = new DataHandler<>();
    }

    @Override
    public T findById(String id) {
        return handler.load(id);
    }

    public void save(T data) {
        handler.save(data);
    }
}
