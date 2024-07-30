package dataStructures.exercise4_sorting.scenario3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Stack;
import java.util.stream.Collectors;

public class LeaderBoard {
    PriorityQueue<Player> leaderBoard;
    HashMap<Integer, Integer> playersData;
    ArrayList<Player> players;

    public LeaderBoard() {
        leaderBoard = new PriorityQueue<>(Comparator.comparing(p -> p.getScore()));
        playersData = new HashMap<>();
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        leaderBoard.add(player);
        playersData.put(player.getPlayerID(), player.getScore());
        players.add(player);
    }

    public void addTeams(ArrayList<Player> players) {
        this.players.addAll(players);
        leaderBoard.addAll(players);
        for (Player player : players) {
            playersData.put(player.getPlayerID(), player.getScore());
        }
    }

    public void showMatchLive() {

        PriorityQueue<Player> bestPlayers = leaderBoard.stream().filter(p -> p.getScore() > 0).collect(Collectors.toCollection(() -> new PriorityQueue<>(Comparator.comparing(p -> p.getScore()))));
        Stack<String> reverseLeaderBoard = new Stack<>();

        for (int i = 0; i < 90; i++) {

            generateRandomEventForTest();
   
            while (!bestPlayers.isEmpty()) {
                reverseLeaderBoard.push(bestPlayers.size() + ". " + bestPlayers.poll());
            }

            for (int j = 0; j < reverseLeaderBoard.size(); j++) {
                System.out.println(reverseLeaderBoard.pop());
            }  

            try {
                Thread.sleep(300);;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void generateRandomEventForTest() {
        Random random = new Random();

        Player scoringPlayer = players.get(random.nextInt(leaderBoard.size()));
        scoringPlayer.score();
    }
}
