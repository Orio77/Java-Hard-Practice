package oop.exercise4_constructorOverloading.scenario2;

import java.util.ArrayList;

public class Menu {
    private ArrayList<MenuItem> dishes;

    public boolean addDish(MenuItem menuItem) {
        return dishes.add(menuItem);
    }

    public boolean removeDish(MenuItem menuItem) {
        return dishes.remove(menuItem);
    }
    
    public void initializeDishes() {
        ArrayList<String> ingredients = new ArrayList<>();
        dishes.add(new MenuItem("PastaCheese", 7));
        ingredients.add("Pasta");
        dishes.add(new MenuItem("Macaroni", 10, ingredients));
        ingredients = new ArrayList<>();
        ingredients.add("Pasta");
        dishes.add(new MenuItem("Ballocio", 15, ingredients, "Luxurious dish"));
    }

    public void extendDish(MenuItem dish, String ingredient) {
        MenuItem newDish = new MenuItem(dish);
        dishes.add(new MenuItem(newDish));
        newDish.getIngredients().add(ingredient);
    }

    public void updateDescription(MenuItem menuItem, String description) {
        if (dishes.contains(menuItem)) {
            menuItem.setDescription(description);
        }
    }
}
