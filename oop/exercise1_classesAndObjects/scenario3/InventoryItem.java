package oop.exercise1_classesAndObjects.scenario3;

public abstract class InventoryItem {
    
    abstract void addStock(int quantity);
    abstract void sellStock(int quantity);
    abstract void restockTreshold();
    abstract boolean isEligibleForStock();
}
