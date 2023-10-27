package DataStructure._5_Stack;

import java.util.Arrays;

/**
 *
 * Stack is a linear data structure that follows a particular
 * order in which the operations are performed -> LIFO from top ot Stack
 */

class Stack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public Stack() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    private void ensureCapacity() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    // push element in Stack
    public void push(T element) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = element;
    }

    // Removes the topmost element from the stack.
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T top = peek();
        elements[size - 1] = null; // Dereference the top element
        size--;
        return top;
    }

    // get the reference of the element at the stack's top
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) elements[size - 1];
    }

    // return size of Stack
    public int size() {
        return size;
    }

    // check Stack is Empty
    public boolean isEmpty() {
        return size == 0;
    }

    // print All element in Stack
    public void printAll() {
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(elements[i]);
            if (i > 0) {
                System.out.print(", ");
            }
        }
        System.out.println(); // Add a newline after printing all elements
    }


}

