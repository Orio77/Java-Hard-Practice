package streamAPI.exercise4_collectors.scenario2;

import java.time.LocalDateTime;

/**
 * A class representing a purchase of a product made by a customer. Contains also info about quantity and time of purchase
 */
public class Purchase {
    private String customerId;
    private String productId;
    private int quantity;
    private LocalDateTime purchaseDate;

    /**
     * getter
     * @return customer ID
     */
    public String getCustomerId() {
        return customerId;
    }
    /**
     * getter
     * @return product ID
     */
    public String getProductId() {
        return productId;
    }
    /**
     * getter
     * @return time of purchase
     */
    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }
    /**
     * getter
     * @return quantity of product bought
     */
    public int getQuantity() {
        return quantity;
    }
}
