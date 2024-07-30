package generics.exercise6_boundedTypeParams.scenario1;

public class AreaCalculator<T extends Shape> {
    
    public double calculateArea(T shape) {
        return shape.getArea();
    }
}
