package dataStructures.exercise11_advancedDS.scenario1;
// AI Generated (manually coded, but still)
public class QuadTree {
    Node root;
    int capacity;

    public QuadTree(BoundingBox box, int capacity) {
        root =  new Node(box);
        this.capacity = capacity;
    }

    public void insert(Location point) {
        insert(root, point);
    }

    private void insert(Node node, Location point) {

        if (!node.getBox().contains(point))
            return;


        if (node.isLeaf()) {
            if (node.getPoint() == null) {
                node.setPoint(point);
            }
            else {
                node.subDivide();

                insert(node.getNorthWest(), node.getPoint());
                insert(node.getNorthEast(), node.getPoint());
                insert(node.getSouthWest(), node.getPoint());
                insert(node.getSouthEast(), node.getPoint());

                node.setPoint(null);

                insert(node.getNorthEast(), point);
                insert(node.getNorthEast(), point);
                insert(node.getSouthWest(), point);
                insert(node.getNorthEast(), point);
            }
        }
        else {
            insert(node.getNorthEast(), point);
            insert(node.getNorthEast(), point);
            insert(node.getSouthWest(), point);
            insert(node.getNorthEast(), point);
        }

    }
}
