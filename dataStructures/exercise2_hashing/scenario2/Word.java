package dataStructures.exercise2_hashing.scenario2;

public class Word {
    private String content;

    public Word(String content) {
        this.content = content;
    }

    public int hashWord() {
        return content.hashCode();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
