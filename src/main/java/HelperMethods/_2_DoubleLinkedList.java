package HelperMethods;



public class _2_DoubleLinkedList {

    // 1 <--> 2 <--> 3 <--> 4 <--> 5
    public static void main(String[] args) {
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.append(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);

        System.out.println("Original List:");
        myList.display();

        System.out.println("Reversed List:");
        reverse(myList);
        myList.display();

    }

    public static void reverse(DoublyLinkedList list) {
        Node current = list.head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev; // Move to the next node
        }

        // Swap head and tail of the list
        Node newHead = list.head;
        list.head = list.tail;
        list.tail = newHead;

    }


}

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}







