package streamAPI.exercise11_customCollectors.scenario1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import streamAPI.exercise4_collectors.scenario1.Pair;

public class ServiceCompanyDemo {
    private List<Comment> comments;

    public Map<String, List<Comment>> analyzeSentiment() {
        
        return comments.stream().filter(c -> c.getSentimentScore() != 0).collect(Collectors.groupingBy(Comment::getSentimentVerdict));
    }
    public Stream<String> getTextStream() {
        return comments.stream().map(c -> c.getText());
    }

    public List<Comment> getCategory(String category) {

        switch (category) {
            case "strongly negative":
                return comments.stream().filter(c -> c.getSentimentScore() >= -1 && c.getSentimentScore() < -0.5).toList();
            case "mildly negative":
                return comments.stream().filter(c -> c.getSentimentScore() >= -0.5 && c.getSentimentScore() < 0).toList();
            case "mildly positive":
                return comments.stream().filter(c -> c.getSentimentScore() >= 0 && c.getSentimentScore() < 0.5).toList();
            case "strongly positive":
                return comments.stream().filter(c -> c.getSentimentScore() >= 0.5 && c.getSentimentScore() < 1).toList();
            default:
                return null;
        }
    }

    public Map<String, Double> calculateAverageScore() {
        return comments.stream().collect(Collectors.groupingBy(Comment::getSentimentVerdict, Collectors.averagingDouble(Comment::getSentimentScore)));
    }

    // AI Copied
    public Map<String, Pair<Comment, Comment>> findBestWorstComments() {
        return comments.stream()
            .collect(Collectors.groupingBy(
                Comment::getSentimentVerdict,
                Collector.of(
                    () -> new Comment[]{null, null},
                    (result, comment) -> {
                        if (result[0] == null || comment.getSentimentScore() < result[0].getSentimentScore()) {
                            result[0] = comment;
                        }
                        if (result[1] == null || comment.getSentimentScore() > result[1].getSentimentScore()) {
                            result[1] = comment;
                        }
                    },
                    (result1, result2) -> {
                        if (result2[0] != null && (result1[0] == null || result2[0].getSentimentScore() < result1[0].getSentimentScore())) {
                            result1[0] = result2[0];
                        }
                        if (result2[1] != null && (result1[1] == null || result2[1].getSentimentScore() > result1[1].getSentimentScore())) {
                            result1[1] = result2[1];
                        }
                        return result1;
                    },
                    result -> new Pair<>(result[0], result[1])
                )
            ));
    }
    
    public Map<String, Map<String, List<Comment>>> groupCommentsBySource() {
        return comments.stream().collect(Collectors.groupingBy(Comment::getSource, Collectors.groupingBy(Comment::getSentimentVerdict)));
    }

    public Map<String, Map<String, Pair<Double, Long>>> calculateTotalSentimentScoreAndCount() {

        return comments.stream().collect(Collectors.groupingBy(Comment::getSource, Collectors.groupingBy(Comment::getSentimentVerdict, Collectors.collectingAndThen(Collectors.teeing(Collectors.summingDouble(Comment::getSentimentScore), Collectors.counting(), (sum, count) -> new Pair<Double, Long>(sum, count)), pair -> pair))));
    }

    public Map<String, Map<Object, Object>> calculateAverageSentimentScore(Map<String, Map<String, Pair<Double, Long>>> sentimentScoreAndCount) {
        
        return sentimentScoreAndCount.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, subEntry -> subEntry.getValue().getKey() / subEntry.getValue().getValue()))));
    }
}
