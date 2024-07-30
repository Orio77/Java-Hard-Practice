package generics.exercise14.scenario2;

import java.time.LocalDateTime;

public class RealTimeTradeProcessor<T extends Trade<?>> implements TradeProcessor<T> {

    @Override
    public void process(T trade) {
        
        System.out.println("Processing the trade");
        System.out.println("Trade details:");
        System.out.println("Price: " + trade.getPrice());
        System.out.println("Quantity: " + trade.getQuantity());
        System.out.println("Symbol: " + trade.getSymbol());
        System.out.println("Time of the trade: " + LocalDateTime.now());
    }
    
}
