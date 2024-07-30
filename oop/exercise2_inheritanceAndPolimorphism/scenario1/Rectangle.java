package oop.exercise2_inheritanceAndPolimorphism.scenario1;

public class Rectangle extends Shape {
    int a;
    int b;

    public Rectangle(int width, int height) {
        this.a = width;
        this.b = height;
    }

    @Override
    public void calculateArea() {
        double area = a * b;
        System.out.println("Area: " + area);
    }

    @Override
    void calculatePerimeter() {
        double perimeter = 2 * a + 2 * b;
        System.out.println("Perimeter: " + perimeter);
    }

    @Override
    void draw() {
        System.out.println("Drawing a rectangle");
    }
}
