package Problems._1_Easy;

/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a
 * height-balanced binary search tree. - BST
 * A height-balanced binary tree is a binary tree
 * in which the depth of the two subtrees of every node never differs by more than ONE.
 * On the left side on the tree element is less than the root
 * On the right side on the tree element is greater than the root
 * When you see sorted array think about binary search
 * We construct the tree using a binary search
 */

public class _29_ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {

        int[] nums = {1, 3};
        System.out.println(sortedArrayToBST(nums));

    }

    public static TreeNodeConvertFromArray sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return constructTreeFromArray(nums, 0, nums.length - 1);
    }

    public static TreeNodeConvertFromArray constructTreeFromArray(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int midPoint = left + (right - left) / 2;
        TreeNodeConvertFromArray node = new TreeNodeConvertFromArray(nums[midPoint]);   //root

        node.left = constructTreeFromArray(nums, left, midPoint - 1);
        node.right = constructTreeFromArray(nums, midPoint + 1, right);


        return node;
    }
}


class TreeNodeConvertFromArray {
    int val;
    TreeNodeConvertFromArray left;
    TreeNodeConvertFromArray right;

    TreeNodeConvertFromArray() {
    }

    TreeNodeConvertFromArray(int val) {
        this.val = val;
    }

    TreeNodeConvertFromArray(int val, TreeNodeConvertFromArray left, TreeNodeConvertFromArray right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
