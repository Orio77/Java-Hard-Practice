package generics.exercise13_genericsInDesignPatterns.scenario3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MessageCollection<T extends Message> {
    private List<T> messages;

    public MessageCollection() {
        messages = new ArrayList<>();
    }

    public boolean addMessage(T message) {
        return messages.add(message);
    }

    public boolean removeMessage(T message) {
        return messages.remove(message);
    }

    public List<T> getAllMessages() {
        return Collections.unmodifiableList(messages);
    }

    public T removeMessage(int index) {
        return messages.remove(index);
    }

    public List<T> filterMessages(Predicate<T> predicate) {
        return messages.stream().filter(predicate).collect(Collectors.toList());
    }

    public List<T> transformMessages(Function<T, T> function) {
        return messages.stream().map(function).collect(Collectors.toList());
    }
}
