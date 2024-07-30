package dataStructures.exercise5_dynamicStructures.scenario3;

import java.util.ArrayList;
import java.util.Random;

public class Product {
    private String name;
    private int productID;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.productID = name.hashCode();
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // In a professional recommendation system this would be a method calculating relevance between any 2 given products
    public static double calculateProductsRelevance(Product product1, Product product2) {
        Random random = new Random();
        return random.nextDouble(10);
    }

    public static ArrayList<Product> generateTestProducts(int number) {
        ArrayList<Product> testProductList = new ArrayList<>();
        Random random = new Random();
        
        for (int i = 0; i < number; i++) {
            testProductList.add(new Product("Product" + i, random.nextInt(10000)));
        }

        return testProductList;
    }
}
