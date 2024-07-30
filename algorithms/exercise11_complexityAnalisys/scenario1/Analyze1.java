package algorithms.exercise11_complexityAnalisys.scenario1;

class Node {
    int key;
    Node left, right;


    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null)  return root;
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    boolean search(int key)  {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key)  {
        if (root==null || root.key==key)
            return root != null;
        if (root.key > key)
            return searchRec(root.left, key);
        return searchRec(root.right, key);
    }
}

// Time complexity of insert: O (log(n)) (BST) | O(n) (Binary Tree)
// Space complexity of insert: O(n)

// Time complexity of delete: O (log(n)) (BST) | O(n) (Binary Tree)
// Space complexity of delete: O(n)

// Time complexity of search: O (log(n)) (BST) | O(n) (Binary Tree)
// Space complexity of search: O(h) (height because of a recursive call stack) (not typically measurable)