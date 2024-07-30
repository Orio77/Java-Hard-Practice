package generics.exercise11_genericsInStreams.scenario2;

public class Phenomenon<T> {
    private T type;

    public T simulate() {
        System.out.println("A phenomenon occured");
        return type;
    }
}
