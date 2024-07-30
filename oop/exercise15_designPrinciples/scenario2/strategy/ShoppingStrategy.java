package oop.exercise15_designPrinciples.scenario2.strategy;

import oop.exercise15_designPrinciples.scenario2.base.ShoppingCart;

public interface ShoppingStrategy {
    void executeStrategy(ShoppingCart cart);
}
