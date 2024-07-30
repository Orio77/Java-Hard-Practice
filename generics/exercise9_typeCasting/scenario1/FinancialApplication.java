package generics.exercise9_typeCasting.scenario1;

public class FinancialApplication<T extends Number> {
    private T type;

    public double castToDouble(T data) {
        return data.doubleValue();
    }

    public boolean isValidType(Object userInput) {
        if (userInput.getClass().equals(type.getClass()))
            return true;
        
        return false;
    }

    public void handleTypeMismatch() throws TypeMismatchException{
        throw new TypeMismatchException("Can not cast this number");
    }
    
}