package DataStructure._10_Set;


import java.util.Arrays;

/**
 * He does’t allow duplicate elements.
 * Set is an unordered collection of unique elements
 */

class Set<E extends Comparable<E>> {
    private Object[] elements;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    public Set() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    private void resize() {
        int newCapacity = elements.length * 2;
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    private int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    // Add an element in Set in don't exist
    public boolean add(E element) {
        if (!contains(element)) {
            if (size == elements.length) {
                resize();
            }
            elements[size++] = element;
            return true;
        }
        return false;
    }

    // Remove element from Set
    public boolean remove(E element) {
        int index = indexOf(element);
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            size--;
            return true;
        }
        return false;
    }

    // Size of Set
    public int size() {
        return size;
    }

    // Get a first element in Set
    public E getFirstElement() {
        if (size > 0) {
            return (E) elements[0];
        } else {
            throw new IllegalStateException("Set is empty.");
        }
    }

    // Get a last element in Set
    public E getLastElement() {
        if (size > 0) {
            return (E) elements[size - 1];
        } else {
            throw new IllegalStateException("Set is empty.");
        }
    }

    // Get value at Index
    public E getValueAtIndex(int index) {
        if (index >= 0 && index < size) {
            return (E) elements[index];
        } else {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
    }

    // Sort Element Alphabetically
    public void sortAlphabetically() {
        Arrays.sort(elements, 0, size);
    }

    // Display all elements in Set
    public void display() {
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println("]");
    }

    // Reverse element in Set
    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            int oppositeIndex = size - i - 1;
            swap(i, oppositeIndex);
        }
    }

    private void swap(int index1, int index2) {
        Object temp = elements[index1];
        elements[index1] = elements[index2];
        elements[index2] = temp;
    }
}