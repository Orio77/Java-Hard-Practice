package generics.exercise14.scenario2;

public class TradeEngine<T extends Trade<?>> {
    private TradeProcessor<T> currentTradeProcessor;

    public void setTradeProcessor(TradeProcessor<T> tradeProcessor) {
        currentTradeProcessor = tradeProcessor;
    }

    public void executeTrade(T trade) {
        currentTradeProcessor.process(trade);
    }
}
