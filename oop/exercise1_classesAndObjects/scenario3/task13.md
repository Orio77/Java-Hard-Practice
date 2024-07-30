**Advanced Inventory Management System**

- **Task 1**: Create an abstract class `InventoryItem` with methods `addStock(int quantity)` and `sellStock(int quantity)`. Implement concrete classes for different types of inventory items (e.g., `Book`, `Electronics`, `Grocery`). Each class should override `addStock()` and `sellStock()` with specific logic, including stock validation. Also, include a `restockThreshold()` method in each class with different threshold calculation logic based on the item type.
    - `Book`: Override `addStock(int quantity)` to include checks for storage space and book condition. Implement `restockThreshold()` to trigger a restock when stock falls below 20 items.
    - `Electronics`: Override `addStock(int quantity)` to validate item functionality and warranty status. Implement `restockThreshold()` to trigger a restock when stock falls below 10 items.
    - `Grocery`: Override `addStock(int quantity)` to validate item freshness and expiration date. Implement `restockThreshold()` to trigger a restock when stock falls below 50 items.
- **Task 2**: Develop an interface `DiscountPolicy` with a method `double calculateDiscount(InventoryItem item)`. Integrate this interface into your inventory items. Implement discount logic differently for each item type, simulating real-world scenarios like seasonal sales or clearance discounts.
    - `Book`: Implement `calculateDiscount(InventoryItem item)` to apply a 10% discount on books that have been in stock for more than 6 months.
    - `Electronics`: Implement `calculateDiscount(InventoryItem item)` to apply a 20% discount on electronics items that are last year's model.
    - `Grocery`: Implement `calculateDiscount(InventoryItem item)` to apply a 30% discount on grocery items that are nearing their expiration date.
- **Task 3**: Design a class `InventoryManager` that can handle multiple types of inventory items. Use a factory pattern to instantiate the appropriate `InventoryItem` based on item details. Implement a method `manageStock(ItemDetail itemDetail)` that not only adds or sells stock but also checks the restock threshold and applies discounts. Ensure the solution leverages polymorphism and demonstrates efficient and effective use of classes and objects.
    - Implement the factory pattern in `InventoryManager` to determine and instantiate the correct `InventoryItem` based on the item type specified in the `ItemDetail` object.
    - In `manageStock(ItemDetail itemDetail)`, use the appropriate `InventoryItem` to add or sell stock. Additionally, check the restock threshold using the `restockThreshold()` method and apply any discounts using the `DiscountPolicy` interface. If the stock falls below the restock threshold, trigger a restock.

**Further practise**:

1. **Advanced Stock Management – Enhanced Details**:
    
    - **Book**: Implement `isEligibleForStock(InventoryItem item)` to check if the book is not damaged and if the storage space is sufficient.
    - **Electronics**: Implement `isEligibleForStock(InventoryItem item)` to check if the electronic item is functional and if the warranty is valid.
    - **Grocery**: Implement `isEligibleForStock(InventoryItem item)` to check if the grocery item is fresh and if the expiration date is not near.
2. **Tier-Based Restock Threshold – Enhanced Details**:
    
    - **Book**: Implement `restockThreshold()` to calculate threshold based on book popularity: 20 for popular books, 10 for average books, and 5 for less popular books.
    - **Electronics**: Implement `restockThreshold()` to calculate threshold based on item demand: 10 for high demand items, 5 for average demand items, and 2 for low demand items.
    - **Grocery**: Implement `restockThreshold()` to calculate threshold based on item perishability: 50 for non-perishable items, 30 for semi-perishable items, and 10 for perishable items.
3. **Customizable Discount Policy – Enhanced Details**:
    
    - **Functionality Description**: Integrate the Strategy pattern into the `DiscountPolicy` interface. Define a `DiscountStrategy` interface with a method `applyDiscount(InventoryItem item)`.
    - **SeasonalDiscount**: Implement this strategy to apply a discount based on the season. This strategy should be used when the item is more popular in a specific season.
    - **ClearanceDiscount**: Implement this strategy to apply a discount on items that are being cleared out. This strategy should be used when the item is being discontinued.
    - **BulkDiscount**: Implement this strategy to apply a discount on items bought in bulk. This strategy should be used when the quantity of the item bought is above a certain threshold.