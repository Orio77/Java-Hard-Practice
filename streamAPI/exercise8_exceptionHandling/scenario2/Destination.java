package streamAPI.exercise8_exceptionHandling.scenario2;

import java.util.List;

public class Destination {
    private String name;
    private int distance; // (miles)
    private int popularity; // (1-10)
    private List<Review> reviews;

    public Destination(String name, int distance, int popularity, List<Review> reviews) {
        this.name = name;
        this.distance = distance;
        this.popularity = popularity;
        this.reviews = reviews;
    }

    public int getDistance() {
        return distance;
    }
    public String getName() {
        return name;
    }
    public int getPopularity() {
        return popularity;
    }
    public List<Review> getReviews() {
        return reviews;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
