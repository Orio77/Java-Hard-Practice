package dataStructures.exercise1_basics.scenario2;

public class Order {
    private int orderID;

    public Order() {
        this.orderID = hashCode();
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    @Override
    public String toString() {
        return Integer.toString(orderID);
    }
}
