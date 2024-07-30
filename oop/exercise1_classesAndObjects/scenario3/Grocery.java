package oop.exercise1_classesAndObjects.scenario3;

public class Grocery extends InventoryItem implements DiscountPolicy {
    private boolean isFresh;
    private int expirationDate;
    private int price;
    private final double expirationDateDiscount = 0.3;
    private static int stock;

    public Grocery(int expirationDate) {
        this.expirationDate = expirationDate;
        isFresh = ascertainFreshness(expirationDate);
        stock = 0;
    }

    public boolean ascertainFreshness(int daysLeft) {
        if (daysLeft > 10)
            return true;
        else
            return false;
    }

    @Override
    public void addStock(int quantity) {
        stock += quantity;
    }

    @Override
    public void sellStock(int quantity) {
        stock -= quantity;
        if (stock < 50)
            restockTreshold();
    }

    @Override
    public void restockTreshold() {
        addStock(200);
    }

    @Override
    public double calculateDiscount(InventoryItem item) {
        if (expirationDate <= 2)
            return price * (1 - expirationDateDiscount);
        return price;
    }

    @Override
    boolean isEligibleForStock() {
        return (isFresh && ascertainFreshness(expirationDate));
    }

    public boolean isFresh() {
        return isFresh;
    }
    public int getExpirationDate() {
        return expirationDate;
    }
    public int getPrice() {
        return price;
    }
}
