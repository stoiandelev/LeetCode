package DataStructure._6_Queue;

import java.util.LinkedList;
import java.util.List;

/**
 * In Java, you can implement a queue using the java.util.Queue interface,
 * and one of its concrete classes such as LinkedList or ArrayDeque
 * A Queue is defined as a linear data structure that is open at both ends and
 * the operations are performed first in first Out (FIFO) order.
 */

class Queue<T> {

    private List<T> elements;

    public Queue() {
        elements = new LinkedList<>();
    }

    // Add an element to the end of the queue
    public void enqueue(T element) {
        elements.add(element);
    }

    // Add an element to the top (front) of the queue
    public void addFirst(T element) {
        elements.add(0, element);
    }

    // Return the front element of the queue without removing it
    public T peekShowTopElement() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements.get(0);
    }

    // Remove and return the front element of the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements.remove(0);
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    // Get the number of elements in the queue
    public int size() {
        return elements.size();
    }

    // Display the elements in the queue
    public void display() {
        System.out.println("Queue Elements: " + elements);
    }
}