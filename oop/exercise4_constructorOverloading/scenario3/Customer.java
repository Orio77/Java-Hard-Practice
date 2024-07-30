package oop.exercise4_constructorOverloading.scenario3;

import java.util.Random;

public class Customer {
    private String name;
    private String address;
    private int phoneNumber;

    public Customer() {
        name = "John";
        address = "warzone57";
        setPhoneNumber(1479891);
    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, String address) {
        this(name);
        this.address = address;
    }

    public Customer(String name, String address, int phoneNumber) {
        this(name, address);
        this.phoneNumber = phoneNumber;
    }

    public boolean isEligibleForDiscount() {
        return simulateDiscountEligibility();
    }

    private boolean simulateDiscountEligibility() {
        Random random = new Random();
        return random.nextInt(10) % 2 == 0;
    }

    public void setPhoneNumber(int phoneNumber) {
        if (Integer.toString(phoneNumber).length() == 7)
            this.phoneNumber = phoneNumber;
    }
    public String getAddress() {
        return address;
    }
    public String getName() {
        return name;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
