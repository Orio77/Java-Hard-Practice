package generics.exercise13.scenario2;

public class GameAI<T extends GameState> {
    private Strategy<T> currentStrategy;

    public void setStrategy(Strategy<T> strategy) {
        currentStrategy = strategy;
    }

    public void executeStrategy(T state) {
        currentStrategy.execute(state);
    }


}
