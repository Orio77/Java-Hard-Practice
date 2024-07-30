package generics.exericse10.scenario3;

import java.util.Stack;

public class RegularUser extends User {
    private final boolean isPremium = false;

    public RegularUser(String name, int userID, Stack<String> purchaseHistory, String browsingBehavior) {
        super(name, userID, purchaseHistory, browsingBehavior);
    }
    @Override
    public boolean isPremium() {
        return isPremium;
    }
}
