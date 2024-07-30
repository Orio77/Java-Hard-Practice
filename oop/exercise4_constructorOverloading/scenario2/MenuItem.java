package oop.exercise4_constructorOverloading.scenario2;

import java.util.ArrayList;

public class MenuItem {
    private String name;
    private int price;
    private ArrayList<String> ingredients;
    private String description;

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public MenuItem(String name, int price, ArrayList<String> ingredients) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    public MenuItem(String name, int price, ArrayList<String> ingredients, String description) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.description = description;
    }

    public MenuItem(MenuItem menuItem) {
        this.name = menuItem.getName();
        this.price = menuItem.getPrice();
        this.ingredients = menuItem.getIngredients();
        this.description = menuItem.getDescription();
    }

    public MenuItem() {
        this.name = "Bread";
        this.price = 3;
        this.ingredients = new ArrayList<>();
        ingredients.add("Flour");
        ingredients.add("Eggs");
        this.description = "Bready bread";
    }


    public String getDescription() {
        return description;
    }
    public ArrayList<String> getIngredients() {
        return ingredients;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
