import java.util.*;

public class EdgesInAnyMinimumSpanningTree {

    // Time Complexity: O(M log M)
    // Space Complexity: O(A + M)

    static class Edge {
        int u;
        int v;
        int weight;
        int index;

        Edge(int u, int v, int weight, int index) {
            this.u = u;
            this.v = v;
            this.weight = weight;
            this.index = index;
        }
    }

    int[] parent;
    int[] rank;

    // Find representative with path compression.
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    // Union two components using rank.
    private void union(int a, int b) {

        int parentA = find(a);
        int parentB = find(b);

        if (parentA == parentB) {
            return;
        }

        if (rank[parentA] < rank[parentB]) {
            parent[parentA] = parentB;
        }
        else if (rank[parentA] > rank[parentB]) {
            parent[parentB] = parentA;
        }
        else {
            parent[parentB] = parentA;
            rank[parentA]++;
        }
    }

    public ArrayList<Integer> solve(
            int A,
            ArrayList<ArrayList<Integer>> B) {

        int m = B.size();

        ArrayList<Edge> edges = new ArrayList<>();

        // Store every edge along with its original index.
        for (int i = 0; i < m; i++) {

            int u = B.get(i).get(0);
            int v = B.get(i).get(1);
            int weight = B.get(i).get(2);

            edges.add(
                    new Edge(u, v, weight, i)
            );
        }

        // Kruskal requires edges sorted by increasing weight.
        Collections.sort(
                edges,
                (e1, e2) -> Integer.compare(e1.weight, e2.weight)
        );

        // Initialize DSU.
        parent = new int[A + 1];
        rank = new int[A + 1];

        for (int i = 1; i <= A; i++) {
            parent[i] = i;
        }

        // Answer is returned in the original edge order.
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            answer.add(0);
        }

        int i = 0;

        while (i < m) {

            int j = i;

            // Find the complete group of equal-weight edges.
            while (j < m &&
                    edges.get(j).weight == edges.get(i).weight) {
                j++;
            }

            /*
             * IMPORTANT:
             *
             * Check all edges of the same weight BEFORE
             * performing any union.
             *
             * If u and v are currently in different components,
             * this edge can be present in some MST.
             */
            for (int k = i; k < j; k++) {

                Edge edge = edges.get(k);

                if (find(edge.u) != find(edge.v)) {
                    answer.set(edge.index, 1);
                }
            }

            /*
             * After checking the complete weight group,
             * merge its edges into the DSU.
             */
            for (int k = i; k < j; k++) {

                Edge edge = edges.get(k);

                if (find(edge.u) != find(edge.v)) {
                    union(edge.u, edge.v);
                }
            }

            i = j;
        }

        return answer;
    }
}