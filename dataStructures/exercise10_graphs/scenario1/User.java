package dataStructures.exercise10_graphs.scenario1;

import java.util.LinkedList;
import java.util.Random;

public class User {
    private LinkedList<User> friends;
    private String login;

    public User(String login) {
        friends = new LinkedList<>();
        this.login = login;
    }

    public void addFriend(User user) {
        friends.add(user);
    }

    public LinkedList<User> getFriends() {
        return friends;
    }

    public void generateFriendsForTests(int upperBound) {

        Random number = new Random();

        for (int i = 0; i < number.nextInt(upperBound); i++) {
            friends.add(new User("Friend" + i));
        }
    }

    @Override
    public String toString() {
        return login;
    }
}
