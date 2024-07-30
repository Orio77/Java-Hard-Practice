package threads.exercise5_threadIntercommunication.scenario1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.List;
// AI Guided & AI Copied
class GameState {
    private int score;

    public GameState() {
        this.score = 0;
    }

    public synchronized void updateScore(int score) {
        this.score += score;
    }

    public synchronized int getScore() {
        return this.score;
    }
}

class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

class PlayerAction {
    private int scoreChange;

    public PlayerAction(int scoreChange) {
        this.scoreChange = scoreChange;
    }

    public int getScoreChange() {
        return this.scoreChange;
    }
}

class GameServer {
    void synchronizedUpdateGameState(GameState gameState, PlayerAction playerAction) {
        synchronized(gameState) {
            gameState.updateScore(playerAction.getScoreChange());
        }
    }

    void synchronizedBroadcastGameState(GameState gameState, List<Player> players) {
        synchronized(gameState) {
            for (Player player : players) {
                System.out.println("Player " + player.getName() + " got informed on the score: " + gameState.getScore());
            }
        }
    }

    void lockObjectUpdateGameState(GameState gameState, PlayerAction playerAction, Lock lock) {
        lock.lock();
        try {
            gameState.updateScore(playerAction.getScoreChange());
        } finally {
            lock.unlock();
        }
    }

    void lockObjectBroadcastGameState(GameState gameState, List<Player> players, Lock lock) {
        lock.lock();
        try {
            for (Player player : players) {
                System.out.println("Player " + player.getName() + " got informed on the score: " + gameState.getScore());
            }
        } finally {
            lock.unlock();
        }
    }

    void threadPoolUpdateGameState(ExecutorService executorService, GameState gameState, PlayerAction playerAction, AtomicInteger atomicInteger) {
        executorService.submit(() -> {
            gameState.updateScore(playerAction.getScoreChange());
            atomicInteger.incrementAndGet();
        });
    }

    void threadPoolBroadcastGameState(ExecutorService executorService, GameState gameState, List<Player> players, AtomicInteger atomicInteger) {
        executorService.submit(() -> {
            for (Player player : players) {
                System.out.println("Player " + player.getName() + " got informed on the score: " + gameState.getScore());
                System.out.println("Total score updates made so far: " + atomicInteger.get());
            }
        });
    }

    void daemonThreadUpdateGameState(GameState gameState, PlayerAction playerAction) {
        Thread daemonThread = new Thread(() -> {
            gameState.updateScore(playerAction.getScoreChange());
        });

        daemonThread.setDaemon(true);
        daemonThread.start();
    }

    void threadSafetyBroadcastGameState(GameState gameState, List<Player> players) {
        synchronized(gameState) {
            for (Player player : players) {
                System.out.println("Player " + player.getName() + " got informed on the score: " + gameState.getScore());
            }
        }
    }

    void performanceTuningUpdateGameState(GameState gameState, PlayerAction playerAction) {
        synchronized(gameState) {
            gameState.updateScore(playerAction.getScoreChange());
        } 
    }
}
