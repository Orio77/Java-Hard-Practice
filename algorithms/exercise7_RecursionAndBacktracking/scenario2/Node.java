package algorithms.exercise7_RecursionAndBacktracking.scenario2;

import java.util.LinkedList;

public class Node {
    LinkedList<Node> children;
    int depth;

    public Node() {
        children = new LinkedList<>();
    }
    public void setDepth(int depth) {
        this.depth = depth;
    }
    public int getDepth() {
        return depth;
    }
    public LinkedList<Node> getChildren() {
        return children;
    }
}
