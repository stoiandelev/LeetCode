package Problems.Easy;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 */

public class _13_MergeTwoSortedLinkedLists {
    public static void main(String[] args) {
        ListNode headList1 = new ListNode(1);
        ListNode secondNode1 = new ListNode(2);
        ListNode thirdNode1 = new ListNode(4);

        headList1.setNext(secondNode1);
        secondNode1.setNext(thirdNode1);

        ListNode headList2 = new ListNode(1);
        ListNode secondNode2 = new ListNode(3);
        ListNode thirdNode2 = new ListNode(4);

        headList2.setNext(secondNode2);
        secondNode2.setNext(thirdNode2);



    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {

            if (list1.value < list2.value) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;

            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }

        if (list1 == null)
            return list2;
        return list1;

    }

    public static class ListNode {
        int value;
        ListNode next;

        public int getValue() {
            return value;
        }

        public ListNode setValue(int value) {
            this.value = value;
            return this;
        }

        public ListNode getNext() {
            return next;
        }

        public ListNode setNext(ListNode next) {
            this.next = next;
            return this;
        }

        ListNode() {
        }

        ListNode(int value) {
            this.value = value;
        }

        ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }
}
