package Problems._1_Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * The "linked list" should use the same TreeNode class where
 * the right child pointer points to the next node in the list,
 * and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 */

public class _35_FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {

        // create a tree
        // root = [1,2,5,3,4,null,6]

        TreeNodeToLinkedList root = new TreeNodeToLinkedList(1);
        TreeNodeToLinkedList node2 = new TreeNodeToLinkedList(2);
        TreeNodeToLinkedList node3 = new TreeNodeToLinkedList(3);
        TreeNodeToLinkedList node4 = new TreeNodeToLinkedList(4);
        TreeNodeToLinkedList node5 = new TreeNodeToLinkedList(5);
        TreeNodeToLinkedList node6 = new TreeNodeToLinkedList(6);

        // Connect the nodes to form the binary tree

        root.left = node2;
        root.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;





    }

    public static void flatten(TreeNodeToLinkedList root) {
        if (root == null) return;
        Stack<TreeNodeToLinkedList> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNodeToLinkedList currentNode = stack.pop();
            // we push to the right node to the stack first, because we actually want the left node first.
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }

            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }

            if (!stack.isEmpty()) {
                currentNode.right = stack.peek();
            }

            currentNode.left = null;
        }
    }

    public static List<Integer> listFromTree(TreeNodeToLinkedList root) {
        List<Integer> result = new ArrayList<>();


        Stack<TreeNodeToLinkedList> stack = new Stack<>();
        stack.push(root);
        result.add(root.val);

        while (!stack.isEmpty()) {
            TreeNodeToLinkedList currentNode = stack.pop();

            // we push to the right node to the stack first, because we actually want the left node first.
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }

            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }

            if (!stack.isEmpty()) {
                currentNode.right = stack.peek();

                int currentNumber = currentNode.right.val;
                result.add(currentNumber);
            }

            currentNode.left = null;

        }
        return result;
    }

}

class TreeNodeToLinkedList {
    int val;
    TreeNodeToLinkedList left;
    TreeNodeToLinkedList right;

    TreeNodeToLinkedList() {
    }

    TreeNodeToLinkedList(int val) {
        this.val = val;
    }

    TreeNodeToLinkedList(int val, TreeNodeToLinkedList left, TreeNodeToLinkedList right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
