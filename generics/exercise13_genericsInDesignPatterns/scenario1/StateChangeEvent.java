package generics.exercise13.scenario1;

public class StateChangeEvent<T> {
    private T previousState;
    private T currentState;

    public StateChangeEvent(T previousState, T currentState) {
        this.previousState = previousState;
        this.currentState = currentState;
    }

    public T getPreviousState() {
        return previousState;
    }
    public T getCurrentState() {
        return currentState;
    }
}
