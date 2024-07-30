package generics.exercise1_understandingGenerics.scenario3;

public interface Storage<T> {
    
    public T retrieveContent(String id);
    public boolean store(T content);
}
