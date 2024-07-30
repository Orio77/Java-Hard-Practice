package algorithms.exercise3_dataStructures.scenario2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Network {
    ArrayList<LinkedList<User>> network;
    ArrayList<User> userBase;

    public Network() {
        network = new ArrayList<>();
        userBase = new ArrayList<>();
    }

    public void showNetwork(User user) {
        showNetwork(user, 10);
    }
    public ArrayList<LinkedList<User>> getNetwork() {
        return network;
    }
    public ArrayList<User> getUserBase() {
        return userBase;
    }

    private void showNetwork(User user, int moveRight) {

        for (User friend : user.getFriends()) {
            System.out.print(friend);
            for (int i = 0; i < moveRight; i++) {
                System.out.print("                  ");
            }
        }
        
        for (User friend : user.getFriends())
            showNetwork(friend, moveRight - 1);
    }

    public void simulateUserBase(int userNumber) {
        Random random = new Random();
        User user = null;
        for (int i = 0; i < userNumber; i++) {
            user = new User("User" + i);
            userBase.add(user);
            generateUserFriends(user, random.nextInt(10));
            network.add(user.getFriends());
        }
    }

    private void generateUserFriends(User user, int number) {
        User friend = null;
        
        for (int i = 0; i < number; i++) {
            friend = new User("Friend" + i);
            user.getFriends().add(friend);
        }
    }
}
