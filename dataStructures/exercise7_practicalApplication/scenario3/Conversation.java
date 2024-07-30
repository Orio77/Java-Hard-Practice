package dataStructures.exercise7_practicalApplication.scenario3;

import java.util.LinkedList;
import java.util.Stack;

public class Conversation {
    private LinkedList<Message> messages; // Stores all messages ever sent
    private Stack<Message> history; // Stores messages that did not get deleted

    public Conversation() {
        messages = new LinkedList<>();
        history = new Stack<>();
    }

    public Stack<Message> getHistory() {
        return history;
    }

    public LinkedList<Message> getMessages() {
        return messages;
    }

    public void addToHistory(String message) {
        Message newMessage = new Message();
        newMessage.setContent(message);
        history.push(newMessage);
    }
}
