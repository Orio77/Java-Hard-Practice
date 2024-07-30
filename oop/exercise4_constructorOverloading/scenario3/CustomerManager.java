package oop.exercise4_constructorOverloading.scenario3;

public class CustomerManager {
    
    public Customer manageCustomer(String detail) {
        return new Customer(detail);
    }
}
