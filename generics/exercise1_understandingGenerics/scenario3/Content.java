package generics.exercise1_understandingGenerics.scenario3;

public class Content<T> {
    private T content;

    public Content(T content) {
        setContent(content);
    }

    public T getContent() {
        return content;
    }
    public void setContent(T content) {
        this.content = content;
    }

}
