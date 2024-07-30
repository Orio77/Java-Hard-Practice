package generics.exercise5_genericMethods.scenario2;

public class DataSource<T> {
    private T data;

    public DataSource(T data) {
        this.data = data;
    }

    public T retrieveData() {
        return data;
    }
}
