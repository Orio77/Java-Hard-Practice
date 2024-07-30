package streamAPI.exercise8_exceptionHandling.scenario2;

public class Review {
    private int rating; // (1-5)
    private String comment;

    public Review(int rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }
    public int getRating() {
        return rating;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    
}
