package DataStructure._3_DoubleLinkedList;

/**
 * To create a doubly linked list, first, we need to define a Node class
 * that has three data members that will store the data stored in the node,
 * the reference to the next node, and the reference to the previous node.
 * <p>
 * Now we need to create a doubly linked list class that will contain
 * two variable head and tail, which will be referenced to the first and last node
 * of the list respectively, and also a constructor which will initialize
 * both head and tail to the null.
 * <p>
 * Now we need to create a doubly linked list class that will contain
 * two variable head and tail, which will be referenced to the first and last node
 * of the list respectively, and also a constructor which will initialize
 * both head and tail to the null.
 * <p>
 * Now we need to create a doubly linked list class that will contain
 * two variable head and tail, which will be referenced to the first and last node
 * of the list respectively, and also a constructor which will initialize
 * both head and tail to the null.
 * <p>
 * Now we need to create a doubly linked list class that will contain
 * two variable head and tail, which will be referenced to the first and last node
 * of the list respectively, and also a constructor which will initialize
 * both head and tail to the null.
 * <p>
 * To insert a node in a doubly linked list, first,
 * we will need to create a new node that is going to be inserted and update
 * the references of the adjacent nodes to add the new node and will update
 * the head or tail of the list if the new node is being inserted
 * at the beginning or end of the list.
 * A node can be added to a Doubly Linked _1_List in three ways:
 * Insertion at the beginning of the list
 * Insertion at a specific position in the list
 * Insertion at the end of the list
 * <p>
 * Now we need to create a doubly linked list class that will contain
 * two variable head and tail, which will be referenced to the first and last node
 * of the list respectively, and also a constructor which will initialize
 * both head and tail to the null.
 * <p>
 * To insert a node in a doubly linked list, first,
 * we will need to create a new node that is going to be inserted and update
 * the references of the adjacent nodes to add the new node and will update
 * the head or tail of the list if the new node is being inserted
 * at the beginning or end of the list.
 * A node can be added to a Doubly Linked _1_List in three ways:
 * Insertion at the beginning of the list
 * Insertion at a specific position in the list
 * Insertion at the end of the list
 * <p>
 * Now we need to create a doubly linked list class that will contain
 * two variable head and tail, which will be referenced to the first and last node
 * of the list respectively, and also a constructor which will initialize
 * both head and tail to the null.
 * <p>
 * To insert a node in a doubly linked list, first,
 * we will need to create a new node that is going to be inserted and update
 * the references of the adjacent nodes to add the new node and will update
 * the head or tail of the list if the new node is being inserted
 * at the beginning or end of the list.
 * A node can be added to a Doubly Linked _1_List in three ways:
 * Insertion at the beginning of the list
 * Insertion at a specific position in the list
 * Insertion at the end of the list
 */

/**
 * Now we need to create a doubly linked list class that will contain
 * two variable head and tail, which will be referenced to the first and last node
 * of the list respectively, and also a constructor which will initialize
 * both head and tail to the null.
 */

/**
 * To insert a node in a doubly linked list, first,
 * we will need to create a new node that is going to be inserted and update
 * the references of the adjacent nodes to add the new node and will update
 * the head or tail of the list if the new node is being inserted
 * at the beginning or end of the list.
 * A node can be added to a Doubly Linked _1_List in three ways:
 * Insertion at the beginning of the list
 * Insertion at a specific position in the list
 * Insertion at the end of the list
 */

/**
 * To delete a node in a doubly linked list, first,
 * we need to update the references of the adjacent nodes to delete the node
 * and will update the head or tail of the list if the new node is being inserted
 * at the beginning or end of the list.
 */


