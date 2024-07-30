package generics.exercise13.scenario2;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameState {
    private List<EnemyAI<?>> enemies;
    
    public List<EnemyAI<?>> getEnemies() {
        return Collections.unmodifiableList(enemies);
    }

    public String getPlayerState() {
        return simulateAnalyzingPlayerState();
    }

    private String simulateAnalyzingPlayerState() {
        Random random = new Random();

        if (random.nextInt(5) % 2 == 0) {
            return "Player fighting an enemy";
        }
        else {
            return "Player exploring the world";
        }
    }
}