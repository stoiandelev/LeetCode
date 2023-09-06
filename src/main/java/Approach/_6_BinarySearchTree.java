package Approach;

/**
 * Binary tree - each node has no more than two children.
 * Binary search tree:
 * root node should be greater to left child, but less than right child.
 * //O log(n) best case 0(n) - worst case
 */

public class _6_BinarySearchTree {
    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(new Node(5));
        tree.insert(new Node(1));
        tree.insert(new Node(9));
        tree.insert(new Node(2));
        tree.insert(new Node(7));
        tree.insert(new Node(3));
        tree.insert(new Node(6));
        tree.insert(new Node(4));
        tree.insert(new Node(8));


        tree.display();

        System.out.println(tree.search(9));


    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

class BinarySearchTree {
    Node root;

    public void insert(Node node) {
        root = insertHelper(root, node);
    }

    private Node insertHelper(Node root, Node node) {
        int data = node.data;

        if (root == null) {
            root = node;
            return root;
        } else if (data < root.data) {
            root.left = insertHelper(root.left, node);
        } else {
            root.right = insertHelper(root.right, node);
        }

        return root;
    }

    public void display() {
        displayHeller(root);
    }

    private void displayHeller(Node root) {
        //print in normal order we change this with first root.right
        if (root != null) {
            displayHeller(root.left);
            System.out.println(root.data);
            displayHeller(root.right);

        }
    }

    public boolean search(int date) {
        return searchHelper(root, date);
    }

    private boolean searchHelper(Node root, int data) {

        if (root == null) {
            return false;
        } else if (root.data == data) {
            return true;
        } else if (root.data > data) {
            return searchHelper(root.left, data);
        } else {
            return searchHelper(root.right, data);
        }

    }

    public void remove(int data) {
        if (search(data)) {
            removeHelper(root, data);
        } else {
            System.out.println(data + " could not be found!");
        }
    }

    public Node removeHelper(Node root, int data) {

        if (root == null) {
            return root;
        } else if (data < root.data) {
            root.left = removeHelper(root.left, data);
        } else if (data > root.data) {
            root.right = removeHelper(root.right, data);
        } else {  // node found
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {  //find a successor to replace this node
                root.data = successor(root);
                root.right = removeHelper(root.right, root.data);
            } else { // find a predecessor to replace this node
                root.data = predecessor(root);
                root.left = removeHelper(root.left, root.data);
            }
        }

        return root;
    }

    private int successor(Node root) { //find the least value below the right child of this root node

        root = root.right;
        while (root.left != null) {
            root = root.left;
        }

        return root.data;
    }

    private int predecessor(Node root) { //find the greatest value below the left child of this root node
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }

        return root.data;
    }
}
