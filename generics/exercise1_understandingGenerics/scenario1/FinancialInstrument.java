package generics.exercise1_understandingGenerics.scenario1;

public class FinancialInstrument<T> {
    private double currentPrice;
    private double priceAtPurchase;
    private FinancialInstrument<T> instrument;
    private final double volatality;

    public FinancialInstrument(double volatality, double currentPrice) {
        this.volatality = volatality;
        this.currentPrice = currentPrice;
    }

    public void setInstrument(FinancialInstrument<T> instrument) {
        this.instrument = instrument;
    }
    public FinancialInstrument<T> getFinancialInstrument() {
        return instrument;
    }

    public double calculateROI(FinancialInstrument<T> instrument) {
        return instrument.getPriceAtPurchase() / instrument.getCurrentPrice();
    }

    public double calculateRisk(FinancialInstrument<T> instrument) {
        return calculateROI(instrument) * volatality;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }
    public double getPriceAtPurchase() {
        return priceAtPurchase;
    }
    public double getVolatality() {
        return volatality;
    }
    public FinancialInstrument<T> getInstrument() {
        return instrument;
    }
}
