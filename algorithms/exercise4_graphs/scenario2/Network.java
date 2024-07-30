package algorithms.exercise4_graphs.scenario2;

import java.util.LinkedList;

// TODO PROBLEM 3
public class Network {
    LinkedList<User> users;

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void addFriendship(User user1, User user2, int likeability) {
        user1.getRelations().add(new Friendship(user1, user2, likeability));
        user2.getRelations().add(new Friendship(user2, user1, likeability));
    }

    public void removeFriendship(User user1, User user2) {
        for (int i = 0; i < user1.getRelations().size(); i++) {
            if (user1.getRelations().get(i).getUser2().equals(user2))
                user1.getRelations().remove(i);
        }
        for (int i = 0; i < user2.getRelations().size(); i++) {
            if (user2.getRelations().get(i).getUser2().equals(user1))
                user2.getRelations().remove(i);
        }
    }

    public LinkedList<User> getUsers() {
        return users;
    }

    public LinkedList<Friendship> getFriendships(User user) {
        return user.getRelations();
    }
}