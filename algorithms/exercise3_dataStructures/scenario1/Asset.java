package algorithms.exercise3_dataStructures.scenario1;

import java.util.LinkedList;

public class Asset {
    private double value;
    private String name;
    private LinkedList<Asset> subAssets;

    public Asset(String name, double value) {
        this.name = name;
        this.value = value;
        subAssets = new LinkedList<>();
    }

    public String getName() {
        return name;
    }
    public LinkedList<Asset> getSubAssets() {
        return subAssets;
    }
    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name;
    }
}
