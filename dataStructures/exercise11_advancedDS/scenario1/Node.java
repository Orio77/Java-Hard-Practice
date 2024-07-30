package dataStructures.exercise11_advancedDS.scenario1;
// AI Generated (manually coded, but still)
public class Node {
    BoundingBox box;
    Node northWest;
    Node northEast;
    Node southWest;
    Node southEast;
    Location point;

    public Node(BoundingBox box) {
        this.box = box;
        northWest = null;
        northEast = null;
        southWest = null;
        southEast = null;
        point = null;
    }
    public BoundingBox getBox() {
        return box;
    }

    public boolean isLeaf() {
        return (northWest == null && northEast == null && southWest == null && southEast == null);
    }

    public void subDivide() {
        double midX = (box.getMinX() + box.getMaxX()) / 2;
        double midY = (box.getMinY() + box.getMaxY()) / 2;

        northWest = new Node(new BoundingBox(box.getMinX(), box.getMinY(), midX, midY));
        northEast = new Node(new BoundingBox(midX, box.getMinY(), box.getMaxX(), midY));
        southWest = new Node(new BoundingBox(box.getMinX(), midY, midX, box.getMaxY()));
        northEast = new Node(new BoundingBox(midX, midY, box.getMaxX(), box.getMaxY()));
    }

    public Location getPoint() {
        return point;
    }
    public void setPoint(Location point) {
        this.point = point;
    }
    public Node getNorthEast() {
        return northEast;
    }
    public Node getNorthWest() {
        return northWest;
    }
    public Node getSouthEast() {
        return southEast;
    }
    public Node getSouthWest() {
        return southWest;
    }
    public void setBox(BoundingBox box) {
        this.box = box;
    }
    public void setNorthEast(Node northEast) {
        this.northEast = northEast;
    }
    public void setNorthWest(Node northWest) {
        this.northWest = northWest;
    }
    public void setSouthEast(Node southEast) {
        this.southEast = southEast;
    }
}
