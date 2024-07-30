package streamAPI.exercise9_streamPerformance.scenario2;

public class Purchase {
    private String product;
    private int quantity;
    private int price;

    public Purchase(String product, int quantity, int price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
    public String getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
