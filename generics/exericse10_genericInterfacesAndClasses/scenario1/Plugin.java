package generics.exericse10.scenario1;

public interface Plugin<T> {
    
    void initialize(T data);
    void execute();
}
