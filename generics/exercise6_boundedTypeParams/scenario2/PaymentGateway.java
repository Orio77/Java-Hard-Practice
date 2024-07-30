package generics.exercise6_boundedTypeParams.scenario2;

import java.util.Stack;

public class PaymentGateway {
    private Stack<Payment> paymentHistory;
    private boolean isSecureOnly;

    public PaymentGateway(boolean isSecureOnly) {
        paymentHistory = new Stack<>();
        this.isSecureOnly = isSecureOnly;
    }

    public boolean getPaymentThrough(Payment payment) {
        if (checkCompatibility(payment)) {
            simulateSuccesfulPayment();
            return true;
        }
        return false;
    }

    private void simulateSuccesfulPayment() {
        System.out.println("Payment went through successfully");
    }

    public String getPaymentDetails(Payment payment) {
        return (
            "Amount: " + payment.getAmount() +
            "\nCurrency: " + payment.getCurrency() +
            "\nPayer: " + payment.getPayer() + 
            "\nReceiver: " + payment.getReceiver()
        );
    }

    public boolean checkCompatibility(Payment payment) {
        if (isSecureOnly && !payment.isSafe() || !isSecureOnly && payment.isSafe()) {
            return false;
        }

        return true;
    }

    public Stack<Payment> getPaymentHistory() {
        return paymentHistory;
    }
    public boolean isSecureOnly() {
        return isSecureOnly;
    }
    
}