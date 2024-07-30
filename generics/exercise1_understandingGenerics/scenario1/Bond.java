package generics.exercise1_understandingGenerics.scenario1;

public class Bond extends FinancialInstrument<Bond>{
    private double coupon;
    private double duration;
    private final double volatality = 0.1;


    public Bond(double volatality, double currentPrice) {
        super(volatality, currentPrice);
    }
    
    @Override
    public double calculateROI(FinancialInstrument<Bond> instrument) {
        return coupon * (instrument.getCurrentPrice() - instrument.getPriceAtPurchase()) / instrument.getPriceAtPurchase();
    }

    @Override
    public double calculateRisk(FinancialInstrument<Bond> instrument) {
        return duration;
    }

    public double getVolatality() {
        return volatality;
    }
}
