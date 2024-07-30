package oop.exercise2_inheritanceAndPolimorphism.scenario1;

import java.util.ArrayList;

public class Drawing {
    ArrayList<Shape> shapes;

    public Drawing() {
        shapes = new ArrayList<>();
    }

    public void drawAll() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
