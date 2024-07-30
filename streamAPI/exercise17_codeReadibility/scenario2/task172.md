Task 1

Background: A manufacturing company wants to optimize its supply chain by analyzing supplier performance and material lead times. The main topic is Stream API code Readibility.

Problem: You are given a list of Suppliers. Each Supplier has a name, a list of Products they supply, and a performance rating. Each Product has a name, a lead time (in days), and a price.

Function 1: `findTopSuppliers(List<Supplier> suppliers, int topN)`: This method should return the top N suppliers sorted by their performance rating in descending order. The performance rating is a double value between 0 and 1.

Function 2: `findCheapestProductForSupplier(List<Supplier> suppliers, String supplierName)`: This method should return the cheapest product for a given supplier. If the supplier does not exist or does not supply any products, return an Optional.empty().

Example:
```java
List<Supplier> suppliers = Arrays.asList(

    new Supplier("Supplier1", Arrays.asList(new Product("Product1", 10, 100.0), new Product("Product2", 5, 200.0)), 0.9),

    new Supplier("Supplier2", Arrays.asList(new Product("Product3", 7, 150.0), new Product("Product4", 3, 250.0)), 0.8)

);

findTopSuppliers(suppliers, 1); // Returns: ["Supplier1"]

findCheapestProductForSupplier(suppliers, "Supplier1"); // Returns: Optional[Product1]
```
Task 2

Background: Same as above. The main topic is Stream API code Readibility and the drawn topic is "Stream Performance".

Problem: You are given a list of Suppliers. Each Supplier has a name, a list of Products they supply, and a performance rating. Each Product has a name, a lead time (in days), and a price.

Function 1: `findFastestSuppliers(List<Supplier> suppliers, int topN)`: This method should return the top N suppliers sorted by the average lead time of their products in ascending order.

Function 2: `findMostExpensiveProductForSupplier(List<Supplier> suppliers, String supplierName)`: This method should return the most expensive product for a given supplier. If the supplier does not exist or does not supply any products, return an Optional.empty().

Example:
```java
List<Supplier> suppliers = Arrays.asList(

    new Supplier("Supplier1", Arrays.asList(new Product("Product1", 10, 100.0), new Product("Product2", 5, 200.0)), 0.9),

    new Supplier("Supplier2", Arrays.asList(new Product("Product3", 7, 150.0), new Product("Product4", 3, 250.0)), 0.8)

);

findFastestSuppliers(suppliers, 1); // Returns: ["Supplier2"]

findMostExpensiveProductForSupplier(suppliers, "Supplier2"); // Returns: Optional[Product4]

Please note that the tasks are designed to be solved using Stream API and require a deep understanding of it. The tasks are not simple filter and map operations and require the creation of a complex pipeline.
```
Task 3

Background: Same as above. The main topic is Stream API code Readibility and the drawn topic is "Parallel Stream".

Problem: You are given a list of Suppliers. Each Supplier has a name, a list of Products they supply, and a performance rating. Each Product has a name, a lead time (in days), and a price.

Function 1: `findParallelTopSuppliers(List<Supplier> suppliers, int topN)`: This method should return the top N suppliers sorted by their performance rating in descending order. The computation should be done in parallel using parallel streams.

Function 2: `findParallelCheapestProductForSupplier(List<Supplier> suppliers, String supplierName)`: This method should return the cheapest product for a given supplier. The computation should be done in parallel using parallel streams. If the supplier does not exist or does not supply any products, return an Optional.empty().

Example:
```java
List<Supplier> suppliers = Arrays.asList(

    new Supplier("Supplier1", Arrays.asList(new Product("Product1", 10, 100.0), new Product("Product2", 5, 200.0)), 0.9),

    new Supplier("Supplier2", Arrays.asList(new Product("Product3", 7, 150.0), new Product("Product4", 3, 250.0)), 0.8)

);

findParallelTopSuppliers(suppliers, 1); // Returns: ["Supplier1"]

findParallelCheapestProductForSupplier(suppliers, "Supplier1"); // Returns: Optional[Product1]
```
Task 4

Background: Same as above. The main topic is Stream API code Readibility and the drawn topic is "Stream API with Data Structures".

Problem: You are given a list of Suppliers. Each Supplier has a name, a list of Products they supply, and a performance rating. Each Product has a name, a lead time (in days), and a price.

Function 1: `findSupplierWithMostProducts(List<Supplier> suppliers)`: This method should return the supplier who supplies the most number of products. If there are multiple suppliers with the same number of products, return any one of them.

Function 2: `findSupplierWithLeastExpensiveProduct(List<Supplier> suppliers)`: This method should return the supplier who supplies the least expensive product. If there are multiple suppliers with the same least expensive product, return any one of them.

Function 3: `findSupplierWithFastestProduct(List<Supplier> suppliers)`: This method should return the supplier who supplies the product with the least lead time. If there are multiple suppliers with the same least lead time product, return any one of them.

Example:
```java
List<Supplier> suppliers = Arrays.asList(

    new Supplier("Supplier1", Arrays.asList(new Product("Product1", 10, 100.0), new Product("Product2", 5, 200.0)), 0.9),

    new Supplier("Supplier2", Arrays.asList(new Product("Product3", 7, 150.0), new Product("Product4", 3, 250.0)), 0.8)

);

findSupplierWithMostProducts(suppliers); // Returns: "Supplier1"

findSupplierWithLeastExpensiveProduct(suppliers); // Returns: "Supplier1"

findSupplierWithFastestProduct(suppliers); // Returns: "Supplier2"