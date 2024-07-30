package streamAPI.exercise6_handlingNulls.scenario2;

import java.util.List;

public class Article {
    private String title;
    private String content;
    private List<String> tags;

    public String getContent() {
        return content;
    }
    public List<String> getTags() {
        return tags;
    }
    public String getTitle() {
        return title;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
