package DataStructure._9_ArrayDeque;

/**
 * The ArrayDeque class in Java is an implementation of the Deque interface
 * that uses a resizable array to store its elements.
 * ArrayDeque class provides constant-time performance for inserting and removing elements
 * from both ends of the queue, making it a good choice for scenarios where you need to perform
 * many add and remove operations.
 */

class ArrayDeque<T> {
    private Object[] elements;
    private int size;
    private int capacity;

    public ArrayDeque() {
        capacity = 10; // Initial capacity
        elements = new Object[capacity];
        size = 0;
    }

    // Resize the underlying array when it's full
    private void resize() {
        capacity *= 2;
        Object[] newElements = new Object[capacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    // Add an element to the front of the deque
    public void addFirst(T element) {
        if (size == capacity) {
            resize();
        }
        System.arraycopy(elements, 0, elements, 1, size);
        elements[0] = element;
        size++;
    }

    // Add an element to the rear of the deque
    public void addLast(T element) {
        if (size == capacity) {
            resize();
        }
        elements[size] = element;
        size++;
    }

    // Remove the front element of the deque
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        T removedElement = (T) elements[0];
        System.arraycopy(elements, 1, elements, 0, size - 1);
        size--;
        return removedElement;
    }

    // Remove the rear element of the deque
    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        T removedElement = (T) elements[size - 1];
        elements[size - 1] = null; // Clear the reference
        size--;
        return removedElement;
    }

    // Return the front element of the deque without removing it
    public T peekFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return (T) elements[0];
    }

    // Return the rear element of the deque without removing it
    public T peekLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return (T) elements[size - 1];
    }

    // Check if the deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get the number of elements in the deque
    public int size() {
        return size;
    }

    // Display the elements in the deque
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }


}
