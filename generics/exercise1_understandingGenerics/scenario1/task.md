**Refined Scenario:** Scenario 1: You are tasked with developing a data processing module for a finance application. The module needs to handle various types of financial instruments (e.g., Stocks, Bonds, Options) using Generics in Java.

- **Refined Sprint Tasks:**
    1. **Task Refinement:** Define a generic class 'FinancialInstrument' where T can be any type that represents a financial instrument (e.g., Stocks, Bonds, Options).
        - **Actionable Transparency Instructions:**
            - Implement methods to get and set the financial instrument's data in the 'FinancialInstrument' class.
            - Test the 'FinancialInstrument' class with different financial instrument types to ensure its generic nature.
    2. **Task Refinement:** Create methods within the 'FinancialInstrument' class to process and analyze different types of financial data. Ensure these methods can handle any type T.
        - **Actionable Transparency Instructions:**
            - Implement a method to calculate the return on investment (ROI) for the financial instrument.
            - Implement a method to calculate the risk associated with the financial instrument.
    3. **Task Refinement:** Implement type-specific behavior for each financial instrument by creating specific classes (e.g., 'Stocks', 'Bonds', 'Options') that extend the 'FinancialInstrument' class.
        - **Actionable Transparency Instructions:**
            - For each specific financial instrument class, override the methods from 'FinancialInstrument' to provide type-specific calculations for ROI and risk.
            - Test these specific classes to ensure they correctly calculate ROI and risk based on their specific type.




1. **Get and Set Methods:** These methods should be used to get and set the data of the financial instrument. The set method should accept an object of type T, which represents a financial instrument, and set an instance variable. The get method should return the current value of this instance variable.
    
2. **Calculate ROI Method:** This method should calculate the Return on Investment (ROI) for the financial instrument. The calculation could be based on the price of the instrument at the time of purchase and its current price. This method should return the calculated ROI.
    
3. **Calculate Risk Method:** This method should calculate the risk associated with the financial instrument. The calculation could be based on the volatility of the instrument's price. This method should return the calculated risk.
    
4. **Type-Specific ROI and Risk Calculation Methods:** These methods should be implemented in the specific financial instrument classes (e.g., 'Stocks', 'Bonds', 'Options') that extend the 'FinancialInstrument' class. They should override the ROI and risk calculation methods from 'FinancialInstrument' to provide calculations specific to each type of financial instrument.