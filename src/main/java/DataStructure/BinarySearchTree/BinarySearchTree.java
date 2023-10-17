package DataStructure.BinarySearchTree;

/**
 * Binary Search Tree -> A tree data structure where each node is greater than it's a left child,
 * but less than it's right.
 * Benefit -> easy to locate node when they are in this order.
 *
 *
 */


public class BinarySearchTree {

    Node root;

    public void insert(Node node) {
        root = insertHelper(root, node);
    }

    private Node insertHelper(Node root, Node node) {
        int data = node.data;

        if (root == null) {
            root = node;
            return root;
        } else if (data < root.data) {  // left child
            root.left = insertHelper(root.left, node);
        } else {  // right child
            root.right = insertHelper(root.right, node);
        }

        return root;
    }

    public void display() {
        displayHelper(root);
    }

    private void displayHelper(Node root) {
        if (root != null) {  // we use in order traversal -> increase order
            displayHelper(root.left);
            System.out.println(root.data);
            displayHelper(root.right);
        }
    }

    public boolean search(int data) {
        return searchHelper(root, data);
    }

    private boolean searchHelper(Node root, int date) {

        if (root == null) {
            return false;
        } else if (root.data == date) {
            return true;
        } else if (root.data > date) { // go left
            return searchHelper(root.left, date);
        } else { // go right
            return searchHelper(root.right, date);
        }
    }

    public void remove(int data) {
        if (search(data)) {
            removeHelper(root, data);
        } else {
            System.out.println(data + " count not be found!");
        }
    }

    private Node removeHelper(Node root, int data) {

        if (root == null) {
            return root;
        } else if (data < root.data) { // go left
            root.left = removeHelper(root.left, data);
        } else if (data > root.data) { // go right
            root.right = removeHelper(root.right, data);
        } else { // node found
            if (root.left == null && root.right == null) { // its leaf node (no child)
                root = null;
            } else if (root.right != null) { // find a successor to replace this node
                root.data = successor(root);
                root.right = removeHelper(root.right, root.data);
            } else { // find a predecessor to replace this node
                root.data = predecessor(root);
                root.left = removeHelper(root.left, root.data);
            }
        }
        return root;
    }

    private int successor(Node root) { // find the least value below the right child of this root node.
        root = root.right;

        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    private int predecessor(Node root) { // find the greatest value below the left child of this root node.
        root = root.left;

        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }


}
