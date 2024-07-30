package generics.exercise9_typeCasting.scenario3;

public class GeneralAgent<T> implements SupportAgent<T>{

    @Override
    public String handleQuery(T Query) {
        return "General query handled";
    }
    
}
