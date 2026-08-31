/**
 * ============================================================
 * Problem            : Diameter of a Tree
 * Category           : Algorithms.Graph.BFS
 * Created By         : Karthik R
 *
 * Approach           : Two BFS Traversals
 * Algorithm          : Tree Diameter using BFS
 *
 * Time Complexity    : O(N)
 * Space Complexity   : O(N)
 *
 * Idea:
 * - Build the undirected tree from the parent array.
 * - BFS from the root to find one endpoint of the diameter.
 * - BFS again from that farthest node.
 * - The maximum distance found in the second BFS is the
 *   diameter of the tree.
 * ============================================================
 */

import java.util.*;

public class DiameterOfTree {

    public int solve(ArrayList<Integer> A) {

        int n = A.size();

        // Build adjacency list.
        ArrayList<ArrayList<Integer>> graph =
                new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int root = -1;

        // Convert parent array into an undirected tree.
        for (int i = 0; i < n; i++) {

            if (A.get(i) == -1) {
                root = i;
            }
            else {
                int parent = A.get(i);

                graph.get(parent).add(i);
                graph.get(i).add(parent);
            }
        }

        // First BFS:
        // Find the farthest node from the root.
        int[] first = bfs(graph, root);

        int farthestNode = first[0];

        // Second BFS:
        // Find the farthest distance from that node.
        int[] second = bfs(graph, farthestNode);

        return second[1];
    }

    private int[] bfs(
            ArrayList<ArrayList<Integer>> graph,
            int source) {

        int n = graph.size();

        boolean[] visited = new boolean[n];
        int[] distance = new int[n];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        visited[source] = true;

        int farthestNode = source;
        int maxDistance = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            // Explore all neighbours.
            for (int neighbour : graph.get(node)) {

                if (!visited[neighbour]) {

                    visited[neighbour] = true;

                    // Distance from source.
                    distance[neighbour] =
                            distance[node] + 1;

                    // Update farthest node.
                    if (distance[neighbour] > maxDistance) {

                        maxDistance =
                                distance[neighbour];

                        farthestNode = neighbour;
                    }

                    queue.add(neighbour);
                }
            }
        }

        return new int[]{
                farthestNode,
                maxDistance
        };
    }

    public static void main(String[] args) {

        DiameterOfTree obj =
                new DiameterOfTree();

        // Parent array:
        // -1 = root
        //
        //        0
        //       / \
        //      1   2
        //     / \
        //    3   4
        //
        // Diameter = 3 -> 1 -> 0 -> 2

        ArrayList<Integer> A =
                new ArrayList<>(
                        Arrays.asList(-1, 0, 0, 1, 1)
                );

        System.out.println(obj.solve(A));
    }
}