package generics.exercise13_genericsInDesignPatterns.scenario3;

public class ImageMessage implements Message {
    private String content;

    public ImageMessage(String content) {
        this.content = content;
    }

    @Override
    public String getContetnt() {
        return content;
    }

    @Override
    public String getType() {
        return "image";
    }
}
