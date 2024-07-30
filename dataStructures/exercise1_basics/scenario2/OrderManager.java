package dataStructures.exercise1_basics.scenario2;

import java.util.Queue;

public class OrderManager {
    private Queue<Order> orders;

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public void listOrders() {
        System.out.println(orders);
    }
}
