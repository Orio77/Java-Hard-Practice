package dataStructures.exercise11_advancedDS.scenario3;

import java.util.HashMap;
import java.util.Random;

public class User {
    private String login;
    private int userId;
    @SuppressWarnings("unused")
    private String[] userHistory;
    private HashMap<Integer, String> generalHistory;
    private final int HISTORYCAPACITY = 3;

    public User(String login) {
        this.login = login;
        userId = login.hashCode();
        userHistory = new String[HISTORYCAPACITY];
        generalHistory = new HashMap<>();
    }

    private String simulateClick() {
        return "Click";
    }

    private String simulateComment() {
        return "Comment";
    }

    private String simulateWatch() {
        return "Watch";
    }

    public String simulateBehaviour() {
        Random random = new Random();
        int value = random.nextInt(100);

        if (value <= 70) {
            generalHistory.put(userId, simulateClick());
            return simulateClick();
        }
        else if (value > 70 && value <= 90) {
            generalHistory.put(userId, simulateClick());
            return simulateComment();
        }
        else {
            generalHistory.put(userId, simulateClick());
            return simulateWatch();
        }
    }

    public int getUserId() {
        return userId;
    }

    public HashMap<Integer, String> getGeneralHistory() {
        return generalHistory;
    }

    @Override
    public String toString() {
        return login;
    }
}
