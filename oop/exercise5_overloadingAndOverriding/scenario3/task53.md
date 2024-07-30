**Advanced Calculator System**

- **Task 1**: Create a class `Calculator` with overloaded methods for `add()`, `subtract()`, `multiply()`, and `divide()`. The methods should allow performing operations on different types of numbers (e.g., `int`, `double`), providing flexibility in performing calculations.
    
    - `add(int a, int b)`, `add(double a, double b)`: Methods that add two numbers of the same type and return the result.
    - `subtract(int a, int b)`, `subtract(double a, double b)`: Methods that subtract two numbers of the same type and return the result.
    - `multiply(int a, int b)`, `multiply(double a, double b)`: Methods that multiply two numbers of the same type and return the result.
    - `divide(int a, int b)`, `divide(double a, double b)`: Methods that divide two numbers of the same type and return the result.
- **Task 2**: Create a class `AdvancedCalculator` that extends `Calculator` and overrides the `add()`, `subtract()`, `multiply()`, and `divide()` methods. The overridden methods should include additional logic, such as validation checks and support for more number types.
    
    - `add(int a, int b, int c)`, `add(double a, double b, double c)`: Overridden methods that add three numbers of the same type and return the result.
    - `subtract(int a, int b, int c)`, `subtract(double a, double b, double c)`: Overridden methods that subtract three numbers of the same type and return the result.
    - `multiply(int a, int b, int c)`, `multiply(double a, double b, double c)`: Overridden methods that multiply three numbers of the same type and return the result.
    - `divide(int a, int b, int c)`, `divide(double a, double b, double c)`: Overridden methods that divide three numbers of the same type and return the result.
- **Task 3**: Design a class `CalculatorManager` that can handle both `Calculator` and `AdvancedCalculator` objects. Implement a method `manageCalculator(CalculatorDetail calculatorDetail)` that performs calculations using the appropriate calculator based on the provided `CalculatorDetail`.
    
    - In `manageCalculator(CalculatorDetail calculatorDetail)`, determine whether to use a `Calculator` or an `AdvancedCalculator` based on the details provided in the `CalculatorDetail` object. Perform the appropriate calculation using the selected calculator.

**Further practise**:

1. **Advanced Calculator Management – Enhanced Details**:
    
    - Implement `isEligibleForAdvancedCalculations(Calculator calculator)` to check if the calculator is eligible for advanced calculations based on its details (e.g., number of inputs, types of inputs).
2. **Tier-Based Calculation Logic – Enhanced Details**:
    
    - Implement different calculation logic for different tiers of calculators. For example, basic calculators may only support addition, subtraction, multiplication, and division, while advanced calculators may also support operations like exponentiation and root extraction.
3. **Customizable Calculation Policy – Enhanced Details**:
    
    - **Functionality Description**: Integrate the Strategy pattern into the calculation logic. Define a `CalculationStrategy` interface with a method `calculate(Calculator calculator)`.
    - **BasicCalculation**: Implement this strategy to perform basic calculations (addition, subtraction, multiplication, division). This strategy should be used when the calculator is a basic calculator.
    - **AdvancedCalculation**: Implement this strategy to perform advanced calculations (exponentiation, root extraction, etc.). This strategy should be used when the calculator is an advanced calculator.