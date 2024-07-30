package dataStructures.exercise4_sorting.scenario1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Storage {
    private String category;
    private HashMap<Integer, Product> productStorage;
    private static ArrayList<String> categories;

    public Storage(String category) {
        this.category = category;
        productStorage = new HashMap<>();
        categories = new ArrayList<>();
        categories.add(category);
    }

    public void takeDelivery(ArrayList<Product> products) {
        for (Product product : products) {
            productStorage.put(product.getProductID(), product);
        }
    }

    public ArrayList<Product> getProducts() {
        return (ArrayList<Product>) productStorage.values();
    }

    public HashMap<Integer, Product> getProductStorage() {
        return productStorage;
    }

    public void setProductStorage(HashMap<Integer, Product> productStorage) {
        this.productStorage = productStorage;
    }

    public String getCategory() {
        return category;
    }

    public static ArrayList<String> getCategories() {
        return categories;
    }

    public Product binarySearch(Product product) throws NullPointerException{
        ArrayList<Product> products = new ArrayList<>(productStorage.values());
        products.sort(Comparator.comparing(p -> p.toString()));

        Product element = null;
        
        while(!element.getName().equals(product.getName())) {
            element = products.get(products.size() / 2);
            if (element.getName().compareTo(product.getName()) == 0) {
                return element;
            }
            else if (element.getName().compareTo(product.getName()) > 0) {
                products.removeAll(products.subList(0, products.size() / 2));
            }
            else if (element.getName().compareTo(product.getName()) < 0) {
                products.removeAll(products.subList(products.size() / 2, products.size()));
            }
        }
        return null;
    }
}
