package DataStructures.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ============================================================
 * Problem            : Binary Tree Vertical Order Traversal
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 * Difficulty         : Medium
 *
 * Approach           : Breadth-First Search (BFS)
 * Algorithm          : Level Order Traversal + HashMap
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(n)
 * ============================================================
 */

public class BinaryTreeVerticalOrderTraversal {

    /**
     * Definition for a binary tree node.
     */
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Returns the vertical order traversal of a binary tree.
     *
     * @param root Root of the binary tree
     * @return Vertical order traversal
     */
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // Edge case
        if (root == null) {
            return result;
        }

        // Maps vertical level to its corresponding node values
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // Queue for tree nodes
        Queue<TreeNode> nodeQueue = new LinkedList<>();

        // Queue for vertical levels
        Queue<Integer> levelQueue = new LinkedList<>();

        int minLevel = Integer.MAX_VALUE;
        int maxLevel = Integer.MIN_VALUE;

        nodeQueue.offer(root);
        levelQueue.offer(0);

        // Perform BFS
        while (!nodeQueue.isEmpty()) {

            TreeNode current = nodeQueue.poll();
            int level = levelQueue.poll();

            // Create a new list if this vertical level is visited first time
            map.putIfAbsent(level, new ArrayList<>());

            // Store the current node
            map.get(level).add(current.val);

            // Update minimum and maximum vertical levels
            minLevel = Math.min(minLevel, level);
            maxLevel = Math.max(maxLevel, level);

            // Process left child
            if (current.left != null) {
                nodeQueue.offer(current.left);
                levelQueue.offer(level - 1);
            }

            // Process right child
            if (current.right != null) {
                nodeQueue.offer(current.right);
                levelQueue.offer(level + 1);
            }
        }

        // Collect the answer from leftmost to rightmost vertical level
        for (int level = minLevel; level <= maxLevel; level++) {
            result.add(map.get(level));
        }

        return result;
    }

    public static void main(String[] args) {

        // Sample tree
        //
        //         3
        //        / \
        //       9   20
        //          /  \
        //         15   7
        //

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Calling the solution
        ArrayList<ArrayList<Integer>> result = verticalOrderTraversal(root);

        // Printing output
        System.out.println(result);
    }
}