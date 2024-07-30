package streamAPI.exercise9_streamPerformance.scenario3;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SportAnalysisApp {
    
    
    public List<String> findTopPerformers(List<Player> players, int n) {
        return players.stream().sorted((player1, player2) -> {
            Double scores1 = player1.getGames().stream().flatMap(game -> game.getPerformances().stream()).collect(Collectors.averagingDouble(Perfornamce::getScore));
            Double scores2 = player2.getGames().stream().flatMap(game -> game.getPerformances().stream()).collect(Collectors.averagingDouble(Perfornamce::getScore));
            return scores1.compareTo(scores2);
        }).limit(n).map(Player::getName).toList();
    }

    public List<String> findMostConsistentPlayers(List<Player> players, int n) {
        return players.stream().filter((Player player) -> {
            Double scores = player.getGames().stream().flatMap(game -> game.getPerformances().stream()).collect(Collectors.averagingDouble(Perfornamce::getScore));
            if (scores < 10) { // average of scores being less than this number 
                return true;    // instead of the standard deviation
            }
            return false;
        }).limit(n).map(Player::getName).toList();
    }

   
    public List<String> findTopTeams(List<Team> teams, int n) {
        return teams.stream().sorted((team1, team2) -> {
            Double scores1 = team1.getPlayers().stream().flatMap(player -> player.getGames().stream()).flatMap(game -> game.getPerformances().stream()).collect(Collectors.averagingDouble(Perfornamce::getScore));
            Double scores2 = team2.getPlayers().stream().flatMap(player -> player.getGames().stream()).flatMap(game -> game.getPerformances().stream()).collect(Collectors.averagingDouble(Perfornamce::getScore));
        
            return scores1.compareTo(scores2);
        }).limit(n).map(Team::getName).toList();
    }

    public List<String> findMostImprovedTeams(List<Team> teams, int n) {
        return teams.stream().sorted((team1, team2) -> {
            long scoresNumber1 = team1.getPlayers().stream().flatMap(player -> player.getGames().stream()).flatMap(game -> game.getPerformances().stream()).sorted(Comparator.comparing(Perfornamce::getTimestamp)).count();
            long scoresNumber2 = team2.getPlayers().stream().flatMap(player -> player.getGames().stream()).flatMap(game -> game.getPerformances().stream()).sorted(Comparator.comparing(Perfornamce::getTimestamp)).count();

            Double firstHalfScores1 = team1.getPlayers().stream().flatMap(player -> player.getGames().stream()).flatMap(game -> game.getPerformances().stream()).sorted(Comparator.comparing(Perfornamce::getTimestamp)).limit(scoresNumber1).collect(Collectors.averagingDouble(Perfornamce::getScore));
            Double secondHalfScores1 = team1.getPlayers().stream().flatMap(player -> player.getGames().stream()).flatMap(game -> game.getPerformances().stream()).sorted(Comparator.comparing(Perfornamce::getTimestamp).reversed()).limit(scoresNumber1).collect(Collectors.averagingDouble(Perfornamce::getScore));

            Double firstHalfScores2 = team2.getPlayers().stream().flatMap(player -> player.getGames().stream()).flatMap(game -> game.getPerformances().stream()).sorted(Comparator.comparing(Perfornamce::getTimestamp)).limit(scoresNumber2).collect(Collectors.averagingDouble(Perfornamce::getScore));
            Double secondHalfScores2 = team2.getPlayers().stream().flatMap(player -> player.getGames().stream()).flatMap(game -> game.getPerformances().stream()).sorted(Comparator.comparing(Perfornamce::getTimestamp).reversed()).limit(scoresNumber2).collect(Collectors.averagingDouble(Perfornamce::getScore));

            Double result1 = secondHalfScores1 - firstHalfScores1;
            Double result2 = secondHalfScores2 - firstHalfScores2;

            return result1.compareTo(result2);
        }).limit(n).map(Team::getName).toList();
    }


    public List<Match> findTopMatches(List<Match> matches, int n) {
        return matches.stream().sorted((m1, m2) -> {
            Double avgScore1 = m1.getTeams().stream().flatMap(team -> team.getPlayers().stream()).flatMap(player -> player.getGames().stream()).flatMap(game -> game.getPerformances().stream()).collect(Collectors.averagingDouble(Perfornamce::getScore));
            Double avgScore2 = m2.getTeams().stream().flatMap(team -> team.getPlayers().stream()).flatMap(player -> player.getGames().stream()).flatMap(game -> game.getPerformances().stream()).collect(Collectors.averagingDouble(Perfornamce::getScore));
        
            return avgScore1.compareTo(avgScore2);
        }).limit(n).toList();
    }

    public List<Match> findMostExcitingMatches(List<Match> matches, int n) {
        return matches.stream().filter(match -> {
            Double avgScore = match.getTeams().stream().flatMap(team -> team.getPlayers().stream()).flatMap(player -> player.getGames().stream()).flatMap(game -> game.getPerformances().stream()).collect(Collectors.averagingDouble(Perfornamce::getScore));

            if (avgScore < 10) { // instead of standard deviation
                return false;
            }
            return true;
        }).limit(n).toList();
    }

   
    public List<Season> findTopSeasons(List<Season> seasons, int n) {
        return seasons.stream().sorted((s1, s2) -> {
            Double avg1 = s1.getMatches().stream().flatMap(match -> match.getTeams().stream()).flatMap(team -> team.getPlayers().stream()).flatMap(player -> player.getGames().stream()).flatMap(game -> game.getPerformances().stream()).collect(Collectors.averagingDouble(Perfornamce::getScore));
            Double avg2 = s2.getMatches().stream().flatMap(match -> match.getTeams().stream()).flatMap(team -> team.getPlayers().stream()).flatMap(player -> player.getGames().stream()).flatMap(game -> game.getPerformances().stream()).collect(Collectors.averagingDouble(Perfornamce::getScore));
            
            return avg1.compareTo(avg2);
        }).limit(n).toList();
    }

    public List<Season> findMostExcitingSeasons(List<Season> seasons, int n) {
        return seasons.stream().filter(season -> {
            Double avg = season.getMatches().stream().flatMap(match -> match.getTeams().stream()).flatMap(team -> team.getPlayers().stream()).flatMap(player -> player.getGames().stream()).flatMap(game -> game.getPerformances().stream()).collect(Collectors.averagingDouble(Perfornamce::getScore));

            if (avg < 50) {     // instead of standard deviation
                return false;
            }
            return true;
        }).limit(n).toList();
    }
    
    public List<Season> findMostImprovedSeasons(List<Season> seasons, int n) {
        return seasons.stream().sorted((s1, s2) -> {
            long scoresNumber1 = s1.getMatches().stream().flatMap(match -> match.getTeams().stream()).flatMap(team -> team.getPlayers().stream()).flatMap(player -> player.getGames().stream()).flatMap(game -> game.getPerformances().stream()).count();
            long scoresNumber2 = s2.getMatches().stream().flatMap(match -> match.getTeams().stream()).flatMap(team -> team.getPlayers().stream()).flatMap(player -> player.getGames().stream()).flatMap(game -> game.getPerformances().stream()).count();

            Double avgFirstHalf1 = s1.getMatches().stream().flatMap(match -> match.getTeams().stream()).flatMap(team -> team.getPlayers().stream()).flatMap(player -> player.getGames().stream()).flatMap(game -> game.getPerformances().stream()).sorted(Comparator.comparing(Perfornamce::getScore)).limit(scoresNumber1).collect(Collectors.averagingDouble(Perfornamce::getScore));
            Double avgSecondHalf1 = s1.getMatches().stream().flatMap(match -> match.getTeams().stream()).flatMap(team -> team.getPlayers().stream()).flatMap(player -> player.getGames().stream()).flatMap(game -> game.getPerformances().stream()).sorted(Comparator.comparing(Perfornamce::getScore).reversed()).limit(scoresNumber1).collect(Collectors.averagingDouble(Perfornamce::getScore));

            Double avgFirstHalf2 = s2.getMatches().stream().flatMap(match -> match.getTeams().stream()).flatMap(team -> team.getPlayers().stream()).flatMap(player -> player.getGames().stream()).flatMap(game -> game.getPerformances().stream()).sorted(Comparator.comparing(Perfornamce::getScore)).limit(scoresNumber2).collect(Collectors.averagingDouble(Perfornamce::getScore));
            Double avgSecondHalf2 = s2.getMatches().stream().flatMap(match -> match.getTeams().stream()).flatMap(team -> team.getPlayers().stream()).flatMap(player -> player.getGames().stream()).flatMap(game -> game.getPerformances().stream()).sorted(Comparator.comparing(Perfornamce::getScore).reversed()).limit(scoresNumber2).collect(Collectors.averagingDouble(Perfornamce::getScore));

            Double result1 = avgSecondHalf1 - avgFirstHalf1;
            Double result2 = avgSecondHalf2 - avgFirstHalf2;
            
            return result1.compareTo(result2);
        }).limit(n).toList();
    }
}
