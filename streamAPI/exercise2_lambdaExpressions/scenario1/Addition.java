package streamAPI.exercise2_lambdaExpressions.scenario1;

import java.util.function.BiFunction;

@FunctionalInterface
public interface Addition {
    
    public abstract int add(int a, int b, BiFunction<Integer, Integer, Integer> adder);
}
