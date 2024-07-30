package generics.exercise13_genericsInDesignPatterns.scenario3;

public class MessageFactory {
    
    public <T> Message createMessage(Class<T> type, String content) {
        if (type.equals(TextMessage.class)) {
            return new TextMessage(content);
        } 
        else if (type.equals(VoiceMessage.class)) {
            return new VoiceMessage(content);
        }
        else if (type.equals(ImageMessage.class)) {
            return new ImageMessage(content);
        }    
        else {
            return null;
        }
    }
}
