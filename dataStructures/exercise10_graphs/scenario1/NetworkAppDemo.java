package dataStructures.exercise10_graphs.scenario1;

public class NetworkAppDemo {
    public static void main(String[] args) {
        
        SocialNetwork network1 = new SocialNetwork();

        network1.generateUsersForTests(50, 20);

        network1.showFriendSuggestions(network1.getUserBase().get(0));
    }
}
