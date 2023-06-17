package ChallengesForNewUsers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Given the head of a singly linked list,
 * return true if it is a palindrome or false otherwise.
 */

public class _2_PalindromeLinkedList {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(2);
        ListNode fourNode = new ListNode(1);
        head.setNext(secondNode);
        secondNode.setNext(thirdNode);
        thirdNode.setNext(fourNode);

        System.out.println(isPalindrome(head));

    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        List<Integer> list = new ArrayList<>();
        ListNode temp = head;

        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (!Objects.equals(list.get(i), list.get(j)))
                return false;
            i++;
            j--;
        }

        return true;


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
