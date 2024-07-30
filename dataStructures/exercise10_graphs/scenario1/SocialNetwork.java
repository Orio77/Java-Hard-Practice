package dataStructures.exercise10_graphs.scenario1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class SocialNetwork {
    LinkedList<LinkedList<User>> network;
    ArrayList<User> userBase;

    public SocialNetwork() {
        network = new LinkedList<>();
        userBase = new ArrayList<>();
    }

    // Add user to the User Base & add his friends to Network Graph
    public void registerUser(User user) {
        userBase.add(user);
        network.add(user.getFriends());
    }

    public HashSet<User> getFriendsSuggestions(User user) throws NullPointerException{

        HashSet<User> friendSuggestions = new HashSet<>();

        if (!userBase.contains(user))
            return null;

        int userIndex = getUserIndex(user);

        LinkedList<User> usersImmediateFriends = network.get(userIndex);

        for (User friend : usersImmediateFriends) {
            friendSuggestions.add(friend);
        }

        if (friendSuggestions.contains(null))
            friendSuggestions.remove(null);

        return friendSuggestions;
    }

    public void showFriendSuggestions(User user) {
        System.out.println("Friend suggestions:");
        System.out.println(getFriendsSuggestions(user));
    }

    private int getUserIndex(User user) {
        for (int i = 0; i < userBase.size() - 1; i++) {
            if (userBase.get(i).equals(user))
                return i;
        }
        return -1;
    }

    public void generateUsersForTests(int userNumber, int friendLimit) {

        for (int i = 0; i < userNumber; i++) {
            registerUser(new User("User" + i));
        }

        for (User user : userBase) {

            user.generateFriendsForTests(friendLimit);
        }
    }

    public ArrayList<User> getUserBase() {
        return userBase;
    }
}
