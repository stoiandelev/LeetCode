package DataStructure._7_PriorityQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * A priority queue is a type of queue that arranges elements based on their priority values.
 * Elements with higher priority values are typically retrieved before elements with lower priority values.
 * In a priority queue, each element has a priority value associated with it.
 * When you add an element to the queue, it is inserted in a position based on its priority value.
 * For example, if you add an element with a high-priority value to a priority queue,
 * it may be inserted near the front of the queue,
 * while an element with a low priority value may be inserted near the back.
 * If two elements have the same priority, they are served according to their order in the queue.
 */

class PriorityQueue<T extends Comparable<T>> {
    private List<T> elements;

    public PriorityQueue() {
        elements = new ArrayList<>();
    }

    // Reorder the elements to maintain priority order
    private void reorder() {
        elements.sort(null);
    }

    // Add an element to the priority queue
    public void enqueue(T element) {
        elements.add(element);
        // Reorder the elements to maintain the priority order
        reorder();
    }

    // Remove and return the highest priority element
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        return elements.remove(0);
    }

    // Return the highest priority element without removing it
    public T peekHighestPriorityWithoutDelete() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        return elements.get(0);
    }

    // Check if the priority queue is empty
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    // Get the number of elements in the priority queue
    public int size() {
        return elements.size();
    }

    // Display the elements in the priority queue
    public void display() {
        System.out.println("Priority Queue Elements: " + elements);
    }


}
