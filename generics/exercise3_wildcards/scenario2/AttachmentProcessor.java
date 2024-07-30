package generics.exercise3_wildcards.scenario2;

import java.util.stream.Stream;

public class AttachmentProcessor<T> {
    private Message<T> message;

    public Stream<T> process() {
        return message.getAttachedFiles().stream();
    }

    public Message<T> getMessage() {
        return message;
    }
}
