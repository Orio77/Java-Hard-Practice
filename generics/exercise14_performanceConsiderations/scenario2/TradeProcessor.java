package generics.exercise14.scenario2;

public interface TradeProcessor<T extends Trade<?>> {
    
    public void process(T trade);
}
