package algorithms.exercise8_divideAndConquer.scenario1;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private List<Asset> assets;
    private double potentialReturnPerRisk;

    public Portfolio() {
        this.assets = new ArrayList<>();
    }

    public void addAsset(Asset asset) {
        assets.add(asset);
    }
    public List<Asset> getAssets() {
        return assets;
    }

    public double getRiskLevel() {
        return assets.stream().mapToDouble(a -> a.getRiskLevel()).average().orElse(0);
    }

    public double getPotentialReturn() {
        return assets.stream().mapToDouble(a -> a.getPotentialReturn()).average().orElse(0);
    }

    public void setPotentialReturnPerRisk(double potentialReturnPerRisk) {
        this.potentialReturnPerRisk = potentialReturnPerRisk;
    }
    public double getPotentialReturnPerRisk() {
        return potentialReturnPerRisk;
    }
}
