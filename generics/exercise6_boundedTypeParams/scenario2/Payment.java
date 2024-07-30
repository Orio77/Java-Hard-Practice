package generics.exercise6_boundedTypeParams.scenario2;

public class Payment {
    private double amount;
    private String currency;
    private String payer;
    private String receiver;
    private boolean isSafe;
    private boolean isSuccess;

    public Payment(double amount, String currency, String payer, String receiver) {
        this.amount = amount;
        this.currency = currency;
        this.payer = payer;
        this.receiver = receiver;
    }

    public void assureSafety() {
        isSafe = true;
    }

    public double getAmount() {
        return amount;
    }
    public String getCurrency() {
        return currency;
    }
    public String getPayer() {
        return payer;
    }
    public String getReceiver() {
        return receiver;
    }
    public boolean isSafe() {
        return isSafe;
    }
    public boolean isSuccess() {
        return isSuccess;
    }
}
