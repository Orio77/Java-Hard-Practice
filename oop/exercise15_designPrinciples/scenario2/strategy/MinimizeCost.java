package oop.exercise15_designPrinciples.scenario2.strategy;

import java.util.Comparator;

public class MinimizeCost implements ShoppingStrategy{

    @Override
    public void executeStrategy(oop.exercise15_designPrinciples.scenario2.base.ShoppingCart cart) {
        cart.getItems().sort(Comparator.comparing(i -> i.getPrice()));
    }
    
}
