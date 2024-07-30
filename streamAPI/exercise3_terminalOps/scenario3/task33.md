## Task 1

You are given a list of `Product` objects. Each `Product` has a `name`, `category`, `price`, and `rating`. Your task is to implement two methods:

1. `findTopRatedProducts(List<Product> products, int n)`: This method should return a list of top `n` products sorted by rating in descending order. If two products have the same rating, sort them by price in ascending order. Use Stream API's `sorted` and `limit` operations.
    
2. `findCheapestProductsInCategory(List<Product> products, String category, int n)`: This method should return the cheapest `n` products in a given category. If two products have the same price, sort them by rating in descending order. Use Stream API's `filter`, `sorted`, and `limit` operations.
    

Example: Input:

List<Product> products = Arrays.asList(

    new Product("Product1", "Electronics", 100.0, 4.3),

    new Product("Product2", "Electronics", 200.0, 4.5),

    new Product("Product3", "Books", 50.0, 4.1),

    new Product("Product4", "Books", 30.0, 4.0),

    new Product("Product5", "Electronics", 150.0, 4.4)

);

findTopRatedProducts(products, 3);

findCheapestProductsInCategory(products, "Electronics", 2);

Output:

[Product{name='Product2', category='Electronics', price=200.0, rating=4.5}, Product{name='Product5', category='Electronics', price=150.0, rating=4.4}, Product{name='Product1', category='Electronics', price=100.0, rating=4.3}]

[Product{name='Product1', category='Electronics', price=100.0, rating=4.3}, Product{name='Product5', category='Electronics', price=150.0, rating=4.4}]

## Task 2

Topic: Stream API with Data Structures

You are given a `Map<String, List<Product>>` where the key is a category and the value is a list of products in that category. Implement two methods:

1. `findMostExpensiveProductInEachCategory(Map<String, List<Product>> products)`: This method should return a map where the key is the category and the value is the most expensive product in that category. Use Stream API's `collect`, `max`, and `Comparator.comparing` operations.
    
2. `findLeastRatedProductInEachCategory(Map<String, List<Product>> products)`: This method should return a map where the key is the category and the value is the product with the lowest rating in that category. Use Stream API's `collect`, `min`, and `Comparator.comparing` operations.
    

Example: Input:

Map<String, List<Product>> products = new HashMap<>();

products.put("Electronics", Arrays.asList(

    new Product("Product1", "Electronics", 100.0, 4.3),

    new Product("Product2", "Electronics", 200.0, 4.5),

    new Product("Product5", "Electronics", 150.0, 4.4)

));

products.put("Books", Arrays.asList(

    new Product("Product3", "Books", 50.0, 4.1),

    new Product("Product4", "Books", 30.0, 4.0)

));

findMostExpensiveProductInEachCategory(products);

findLeastRatedProductInEachCategory(products);

Output:

{Electronics=Product{name='Product2', category='Electronics', price=200.0, rating=4.5}, Books=Product{name='Product3', category='Books', price=50.0, rating=4.1}}

{Electronics=Product{name='Product1', category='Electronics', price=100.0, rating=4.3}, Books=Product{name='Product4', category='Books', price=30.0, rating=4.0}}

## Task 3

Topic: Stream Performance

You are given a list of `Product` objects. Each `Product` has a `name`, `category`, `price`, and `rating`. Your task is to implement two methods:

1. `findTopRatedProductsParallel(List<Product> products, int n)`: This method should return a list of top `n` products sorted by rating in descending order. If two products have the same rating, sort them by price in ascending order. Use Stream API's `parallelStream`, `sorted`, and `limit` operations.
    
2. `findCheapestProductsInCategoryParallel(List<Product> products, String category, int n)`: This method should return the cheapest `n` products in a given category. If two products have the same price, sort them by rating in descending order. Use Stream API's `parallelStream`, `filter`, `sorted`, and `limit` operations.
    

Example: Input:

List<Product> products = Arrays.asList(

    new Product("Product1", "Electronics", 100.0, 4.3),

    new Product("Product2", "Electronics", 200.0, 4.5),

    new Product("Product3", "Books", 50.0, 4.1),

    new Product("Product4", "Books", 30.0, 4.0),

    new Product("Product5", "Electronics", 150.0, 4.4)

);

findTopRatedProductsParallel(products, 3);

findCheapestProductsInCategoryParallel(products, "Electronics", 2);

Output:

[Product{name='Product2', category='Electronics', price=200.0, rating=4.5}, Product{name='Product5', category='Electronics', price=150.0, rating=4.4}, Product{name='Product1', category='Electronics', price=100.0, rating=4.3}]

[Product{name='Product1', category='Electronics', price=100.0, rating=4.3}, Product{name='Product5', category='Electronics', price=150.0, rating=4.4}]

## Task 4

Topic: Error Handling Strategies

You are given a list of `Product` objects. Each `Product` has a `name`, `category`, `price`, and `rating`. Your task is to implement three methods:

1. `findProductsByCategory(List<Product> products, String category)`: This method should return a list of products in a given category. If the category does not exist, it should throw a `NoSuchElementException` with a message "No products found in the given category." Use Stream API's `filter` and `collect` operations.
    
2. `findProductByName(List<Product> products, String name)`: This method should return a product with a given name. If the product does not exist, it should throw a `NoSuchElementException` with a message "No product found with the given name." Use Stream API's `filter` and `findFirst` operations.
    
3. `findProductsByPriceRange(List<Product> products, double minPrice, double maxPrice)`: This method should return a list of products within a given price range. If no products fall within the given price range, it should throw a `NoSuchElementException` with a message "No products found within the given price range." Use Stream API's `filter` and `collect` operations.
    

Example: Input:

List<Product> products = Arrays.asList(

    new Product("Product1", "Electronics", 100.0, 4.3),

    new Product("Product2", "Electronics", 200.0, 4.5),

    new Product("Product3", "Books", 50.0, 4.1),

    new Product("Product4", "Books", 30.0, 4.0),

    new Product("Product5", "Electronics", 150.0, 4.4)

);

findProductsByCategory(products, "Electronics");

findProductByName(products, "Product1");

findProductsByPriceRange(products, 100.0, 200.0);

Output:

[Product{name='Product1', category='Electronics', price=100.0, rating=4.3}, Product{name='Product2', category='Electronics', price=200.0, rating=4.5}, Product{name='Product5', category='Electronics', price=150.0, rating=4.4}]

Product{name='Product1', category='Electronics', price=100.0, rating=4.3}

[Product{name='Product1', category='Electronics', price=100.0, rating=4.3}, Product{name='Product2', category='Electronics', price=200.0, rating=4.5}, Product{name='Product5', category='Electronics', price=150.0, rating=4.4}]