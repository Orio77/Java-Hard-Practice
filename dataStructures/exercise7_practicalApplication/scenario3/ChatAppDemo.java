package dataStructures.exercise7_practicalApplication.scenario3;

public class ChatAppDemo {
    public static void main(String[] args) {
    
        ChattingApp app1 = new ChattingApp();
        User me = new User("password");
        me.newChat();

        app1.registerUser(me);
        app1.run();
    }
}
