package DataStructure._1_List;

import java.util.Arrays;

class List<T> {

    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public List() {
        this.elements = new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    private void ensureCapacity() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    // add an element to list
    public void add(T element) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = element;
    }

    // get element on specific index
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (T) elements[index];
    }

    // return a size on a list
    public int size() {
        return size;
    }

    // return list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // remove an element on the list
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }

    // contains an element in the list
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    // print all elements in the list
    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(); // Add a newline after printing all elements
    }

    // Reverse the elements in the list
    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            int oppositeIndex = size - i - 1;
            swap(i, oppositeIndex);
        }
    }

    // Reverse the elements between two given indices (inclusive)
    public void reverseBetweenIndices(int startIndex, int endIndex) {
        if (startIndex < 0 || startIndex >= size || endIndex < 0 || endIndex >= size || startIndex > endIndex) {
            throw new IndexOutOfBoundsException("Invalid start or end index");
        }

        while (startIndex < endIndex) {
            swap(startIndex, endIndex);
            startIndex++;
            endIndex--;
        }
    }

    private void swap(int index1, int index2) {
        Object temp = elements[index1];
        elements[index1] = elements[index2];
        elements[index2] = temp;
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
}


// add an element
// remove an element on the list
// get an element on specific index
// return a size
// contains an element in DS
// return DS is empty
// print all elements
// Reverse the elements
// Reverse the elements between two index