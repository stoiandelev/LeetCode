package DataStructure._13_SortedSet;

/**
 * The SortedSet interface present in java.util package extends the Set interface
 * present in the collection framework. It is an interface that implements the mathematical set.
 * This interface contains the methods inherited from the Set interface and adds a
 * feature that stores all the elements in this interface to be stored in a sorted manner.
 */


class Node<T extends Comparable<T>> {
    T data;
    Node<T> left;
    Node<T> right;

    public Node(T data) {
        this.data = data;
    }
}

public class SortedSet<T extends Comparable<T>> {
    private Node<T> root;
    private int size;

    public SortedSet() {
        size = 0;
    }

    // add value in SortedSet
    public boolean add(T value) {
        if (contains(value)) {
            return false;
        }
        root = insert(root, value);
        size++;
        return true;
    }

    // remove value in SortedSet if exist
    public boolean remove(T value) {
        if (!contains(value)) {
            return false;
        }
        root = delete(root, value);
        size--;
        return true;
    }

    // Contains value in SortedSet
    public boolean contains(T value) {
        return search(root, value);
    }

    // Search in SortedSet
    private boolean search(Node<T> root, T value) {
        if (root == null) {
            return false;
        }

        if (value.compareTo(root.data) == 0) {
            return true;
        } else if (value.compareTo(root.data) < 0) {
            return search(root.left, value);
        } else {
            return search(root.right, value);
        }
    }

    // Print in order
    public void printInOrder() {
        inOrderTraversal(root);
    }

    // size of SortedSet
    public int size() {
        return size;
    }

    private void inOrderTraversal(Node<T> root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    private Node<T> insert(Node<T> root, T value) {
        if (root == null) {
            return new Node<>(value);
        }

        if (value.compareTo(root.data) < 0) {
            root.left = insert(root.left, value);
        } else if (value.compareTo(root.data) > 0) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    private Node<T> delete(Node<T> root, T value) {
        if (root == null) {
            return root;
        }

        if (value.compareTo(root.data) < 0) {
            root.left = delete(root.left, value);
        } else if (value.compareTo(root.data) > 0) {
            root.right = delete(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = minValue(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    private T minValue(Node<T> node) {
        T minValue = node.data;
        while (node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }
        return minValue;
    }

}
