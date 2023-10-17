package DataStructure._8_Deque;

import java.util.ArrayList;
import java.util.List;

class Deque<T> {
    private List<T> elements;

    public Deque() {
        elements = new ArrayList<>();
    }

    // Add an element to the front of the deque
    public void addFront(T element) {
        elements.add(0, element);
    }

    // Add an element to the rear of the deque
    public void addRear(T element) {
        elements.add(element);
    }

    // Remove and return the front element of the deque
    public T removeFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return elements.remove(0);
    }

    // Return the front element of the deque without removing it
    public T peekFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return elements.get(0);
    }

    // Return the rear element of the deque without removing it
    public T peekRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        int lastIndex = elements.size() - 1;
        return elements.get(lastIndex);
    }

    // Remove and return the rear element of the deque
    public T removeRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return elements.remove(elements.size() - 1);
    }

    // Check if the deque is empty
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    // Get the number of elements in the deque
    public int size() {
        return elements.size();
    }

    // Display the elements in the deque
    public void display() {
        System.out.println("Deque Elements: " + elements);
    }

}