package oop.exercise15_designPrinciples.scenario2.factory;

import oop.exercise15_designPrinciples.scenario2.base.Electronics;
import oop.exercise15_designPrinciples.scenario2.base.Product;

public class ElectronicsFactory implements ProductFactory{
    
    @Override
    public Product createProduct(String brand, String model, String specifications, boolean isNew) {
        return new Electronics(brand, model, specifications, isNew);
    }

    @Override
    public Product createProduct(int size, String colour, String material) {
        return null;
    }
}
