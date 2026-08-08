package DataStructures.Trees;

/**
 * ============================================================
 * Problem            : Lowest Common Ancestor of a Binary Tree
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Difficulty         : Medium
 *
 * Approach           : Recursive Tree Traversal
 * Algorithm          : Depth First Search (DFS)
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(h)
 * ============================================================
 */

public class LowestCommonAncestor {

    /**
     * Finds the Lowest Common Ancestor (LCA) of two nodes.
     *
     * First verifies that both nodes exist in the tree.
     * Then recursively searches the left and right subtrees.
     *
     * @param root Root of the binary tree
     * @param B First target value
     * @param C Second target value
     * @return LCA value, or -1 if either node does not exist
     */
    public static int lca(TreeNode root, int B, int C) {

        // Both nodes must exist in the tree
        if (!find(root, B) || !find(root, C)) {
            return -1;
        }

        // Find the Lowest Common Ancestor
        return solve(root, B, C);
    }

    /**
     * Recursive DFS to find the LCA.
     */
    private static int solve(TreeNode root, int B, int C) {

        // Empty subtree
        if (root == null) {
            return 0;
        }

        // Current node is one of the target nodes
        if (root.val == B || root.val == C) {
            return root.val;
        }

        // Search in the left subtree
        int left = solve(root.left, B, C);

        // Search in the right subtree
        int right = solve(root.right, B, C);

        // One target found on each side
        if (left != 0 && right != 0) {
            return root.val;
        }

        // Target/LCA found in the left subtree
        if (left != 0) {
            return left;
        }

        // Target/LCA found in the right subtree
        return right;
    }

    /**
     * Checks whether a value exists in the binary tree.
     */
    private static boolean find(TreeNode root, int value) {

        // Value does not exist in this subtree
        if (root == null) {
            return false;
        }

        // Target found
        if (root.val == value) {
            return true;
        }

        // Search both subtrees
        return find(root.left, value) || find(root.right, value);
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
         * Sample tree:
         *
         *          3
         *        /   \
         *       5     1
         *      / \   / \
         *     6   2 0   8
         *        / \
         *       7   4
         */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Find LCA of 5 and 1
        int result = lca(root, 5, 1);

        // Print the result
        System.out.println("Lowest Common Ancestor: " + result);
    }
}