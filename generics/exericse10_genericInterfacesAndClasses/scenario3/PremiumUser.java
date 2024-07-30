package generics.exericse10.scenario3;

import java.util.Stack;

public class PremiumUser extends User {
    private final boolean isPremium = true;

    public PremiumUser(String name, int userID, Stack<String> purchaseHistory, String browsingBehavior) {
        super(name, userID, purchaseHistory, browsingBehavior);
    }
    
    @Override
    public boolean isPremium() {
        return isPremium;
    }
    
}
