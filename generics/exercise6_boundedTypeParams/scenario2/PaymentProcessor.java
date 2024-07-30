package generics.exercise6_boundedTypeParams.scenario2;

public class PaymentProcessor<T extends Payment> {
    
    public boolean processPayment(PaymentGateway gateway, T payment) {
        return gateway.getPaymentThrough(payment);
    }

    public boolean secureProcess(PaymentGateway gateway, T payment) {
        if (!gateway.isSecureOnly() || !payment.isSafe()) {
            System.out.println("Only secure gateways and payments are acceptable");
            return false;
        }

        return gateway.getPaymentThrough(payment);
    }

    public boolean isCompatible(PaymentGateway gateway, T payment) {
        return gateway.checkCompatibility(payment);
    }
}
