package DataStructure._2_LinkedList;

class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addData(1);
        ll.addData(2);
        ll.addData(3);
        ll.addData(4);
        ll.addData(5);
        ll.addData(6);

        System.out.println("Original _1_List");
        ll.display();

        System.out.println("Traverse from head");
        ll.traverseFromHead();

        System.out.println("Traverse reversed");
        ll.traverseFromTailToHead();

        System.out.println();
        System.out.println("Insert at beginning");
        ll.insertAtBeginning(0);
        ll.display();


        System.out.println("Insert to end");
        ll.insertAtEnd(45);
        ll.display();

        System.out.println("Insert to specific position");
        ll.insertAtPosition(0, 34);
        ll.display();

        System.out.println("Delete a head(first node) in _2_LinkedList");
        ll.deleteFirstNode();
        ll.display();

        System.out.println("Delete a last node in _2_LinkedList");
        ll.deleteLastNode();
        ll.display();

        System.out.println("Delete a node in specific position in _2_LinkedList");
        ll.deleteNodeAtPosition(1);
        ll.display();

        System.out.println("Rotate from given index");
        ll.rotateByIndex(1);
        ll.display();

        System.out.println("Reverse _2_LinkedList");
        ll.reverse();
        ll.display();

        System.out.println("Reverse between two index");
        ll.reverseBetween(2, 5);
        ll.display();

        System.out.println("Find number contains in _2_LinkedList");
        boolean contains = ll.contains(10);
        System.out.println(contains);


    }
}



class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // add data in a list
    public void addData(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // display _2_LinkedList
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Traversing from head to the end of the list
    public void traverseFromHead() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Traversing from tail to the head
    public void traverseFromTailToHead() {
        Node current = head;
        Node prev = null;
        Node nextNode;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        head = prev;

        // Now, head points to the previous tail, so you can traverse from head to tail
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    // Insertion in a Linked _1_List at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }


    // Insertion in a number in Linked _1_List at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Insertion in a Linked _1_List at specific position
    public void insertAtPosition(int position, int data) {
        if (position < 0) {
            System.out.println("Invalid position. Position should be non-negative.");
            return;
        }

        Node newNode = new Node(data);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        int currentPosition = 0;

        while (current != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }

        if (current == null) {
            System.out.println("Invalid position. Position exceeds the length of the list.");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // Deletion of the first node in the list
    public void deleteFirstNode() {
        if (head != null) {
            head = head.next;
        }
    }


    // Deletion of the last node in the list
    public void deleteLastNode() {
        if (head == null) {
            // The list is empty, nothing to delete.
            return;
        }

        if (head.next == null) {
            // If there is only one node in the list, set the head to null to empty the list.
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            // Traverse the list until the second-to-last node.
            current = current.next;
        }

        // Set the next of the second-to-last node to null, effectively removing the last node.
        current.next = null;
    }


    // Deletion at a specific position in the list
    public void deleteNodeAtPosition(int position) {
        if (position < 0) {
            System.out.println("Invalid position. Position should be non-negative.");
            return;
        }

        if (position == 0) {
            // If deleting the first node, update the head to the next node.
            if (head != null) {
                head = head.next;
            }
            return;
        }

        Node current = head;
        int currentPosition = 0;

        while (current != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }

        if (current == null || current.next == null) {
            System.out.println("Invalid position. Position exceeds the length of the list.");
            return;
        }

        // Remove the node at the specified position by bypassing it.
        current.next = current.next.next;
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

        // Find the last node of the sublist before the rotation point
        Node sublistEnd = current;

        // Traverse to the end of the list to find the current tail
        while (sublistEnd.next != null) {
            sublistEnd = sublistEnd.next;
        }

        // Update the tail of the sublist to point to the current head
        sublistEnd.next = head;

        // Update the head to the node after the rotation point
        head = current.next;

        // Disconnect the sublist by setting current.next to null
        current.next = null;
    }

    // Reverse _2_LinkedList
    public void reverse() {
        if (head == null || head.next == null) {
            // The list is empty or has only one element, no need to reverse.
            return;
        }

        Node prev = null;
        Node current = head;
        Node nextNode;

        while (current != null) {
            nextNode = current.next;  // Store the next node
            current.next = prev;     // Reverse the link

            prev = current;
            current = nextNode;
        }

        // Update the head to the last node (prev)
        head = prev;
    }

    // Reverse the elements between two indices
    public void reverseBetween(int indexOne, int indexTwo) {
        if (head == null || indexOne == indexTwo || indexOne < 1 || indexTwo < 1) {
            // Invalid input or nothing to reverse.
            return;
        }

        Node dummy = new Node(0); // Create a dummy node to simplify edge cases.
        dummy.next = head;
        Node prevM = dummy;

        // Find the node before the start of the reverse portion.
        for (int i = 0; i < indexOne - 1 && prevM.next != null; i++) {
            prevM = prevM.next;
        }

        if (prevM.next == null) {
            // indexOne is out of range.
            return;
        }

        Node curr = prevM.next;
        Node prev = null;

        // Reverse the elements between indexOne and indexTwo.
        for (int i = indexOne; i <= indexTwo; i++) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // Connect the reversed portion back to the list.
        prevM.next.next = curr;
        prevM.next = prev;

        // Update the head if necessary (if indexOne == 1).
        if (indexOne == 1) {
            head = dummy.next;
        }
    }

    // Contain targetNumber number
    public boolean contains(int targetNumber) {
        Node current = head;

        while (current != null) {
            if (current.data == targetNumber) {
                return true; // Found the targetNumber element in the list
            }
            current = current.next;
        }

        return false; // Target element not found in the list
    }


}
