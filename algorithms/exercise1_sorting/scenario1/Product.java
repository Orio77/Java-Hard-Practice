package algorithms.exercise1_sorting.scenario1;

public class Product {
    private String name;
    private int price;
    private double popularity;
    private double ratings;

    public Product(String name, int price, double popularity, double ratings) {
        this.name = name;
        setPrice(price);
        setPopularity(popularity);
        setRatings(ratings);
    }

    public double getPopularity() {
        return popularity;
    }
    public void setPopularity(double popularity) {
        if (popularity > 0 && popularity <= 10.0)
            this.popularity = popularity;

        else
        this.popularity = 0.0;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        if (price > 0)
            this.price = price;

    }public double getRatings() {
        return ratings;
    }
    public void setRatings(double ratings) {
        if (ratings > 0 && ratings <= 5.0)
            this.ratings = ratings;

        else
            this.ratings = 0.0;
    }   

    @Override
    public String toString() {
        return name;
    }
}
