package oop.exercise15_designPrinciples.scenario2.base;

import java.util.ArrayList;

public class Books extends Product{
    private String author;
    private String title;
    private String genre;
    private boolean isBestseller;
    private ArrayList<Double> discounts;

    

    public Books(String author, String title, String genre, boolean isBestseller) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.isBestseller = isBestseller;
        discounts = new ArrayList<>();
    }

    @Override
    public String getDetails() {
        return "Title: " + title + "\nAuthor: " + author + "\ngenre: " + genre;
    }

    @Override
    public double getPrice() {
        double price = getPrice();

        for (Double discount : discounts) {
            price = price * (1 - discount);
        }

        return price;
    }

    @Override
    public void applyDiscount(double discount) {
        if (!isBestseller)
            setPrice(getPrice() * (1 - discount));
    }

    public String getTitle() {
        return title;
    }
    public String getGenre() {
        return genre;
    }
    public String getAuthor() {
        return author;
    }
    public boolean isBestSeller() {
        return isBestseller;
    }
}
