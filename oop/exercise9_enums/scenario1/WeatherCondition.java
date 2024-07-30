package oop.exercise9_enums.scenario1;

public enum WeatherCondition {
    SUNNY("Sunny", 25, 40) {
        @Override
        public double calculateLikelihood() {
            return 0;
        }
    },
    CLOUDY("Cloudy", 10, 20) {
        @Override
        public double calculateLikelihood() {
            return 0;
        }
    },
    RAINY("Rainy", 1, 25) {
        @Override
        public double calculateLikelihood() {
            return 0;
        }
    },
    SNOWY("Snowy", -20, 0) {
        @Override
        public double calculateLikelihood() {
            return 0;
        }
    },
    WINDY("Windy", 10, 20) {
        @Override
        public double calculateLikelihood() {
            return 0;
        }
    };

    private final String description;
    private final int minimumTemperature;
    private final int maximumTemperature;

    private WeatherCondition(String description, int minimumTemperature, int maximumTemperature) {
        this.description = description;
        this.minimumTemperature = minimumTemperature;
        this.maximumTemperature = maximumTemperature;
    }

    public abstract double calculateLikelihood();

    public String getDescription() {
        return this.description;
    }

    public int getMaximumTemperature() {
        return maximumTemperature;
    }

    public int getMinimumTemperature() {
        return minimumTemperature;
    }
}
