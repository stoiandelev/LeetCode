package Problems._1_Easy;


import java.time.chrono.MinguoChronology;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node
 * down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 */

public class _31_MinimumDepthOfBinaryTree {
    public static void main(String[] args) {


    }

    public int minDepth(TreeNodeMinDeep root) {
        //DFS approach

        //basic
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}


class TreeNodeMinDeep {
    int val;
    TreeNodeMinDeep left;
    TreeNodeMinDeep right;

    TreeNodeMinDeep() {
    }

    TreeNodeMinDeep(int val) {
        this.val = val;
    }

    TreeNodeMinDeep(int val, TreeNodeMinDeep left, TreeNodeMinDeep right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
