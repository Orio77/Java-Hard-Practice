package streamAPI.exercise14_streamOrdering.scenario1;

import java.time.LocalDateTime;

public class Transaction {
    private int transactionId;
    private double amount;
    private LocalDateTime date;
    private int departmentId;

    public Transaction(int transactionId, double amount, LocalDateTime date, int departmentId) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.date = date;
        this.departmentId = departmentId;
    }

    public double getAmount() {
        return amount;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public int getDepartmentId() {
        return departmentId;
    }
    public int getTransactionId() {
        return transactionId;
    }
}
