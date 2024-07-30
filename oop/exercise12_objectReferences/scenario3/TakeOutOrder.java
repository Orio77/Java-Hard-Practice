package oop.exercise12_objectReferences.scenario3;

public class TakeOutOrder extends Order{
    
    @Override
    public void placeOrder() {
        System.out.println("Placing take-out order");
    }

    @Override
    public void cancelOrder() {
        System.out.println("Canceling take-out order");
    }
}
