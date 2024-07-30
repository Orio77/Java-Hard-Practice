package algorithms.exercise8_divideAndConquer.scenario1;

public class Asset {
    private double riskLevel;
    private double potentialReturn;

    public Asset(double riskLevel, double potentialReturn) {
        this.riskLevel = riskLevel;
        this.potentialReturn = potentialReturn;
    }

    public double getPotentialReturn() {
        return potentialReturn;
    }
    public double getRiskLevel() {
        return riskLevel;
    }
}
