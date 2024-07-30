package generics.exercise9_typeCasting.scenario3;

public class BillingAgent<T> implements SupportAgent<T> {

    @Override
    public String handleQuery(T Query) {
        return "Billing query handled";
    }
    
}
