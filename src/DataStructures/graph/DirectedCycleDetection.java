import java.util.*;

/**
 * ============================================================
 * Problem            : Cycle Detection in Directed Graph
 *
 * Approach           : DFS
 * Algorithm          : DFS + Recursion Stack
 *
 * Time Complexity    : O(A + M)
 * Space Complexity   : O(A + M)
 *
 * A = Number of vertices
 * M = Number of directed edges
 *
 * Idea:
 *
 * We use two boolean arrays:
 *
 * 1. visited[]
 *    -> Has this node been visited before?
 *
 * 2. path[]
 *    -> Is this node currently present in the
 *       current DFS recursion path?
 *
 * If we reach a node where:
 *
 *     path[neighbour] == true
 *
 * then we have found a cycle.
 *
 * ============================================================
 */

public class DirectedCycleDetection {

    public static int solve(int A, int[][] B) {

        // visited[i] = true if node i has been visited
        boolean[] visited = new boolean[A + 1];

        // path[i] = true if node i is currently
        // in the active DFS recursion path
        boolean[] path = new boolean[A + 1];

        // Adjacency list
        List<Integer>[] graph = new ArrayList[A + 1];

        // Initialize adjacency lists
        for (int i = 1; i <= A; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build directed graph
        for (int[] edge : B) {

            int u = edge[0];
            int v = edge[1];

            // Directed edge:
            // u -> v
            graph[u].add(v);
        }

        // Graph may contain multiple disconnected components.
        // Therefore, start DFS from every unvisited node.
        for (int i = 1; i <= A; i++) {

            if (!visited[i]) {

                if (dfs(graph, i, visited, path)) {
                    return 1; // Cycle found
                }
            }
        }

        // No cycle found
        return 0;
    }

    private static boolean dfs(
            List<Integer>[] graph,
            int src,
            boolean[] visited,
            boolean[] path
    ) {

        // Mark node as visited
        visited[src] = true;

        // Put node into current DFS path
        path[src] = true;

        // Explore all neighbours
        for (int neighbour : graph[src]) {

            // If neighbour is already in the
            // current recursion path, we found a cycle.
            if (path[neighbour]) {
                return true;
            }

            // If neighbour hasn't been visited,
            // explore it recursively.
            if (!visited[neighbour]) {

                if (dfs(
                        graph,
                        neighbour,
                        visited,
                        path
                )) {
                    return true;
                }
            }
        }

        // DFS for this node is complete.
        // Remove it from the current recursion path.
        path[src] = false;

        return false;
    }

    public static void main(String[] args) {

        int A = 3;

        int[][] B = {
                {1, 2},
                {2, 3},
                {3, 1}
        };

        System.out.println(solve(A, B));
    }
}