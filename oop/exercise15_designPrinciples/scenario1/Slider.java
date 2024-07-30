package oop.exercise15_designPrinciples.scenario1;

public class Slider implements VisualElements{

    @Override
    public void display() {
        
        System.out.println("Displaying the slider");
    }

    @Override
    public void interact() {
        System.out.println("Interaction with the slider detected");
    }
    
}
