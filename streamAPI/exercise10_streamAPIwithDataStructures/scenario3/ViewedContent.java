package streamAPI.exercise10_streamAPIwithDataStructures.scenario3;

import java.time.LocalDateTime;

public class ViewedContent {
    private String contentId;
    private LocalDateTime timestamp;
    private String genre;
    private int rating;

    public String getContentId() {
        return contentId;
    }
    public String getGenre() {
        return genre;
    }
    public int getRating() {
        return rating;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
