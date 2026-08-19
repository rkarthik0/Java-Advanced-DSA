import java.util.*;

/**
 * ============================================================
 * Problem            : Path in Directed Graph
 *
 * Approach           : DFS
 * Algorithm          : Graph Traversal
 *
 * Time Complexity    : O(N + M)
 * Space Complexity   : O(N + M)
 *
 * N = Number of vertices
 * M = Number of edges
 *
 * Idea:
 * Start DFS from node 1.
 *
 * If DFS reaches node A:
 *     Path exists -> return 1
 *
 * Otherwise:
 *     Path does not exist -> return 0
 * ============================================================
 */

public class PathInDirectedGraph {

    public static int solve(int A, int[][] B) {

        // visited[i] tells whether node i has already been explored.
        boolean[] visit = new boolean[A + 1];

        // Adjacency list representation of the graph.
        List<Integer>[] graph = new ArrayList[A + 1];

        // Initialize every adjacency list.
        for (int i = 1; i <= A; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build the directed graph.
        for (int[] edge : B) {

            int u = edge[0];
            int v = edge[1];

            // Directed edge: u -> v
            graph[u].add(v);
        }

        // Start DFS from node 1.
        return dfs(graph, 1, A, visit) ? 1 : 0;
    }

    private static boolean dfs(
            List<Integer>[] graph,
            int src,
            int A,
            boolean[] visit
    ) {

        // Destination reached.
        if (src == A) {
            return true;
        }

        // Mark current node as visited.
        visit[src] = true;

        // Explore all neighbours.
        for (int neighbour : graph[src]) {

            // Visit only unvisited neighbours.
            if (!visit[neighbour]) {

                if (dfs(
                        graph,
                        neighbour,
                        A,
                        visit
                )) {
                    return true;
                }
            }
        }

        // No path to A from this node.
        return false;
    }

    public static void main(String[] args) {

        int A = 4;

        int[][] B = {
                {1, 2},
                {2, 3},
                {3, 4}
        };

        System.out.println(solve(A, B));
    }
}