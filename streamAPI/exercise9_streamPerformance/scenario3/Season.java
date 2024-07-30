package streamAPI.exercise9_streamPerformance.scenario3;

import java.util.List;

public class Season {
    private String year;
    private List<Match> matches;

    public List<Match> getMatches() {
        return matches;
    }
    public String getYear() {
        return year;
    }
}
