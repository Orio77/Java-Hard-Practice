package streamAPI.exercise2_lambdaExpressions.scenario1;

import java.util.List;

@FunctionalInterface
public interface Sort {
    
    public abstract void sort(List<String> strings);
}
