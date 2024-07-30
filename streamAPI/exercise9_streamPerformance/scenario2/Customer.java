package streamAPI.exercise9_streamPerformance.scenario2;

import java.util.List;

public class Customer {
    private String name;
    private int age;
    private List<Purchase> purchaseHistory;

    public Customer(String name, int age, List<Purchase> purchaseHistory) {
        this.name = name;
        this.age = age;
        this.purchaseHistory = purchaseHistory;
    }

    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public List<Purchase> getPurchaseHistory() {
        return purchaseHistory;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPurchaseHistory(List<Purchase> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }
}
