package dataStructures.exercise4_sorting.scenario1;

import java.util.ArrayList;
import java.util.Random;

public class Product {
    private String name;
    private double price;
    private int productID;
    private double popularity;

    public Product(String name, int price, int productID, double popularity) {
        this.name = name;
        this.price = price;
        this.productID = productID;
        this.popularity = popularity;
    }

    public ArrayList<Product> sampleProductGenerator(int number, String category) {

        ArrayList<Product> sampleProductList = new ArrayList<>();
        Random random = new Random(); 

        for (int i = 0; i < number; i++) {
            sampleProductList.add(new Product(category + i, random.nextInt(500, 1000), name.hashCode(), random.nextDouble(0, 10)));
        }

        return sampleProductList;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }
}
