package streamAPI.exercise2_lambdaExpressions.scenario3;

import java.time.LocalDate;

public class Transaction {
    private String ticker;
    private int volume;
    private double price;
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }
    public double getPrice() {
        return price;
    }
    public String getTicker() {
        return ticker;
    }
    public int getVolume() {
        return volume;
    }
}
