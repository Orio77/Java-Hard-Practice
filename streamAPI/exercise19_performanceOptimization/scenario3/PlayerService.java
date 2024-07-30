package streamAPI.exercise19_performanceOptimization.scenario3;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class PlayerService {
    
    public List<Player> topScoringPlayers(List<Player> players, int n) {
        return players.stream().sorted(Comparator.comparing(Player::getScore)).limit(n).toList();
    }

    public double playerWinPercentage(List<Player> players, String playerName) {
        Optional<Player> optionalTarget = players.stream().filter(player -> player.getName().matches(playerName)).findAny();
        Player target = null;

        if (optionalTarget.isPresent()) {
            return 0.0;
        }
        target = optionalTarget.get();

        int totalMatches = target.getMatchOutcomes().size();
        long wonMatches = target.getMatchOutcomes().stream().filter(outcome -> outcome.getResult().matches("won")).count();

        return wonMatches / totalMatches;
    }

    public Map<String, List<MatchOutcome>> groupMatchOutcomesByResult(List<Player> players, String playerName) {
        Optional<Player> optionalTarget = players.stream().filter(player -> player.getName().matches(playerName)).findAny();
        Player target = null;

        if (optionalTarget.isPresent()) {
            return null;
        }
        target = optionalTarget.get();

        return target.getMatchOutcomes().stream().collect(Collectors.groupingBy(MatchOutcome::getResult));
    }

    public Map<String, Double> averageScoreByResult(List<Player> players, String playerName) {
        Optional<Player> optionalTarget = players.stream().filter(player -> player.getName().matches(playerName)).findAny();
        Player target = null;

        if (optionalTarget.isPresent()) {
            return null;
        }
        target = optionalTarget.get();

        return target.getMatchOutcomes().stream().collect(Collectors.groupingBy(MatchOutcome::getResult, Collectors.averagingDouble(MatchOutcome::getScore)));
    }

    public List<Player> topScoringPlayersParallel(List<Player> players, int n) {
        return players.parallelStream().sorted(Comparator.comparing(Player::getScore)).limit(n).toList();
    }

    public double playerWinPercentageParallel(List<Player> players, String playerName) {
        Optional<Player> optionalTarget = players.parallelStream().filter(player -> player.getName().matches(playerName)).findAny();
        Player target = null;

        if (optionalTarget.isPresent()) {
            return 0.0;
        }
        target = optionalTarget.get();

        int totalMatches = target.getMatchOutcomes().size();
        long wonMatches = target.getMatchOutcomes().parallelStream().filter(outcome -> outcome.getResult().matches("won")).count();

        return wonMatches / totalMatches;
    }

    public List<Player> safeTopScoringPlayers(List<Player> players, int n) {
        if (players == null || players.isEmpty() || n <= 0) {
            return null;
        }
        return players.stream().filter(player -> player.getScore() > 0 && Objects.nonNull(player)).sorted(Comparator.comparing(Player::getScore)).limit(n).toList();
    }

    public double safePlayerWinPercentage(List<Player> players, String playerName) {
        if (playerName == null || players.isEmpty() || playerName == null || playerName.isBlank()) {
            return 0.0;
        }
        Optional<Player> optionalTarget = players.stream().filter(player -> player.getName() != null && player.getName().matches(playerName)).findAny();
        Player target = null;

        if (optionalTarget.isPresent()) {
            return 0.0;
        }
        target = optionalTarget.get();

        int totalMatches = target.getMatchOutcomes().size();
        long wonMatches = target.getMatchOutcomes().stream().filter(outcome -> outcome.getResult() != null && outcome.getResult().matches("won")).count();

        return wonMatches / totalMatches;
    }

    public Map<String, Double> safeAverageScoreByResult(List<Player> players, String playerName) {
        if (playerName == null || players.isEmpty() || playerName == null || playerName.isBlank()) {
            return null;
        }
        Optional<Player> optionalTarget = players.stream().filter(player -> player.getName() != null && player.getName().matches(playerName)).findAny();
        Player target = null;

        if (optionalTarget.isPresent()) {
            return null;
        }
        target = optionalTarget.get();

        return target.getMatchOutcomes().stream().filter(outcome -> outcome.getResult() != null && outcome.getScore() > 0).collect(Collectors.groupingBy(MatchOutcome::getResult, Collectors.averagingDouble(MatchOutcome::getScore)));
    }
}
