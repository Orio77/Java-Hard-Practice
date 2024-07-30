package dataStructures.exercise6_recursion.scenario2.preparation;

public class AVLTree {
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

        public int calculateHeight(Node node) {
            if (node == null)
                return -1;

            return node.getHeight();
        }

        public int calculateBalanceFactor() {
            if (left == null && right == null)
                return 0;

            if (left == null) {
                return right.getHeight();
            } else if (right == null) {
                return left.getHeight();
            }

            return Math.abs(left.getHeight() - left.getHeight());
        }

        public void updateHeight() {
            if (this == null || (left == null && right == null))
                return;

            if (left == null || right == null) {
                if (left == null)
                    height = (right.getHeight() + 1);
                else
                    height = (left.getHeight() + 1);
            }

            if (left.getHeight() > right.getHeight())
                height = (left.getHeight() + 1);
            else
                height = (right.getHeight() + 1);
        }

    }

    public Node leftRotation(Node node) {
            Node newNode = node.getRight();
            Node child = newNode.getLeft();
            newNode.setLeft(node);
            node.setRight(child);

            node.updateHeight();
            newNode.updateHeight();

            return newNode;
        }

    public Node rightRotation(Node node) {
            Node newNode = node.getLeft();
            Node child = newNode.getRight();
            newNode.setRight(node);
            node.setLeft(child);

            node.updateHeight();
            newNode.updateHeight();
            return newNode;
        }

    public void insert(Node node) {
        root = insertHelper(root, node.getKey());
    }
    

    private Node insertHelper(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.getKey())
            node.setLeft(insertHelper(node.getLeft(), key));
        else if (key > node.getKey())
            node.setRight(insertHelper(node.getRight(), key));
        else
            return node;

        node.updateHeight();
        int balance = node.calculateBalanceFactor();

        if (balance > 1) {
            if (key < node.getLeft().getKey()) {
                return rightRotation(node);
            }
            if (key > node.getLeft().getKey()) {
                node.setLeft(leftRotation(node.getLeft()));
                return rightRotation(node);
            }
        }

        if (balance < -1) {
            if (key > node.getRight().getKey()){
                return leftRotation(node);
            }
            if (key < node.getRight().getKey()) {
                node.setRight(rightRotation(node.getRight()));
                leftRotation(node);
            }
        }
        return node;
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

