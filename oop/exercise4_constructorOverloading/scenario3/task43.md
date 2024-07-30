**Advanced Customer Management System**

- **Task 1**: Create a class `Customer` with overloaded constructors. The constructors should allow creating a `Customer` object with different sets of parameters, providing flexibility in specifying customer details.
    
    - `Customer()`: A default constructor that initializes a new `Customer` with default values.
    - `Customer(String name)`: A constructor that initializes a new `Customer` with a specified name and other default values.
    - `Customer(String name, String address)`: A constructor that initializes a new `Customer` with a specified name and address, and other default values.
    - `Customer(String name, String address, String phoneNumber)`: A constructor that initializes a new `Customer` with a specified name, address, and phone number.
- **Task 2**: Implement methods `getName()`, `getAddress()`, and `getPhoneNumber()` to return the respective details of the `Customer`. Also, implement methods `setName(String name)`, `setAddress(String address)`, and `setPhoneNumber(String phoneNumber)` to set the respective details of the `Customer`.
    
- **Task 3**: Design a class `CustomerManager` that can handle multiple `Customer` objects. Implement a method `manageCustomer(CustomerDetail customerDetail)` that creates a new `Customer` object using the appropriate constructor based on the provided `CustomerDetail`. It should also be able to update the details of a `Customer` using the setter methods.
    
    - In `manageCustomer(CustomerDetail customerDetail)`, determine the appropriate `Customer` constructor to use based on the details provided in the `CustomerDetail` object. Create a new `Customer` object using the selected constructor.
    - If the `CustomerDetail` object includes updates to the customer's details, use the appropriate setter methods in the `Customer` class to update the customer's details.

**Further practise**:

1. **Advanced Customer Management – Enhanced Details**:
    
    - Implement `isEligibleForDiscount(Customer customer)` to check if the customer is eligible for a discount based on their details (e.g., address, phone number).
2. **Tier-Based Discount Calculation – Enhanced Details**:
    
    - Implement `calculateDiscount(Customer customer)` to calculate the discount for a customer based on their details. For example, customers from certain addresses or with certain phone numbers may receive different discounts.
3. **Customizable Discount Policy – Enhanced Details**:
    
    - **Functionality Description**: Integrate the Strategy pattern into the discount calculation. Define a `DiscountStrategy` interface with a method `calculateDiscount(Customer customer)`.
    - **LocationBasedDiscount**: Implement this strategy to calculate discounts based on the customer's address. This strategy should be used when the discount depends on the customer's location.
    - **LoyaltyBasedDiscount**: Implement this strategy to calculate discounts based on the customer's purchase history. This strategy should be used when the discount depends on the customer's loyalty.
    - **PromotionBasedDiscount**: Implement this strategy to calculate discounts based on current promotions. This strategy should be used when the discount depends on ongoing promotions.