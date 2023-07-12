package Problems.Easy;

/**
 * Given the roots of two binary trees p and q,
 * write a function to check if they are the same or not.
 * Two binary trees are considered the same
 * if they are structurally identical, and the nodes have the same value.
 */

public class _26_SameTree {
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        insert(tree1, 2);

        TreeNode tree2 = new TreeNode(1);
        insert(tree2, 1);

        System.out.println(isSameTree(tree1, tree2));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        //if both trees are null, they are identical
        if (p == null && q == null) {
            return true;
        }

        //If only one tree is null or the values are different, they are not identical
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        //Recursively check if the left and right subtrees are identical
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);


    }

    public static TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }

        if (value < root.getVal()) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        public int getVal() {
            return val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
