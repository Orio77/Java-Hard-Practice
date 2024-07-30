**Scenario 2: Building an E-commerce Product Catalog**

**Enhanced Task 1**: Define a `Product` class with attributes such as name, price, and description. The class should have methods to get and set these attributes. The `Product` class should also have a method to display all the information about a product.

_Potential Input_:

product = Product("Laptop", 1000, "High performance laptop")

product.set_price(900)

product.get_price()

product.display_info()

_Desired Output_:

900

"Product Name: Laptop, Price: 900, Description: High performance laptop"

_Coach Suggestions_: Start by defining the `Product` class with the `__init__` method to initialize the attributes. Then, implement the getter and setter methods. Finally, create a method to display the product information.

**Enhanced Task 2**: Implement a feature to display product details to customers. This should be done through a `Catalog` class that contains a list of `Product` objects. The `Catalog` class should have methods to add a `Product` object to the list and a method to display the details of all the products in the catalog.

_Potential Input_:

catalog = Catalog()

catalog.add_product(product)

catalog.display_products()

_Desired Output_:

"Product added."

"Product Name: Laptop, Price: 900, Description: High performance laptop"

_Coach Suggestions_: Define the `Catalog` class with an attribute that is a list of `Product` objects. Then, implement the methods to add products and display their details. Remember to handle the case where there are no products in the catalog.

**Enhanced Task 3**: Create a `ShoppingCart` class to handle adding and removing products. The `ShoppingCart` class should have methods to add a `Product` object to the cart, remove a `Product` object from the cart by name, and display all the products in the cart.

_Potential Input_:

cart = ShoppingCart()

cart.add_product(product)

cart.remove_product("Laptop")

cart.display_cart()

_Desired Output_:

"Product added to cart."

"Product removed from cart."

"Your cart is empty."

_Coach Suggestions_: Create a `ShoppingCart` class with an attribute that is a list of `Product` objects. Then, implement the methods to add and remove products from the cart, and to display the products in the cart. Make sure to handle any errors that may occur, such as trying to remove a product that is not in the cart.
