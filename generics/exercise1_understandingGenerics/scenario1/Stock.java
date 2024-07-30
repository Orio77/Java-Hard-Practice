package generics.exercise1_understandingGenerics.scenario1;

public class Stock extends FinancialInstrument<Stock>{
    private final double volatality = 0.3;

    public Stock(double volatality, double currentPrice) {
        super(volatality, currentPrice);
    }


    @Override
    public double calculateROI(FinancialInstrument<Stock> instrument) {
        return (instrument.getCurrentPrice() - instrument.getPriceAtPurchase()) / instrument.getPriceAtPurchase();
    }

    @Override
    public double calculateRisk(FinancialInstrument<Stock> instrument) {
        return instrument.getCurrentPrice() * volatality;
    }
}
