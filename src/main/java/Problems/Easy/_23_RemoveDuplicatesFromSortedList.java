package Problems.Easy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Given the head of a sorted linked list,
 * delete all duplicates such that each element appears only once.
 * Return the linked list sorted as well.
 */

public class _23_RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode headList = new ListNode(1);
        ListNode secondNode = new ListNode(1);
        ListNode thirdNode = new ListNode(2);
        ListNode fourNode = new ListNode(3);
        ListNode fiveNode = new ListNode(3);

        headList.setNext(secondNode);
        secondNode.setNext(thirdNode);
        thirdNode.setNext(fourNode);
        fourNode.setNext(fiveNode);

        ListNode resultListNodeSorted = deleteDuplicates(headList);

        ListNode current = resultListNodeSorted;

        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }

        System.out.println();




    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.next.val == temp.val) {
                temp.next = temp.next.next;
                continue;
            }
            temp = temp.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
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
}
