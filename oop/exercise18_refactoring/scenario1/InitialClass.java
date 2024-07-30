package oop.exercise18_refactoring.scenario1;

import java.util.*;

public class InitialClass {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Shape("Circle", 10.0));
        shapes.add(new Shape("Square", 5.0));
        shapes.add(new Shape("Rectangle", 5.0, 10.0));

        for (Shape shape : shapes) {
            if (shape.getType().equals("Circle")) {
                System.out.println("The area of the circle is " + (3.14 * shape.getRadius() * shape.getRadius()));
            } else if (shape.getType().equals("Square")) {
                System.out.println("The area of the square is " + (shape.getLength() * shape.getLength()));
            } else if (shape.getType().equals("Rectangle")) {
                System.out.println("The area of the rectangle is " + (shape.getLength() * shape.getWidth()));
            }
        }
    }
}

class Shape {
    private String type;
    private Double radius;
    private Double length;
    private Double width;

    public Shape(String type, Double radius) {
        this.type = type;
        this.radius = radius;
    }

    public Shape(String type, Double length, Double width) {
        this.type = type;
        this.length = length;
        this.width = width;
    }

    public String getType() {
        return type;
    }

    public Double getRadius() {
        return radius;
    }

    public Double getLength() {
        return length;
    }

    public Double getWidth() {
        return width;
    }
}