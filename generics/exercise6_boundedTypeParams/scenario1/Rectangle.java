package generics.exercise6_boundedTypeParams.scenario1;

public class Rectangle implements Shape{
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double getArea() {
        return width*height;
    }
}
