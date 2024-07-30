package oop.exercise15_designPrinciples.scenario2.factory;

import oop.exercise15_designPrinciples.scenario2.base.Books;
import oop.exercise15_designPrinciples.scenario2.base.Product;

public class BookFactory implements ProductFactory{

    @Override
    public Product createProduct(int size, String colour, String material) {
        return null;
    }

    @Override
    public Product createProduct(String title, String author, String genre, boolean isBestseller) {
        return new Books(author, title, genre, isBestseller);
    }
    
}
