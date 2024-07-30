package generics.exercise9_typeCasting.scenario3;

public class TechnicalAgent<T> implements SupportAgent<T> {

    @Override
    public String handleQuery(T Query) {
        return "Technical query handled";
    }
    
}