class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.append(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);

        System.out.println("Original _1_List:");
        dll.display();

        System.out.println("Traverse forward:");
        dll.traverseForward();

        System.out.println();
        System.out.println("Traverse backward:");
        dll.traverseBackward();

        System.out.println();
        System.out.println("Insert at Beginning -> number 5");
        dll.insertAtBeginning(5);
        dll.display();

        System.out.println();
        System.out.println("Insert at the End -> number 6");
        dll.insertAtEnd(6);
        dll.display();

        System.out.println();
        System.out.println("Insert at the specific position -> number 8, position 2");
        dll.insertAtPosition(8, 3);
        dll.display();

        System.out.println();
        System.out.println("Delete first position");
        dll.deleteAtBeginning();
        dll.display();

        System.out.println();
        System.out.println("Delete last position");
        dll.deleteAtEnd();
        dll.display();

        System.out.println();
        System.out.println("Delete at the specific position");
        dll.deleteOfCurrentPosition(3);
        dll.display();

        System.out.println();
        System.out.println("Rotate from the specific index");
        dll.rotateByIndex(1);
        dll.display();

        System.out.println();
        System.out.println("Reverse the list");
        dll.reverse();
        dll.display();

        System.out.println();
        System.out.println("Reverse the elements between two indices");
        dll.reverseBetweenIndices(1, 3);
        dll.display();

        System.out.println();
        System.out.println("Contains number");
        boolean contains = dll.contains(2);
        System.out.println(contains);

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

    // Traversing from head to the end of the list
    public void traverseForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    // Traversing from tail to the head
    public void traverseBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
    }

    // Insertion in a Doubly Linked _1_List at the beginning
    public void insertAtBeginning(int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
    }

    // Insertion in a Doubly Linked _1_List at the end
    public void insertAtEnd(int data) {
        Node temp = new Node(data);
        if (tail == null) {
            head = temp;
        } else {
            tail.next = temp;
            temp.prev = tail;
        }
        tail = temp;
    }

    // Insertion in a Doubly Linked _1_List at specific position
    public void insertAtPosition(int data, int position) {
        Node temp = new Node(data);
        if (position == 1) {
            insertAtBeginning(data);
        } else {
            Node current = head;
            int currPosition = 1;
            while (current != null && currPosition < position) {
                current = current.next;
                currPosition++;
            }
            if (current == null) {
                insertAtEnd(data);
            } else {
                temp.next = current;
                temp.prev = current.prev;
                current.prev.next = temp;
                current.prev = temp;
            }
        }
    }

    // Deletion of the first node in the list
    public void deleteAtBeginning() {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
    }

    // Deletion of the last node in the list
    public void deleteAtEnd() {
        if (tail == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
    }

    // Deletion at a specific position in the list
    public void deleteOfCurrentPosition(int pos) {
        if (head == null) {
            return;
        }

        if (pos == 1) {
            deleteAtBeginning();
            return;
        }

        Node current = head;
        int count = 1;

        while (current != null && count != pos) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position wrong");
            return;
        }

        if (current == tail) {
            deleteAtEnd();
            return;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.prev = null;
        current.next = null;
    }

    // Rotate from a specific index
    public void rotateByIndex(int index) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        int size = 0;
        Node current = head;

        // Find the size of the list
        while (current != null) {
            size++;
            current = current.next;
        }

        // Calculate the actual rotation index
        index = index % size;

        if (index == 0) {
            // No rotation needed if the index is a multiple of the list size
            return;
        }

        current = head;
        int count = 0;

        // Traverse to the node at the given index
        while (count < index && current != null) {
            current = current.next;
            count++;
        }

        // If the index is beyond the end of the list, return
        if (current == null) {
            System.out.println("Invalid index.");
            return;
        }

        // Reverse the sublist after the given index
        Node newHead = current.next;

        if (newHead != null) {
            current.next = null;
            newHead.prev = null;
            Node temp = newHead;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = head;
            head.prev = temp;
            head = newHead;
        }
    }

    // Reverse double linkedList
    public void reverse() {
        Node current = head;
        Node temp = null;

        while (current != null) {
            // Swap the next and prev pointers of the current node
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            // Move to the next node
            current = current.prev; // The new next is the previous node (due to swapping)
        }

        // Update the head to the last node, which is now the new head
        if (temp != null) {
            head = temp.prev;
        }
    }

    // Reverse reverse the elements between two indices
    public void reverseBetweenIndices(int startIndex, int endIndex) {
        if (head == null || startIndex >= endIndex) {
            return; // Nothing to reverse or invalid indices
        }

        int index = 0;
        Node current = head;

        // Traverse to the node at the start index
        while (current != null && index < startIndex) {
            current = current.next;
            index++;
        }

        if (current == null) {
            return; // Start index is out of bounds
        }

        Node startNode = current;

        // Traverse to the node at the end index
        while (current != null && index < endIndex) {
            current = current.next;
            index++;
        }

        if (current == null) {
            return; // End index is out of bounds
        }

        Node endNode = current;

        // Reverse the elements between the start and end nodes
        while (startNode != endNode) {
            int temp = startNode.data;
            startNode.data = endNode.data;
            endNode.data = temp;

            startNode = startNode.next;
            endNode = endNode.prev;
        }
    }

    // Contain target number
    public boolean contains(int targetNumber) {
        Node current = head;
        while (current != null) {
            if (current.data == targetNumber) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

}




