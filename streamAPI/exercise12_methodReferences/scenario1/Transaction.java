package streamAPI.exercise12_methodReferences.scenario1;

import java.time.LocalDateTime;

/**
 * Transaction
 */
public class Transaction {
    private int id;
    private double amount;
    private String type;
    private LocalDateTime date;

    public Transaction(int id, double amount, String type, LocalDateTime date) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public int getId() {
        return id;
    }
    public String getType() {
        return type;
    }
}