package algorithms.exercise7_RecursionAndBacktracking.scenario2;

public class Tree {
    Node root;

    public Tree() {
        root = new Node();
        root.setDepth(0);
    }

    public void generate(int limitDepth, int numberOfChildren) {
        insert(root, limitDepth, numberOfChildren);
    }

    public void insert(Node node, int limitDepth, int numberOfChildren) {
        if (node.getDepth() == limitDepth)
            return;

        for (int i = 0; i < numberOfChildren; i++) {
            node.getChildren().add(new Node());
        }

        for (Node child : node.getChildren()) {
            insert(child, limitDepth, numberOfChildren);
        }
    }
}
