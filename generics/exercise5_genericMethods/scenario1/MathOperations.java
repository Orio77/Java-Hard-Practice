package generics.exercise5_genericMethods.scenario1;
// AI Helped
public class MathOperations<T extends Number> {
    
    // Here is what I wanted to do 
    // public T add(T number1, T number2) {
    //     return number1 + number1;
    // }

    public double add(T number1, T number2) {
        return number1.doubleValue() + number2.doubleValue();
    }

    public double substract(T number1, T number2) {
        return number1.doubleValue() - number2.doubleValue();
    }

    public double multiply(T number1, T number2) {
        return number1.doubleValue() * number2.doubleValue();
    }

    public double divide(T number1, T number2) {
        if (number2.doubleValue() == 0) {
            throw new IllegalArgumentException("You can not divide by 0");
        }

        return number1.doubleValue() / number2.doubleValue();
    }

    public double performOperations(String operation, T number1, T number2) {
        switch (operation) {
            case "add":
                return add(number1, number2);
            case "substract":
                return substract(number1, number2);
            case "multiply":
                return multiply(number1, number2);
            case "divide":
                return divide(number1, number2);
            default:
                return 0;
        }
    }
}
