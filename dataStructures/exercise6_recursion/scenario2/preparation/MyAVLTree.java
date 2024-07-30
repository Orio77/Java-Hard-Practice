package dataStructures.exercise6_recursion.scenario2.preparation;

public class MyAVLTree {
    private Node root;
    private Node left;
    private Node right;
    private int key;

    class Node {
        private int key;
        private int height;
        private Node left;
        private Node right;

        public Node(int key) {
            this.key = key;
            height = 1;
            left = null;
            right = null;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }
    }

    public int calculateHeight(Node node) {
        if (node != null)
            return node.getHeight();
        else 
            return -1;
    }

    public void updateHeight(Node node) {

    }

    public void leftRotation() {
        
    }

    public int getKey() {
        return key;
    }
    public Node getLeft() {
        return left;
    }
    public Node getRight() {
        return right;
    }
    public Node getRoot() {
        return root;
    }
}