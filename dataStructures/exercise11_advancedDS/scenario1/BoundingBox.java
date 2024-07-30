package dataStructures.exercise11_advancedDS.scenario1;
// AI Generated (manually coded, but still)
public class BoundingBox {
    double minX;
    double minY;
    double maxX;
    double maxY;

    
    public BoundingBox(double minX, double minY, double maxX, double maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }
    public double getMaxX() {
        return maxX;
    }
    public double getMaxY() {
        return maxY;
    }
    public double getMinX() {
        return minX;
    }
    public double getMinY() {
        return minY;
    }

    public boolean contains(Location point) {
        return (point.getX() > minX && point.getX() < maxX && point.getY() > minY && point.getY() < maxY);
    }

    public boolean insertSects(BoundingBox otherBox) {
        return (this.maxX >= otherBox.getMinX() && this.minX <= otherBox.getMaxX() && this.maxY >= otherBox.getMinY() && this.minY <= otherBox.getMaxY());
    }
}
