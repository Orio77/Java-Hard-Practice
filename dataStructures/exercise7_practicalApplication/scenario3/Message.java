package dataStructures.exercise7_practicalApplication.scenario3;

public class Message {
    private String content;

    @Override
    public String toString() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
