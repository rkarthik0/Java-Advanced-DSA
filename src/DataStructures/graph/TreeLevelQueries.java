/**
 * ============================================================
 * Problem            : Tree Queries by Level
 * Created By         : Karthik R
 *
 * Approach           : Tree + DFS + Binary Search
 * Algorithm          : DFS + Level-wise Sorting + Lower Bound
 *
 * Time Complexity    : O(A log A + E log A)
 * Space Complexity   : O(A)
 *
 * Idea:
 * - Build the tree using an adjacency list.
 * - DFS from root node 1 and store every node's value
 *   according to its depth.
 * - Sort the values at every depth.
 * - For each query:
 *      1. Find the required level using modulo.
 *      2. Use lower bound to find the smallest value >= X.
 * ============================================================
 */

import java.util.*;

public class TreeLevelQueries {

    private List<Integer>[] graph;
    private List<Integer>[] levelValues;
    private int maxDepth;

    public int[] solve(
            int A,
            int[] B,
            int[] C,
            int[] D,
            int[] E,
            int[] F) {

        // ========================================================
        // 1. Build adjacency list
        // ========================================================

        graph = new ArrayList[A + 1];

        for (int i = 1; i <= A; i++) {
            graph[i] = new ArrayList<>();
        }

        // Tree is undirected
        for (int i = 0; i < A - 1; i++) {

            int u = B[i];
            int v = C[i];

            graph[u].add(v);
            graph[v].add(u);
        }

        // ========================================================
        // 2. Create list for every possible depth
        // ========================================================

        levelValues = new ArrayList[A];

        for (int i = 0; i < A; i++) {
            levelValues[i] = new ArrayList<>();
        }

        maxDepth = 0;

        // ========================================================
        // 3. DFS from root = 1
        // ========================================================

        dfs(1, 0, 0, D);

        // ========================================================
        // 4. Sort values at every level
        // ========================================================

        for (int level = 0; level <= maxDepth; level++) {
            Collections.sort(levelValues[level]);
        }

        // ========================================================
        // 5. Answer queries
        // ========================================================

        int Q = E.length;
        int[] answer = new int[Q];

        for (int i = 0; i < Q; i++) {

            int L = E[i];
            int X = F[i];

            // Required level
            int level = L % (maxDepth + 1);

            // Find smallest value >= X
            answer[i] = lowerBound(
                    levelValues[level],
                    X
            );
        }

        return answer;
    }

    // ============================================================
    // DFS
    // ============================================================

    private void dfs(
            int node,
            int parent,
            int depth,
            int[] D) {

        // Store current node's value at its depth
        levelValues[depth].add(D[node - 1]);

        maxDepth = Math.max(maxDepth, depth);

        // Visit neighbours
        for (int next : graph[node]) {

            // Don't go back to parent
            if (next == parent) {
                continue;
            }

            dfs(
                    next,
                    node,
                    depth + 1,
                    D
            );
        }
    }

    // ============================================================
    // Lower Bound
    //
    // Returns the smallest value >= target.
    //
    // If no such value exists, returns -1.
    // ============================================================

    private int lowerBound(
            List<Integer> list,
            int target) {

        int left = 0;
        int right = list.size() - 1;

        int answer = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (list.get(mid) >= target) {

                // Possible answer found.
                answer = list.get(mid);

                // Try to find an even smaller valid value.
                right = mid - 1;

            } else {

                // Current value is too small.
                left = mid + 1;
            }
        }

        return answer;
    }

    // ============================================================
    // MAIN METHOD
    // ============================================================

    public static void main(String[] args) {

        TreeLevelQueries obj = new TreeLevelQueries();

        /*
         * Example tree:
         *
         *          1
         *        /   \
         *       2     3
         *      / \
         *     4   5
         */

        int A = 5;

        int[] B = {1, 1, 2, 2};
        int[] C = {2, 3, 4, 5};

        // Values of nodes 1 to 5
        int[] D = {10, 20, 30, 40, 50};

        int[] E = {1, 2, 3};
        int[] F = {15, 35, 45};

        int[] result =
                obj.solve(A, B, C, D, E, F);

        System.out.println(Arrays.toString(result));
    }
}