package oop.exercise9_enums.scenario3;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private State state;
    private List<Product> items;
    private Product selectedItem;

    public VendingMachine() {
        items = new ArrayList<>();
    }

    public String selectItem(int number) {
        setState(State.SELECTING);
        if (number < items.size()) {
            setSelectedItem(items.get(number));
            return items.get(number).getName();
        }
            
        setState(State.IDLE);
        return null;
    }

    private boolean insertPayment(int money) {
        setState(State.PAYING);
        if (money < selectedItem.getPrice()) {
            setState(State.IDLE);
            return false;
        }

        return true;
    }

    public Product dispenseItem(int money) {
        setState(State.DISPENSING);
        if (insertPayment(money)) {
            setState(State.IDLE);
            return selectedItem;
        }
        setState(State.IDLE);
        return null;
    }

    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
    public List<Product> getItems() {
        return items;
    }
    public Product getSelectedItem() {
        return selectedItem;
    }
    public void setSelectedItem(Product selectedItem) {
        this.selectedItem = selectedItem;
    }
}
