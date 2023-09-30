package HelperMethods;


class LinkedList {

    // Create the linked list with data [1, 2, 3, 4, 5]
    public static void main(String[] args) {
        LinkedListHelperMethod head = new LinkedListHelperMethod(1);
        head.next = new LinkedListHelperMethod(2);
        head.next.next = new LinkedListHelperMethod(3);
        head.next.next.next = new LinkedListHelperMethod(4);
        head.next.next.next.next = new LinkedListHelperMethod(5);
    }

    // Helper method to print the linked list
    public static void printList(LinkedListHelperMethod head) {
        LinkedListHelperMethod current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }








}

class LinkedListHelperMethod {
    int val;
    LinkedListHelperMethod next;

    LinkedListHelperMethod() {
    }

    LinkedListHelperMethod(int val) {
        this.val = val;
    }

    LinkedListHelperMethod(int val, LinkedListHelperMethod next) {
        this.val = val;
        this.next = next;
    }
}


