package dataStructures.exercise7_practicalApplication.scenario3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class ChattingApp {
    private HashMap<Integer, LinkedList<Conversation>> conversationBase;
    private LinkedList<User> userBase;
    private Scanner sc = new Scanner(System.in);

    public ChattingApp() {
        conversationBase = new HashMap<>();
        userBase = new LinkedList<>();
    }

    public void registerUser(User user) {
        conversationBase.put(user.getUserID(), user.getChats());
        userBase.add(user);
    }


    public void run() {

        Message login = getLogin();

        if (!verifyLogin(login.getContent()))
            return;

        User thisUser = getUser(login.getContent());
        Conversation thisConversation = null;
        if (setCurrentConversation(thisConversation, login.getContent()) == null)
            thisConversation = setCurrentConversation(thisConversation, login.getContent());

        while (true) {
            printMenu();

            String userInput = getUserInput();
            thisConversation.addToHistory(userInput);

            switch (userInput) {
                case "/new":
                    thisConversation = reactToNew(thisUser);
                    break;
                case "/unsend":
                    reactToUnsed(thisConversation);
                    resetConversation();
                    printMessages(thisConversation);
                    break;

                case "/change":
                    thisConversation = reactToChange(login.getContent());
                    printMessages(thisConversation);
                    break;

                default:
                    simulateResponse();
                    break;
            }

            
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("------Menu");
        System.out.println("Start new chat: /new");
        System.out.println("Unsend message: /unsend");
        System.out.println("Change conversation: /change");
        System.out.println("------Menu");
        System.out.println();
    }

    private boolean verifyLogin(String login) {
        if (!conversationBase.containsKey(login.hashCode())){
            System.out.println("Wrong login");
            return false;
        }
        return true;
    }

    private  String getUserInput() {
        String userInput;
        System.out.print("You: ");
        userInput = sc.nextLine().toLowerCase();
        System.out.println();
        return userInput;
    }

    private Conversation reactToNew(User user) {

        user.newChat();
        Conversation currentConversation = user.getChats().getLast();
        return currentConversation;
    }

    private void reactToUnsed(Conversation conversation) {
        if (conversation != null && !conversation.getHistory().isEmpty()) {
            conversation.getHistory().pop();
        }
    }

    private Conversation reactToChange(String login) {
        System.out.print("Please enter a number of the chat: ");
        int number = sc.nextInt();

        if (number > 0 && number < conversationBase.get(Integer.parseInt(login)).size()) {
            return conversationBase.get(Integer.parseInt(login)).get(number);
        }
        return null;
    }

    private User getUser(String login) {

        if (login == null || userBase.size() == 0 )
            return null;

        for (int i = 0; i < userBase.size(); i++) {
            if (userBase.get(i).getLogin().matches(login))
                return userBase.get(i);
        }
        return null;
    }

    private void printMessages(Conversation conversation) {
        for (Message message : conversation.getHistory()) {
            System.out.println(message);
        }
    }

    private Conversation setCurrentConversation(Conversation conversation, String login) {
        if (conversation == null) {
            return conversationBase.get(Integer.parseInt(login)).getFirst();
        }
        else
            return null;
    }

    private void simulateResponse() {
        System.out.println("Other Party: Response");
    }

    private Message getLogin() {
        System.out.println();
        System.out.print("Enter login: ");
        Message message = new Message();
        message.setContent(sc.nextLine());
        return message;
    }

    private void resetConversation() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }
}
