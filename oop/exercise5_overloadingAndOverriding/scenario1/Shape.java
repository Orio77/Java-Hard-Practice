package oop.exercise5_overloadingAndOverriding.scenario1;

public class Shape {

    public void draw() {
        System.out.println("Drawing a shape");
    }

    public void resize(int percent) {
        System.out.println("Resizing the shape by " + percent + "%");
    }
}
