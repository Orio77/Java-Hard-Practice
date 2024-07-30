package oop.exercise19_bestPractises.scenario2;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationSystem {
    private Map<String, Member> registeredusers;
    private Map<String, Member> loggedInUsers;

    public AuthenticationSystem() {
        registeredusers = new HashMap<>();
        loggedInUsers = new HashMap<>();
    }

    public boolean login(String login) {
        if (registeredusers.containsKey(login))  {
            loggedInUsers.put(login, new Member(login));
            return true;
        }

        else if (!registeredusers.containsKey(login)) {
            registeredusers.put(login, new Member(login));
            return false;
        }
        return false;
    }

    public boolean logOut(String login) {
        if (loggedInUsers.containsKey(login)) {
            loggedInUsers.remove(login);
            return true;
        }
        return false;
    }

    public boolean authenticateUser(String login) {
        return registeredusers.containsKey(login);
    }

}
