package generics.exercise1_understandingGenerics.scenario1;

public class Option extends FinancialInstrument<Option>{
    private double strikePrice;
    private double assetPrice;
    private double delta;
    private final double volatality = 0.4;

    public Option(double volatality, double currentPrice) {
        super(volatality, currentPrice);
    }
    
    
    @Override
    public double calculateROI(FinancialInstrument<Option> instrument) {
        return (strikePrice - assetPrice) * volatality;
    }

    @Override
    public double calculateRisk(FinancialInstrument<Option> instrument) {
        return delta;
    }
}
