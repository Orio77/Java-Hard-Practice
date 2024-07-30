package dataStructures.exercise7_practicalApplication.scenario3;

import java.util.LinkedList;

public class User {
    private String login;
    private int userID;
    private LinkedList<Conversation> chats;

    public User(String login) {
        this.login = login;
        userID = login.hashCode();
        chats = new LinkedList<>();
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public int getUserID() {
        return userID;
    }

    public LinkedList<Conversation> getChats() {
        return chats;
    }

    public void newChat() {
        chats.add(new Conversation());
    }
}
