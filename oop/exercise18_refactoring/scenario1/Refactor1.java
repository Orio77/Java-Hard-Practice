package oop.exercise18_refactoring.scenario1;

import java.util.*;

public class Refactor1 {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(10.0));
        shapes.add(new Square(5.0));
        shapes.add(new Rectangle(5.0, 10.0));

        for (Shape shape : shapes) {
            System.out.println("Area of the " + shape.getType() + " is: " + shape.calculateArea());
        }
    }
}

abstract class Shape {
    private String type;

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public abstract double calculateArea();
    public abstract double calculatePerimeter();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        setType("Circle");
    }


    public double getRadius() {
        return radius;
    }

    @Override
    public double calculateArea() {
        return (Math.PI * radius * radius);
    }

    @Override
    public double calculatePerimeter() {
        return (2 * Math.PI * radius);
    }
    
}

class Rectangle extends Shape {
    private double length;
    private double width;

    protected Rectangle(double length) {
        this.length = length;
        setType("Rectangle");
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
        setType("Rectangle");
    }

    public double getLength() {
        return length;
    }
    public double getWidth() {
        return width;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2*length + 2*width;
    }
}

class Square extends Rectangle {

    public Square(double length) {
        super(length);
        setWidth(length);
        setType("Square");
    }

    @Override
    public double getLength() {
        return super.getLength();
    }

    @Override
    public double getWidth() {
        return getLength();
    }

    @Override
    public double calculateArea() {
        return getLength()*getLength();
    }

    @Override
    public double calculatePerimeter() {
        return 4*getLength();
    }
}
