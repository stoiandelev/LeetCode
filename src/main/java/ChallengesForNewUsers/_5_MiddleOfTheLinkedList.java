package ChallengesForNewUsers;

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 */
public class _5_MiddleOfTheLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(3);
        ListNode fourNode = new ListNode(4);
        ListNode fiveNode = new ListNode(5);
        ListNode sixNode = new ListNode(6);

        head.setNext(secondNode);
        secondNode.setNext(thirdNode);
        thirdNode.setNext(fourNode);
        fourNode.setNext(fiveNode);
        fiveNode.setNext(sixNode);

        ListNode result = middleNode(head);
        System.out.println(result.val);

    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        return slow;
    }


    public static class ListNode {
        int val;
        ListNode next;

        public ListNode getNext() {
            return next;
        }

        public ListNode setNext(ListNode next) {
            this.next = next;
            return this;
        }

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
