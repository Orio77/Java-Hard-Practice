package algorithms.exercise4_graphs.scenario2;

import java.util.ArrayList;
import java.util.LinkedList;

public class User {
    String name;
    LinkedList<String> interests;
    int userId;
    LinkedList<Friendship> relations;

    public User(String name) {
        this.name = name;
        userId = name.hashCode();
        interests = new LinkedList<>();
        relations = new LinkedList<>();
    }
    public LinkedList<Friendship> getRelations() {
        return relations;
    }

    public void addFriend(User user, int likeability) {
        relations.add(new Friendship(this, user, likeability));
    }

    public void removeFriend(User user) {
        for (int i = 0; i < relations.size(); i++) {
            if (relations.get(i).getUser2().equals(user)) {
                relations.remove(i);
            }
        }
    }

    public ArrayList<User> getFriends() {
        ArrayList<User> friends = new ArrayList<>();
        for (Friendship friendship : relations) {
            friends.add(friendship.getUser2());
        }
        return friends;
    }

    public LinkedList<String> getInterests() {
        return interests;
    }

    public int getMutualFriendsCount(User friend) {
        int mutualCount = 0;
        for (User user : friend.getFriends()) {
            for (User usersFriend : this.getFriends()) {
                if (user.equals(usersFriend))
                    mutualCount++;
            }
        }
        return mutualCount;
    }
    
}