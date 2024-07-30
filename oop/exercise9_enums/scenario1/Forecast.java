package oop.exercise9_enums.scenario1;

public class Forecast {
    WeatherCondition condition;

    public void getDetailedForecast(WeatherCondition condition) {
        System.out.println("The weather is " + condition.getDescription() + " with typical temperatures between "
                + condition.getMinimumTemperature() + " and " + condition.getMaximumTemperature()
                + ". Based on historical data, there is a " + condition.calculateLikelihood()
                + "% chance of this condition");
    }

    public void displayWeatherIcon(WeatherCondition condition) {
        System.out.println("Displaying " + condition.getDescription() + " icon");
    }

    public void displayWeatherAnimation(WeatherCondition condition) {
        System.out.println("Displaying " + condition.getDescription() + " icon");
    }
}
