package DataStructure._17_TreeMap;


/**
 * SortedMap is an interface, it can be used only with a class that implements this interface.
 * _17_TreeMap is the class that implements the SortedMap interface.
 * <></>
 * <></>
 * The _17_TreeMap in Java is used to implement Map interface and NavigableMap
 * along with the AbstractMap Class. The map is sorted according to the natural ordering of its keys,
 * or by a Comparator provided at map creation time, depending on which constructor is used.
 * This proves to be an efficient way of sorting and storing the key-value pairs.
 * The storing order maintained by the treemap must be consistent with equals just like
 * any other sorted map, irrespective of the explicit comparators.
 * The treemap implementation is not synchronized in the sense that if a map is accessed
 * by multiple threads, concurrently and at least one of the threads modifies the map structurally,
 * it must be synchronized externally.
 * The _17_TreeMap in Java is a concrete implementation of the java.util.SortedMap interface.
 * It provides an ordered collection of key-value pairs, where the keys are ordered based on
 * their natural order or a custom Comparator passed to the constructor.
 * A _17_TreeMap is implemented using a Red-Black tree, which is a type of self-balancing binary search tree.
 * This provides efficient performance for common operations such as
 * adding, removing, and retrieving elements, with an average time complexity of O(log n).
 */


public class TreeMap<K extends Comparable<K>, V> {

    private Node root;

    private class Node {
        K key;
        V value;
        Node left;
        Node right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // put key value in _17_TreeMap
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }

        int compare = key.compareTo(node.key);
        if (compare < 0) {
            node.left = put(node.left, key, value);
        } else if (compare > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }

        return node;
    }

    // get value in _17_TreeMap
    public V get(K key) {
        Node node = get(root, key);
        return node == null ? null : node.value;
    }

    private Node get(Node node, K key) {
        if (node == null) {
            return null;
        }

        int compare = key.compareTo(node.key);
        if (compare < 0) {
            return get(node.left, key);
        } else if (compare > 0) {
            return get(node.right, key);
        } else {
            return node;
        }
    }

    // remove value in _17_TreeMap
    public void remove(K key) {
        root = remove(root, key);
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }

        int compare = key.compareTo(node.key);
        if (compare < 0) {
            node.left = remove(node.left, key);
        } else if (compare > 0) {
            node.right = remove(node.right, key);
        } else {
            // Node to delete found

            // Node with only one child or no child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Node with two children; get the inOrder successor
            node.key = minValue(node.right);

            // Delete the inOrder successor
            node.right = remove(node.right, node.key);
        }

        return node;
    }

    private K minValue(Node node) {
        K minValue = node.key;
        while (node.left != null) {
            minValue = node.left.key;
            node = node.left;
        }
        return minValue;
    }

    // contains key in _17_TreeMap
    public boolean containsKey(K key) {
        return get(root, key) != null;
    }

    // size of _17_TreeMap
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }

    // is Empty _17_TreeMap
    public boolean isEmpty() {
        return root == null;
    }

    // In-order traversal to print all key-value pairs
    public void printAll() {
        printAll(root);
    }

    private void printAll(Node node) {
        if (node != null) {
            printAll(node.left);
            System.out.println("Key: " + node.key + ", Value: " + node.value);
            printAll(node.right);
        }
    }
}



