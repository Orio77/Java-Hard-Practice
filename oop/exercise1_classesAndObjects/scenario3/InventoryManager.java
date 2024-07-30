package oop.exercise1_classesAndObjects.scenario3;

public class InventoryManager {
    
    public void delivery(InventoryItem item, int number) {
        item.addStock(number);
    }

    public void sale(InventoryItem item, int number) {
        item.sellStock(number);
    }
}
