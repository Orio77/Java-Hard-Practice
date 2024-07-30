**Advanced Shopping Cart System**

- **Task 1**: Create a class `Product` with properties `name` and `price`. Implement a constructor that sets these properties.
- **Task 2**: Create a class `ShoppingCart` with a property `items` (a list of `Product` objects). Implement methods `addItem(Product product)` and `totalPrice()` that add a product to the cart and calculate the total price of all items in the cart, respectively.
- **Task 3**: Create a class `User` with properties `name` and `cart` (a `ShoppingCart` object). Implement a constructor that sets the `name` property and initializes `cart` as an empty `ShoppingCart`. Implement methods `addToCart(Product product)` and `checkout()` that add a product to the user's cart and calculate the total price of the cart, respectively.

**Further practise**:

1. **Advanced Shopping Cart System – Enhanced Details**:
    - **Product**: Extend the `Product` class to include a `stock` property that represents the number of items in stock. Implement a method `reduceStock(int quantity)` that reduces the stock by a certain quantity.
    - **ShoppingCart**: Extend the `ShoppingCart` class to include a method `removeItem(Product product)` that removes a product from the cart.
2. **Shopping Cart System with Discounts – Enhanced Details**:
    - **Discount**: Create a class `Discount` with properties `product` (a `Product` object) and `percentage`. Implement a method `apply(Product product)` that reduces the price of a product by the discount percentage.
    - **User**: Extend the `User` class to include a method `applyDiscount(Discount discount)` that applies a discount to all matching products in the user's cart.
3. **Customizable Shopping Cart System – Enhanced Details**:
    - **ShoppingCartSystem**: Create an interface `ShoppingCartSystem` with methods `addItem(Product product)`, `totalPrice()`, `removeItem(Product product)`, and `applyDiscount(Discount discount)`. Make `ShoppingCart` a class that implements this interface.
    - **User**: Extend the `User` class to include a method `emptyCart()` that removes all items from the user's cart.