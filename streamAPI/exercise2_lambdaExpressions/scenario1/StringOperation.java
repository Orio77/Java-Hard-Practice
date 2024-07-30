package streamAPI.exercise2_lambdaExpressions.scenario1;

@FunctionalInterface
public interface StringOperation {
    
    public abstract String applyStringOperation(String str, StringOperation operation);
}
