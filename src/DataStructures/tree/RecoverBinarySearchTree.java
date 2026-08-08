package DataStructures.Trees;

import java.util.ArrayList;

/**
 * ============================================================
 * Problem            : Recover Binary Search Tree
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/recover-binary-search-tree/
 * Difficulty         : Medium
 *
 * Approach           : Inorder Traversal
 * Algorithm          : Morris Traversal
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(1)
 * ============================================================
 */

public class RecoverBinarySearchTree {

    private TreeNode first = null;
    private TreeNode middle = null;
    private TreeNode last = null;
    private TreeNode previous = null;

    /**
     * Finds the two nodes that were swapped in a BST.
     *
     * The inorder traversal of a valid BST must be sorted.
     * A violation in this order helps identify the swapped nodes.
     *
     * Morris Traversal is used to perform inorder traversal
     * without recursion or an auxiliary stack.
     *
     * @param root Root of the BST
     * @return Values of the two swapped nodes in ascending order
     */
    public ArrayList<Integer> recoverTree(TreeNode root) {

        TreeNode current = root;

        // Morris Inorder Traversal
        while (current != null) {

            // Case 1: No left subtree
            if (current.left == null) {

                // Check inorder violation
                checkViolation(current);

                // Move to right subtree
                current = current.right;

            } else {

                // Find inorder predecessor
                TreeNode predecessor = current.left;

                while (predecessor.right != null &&
                        predecessor.right != current) {

                    predecessor = predecessor.right;
                }

                // Create temporary thread
                if (predecessor.right == null) {

                    predecessor.right = current;
                    current = current.left;

                } else {

                    // Remove temporary thread
                    predecessor.right = null;

                    // Visit current node
                    checkViolation(current);

                    // Move to right subtree
                    current = current.right;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        // Non-adjacent swapped nodes
        if (first != null && last != null) {

            result.add(Math.min(first.val, last.val));
            result.add(Math.max(first.val, last.val));

        } else {

            // Adjacent swapped nodes
            result.add(Math.min(first.val, middle.val));
            result.add(Math.max(first.val, middle.val));
        }

        return result;
    }

    /**
     * Checks whether the current node violates the sorted
     * inorder property of a Binary Search Tree.
     */
    private void checkViolation(TreeNode current) {

        // Inorder traversal of a BST must be sorted
        if (previous != null && previous.val > current.val) {

            // First violation
            if (first == null) {

                first = previous;
                middle = current;

            } else {

                // Second violation
                last = current;
            }
        }

        // Update previous node
        previous = current;
    }

    /**
     * Basic TreeNode class for testing.
     */
    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        /*
         * Example BST with two swapped nodes:
         *
         *          3
         *        /   \
         *       1     4
         *            /
         *           2
         *
         * 2 and 3 are swapped.
         *
         * Correct BST:
         *
         *          2
         *        /   \
         *       1     4
         *            /
         *           3
         */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        // Create solution object
        RecoverBinarySearchTree solution =
                new RecoverBinarySearchTree();

        // Find the swapped nodes
        ArrayList<Integer> result = solution.recoverTree(root);

        // Printing output
        System.out.println("Swapped Nodes: " + result);
    }
}