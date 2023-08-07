package Problems.Easy;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself
 * (i.e. symmetric around its centre).
 */


public class _27_SymmetricTree {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);

        tree.right.left = new TreeNode(4);
        tree.right.right = new TreeNode(3);

        System.out.println();

        System.out.println(isSymmetric(tree));


    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.value == node2.value &&
                isMirror(node1.left, node2.right) &&
                isMirror(node1.right, node2.left);
    }

    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int value) {
            this.value = value;
        }

        TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public TreeNode setValue(int value) {
            this.value = value;
            return this;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode setLeft(TreeNode left) {
            this.left = left;
            return this;
        }

        public TreeNode getRight() {
            return right;
        }

        public TreeNode setRight(TreeNode right) {
            this.right = right;
            return this;
        }
    }

}




