package generics.exercise14.scenario2;

public class Trade<T> {
    private double price;
    private int quantity;
    private String symbol;
    private T details;

    public Trade(double price, int quantity, String symbol) {
        this.price = price;
        this.quantity = quantity;
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getSymbol() {
        return symbol;
    }
    public T getDetails() {
        return details;
    }
}
