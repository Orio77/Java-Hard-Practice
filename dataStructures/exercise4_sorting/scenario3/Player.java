package dataStructures.exercise4_sorting.scenario3;

import java.util.ArrayList;

public class Player {
    String name;
    int playerID;
    int score;

    public Player(String name) {
        this.name = name;
        score = 0;
        playerID = name.hashCode();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void score() {
        score++;
    }

    public static ArrayList<Player> generatePlayersForTests(int number) {
        ArrayList<Player> playerList = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            playerList.add(new Player("player" + i));
        }

        return playerList;
    }

    @Override
    public String toString() {
        return name;
    }
}
