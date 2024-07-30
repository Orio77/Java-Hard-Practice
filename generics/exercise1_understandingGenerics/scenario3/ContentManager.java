package generics.exercise1_understandingGenerics.scenario3;

public class ContentManager<T> {
    private Storage<T> storage;

    public void setStorage(Storage<T> storage) {
        if (storage == null) {
            return;
        }
        this.storage = storage;
    }

    public boolean storeContent(T content) {
        if (content == null) {
            return false;
        }
        return storage.store(content);
    }

    public T retrieveContent(String id) {
        if (id == null || id.isEmpty())
            return null;
        
        return storage.retrieveContent(id);
    }

}
