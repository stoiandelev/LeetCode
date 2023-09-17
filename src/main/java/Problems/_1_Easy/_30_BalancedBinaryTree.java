package Problems._1_Easy;

/**
 * Given a binary tree, determine if it is height-balanced.
 * A height-balanced binary tree is a binary tree in which
 * the depth of the two subtrees of every node never differs by more than one.
 */

public class _30_BalancedBinaryTree {

    final int UNBALANCE = -1;

    public boolean isBalanced(TreeNodeBBT root) {
        if (root == null) {
            return true;
        }

        return dfs(root) != UNBALANCE;
    }

    private int dfs(TreeNodeBBT root) {
        // base case
        if (root.left == null && root.right == null) {
            return 1;
        }

        // left subtree DSF
        int leftHight = 0;
        if (root.left != null) {
            leftHight = dfs(root.left);
        }
        if (leftHight == UNBALANCE) {
            return UNBALANCE;
        }

        // right subtree DSF
        int rigthHight = 0;
        if (root.right != null) {
            rigthHight = dfs(root.right);
        }
        if (rigthHight == UNBALANCE) {
            return UNBALANCE;
        }

        // check the current tree
        if (Math.abs(rigthHight - leftHight) <= 1) {
            return Math.max(rigthHight, leftHight) + 1;
        }

        return UNBALANCE;
    }


    public static void main(String[] args) {
       // root = [3,9,20,null,null,15,7] -> true



    }


}


class TreeNodeBBT {
    int val;
    TreeNodeBBT left;
    TreeNodeBBT right;

    TreeNodeBBT() {
    }

    TreeNodeBBT(int val) {
        this.val = val;
    }

    TreeNodeBBT(int val, TreeNodeBBT left, TreeNodeBBT right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


}
