package generics.exercise6_boundedTypeParams.scenario2;

public class SecurePayment extends Payment {
    private final boolean isSafe = true;

    public SecurePayment(double amount, String currency, String payer, String receiver) {
        super(amount, currency, payer, receiver);
    }
    
    public boolean isSafe() {
        return isSafe;
    }
}
