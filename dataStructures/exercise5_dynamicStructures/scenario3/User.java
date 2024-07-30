package dataStructures.exercise5_dynamicStructures.scenario3;

import java.util.ArrayList;
import java.util.LinkedList;

public class User {
    private String name;
    private int userID;
    private LinkedList<Product> listOfInterest;

    public User(String name) {
        this.name = name;
        this.userID = name.hashCode();
        listOfInterest = new LinkedList<>();
    }

    // If a product was viewed by the user, it will be treated as if the user was interested in it
    public void viewProduct(Product product) {
        listOfInterest.add(product);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public LinkedList<Product> getListOfInterest() {
        return listOfInterest;
    }

    public void setListOfInterest(LinkedList<Product> listOfInterest) {
        this.listOfInterest = listOfInterest;
    }

    public static ArrayList<User> generateTestUsers(int number) {
        ArrayList<User> testUserList = new ArrayList<>();
        
        for (int i = 0; i < number; i++) {
            testUserList.add(new User("User" + i));
        }

        return testUserList;
    }
}
