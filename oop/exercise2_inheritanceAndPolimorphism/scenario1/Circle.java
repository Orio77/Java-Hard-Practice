package oop.exercise2_inheritanceAndPolimorphism.scenario1;

public class Circle extends Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void calculateArea() {
        double area = Math.PI * radius * radius;
        System.out.println("Area: " + area);
    }

    @Override
    void calculatePerimeter() {
        double perimeter = 2 * Math.PI * radius;
        System.out.println("Perimeter: " + perimeter);
    }

    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}
