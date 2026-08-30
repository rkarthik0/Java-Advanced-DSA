/**
 * ============================================================
 * Problem            : Minimum Spanning Tree
 * Category           : Algorithms.Graph
 * Created By         : Karthik R
 *
 * Approach           : Prim's Algorithm
 * Algorithm          : PriorityQueue + Adjacency List
 *
 * Time Complexity    : O((V + E) log V)
 * Space Complexity   : O(V + E)
 *
 * Idea:
 * - Start from vertex 1.
 * - Always choose the cheapest edge connecting an unvisited
 *   vertex to the current MST.
 * - Use PriorityQueue to efficiently get the minimum edge.
 * - Add the selected edge cost to the answer.
 * ============================================================
 */

import java.util.*;

public class MinimumSpanningTree {

    // Stores vertex and edge weight.
    static class Pair {

        int v;
        long w;

        Pair(int v, long w) {
            this.v = v;
            this.w = w;
        }
    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {

        // Create adjacency list.
        ArrayList<ArrayList<Pair>> graph =
                new ArrayList<>();

        for (int i = 0; i <= A; i++) {
            graph.add(new ArrayList<>());
        }

        // Build undirected weighted graph.
        for (ArrayList<Integer> edge : B) {

            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);

            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }

        // Minimum weight edge comes first.
        PriorityQueue<Pair> pq =
                new PriorityQueue<>(
                        (a, b) -> Long.compare(a.w, b.w)
                );

        boolean[] visited = new boolean[A + 1];

        // Start Prim's algorithm from vertex 1.
        pq.add(new Pair(1, 0));

        long ans = 0;

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int vertex = curr.v;
            long weight = curr.w;

            // Ignore already visited vertices.
            if (visited[vertex]) {
                continue;
            }

            // Include vertex in MST.
            visited[vertex] = true;

            // Add selected edge weight.
            ans += weight;

            // Add all possible edges to unvisited vertices.
            for (Pair neighbor : graph.get(vertex)) {

                if (!visited[neighbor.v]) {
                    pq.add(neighbor);
                }
            }
        }

        // Return answer modulo 1,000,000,007.
        return (int) (ans % 1000000007);
    }

    public static void main(String[] args) {

        MinimumSpanningTree obj =
                new MinimumSpanningTree();

        ArrayList<ArrayList<Integer>> B =
                new ArrayList<>();

        B.add(new ArrayList<>(Arrays.asList(1, 2, 10)));
        B.add(new ArrayList<>(Arrays.asList(1, 3, 5)));
        B.add(new ArrayList<>(Arrays.asList(2, 3, 4)));
        B.add(new ArrayList<>(Arrays.asList(2, 4, 2)));
        B.add(new ArrayList<>(Arrays.asList(3, 4, 8)));

        int A = 4;

        System.out.println(obj.solve(A, B));
    }
}