package generics.exercise16.scenario2;

public interface Repository<T> {
    
    public T findById(String id);
}
