package oop.exercise15_designPrinciples.scenario2.base;

import java.util.ArrayList;

import oop.exercise15_designPrinciples.scenario2.ProductNotAvailableException;
import oop.exercise15_designPrinciples.scenario2.factory.BookFactory;
import oop.exercise15_designPrinciples.scenario2.factory.ClothingFactory;
import oop.exercise15_designPrinciples.scenario2.factory.ElectronicsFactory;

public class ShoppingCart {
    private ArrayList<Product> items;
    private ElectronicsFactory eleFactory;
    private ClothingFactory clothFactory;
    private BookFactory bookFactory;

    public void addProduct(Product product) {
        if (product instanceof Electronics) {
            Electronics ele = (Electronics) product;
            eleFactory.createProduct(ele.getBrand(), ele.getModel(), ele.getSpecifications(), ele.isNew());
        }
        else if (product instanceof Clothing) {
            Clothing cloth = (Clothing) product;
            clothFactory.createProduct(cloth.getSize(), cloth.getColour(), cloth.getMaterial());
        }
        else if (product instanceof Books) {
            Books book = (Books) product;
            bookFactory.createProduct(book.getTitle(), book.getAuthor(), book.getGenre(), book.isBestSeller());
        }
    }

    public double getTotalPrice() throws ProductNotAvailableException{
        double sum = 0;

        for (Product product : items) {
            if (product.getAvailability() > 0)
                sum = sum + product.getPrice();
            else 
                throw new ProductNotAvailableException("Product is not avaliable");
        }

        return sum;
    }

    public ArrayList<Product> getItems() {
        return items;
    }
}
