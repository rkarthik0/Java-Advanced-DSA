package DataStructures.Trees;

/**
 * ============================================================
 * Problem            : Path Sum
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/path-sum/
 * Difficulty         : Easy
 *
 * Approach           : Recursive Tree Traversal
 * Algorithm          : Depth First Search (DFS)
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(h)
 * ============================================================
 */

public class PathSum {

    /**
     * Checks whether the tree contains a root-to-leaf path
     * whose node values add up to the given target.
     *
     * @param root Root of the binary tree
     * @param targetSum Required path sum
     * @return 1 if a valid path exists, otherwise 0
     */
    public static int hasPathSum(TreeNode root, int targetSum) {

        // Empty tree cannot contain a valid path
        if (root == null) {
            return 0;
        }

        // Check the sum only when a leaf node is reached
        if (root.left == null && root.right == null) {
            return root.val == targetSum ? 1 : 0;
        }

        // Reduce the remaining target by the current node's value
        int remainingSum = targetSum - root.val;

        // Search both subtrees for a valid path
        return (hasPathSum(root.left, remainingSum) == 1 ||
                hasPathSum(root.right, remainingSum) == 1) ? 1 : 0;
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
         *        5
         *       / \
         *      4   8
         *     /   / \
         *    11  13  4
         *   /  \
         *  7    2
         */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        // Target sum
        int targetSum = 22;

        // Calling the solution
        int result = hasPathSum(root, targetSum);

        // Printing output
        System.out.println("Path Exists: " + result);
    }
}