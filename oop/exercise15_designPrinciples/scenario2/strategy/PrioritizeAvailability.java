package oop.exercise15_designPrinciples.scenario2.strategy;

import java.util.Comparator;

import oop.exercise15_designPrinciples.scenario2.base.Product;

public class PrioritizeAvailability implements ShoppingStrategy{
    
    @Override
    public void executeStrategy(oop.exercise15_designPrinciples.scenario2.base.ShoppingCart cart) {
        cart.getItems().sort(Comparator.comparing((Product i) -> i.getAvailability()).reversed());
    }
}
