package oop.exercise15_designPrinciples.scenario2.factory;

import oop.exercise15_designPrinciples.scenario2.base.Clothing;
import oop.exercise15_designPrinciples.scenario2.base.Product;

public class ClothingFactory implements ProductFactory{
    
    @Override
    public Product createProduct(int size, String colour, String material) {
        return new Clothing(size, colour, material);
    }

    @Override
    public Product createProduct(String title, String author, String genre, boolean isBestseller) {
        return null;
    }
}
