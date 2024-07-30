package oop.exercise15_designPrinciples.scenario2.factory;

import oop.exercise15_designPrinciples.scenario2.base.Product;

public interface ProductFactory {

    Product createProduct(int size, String colour, String material);
    Product createProduct(String title, String author, String genre, boolean isBestseller);


}


