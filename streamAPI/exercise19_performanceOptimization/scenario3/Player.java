package streamAPI.exercise19_performanceOptimization.scenario3;

import java.util.List;

public class Player {
    private String name;
    private int score;
    private List<MatchOutcome> matchOutcomes;

    public List<MatchOutcome> getMatchOutcomes() {
        return matchOutcomes;
    }
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
}
