package oop.exercise15_designPrinciples.scenario1;

public class Button implements VisualElements{
    private String content;

    @Override
    public void display() {
        System.out.println("Displaying the '" + content + "'");
    }

    @Override
    public void interact() {
        System.out.println("Performing " + content + " action");
    }
    
}
