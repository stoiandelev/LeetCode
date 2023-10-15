package Problems._1_Easy;

public class _37_ReverseDoubleLinkedList {
    // 1 <--> 2 <--> 3 <--> 4 <--> 5
    public static void main(String[] args) {
        DoublyLinkedListReverse myList = new DoublyLinkedListReverse();
        myList.append(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);

        System.out.println("Original _1_List:");
        myList.display();

        System.out.println("Reversed _1_List:");
        reverse(myList);
        myList.display();

    }

    public static void reverse(DoublyLinkedListReverse list) {
        NodeReverse current = list.head;
        NodeReverse temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev; // Move to the next node
        }

        // Swap head and tail of the list
        NodeReverse newHead = list.head;
        list.head = list.tail;
        list.tail = newHead;

    }


}

class NodeReverse {
    int data;
    NodeReverse prev;
    NodeReverse next;

    public NodeReverse(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedListReverse {
    NodeReverse head;
    NodeReverse tail;

    public DoublyLinkedListReverse() {
        this.head = null;
        this.tail = null;
    }

    public void append(int data) {
        NodeReverse newNode = new NodeReverse(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void display() {
        NodeReverse current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}





