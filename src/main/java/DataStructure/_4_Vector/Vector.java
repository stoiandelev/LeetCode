package DataStructure._4_Vector;

import java.util.Arrays;

/**
 * The Vector class implements a growable array of objects.
 * Vectors fall in legacy classes, but now it is fully compatible with collections.
 * It is found in java.util package and implements the List interface,
 * so we can use all the methods of the List interface as shown below as follows:
 * They are very similar to ArrayList, but Vector is synchronized
 * and has some legacy methods that the collection framework does not contain.
 * 1) ArrayList is not synchronized. Vector is synchronized.
 * 2) ArrayList increments 50% of the current array size
 * if the number of elements exceeds its capacity.
 * Vector increments 100% means doubles the array size if the total number
 * of elements exceeds than its capacity.
 * Multiple threads are allowed in ArrayList
 * Only a single thread is allowed in Vector
 * Synchronized -> only one thread at a time can access the code.
 */

class Vector<T> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public Vector() {
        this.elements = new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    private void ensureCapacity() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    // add element in Vector
    public void add(T element) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = element;
    }

    // get element from Vector
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (T) elements[index];
    }

    // return size of Vector
    public int size() {
        return size;
    }

    // check Vector is Empty
    public boolean isEmpty() {
        return size == 0;
    }

    // remove element from Vector
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }

    // contains element in Vector
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    // print all element in Vector
    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(); // Add a newline after printing all elements
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Reverse Vector
    public void reverse() {
        int left = 0;
        int right = size - 1;

        while (left < right) {
            // Swap elements at the left and right indices
            T temp = get(left);
            set(left, get(right));
            set(right, temp);

            left++;
            right--;
        }
    }

    private void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        elements[index] = element;
    }

    // Reverse between two index
    public void reverseBetweenIndices(int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex >= size || startIndex >= endIndex) {
            throw new IllegalArgumentException("Invalid start and end indices");
        }

        int left = startIndex;
        int right = endIndex;

        while (left < right) {
            // Swap elements at the left and right indices
            T temp = get(left);
            set(left, get(right));
            set(right, temp);

            left++;
            right--;
        }
    }


}
