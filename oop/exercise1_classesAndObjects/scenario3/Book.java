package oop.exercise1_classesAndObjects.scenario3;

public class Book extends InventoryItem implements DiscountPolicy{
    private final static int capacity = 100;
    private final double ageDiscount = 0.1;
    private static int stock;
    private String condition;
    private double price;
    private int age;

    public Book(String condition, int price) {
        this.condition = condition;
        this.price = price;
        age = 0;
        stock = 0;
    }

    @Override
    public void addStock(int quantity) {
        stock += quantity;
    }

    @Override
    public void sellStock(int quantity) {
        stock -= quantity;
        if (stock < 20)
            restockTreshold();
    }

    @Override
    public void restockTreshold() {
        addStock(capacity - stock);
    }

    @Override
    public double calculateDiscount(InventoryItem item) {
        if (age > 180)
            return price*(1 - ageDiscount);
        return price;
    }

    @Override
    public boolean isEligibleForStock() {
        return (condition.matches("new") && stock < capacity);
    }

    public String getCondition() {
        return condition;
    }
    public int getAge() {
        return age;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
