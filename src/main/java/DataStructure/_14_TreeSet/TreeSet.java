package DataStructure._14_TreeSet;


/**
 * TreeSet is one of the most important implementations of the SortedSet interface in Java
 * that uses a Tree for storage. The ordering of the elements is maintained by a set using
 * their natural ordering whether an explicit comparator is provided.
 * This must be consistent with equals if it is to correctly implement the Set interface.
 * An object is said to be comparable if and only if the corresponding class
 * implements a Comparable interface.
 * <></>
 * TreeSet is basically an implementation of a self-balancing binary search tree like a
 * Red-Black Tree. Therefore, operations like add, remove, and search take O(log(N)) time.
 * The reason is that in a self-balancing tree, it is made sure that the height of the tree
 * is always O(log(N)) for all the operations. Therefore, this is considered as one of the
 * most efficient data structures to store the huge sorted data and perform operations
 * on it. However, operations like printing N elements in the sorted order take O(N) time.
 */


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class TreeSet<E> {


    private Node<E> root;
    private Comparator<? super E> comparator;

    public TreeSet() {
        this(null);
    }

    public TreeSet(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    // Add a new element in TreeSet
    public boolean add(E element) {
        if (element == null) {
            throw new NullPointerException("TreeSet does not allow null elements.");
        }
        if (root == null) {
            root = new Node<>(element);
            return true;
        } else {
            return add(root, element);
        }
    }

    private boolean add(Node<E> node, E element) {
        int compare = compare(element, node.value);
        if (compare < 0) {
            if (node.left == null) {
                node.left = new Node<>(element);
                return true;
            } else {
                return add(node.left, element);
            }
        } else if (compare > 0) {
            if (node.right == null) {
                node.right = new Node<>(element);
                return true;
            } else {
                return add(node.right, element);
            }
        } else {
            return false; // Element already exists
        }
    }

    // Remove element in TreeSet
    public boolean remove(E element) {
        if (element == null) {
            throw new NullPointerException("TreeSet does not allow null elements.");
        }
        if (root == null) {
            return false;
        } else {
            return remove(root, element, null);
        }
    }

    private boolean remove(Node<E> node, E element, Node<E> parent) {
        if (node == null) {
            return false;
        }
        int compare = compare(element, node.value);
        if (compare < 0) {
            return remove(node.left, element, node);
        } else if (compare > 0) {
            return remove(node.right, element, node);
        } else {
            if (node.left != null && node.right != null) {
                Node<E> min = findMin(node.right);
                node.value = min.value;
                remove(node.right, min.value, node);
            } else if (parent == null) {
                root = (node.left != null) ? node.left : node.right;
            } else if (parent.left == node) {
                parent.left = (node.left != null) ? node.left : node.right;
            } else {
                parent.right = (node.left != null) ? node.left : node.right;
            }
            return true;
        }
    }

    // Check element in TreeSet
    public boolean contains(E element) {
        return contains(root, element);
    }

    private boolean contains(Node<E> node, E element) {
        if (node == null) {
            return false;
        }
        int compare = compare(element, node.value);
        if (compare < 0) {
            return contains(node.left, element);
        } else if (compare > 0) {
            return contains(node.right, element);
        } else {
            return true;
        }
    }

    // Reverse values in TreeSet
    public TreeSet<E> reverse() {
        List<E> elements = new ArrayList<>();
        reverse(root, elements);

        TreeSet<E> reversedSet = new TreeSet<>();
        for (E element : elements) {
            reversedSet.add(element);
        }

        return reversedSet;
    }

    private void reverse(Node<E> node, List<E> elements) {
        if (node == null) {
            return;
        }
        reverse(node.right, elements);
        elements.add(node.value);
        reverse(node.left, elements);
    }

    // Print all element in TreeSet
    public void printAll() {
        forEach(root);
    }

    private void forEach(Node<E> node) {
        if (node == null) {
            return;
        }
        forEach(node.left);
        System.out.print(node.value + " "); // Print the element
        forEach(node.right);
    }

    public void forEach(Consumer<? super E> action) {
        forEach(root, action);
    }

    private void forEach(Node<E> node, Consumer<? super E> action) {
        if (node == null) {
            return;
        }
        forEach(node.left, action);
        action.accept(node.value);
        forEach(node.right, action);
    }

    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        } else {
            @SuppressWarnings("unchecked")
            Comparable<? super E> c = (Comparable<? super E>) e1;
            return c.compareTo(e2);
        }
    }

    private Node<E> findMin(Node<E> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private static class Node<E> {
        E value;
        Node<E> left;
        Node<E> right;

        Node(E value) {
            this.value = value;
        }
    }
}


