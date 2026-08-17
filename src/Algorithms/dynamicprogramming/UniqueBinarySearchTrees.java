import java.util.*;

/**
 * ============================================================
 * Problem : Unique Binary Search Trees
 *
 * Approach:
 * Dynamic Programming
 *
 * Time Complexity  : O(N^2)
 * Space Complexity : O(N)
 *
 * Idea:
 *
 * dp[i] = number of unique BSTs that can be formed
 *         using i nodes.
 *
 * For every possible root:
 *
 *       left subtree     root     right subtree
 *       has j nodes               has i-1-j nodes
 *
 * Number of trees for this root:
 *
 *       dp[j] * dp[i - 1 - j]
 *
 * Therefore:
 *
 *       dp[i] = Σ dp[j] * dp[i-1-j]
 *
 * This is the Catalan recurrence.
 * ============================================================
 */

public class UniqueBinarySearchTrees {

    public static int numTrees(int A) {

        // dp[i] = number of unique BSTs with i nodes
        int[] dp = new int[A + 1];

        // Empty tree
        dp[0] = 1;

        // One node -> only one BST
        if (A >= 1) {
            dp[1] = 1;
        }

        // Calculate answer for 2...A nodes
        for (int i = 2; i <= A; i++) {

            int count = 0;

            /*
             * Try every possible node as the root.
             *
             * j = number of nodes in the left subtree
             * i-1-j = number of nodes in the right subtree
             */
            for (int j = 0; j <= i - 1; j++) {

                int leftTrees = dp[j];

                int rightTrees = dp[i - 1 - j];

                // Combine every possible left subtree
                // with every possible right subtree.
                count += leftTrees * rightTrees;
            }

            dp[i] = count;
        }

        return dp[A];
    }

    public static void main(String[] args) {

        int A = 3;

        System.out.println(
                "Number of unique BSTs: " + numTrees(A)
        );
    }
}