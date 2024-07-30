package algorithms.exercise3_dataStructures.scenario2;

import java.util.LinkedList;
import java.util.Random;

public class User {
    private String name;
    private LinkedList<User> friends;
    private LinkedList<String> activities;
    private LinkedList<String> notifications; 

    public User(String name) {
        this.name = name;
        friends = new LinkedList<>();
        activities = new LinkedList<>();
        notifications = new LinkedList<>();
    }

    public void post(String postTitle) {
        activities.add("Posted: " + postTitle);
    }

    public void comment(String content) {
        activities.add("Commented: " + content);
    }

    public void showNotifications() {
        System.out.println("Notifications: ");
        System.out.println(notifications);
    }

    public void simulateNotifications(int number) {
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            int ran = random.nextInt(3);
            if (ran == 0)
                notifications.add("message");
            else if (ran == 0)
                notifications.add("post");
            else
                notifications.add("comment");
            
        }
    }

    public LinkedList<String> getActivities() {
        return activities;
    }
    public LinkedList<User> getFriends() {
        return friends;
    }
    public String getName() {
        return name;
    }
    public LinkedList<String> getNotifications() {
        return notifications;
    }

    @Override
    public String toString() {
        return name;
    }
}
