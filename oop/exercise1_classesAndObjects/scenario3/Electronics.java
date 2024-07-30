package oop.exercise1_classesAndObjects.scenario3;

public class Electronics extends InventoryItem implements DiscountPolicy{
    private double price;
    private boolean isOnWarranty;
    private boolean isFunctional;
    private final int yearOfProduction;
    private final double lastYearDiscount = 0.2;
    private static int stock;

    public Electronics(boolean isOnWarranty, int yearOfProduction) {
        this.isOnWarranty = isOnWarranty;
        this.yearOfProduction = yearOfProduction;
        isFunctional = true;
        stock = 0;
    }

    @Override
    void addStock(int quantity) {
        stock += quantity;
        if (stock < 10)
            restockTreshold();
    }

    @Override
    void sellStock(int quantity) {
        stock -= quantity;
    }

    @Override
    void restockTreshold() {
        addStock(100);
    }

    @Override
    public double calculateDiscount(InventoryItem item) {
        if (yearOfProduction == 2023)
            return price * (1 - lastYearDiscount);
        return price;
    }

    @Override
    public boolean isEligibleForStock() {
        return (isFunctional && isOnWarranty);
    }

    public boolean isFunctional() {
        return isFunctional;
    }
    public boolean isOnWarranty() {
        return isOnWarranty;
    }
    public double getPrice() {
        return price;
    }

}
