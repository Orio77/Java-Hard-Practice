package dataStructures.exercise4_sorting.scenario3;

public class Main {
    public static void main(String[] args) {
        
        LeaderBoard leaderBoard = new LeaderBoard();

        leaderBoard.addTeams(Player.generatePlayersForTests(50));

        leaderBoard.showMatchLive();
    }
}
