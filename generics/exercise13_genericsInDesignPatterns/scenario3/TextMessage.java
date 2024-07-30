package generics.exercise13_genericsInDesignPatterns.scenario3;

public class TextMessage implements Message {
    private String content;

    public TextMessage(String content) {
        this.content = content;
    }

    @Override
    public String getContetnt() {
        return content;
    }

    @Override
    public String getType() {
        return "text";
    }
}
