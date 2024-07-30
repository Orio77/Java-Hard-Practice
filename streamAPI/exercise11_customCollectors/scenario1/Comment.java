package streamAPI.exercise11_customCollectors.scenario1;

import java.time.LocalDateTime;

public class Comment {
    private String text;
    private double sentimentScore;
    private String sentimentVerdict;
    private String source;
    private LocalDateTime commentTime;

    public double getSentimentScore() {
        return sentimentScore;
    }
    public String getText() {
        return text;
    }
    public String getSentimentVerdict() {
        return sentimentVerdict;
    }
    public String getSource() {
        return source;
    }
    public LocalDateTime getCommentTime() {
        return commentTime;
    }
}
