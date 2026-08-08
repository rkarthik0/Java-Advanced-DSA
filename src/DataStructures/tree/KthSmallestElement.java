package DataStructures.Trees;

/**
 * ============================================================
 * Problem            : Kth Smallest Element in a BST
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * Difficulty         : Medium
 *
 * Approach           : Inorder Traversal
 * Algorithm          : Depth First Search (DFS)
 *
 * Time Complexity    : O(h + k)
 * Space Complexity   : O(h)
 * ============================================================
 */

public class KthSmallestElement {

    // Stores the current inorder position
    private static int count = 0;

    // Stores the kth smallest value
    private static int answer = Integer.MIN_VALUE;

    /**
     * Finds the kth smallest element in a Binary Search Tree.
     *
     * Inorder traversal of a BST visits nodes in sorted order.
     *
     * @param root Root of the BST
     * @param k Position of the required smallest element
     * @return kth smallest element
     */
    public static int kthSmallest(TreeNode root, int k) {

        // Empty subtree
        if (root == null) {
            return 0;
        }

        // Visit left subtree first
        kthSmallest(root.left, k);

        // Current node's inorder position
        count++;

        // kth element found
        if (count == k) {
            answer = root.val;
            return answer;
        }

        // Search right subtree only if answer is not found
        if (answer == Integer.MIN_VALUE) {
            kthSmallest(root.right, k);
        }

        return answer;
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
         * Sample BST:
         *
         *        5
         *       / \
         *      3   7
         *     / \ / \
         *    2  4 6  8
         *
         * Inorder: 2, 3, 4, 5, 6, 7, 8
         */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        int k = 3;

        // Reset state before calling the solution
        count = 0;
        answer = Integer.MIN_VALUE;

        // Calling the solution
        int result = kthSmallest(root, k);

        // Printing output
        System.out.println("Kth Smallest Element: " + result);
    }
}