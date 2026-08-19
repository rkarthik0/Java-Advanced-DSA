import java.util.*;

/**
 * ============================================================
 * Problem            : Path in Tree
 *
 * Approach           : Graph
 * Algorithm          : DFS
 *
 * Time Complexity    : O(N)
 * Space Complexity   : O(N)
 *
 * Idea:
 * - A[i] represents the parent of node i + 1.
 * - Build the directed tree:
 *
 *      A[i] -> i + 1
 *
 * - Start DFS from node B.
 * - If we reach node C, a path exists.
 * ============================================================
 */

public class PathInTree {

    public static int solve(int[] A, final int B, final int C) {

        int n = A.length;

        // Adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // Nodes are numbered from 1 to n
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build directed tree
        //
        // A[i] = parent of node i + 1
        //
        // Example:
        // A = [1, 1, 2]
        //
        // 1 -> 2
        // 1 -> 3
        // 2 -> 4

        for (int i = 1; i < n; i++) {

            int from = A[i];
            int to = i + 1;

            graph.get(from).add(to);
        }

        boolean[] visit = new boolean[n + 1];

        // Start DFS from B and search for C
        return dfs(C, B, graph, visit);
    }

    private static int dfs(
            int dest,
            int cur,
            ArrayList<ArrayList<Integer>> graph,
            boolean[] visit) {

        // Destination reached
        if (cur == dest) {
            return 1;
        }

        // Mark current node visited
        visit[cur] = true;

        // Explore all children
        for (int neigh : graph.get(cur)) {

            if (!visit[neigh]) {

                if (dfs(
                        dest,
                        neigh,
                        graph,
                        visit
                ) == 1) {

                    return 1;
                }
            }
        }

        // Destination not found
        return 0;
    }

    // ============================================================
    // MAIN METHOD
    // ============================================================

    public static void main(String[] args) {

        int[] A = {0, 1, 1, 2, 2};

        int B = 1;
        int C = 5;

        int result = solve(A, B, C);

        System.out.println(result);
    }
}