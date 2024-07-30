package generics.exericse10.scenario3;

import java.util.Stack;

public class User {
    private String name;
    private int userID;
    private Stack<String> purchaseHistory;
    private String browsingBehavior;
    private boolean isPremium;

    public User(String name, int userID, Stack<String> purchaseHistory, String browsingBehavior) {
        this.name = name;
        this.userID = userID;
        this.purchaseHistory = purchaseHistory;
        this.browsingBehavior = browsingBehavior;
        isPremium = false;
    }

    public String getBrowsingBehavior() {
        return browsingBehavior;
    }
    public String getName() {
        return name;
    }
    public Stack<String> getPurchaseHistory() {
        return purchaseHistory;
    }
    public int getUserID() {
        return userID;
    }
    public boolean isPremium() {
        return isPremium;
    }
}
