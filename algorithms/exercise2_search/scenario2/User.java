package algorithms.exercise2_search.scenario2;

import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<String> interests;
    private ArrayList<User> friends;
    private int id;

    public User(String name, ArrayList<String> interests) {
        this.name = name;
        this.interests = interests;
        this.friends = new ArrayList<>();
        this.id = name.hashCode();
    }

    public ArrayList<User> getFriends() {
        return friends;
    }
    public int getId() {
        return id;
    }
    public ArrayList<String> getInterests() {
        return interests;
    }
    public String getName() {
        return name;
    }
    public void setFriends(ArrayList<User> friends) {
        this.friends = friends;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setInterests(ArrayList<String> interests) {
        this.interests = interests;
    }
    public void setName(String name) {
        this.name = name;
    }

    public User findFriend(String name, int startIndex, int endIndex) {
        int midIndex = startIndex + (endIndex - startIndex) / 2;
        User midFriend = friends.get(midIndex);

        if (midFriend.getName().matches(name))
            return midFriend;

        User foundLeft = null;
        User foundRight =  null;

        if (name.compareTo(midFriend.getName()) > 0)
            foundLeft = findFriend(name, midIndex + 1, endIndex);
        if (name.compareTo(midFriend.getName()) < 0)
            foundRight = findFriend(name, startIndex, midIndex - 1);

        if (foundLeft.getName().matches(name))
            return foundLeft;
        else if (foundRight.getName().matches(name))
            return foundRight;
        else
            return null;
    }
    
    public ArrayList<User> getSimilarPeople() {
        ArrayList<User> similarPeople = new ArrayList<>();

        for (int i = 0; i < interests.size(); i++) {
            for (User friend : friends) {
                if (friend.getInterests().contains(interests.get(i))) {
                    similarPeople.add(friend);
                }
            }
        }
        return similarPeople;
    }
}
