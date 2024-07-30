package oop.exercise5_overloadingAndOverriding.scenario1;

public class Circle extends Shape {

    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }

    public void draw(String colour) {
        System.out.println("Drawing a " + colour + " circle");
    }

    @Override
    public void resize(int percent) {
        System.out.println("Resizing circle by " + percent + "%");
    }
}
