**Problem: Online Shopping System**

- **Task 1**: Create an abstract class `Product` with methods `getPrice()`, `getDetails()`, and `getAvailability()`. Implement concrete classes for different types of products (e.g., `Clothing`, `Electronics`, `Books`). Each class should override these methods with specific logic, including price calculation, details retrieval, and availability checks.
    - `Clothing`: Override `getPrice()` to include any applicable discounts. Implement `getDetails()` to return product details like size, color, and material. Implement `getAvailability()` to check if the product size and color are available in stock.
    - `Electronics`: Override `getPrice()` to include any applicable taxes. Implement `getDetails()` to return product details like brand, model, and specifications. Implement `getAvailability()` to check if the product is available in stock.
    - `Books`: Override `getPrice()` to include any applicable discounts for hardcover or paperback. Implement `getDetails()` to return product details like author, title, and genre. Implement `getAvailability()` to check if the book is available in stock.
- **Task 2**: Develop an interface `Discountable` with a method `applyDiscount(double discount)`. Integrate this interface into your product classes. Implement discount application logic differently for each product type, simulating real-world scenarios like seasonal sales or clearance.
    - `Clothing`: Implement `applyDiscount(double discount)` to apply the discount to the base price of the clothing item.
    - `Electronics`: Implement `applyDiscount(double discount)` to apply the discount to the base price of the electronic item, but only if the item is not a new release (less than 1 month old).
    - `Books`: Implement `applyDiscount(double discount)` to apply the discount to the base price of the book, but only if the book is not a bestseller.
- **Task 3**: Design a class `ShoppingCart` that can handle multiple types of products. Use a factory pattern to instantiate the appropriate `Product` based on product details. Implement a method `addProduct(Product product)` that adds the product to the cart and calculates the total price. Ensure the solution leverages polymorphism and demonstrates efficient and effective use of inheritance.
    - Implement the factory pattern in `ShoppingCart` to determine and instantiate the correct `Product` based on the product type specified in the `Product` object.
    - In `addProduct(Product product)`, use the appropriate `Product` to add the product to the cart. Additionally, calculate the total price using the `getPrice()` method. If the product is not available, throw a custom exception `ProductNotAvailableException` with an appropriate message.

**Further practise**:

1. **Advanced Discount System – Enhanced Details**:
    
    - **Clothing**: Implement `applyDiscount(double discount)` to apply the discount to the base price of the clothing item, but only if the item is not a new arrival (less than 1 month old).
    - **Electronics**: Implement `applyDiscount(double discount)` to apply the discount to the base price of the electronic item, but only if the item is not a new release (less than 1 month old) and not a high-demand item (identified by a flag in the product details).
    - **Books**: Implement `applyDiscount(double discount)` to apply the discount to the base price of the book, but only if the book is not a bestseller and not a new release (less than 1 month old).
2. **Tier-Based Pricing Structure – Enhanced Details**:
    
    - **Clothing**: Implement `getPrice()` to calculate price based on the clothing item's brand: premium brands have a higher base price, while standard brands have a lower base price.
    - **Electronics**: Implement `getPrice()` to calculate price based on the electronic item's brand and model: newer models and premium brands have a higher base price.
    - **Books**: Implement `getPrice()` to calculate price based on the book's popularity: bestsellers have a higher base price, while less popular books have a lower base price.
3. **Customizable Shopping Strategy – Enhanced Details**:
    
    - **Functionality Description**: Integrate the Strategy pattern into the `ShoppingCart` class. Define a `ShoppingStrategy` interface with a method `executeStrategy(ShoppingCart cart)`.
    - **MinimizeCost**: Implement this strategy to sort the products in the cart by price in ascending order. This strategy should be used when the user wants to review the cheapest items first.
    - **MaximizeDiscount**: Implement this strategy to sort the products in the cart by discount in descending order. This strategy should be used when the user wants to review the items with the highest discounts first.
    - **PrioritizeAvailability**: Implement this strategy to sort the products in the cart by availability. This strategy should be used when the user wants to review the available items first.