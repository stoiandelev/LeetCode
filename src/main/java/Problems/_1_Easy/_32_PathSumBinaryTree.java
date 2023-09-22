package Problems._1_Easy;


import java.util.Stack;

/**
 * Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals targetSum.
 * A leaf is a node with no children.
 */

public class _32_PathSumBinaryTree {
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNodePathSumBinaryTree root, int targetSum) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null && targetSum - root.val == 0) {
            return true;
        } else {
            return hasPathSum(root.left, targetSum - root.val) ||
                    hasPathSum(root.right, targetSum - root.val);
        }


    }
}

class TreeNodePathSumBinaryTree {
    int val;
    TreeNodePathSumBinaryTree left;
    TreeNodePathSumBinaryTree right;

    TreeNodePathSumBinaryTree() {
    }

    TreeNodePathSumBinaryTree(int val) {
        this.val = val;
    }

    TreeNodePathSumBinaryTree(int val, TreeNodePathSumBinaryTree left, TreeNodePathSumBinaryTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}