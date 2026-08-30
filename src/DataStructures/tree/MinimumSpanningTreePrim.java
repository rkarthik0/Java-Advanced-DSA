/**
 * ============================================================
 * Problem            : Minimum Spanning Tree
 * Category           : Algorithms.Graph
 * Created By         : Karthik R
 *
 * Approach           : Prim's Algorithm
 * Algorithm          : Minimum Spanning Tree using PriorityQueue
 *
 * Time Complexity    : O((V + E) log V)
 * Space Complexity   : O(V + E)
 *
 * Idea:
 * - Build an undirected weighted graph.
 * - Start from vertex 1 with cost 0.
 * - Always choose the minimum-cost edge leading to an
 *   unvisited vertex.
 * - Add that vertex to the MST.
 * - Continue until all vertices are included.
 * ============================================================
 */

import java.util.*;

public class MinimumSpanningTreePrim {

    // Stores neighboring vertex and edge weight.
    static class Pair {
        int v;
        int w;

        Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {

        // ---------------------------------------------------------
        // STEP 1: Create adjacency list
        // ---------------------------------------------------------
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for (int i = 0; i <= A; i++) {
            graph.add(new ArrayList<>());
        }

        // ---------------------------------------------------------
        // STEP 2: Build undirected weighted graph
        //
        // B row = [u, v, w]
        // ---------------------------------------------------------
        for (ArrayList<Integer> row : B) {

            int u = row.get(0);
            int v = row.get(1);
            int w = row.get(2);

            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }

        // ---------------------------------------------------------
        // STEP 3: PriorityQueue
        //
        // Always gives the edge with minimum weight.
        // ---------------------------------------------------------
        PriorityQueue<Pair> pq =
                new PriorityQueue<>(
                        (a, b) -> Integer.compare(a.w, b.w)
                );

        boolean[] visited = new boolean[A + 1];

        // Start from vertex 1 with cost 0.
        pq.add(new Pair(1, 0));

        int ans = 0;
        int verticesAdded = 0;

        // ---------------------------------------------------------
        // STEP 4: Build MST
        // ---------------------------------------------------------
        while (!pq.isEmpty() && verticesAdded < A) {

            Pair curr = pq.poll();

            int vertex = curr.v;
            int weight = curr.w;

            // Ignore vertex if already included in MST.
            if (visited[vertex]) {
                continue;
            }

            // Add vertex and its connecting edge to MST.
            visited[vertex] = true;
            ans += weight;
            verticesAdded++;

            // Add all unvisited neighboring edges.
            for (Pair neighbor : graph.get(vertex)) {

                if (!visited[neighbor.v]) {
                    pq.add(neighbor);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        MinimumSpanningTreePrim obj =
                new MinimumSpanningTreePrim();

        ArrayList<ArrayList<Integer>> B = new ArrayList<>();

        B.add(new ArrayList<>(Arrays.asList(1, 2, 10)));
        B.add(new ArrayList<>(Arrays.asList(1, 3, 5)));
        B.add(new ArrayList<>(Arrays.asList(2, 3, 4)));
        B.add(new ArrayList<>(Arrays.asList(2, 4, 2)));
        B.add(new ArrayList<>(Arrays.asList(3, 4, 8)));

        int A = 4;

        System.out.println(obj.solve(A, B));
    }
}