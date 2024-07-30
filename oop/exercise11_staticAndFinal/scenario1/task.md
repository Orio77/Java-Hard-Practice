**Scenario x**: "Designing a MathUtils Class"

- **Task 1**: Design a `MathUtils` class with static methods for common mathematical operations.
    
    - **Enhanced Task**: Design a `MathUtils` class with static methods for common mathematical operations such as addition, subtraction, multiplication, and division. Each method should take two integer parameters and return the result of the operation. The use of `static` keyword should ensure that these methods belong to the class itself and not to any instance of the class.
    - _Potential input_: `MathUtils.add(5, 3)`
    - _Desired Output_: `8`
    - _Coach Suggestions_: Start by defining the class and the static methods. Remember, static methods can be called without creating an instance of the class.
- **Task 2**: Ensure that methods are efficient and thread-safe through static usage.
    
    - **Enhanced Task**: Ensure that the methods in `MathUtils` class are thread-safe. This means that they can be used by multiple threads at the same time without causing any issues. To achieve this, avoid using any shared mutable state in your methods.
    - _Potential input_: Multiple threads calling `MathUtils.multiply(4, 2)` at the same time.
    - _Desired Output_: Each thread should independently get the result `8`.
    - _Coach Suggestions_: Since your methods do not rely on any shared state and only use the parameters passed to them, they are inherently thread-safe. You don't need to do anything extra for this task.
- **Task 3**: Make the utility class final to prevent inheritance.
    
    - **Enhanced Task**: Make the `MathUtils` class `final` to prevent other classes from inheriting from it. This is a common practice for utility classes, as they are not meant to be extended.
    - _Potential input_: Attempt to define a class `AdvancedMathUtils` that extends `MathUtils`.
    - _Desired Output_: The Java compiler should give an error saying that you cannot inherit from a final class.
    - _Coach Suggestions_: Simply add the `final` keyword to the class definition. This will prevent any other class from extending `MathUtils`.