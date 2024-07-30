package generics.exercise15.scenario2;

import java.util.List;

public interface Processor<T> {
    
    public void process(List<T> data);
}
