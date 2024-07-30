package oop.exercise12_objectReferences.scenario3;

public class DineInOrder extends Order{
    
    @Override
    public void placeOrder() {
        System.out.println("Placing dine in order");
    }

    @Override
    public void cancelOrder() {
        System.out.println("Canceling dine in order");
    }
}
