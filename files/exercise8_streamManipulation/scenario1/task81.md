Task 1

Problem: Implement a class `ProductCatalog` that manages a product catalog for an e-commerce platform. The class should have two methods:

1. `addProduct(String productId, String productDetails)`: This method should add a new product to the catalog. The product details should be written to a file named `productId.txt`. If the file already exists, append the product details to the existing file. Handle any IO exceptions that may occur.
    
2. `getProduct(String productId)`: This method should read the product details from the file `productId.txt` and return them as a string. If the file does not exist, return an empty string. Handle any IO exceptions that may occur.
    

Example:

ProductCatalog catalog = new ProductCatalog();

catalog.addProduct("123", "Product details for 123");

String details = catalog.getProduct("123"); // returns "Product details for 123"

Task 2

Topic: File Permissions

Problem: Extend the `ProductCatalog` class with two methods that deal with file permissions:

1. `makeProductPrivate(String productId)`: This method should change the permissions of the file `productId.txt` so that only the owner can read and write to it. If the file does not exist, create it.
    
2. `makeProductPublic(String productId)`: This method should change the permissions of the file `productId.txt` so that everyone can read it, but only the owner can write to it. If the file does not exist, create it.
    

Example:

ProductCatalog catalog = new ProductCatalog();

catalog.makeProductPrivate("123");

catalog.makeProductPublic("123");

Task 3

Topic: File Performance

Problem: Improve the performance of the `ProductCatalog` class by implementing buffering in the `addProduct` and `getProduct` methods. Use a `BufferedWriter` in the `addProduct` method and a `BufferedReader` in the `getProduct` method.

Example:

ProductCatalog catalog = new ProductCatalog();

catalog.addProduct("123", "Product details for 123");

String details = catalog.getProduct("123"); // returns "Product details for 123"

Task 4

Topic: File Handling with Data Structures

Problem: Extend the `ProductCatalog` class with a method that uses a data structure to improve the performance of the catalog:

1. `getProducts()`: This method should return a list of all product IDs in the catalog. The list should be obtained by reading the names of all files in the catalog directory. Use a `File` object to get the names of the files.
    
2. `deleteProduct(String productId)`: This method should delete the file `productId.txt` from the catalog. If the file does not exist, do nothing.
    
3. `updateProduct(String productId, String newDetails)`: This method should update the details of a product in the catalog. It should overwrite the existing details in the file `productId.txt` with `newDetails`.
    

Example:

ProductCatalog catalog = new ProductCatalog();

catalog.addProduct("123", "Product details for 123");

catalog.addProduct("456", "Product details for 456");

List<String> products = catalog.getProducts(); // returns ["123", "456"]

catalog.deleteProduct("123");

products = catalog.getProducts(); // returns ["456"]

catalog.updateProduct("456", "Updated product details for 456");

String details = catalog.getProduct("456"); // returns "Updated product details for 456"