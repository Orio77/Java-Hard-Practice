**Refined Scenario:** Scenario 1: You are working on a healthcare application that manages patient records. Your task is to design a generic class to represent medical prescriptions that can be customized for different types of medications using Parameterized Types in Java.

- **Refined Sprint Tasks:**
    1. **Task Refinement:** Define a parameterized class 'Prescription' where T can be any type that represents a medication.
        - **Actionable Transparency Instructions:**
            - Implement a constructor in the 'Prescription' class that accepts an object of type T.
            - Test the 'Prescription' class with different medication types to ensure its generic nature.
    2. **Task Refinement:** Create methods within the 'Prescription' class to set dosage, medication details (using the type T), and patient information.
        - **Actionable Transparency Instructions:**
            - Implement a method to set the dosage for the medication.
            - Implement a method to set the details of the medication, ensuring it accepts an object of type T.
    3. **Task Refinement:** Ensure that the 'Prescription' class enforces type safety for medication types.
        - **Actionable Transparency Instructions:**
            - Implement a method that accepts an object of type T and checks if it is of the correct medication type.
            - Test this method with different medication types to ensure that type safety is enforced.



1. **Constructor:** The constructor in the 'Prescription' class should accept an object of type T, which represents a medication. This object should be used to initialize an instance variable of the class. This allows the creation of a 'Prescription' object for any type of medication.
    
2. **Set Dosage Method:** This method should accept a dosage amount (could be a double or integer) and set an instance variable for dosage. This allows the prescription to have a specific dosage associated with the medication.
    
3. **Set Medication Details Method:** This method should accept an object of type T, which represents a medication. It should set the details of the medication, which could include the name, manufacturer, etc. This method ensures that the 'Prescription' class can handle any type of medication.
    
4. **Check Medication Type Method:** This method should accept an object of type T and check if it is of the correct medication type. This could be done by checking the class of the object or by using a method provided by the medication class. This method ensures that the 'Prescription' class enforces type safety for medication types.