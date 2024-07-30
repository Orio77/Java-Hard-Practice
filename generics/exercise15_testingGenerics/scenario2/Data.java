package generics.exercise15.scenario2;

public class Data<T> {
    private T value;

    public Data(T value) {
        setValue(value);
    }

    public void setValue(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }
}
