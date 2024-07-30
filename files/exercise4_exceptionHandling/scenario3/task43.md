## Task 1

You are to implement two methods, `readInventoryFile` and `updateInventoryFile`.

The `readInventoryFile` method should read a file that contains inventory data. Each line of the file contains a product ID, product name, and quantity, separated by commas. The method should handle any exceptions that occur during file reading, such as `FileNotFoundException` and `IOException`. If an exception occurs, the method should print an error message and return an empty list. If the file is read successfully, the method should return a list of product objects.

The `updateInventoryFile` method should take a list of product objects and a file path as input. It should write the product data to the file, with each product on a new line. The method should handle any exceptions that occur during file writing, such as `FileNotFoundException` and `IOException`. If an exception occurs, the method should print an error message and return false. If the file is updated successfully, the method should return true.

Example Input:

readInventoryFile("inventory.txt")

updateInventoryFile(products, "inventory.txt")

Example Output:

[Product(id=1, name="Product A", quantity=100), Product(id=2, name="Product B", quantity=200)]

true

## Task 2

Drawn Topic: File Permissions

You are to implement two methods, `checkFilePermission` and `changeFilePermission`.

The `checkFilePermission` method should take a file path as input and return the current permissions of the file. It should handle any exceptions that occur during this operation, such as `FileNotFoundException` and `SecurityException`. If an exception occurs, the method should print an error message and return an empty string.

The `changeFilePermission` method should take a file path and a permission string as input. It should change the permissions of the file to the provided permission string. The method should handle any exceptions that occur during this operation, such as `FileNotFoundException` and `SecurityException`. If an exception occurs, the method should print an error message and return false. If the permissions are changed successfully, the method should return true.

Example Input:

checkFilePermission("inventory.txt")

changeFilePermission("inventory.txt", "rw")

Example Output:

"r"

true

## Task 3

Drawn Topic: File Handling with Data Structures

You are to implement two methods, `readInventoryFileToMap` and `updateInventoryFileFromMap`.

The `readInventoryFileToMap` method should read a file that contains inventory data and store the data in a map. The key of the map should be the product ID and the value should be the product object. The method should handle any exceptions that occur during file reading, such as `FileNotFoundException` and `IOException`. If an exception occurs, the method should print an error message and return an empty map.

The `updateInventoryFileFromMap` method should take a map of product objects and a file path as input. It should write the product data to the file, with each product on a new line. The method should handle any exceptions that occur during file writing, such as `FileNotFoundException` and `IOException`. If an exception occurs, the method should print an error message and return false. If the file is updated successfully, the method should return true.

Example Input:

readInventoryFileToMap("inventory.txt")

updateInventoryFileFromMap(products, "inventory.txt")

Example Output:

{1=Product(id=1, name="Product A", quantity=100), 2=Product(id=2, name="Product B", quantity=200)}

true

## Task 4

Drawn Topic: File Performance

You are to implement three methods, `readLargeInventoryFile`, `updateLargeInventoryFile`, and `searchProductInLargeInventoryFile`.

The `readLargeInventoryFile` method should read a large file that contains inventory data. The method should handle any exceptions that occur during file reading, such as `FileNotFoundException` and `IOException`. If an exception occurs, the method should print an error message and return an empty list. If the file is read successfully, the method should return a list of product objects.

The `updateLargeInventoryFile` method should take a list of product objects and a file path as input. It should write the product data to the file, with each product on a new line. The method should handle any exceptions that occur during file writing, such as `FileNotFoundException` and `IOException`. If an exception occurs, the method should print an error message and return false. If the file is updated successfully, the method should return true.

The `searchProductInLargeInventoryFile` method should take a product ID and a file path as input. It should search for the product in the file and return the product object if found. The method should handle any exceptions that occur during file reading, such as `FileNotFoundException` and `IOException`. If an exception occurs, the method should print an error message and return null. If the product is found, the method should return the product object.

Example Input:

readLargeInventoryFile("large_inventory.txt")

updateLargeInventoryFile(products, "large_inventory.txt")

searchProductInLargeInventoryFile(1, "large_inventory.txt")

Example Output:

[Product(id=1, name="Product A", quantity=100), Product(id=2, name="Product B", quantity=200)]

true

Product(id=1, name="Product A", quantity=100)