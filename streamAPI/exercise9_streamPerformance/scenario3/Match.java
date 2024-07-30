package streamAPI.exercise9_streamPerformance.scenario3;

import java.time.LocalDateTime;
import java.util.List;

public class Match {
    private LocalDateTime timestamp;
    private List<Team> teams;

    public List<Team> getTeams() {
        return teams;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
