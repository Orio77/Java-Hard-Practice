package oop.exercise19_bestPractises.scenario3.bills;

public class SelfPayBilling implements BillingService{
    
    @Override
    public int generateBill() {
        return 1000;
    }
}
