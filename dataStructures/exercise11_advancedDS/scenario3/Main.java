package dataStructures.exercise11_advancedDS.scenario3;

public class Main {
    public static void main(String[] args) {
        DashBoard board = new DashBoard();

        board.simulateUserBase(10000);
        board.simulateEvents(10);
        // board.showGeneralEventHistory();
        System.out.println(board.getUserBase());

        User user1 = new User("User1");
        board.registerUser(user1);
        System.out.println(board.isNew(user1));
    }
}
