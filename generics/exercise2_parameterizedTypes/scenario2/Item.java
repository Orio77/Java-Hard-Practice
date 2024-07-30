package generics.exercise2_parameterizedTypes.scenario2;

public class Item<T> {
    private T property;

    public Item(T property) {
        this.property = property;
    }

    public void updateItem(T property) {
        this.property = property;
    }

    public T queryItem() {
        return this.property;
    }
}
