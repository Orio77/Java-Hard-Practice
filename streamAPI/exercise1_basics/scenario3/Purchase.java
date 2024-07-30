package streamAPI.exercise1_basics.scenario3;

public class Purchase {
    private String product;
    private int price;

    public int getPrice() {
        return price;
    }
    public String getProduct() {
        return product;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setProduct(String product) {
        this.product = product;
    }
}
