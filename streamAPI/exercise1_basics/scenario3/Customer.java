package streamAPI.exercise1_basics.scenario3;

import java.util.List;

public class Customer {
    String name;
    int age;
    String email;
    List<Purchase> purchases;

    public int getAge() {
        return age;
    }
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }public List<Purchase> getPurchases() {
        return purchases;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
}
