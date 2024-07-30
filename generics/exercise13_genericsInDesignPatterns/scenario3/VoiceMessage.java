package generics.exercise13_genericsInDesignPatterns.scenario3;

public class VoiceMessage implements Message {
    private String content;

    public VoiceMessage(String content) {
        this.content = content;
    }

    @Override
    public String getContetnt() {
        return content;
    }

    @Override
    public String getType() {
        return "voice";
    }

}
