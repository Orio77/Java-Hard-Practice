package generics.exercise1_understandingGenerics.scenario2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ShoppingCart<T> {
    private List<T> products;

    public ShoppingCart() {
        products = new LinkedList<>();
    }

    public boolean addItem(T product) {
        try {
            product = Objects.requireNonNull(product);
        } catch (NullPointerException e) {
            System.out.println("Please provide a non-null product");
        }
        
        return products.add(product);
    }

    public boolean removeItem(T product) {
        try {
            product = Objects.requireNonNull(product);
        } catch (NullPointerException e) {
            System.out.println("Please provide a non-null product");
        }

        return products.remove(product);
    }

    public List<T> getProducts() {
        return Collections.unmodifiableList(products);
    }
}
