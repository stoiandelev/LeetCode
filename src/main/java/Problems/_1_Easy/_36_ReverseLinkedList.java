package Problems._1_Easy;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

public class _36_ReverseLinkedList {
    public static void main(String[] args) {

        // head = [1,2,3,4,5]

        // Create the linked list with data [1, 2, 3, 4, 5]
        ListNodeLinkedList head = new ListNodeLinkedList(1);
        head.next = new ListNodeLinkedList(2);
        head.next.next = new ListNodeLinkedList(3);
//        head.next.next.next = new ListNodeLinkedList(4);
//        head.next.next.next.next = new ListNodeLinkedList(5);

        // before
        printList(head);

        // after reverse
        printList(reverseListRecursion(head));

    }

    // Two pointer approach -> iterative
    public static ListNodeLinkedList reverseList(ListNodeLinkedList head) {
        // base case
        if (head == null) return null;

        // current pointer and previous pointer
        ListNodeLinkedList current = head;
        ListNodeLinkedList previous = null;

        // while current is not null -> continue to traverse
        while (current != null) {
            ListNodeLinkedList temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;

        }

        // return the previous pointer
        return previous;


    }

    // Recursion
    public static ListNodeLinkedList reverseListRecursion(ListNodeLinkedList head) {
        return reverseRecursion(head, null);
    }

    private static ListNodeLinkedList reverseRecursion(ListNodeLinkedList head, ListNodeLinkedList newHead) {
        // base case
        if (head == null) return newHead;

        ListNodeLinkedList next = head.next;
        head.next = newHead;
        newHead = head;
        head = next;

        return reverseRecursion(head, newHead);
    }

    // Helper method to print the linked list
    public static void printList(ListNodeLinkedList head) {
        ListNodeLinkedList current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }


}

class ListNodeLinkedList {
    int val;
    ListNodeLinkedList next;

    ListNodeLinkedList() {
    }

    ListNodeLinkedList(int val) {
        this.val = val;
    }

    ListNodeLinkedList(int val, ListNodeLinkedList next) {
        this.val = val;
        this.next = next;
    }

}
