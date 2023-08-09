package Problems._2_Medium;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 */

public class _1_AddTwoNumbers {
    public static void main(String[] args) {

        ListNode firstNode = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        firstNode.setNext(node2);
        node2.setNext(node3);

        ListNode secondNode = new ListNode(5);
        ListNode node22 = new ListNode(6);
        ListNode node33 = new ListNode(4);
        secondNode.setNext(node22);
        node22.setNext(node33);


        ListNode finalNode = addTwoNumbers(firstNode, secondNode);

        printListNode(finalNode);


    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public ListNode setVal(int val) {
            this.val = val;
            return this;
        }

        public ListNode getNext() {
            return next;
        }

        public ListNode setNext(ListNode next) {
            this.next = next;
            return this;
        }
    }

    public static ListNode addTwoNumbers(ListNode listNode1, ListNode listNode2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while (listNode1 != null || listNode2 != null || carry != 0) {
            int digit1 = (listNode1 != null) ? listNode1.val : 0;
            int digit2 = (listNode2 != null) ? listNode2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;

            listNode1 = (listNode1 != null) ? listNode1.next : null;
            listNode2 = (listNode2 != null) ? listNode2.next : null;
        }

        ListNode result = dummyHead.next;
        dummyHead.next = null;
        return result;
    }

    public static void printListNode(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.getVal() + " ");
            current = current.getNext();
        }

    }

}
