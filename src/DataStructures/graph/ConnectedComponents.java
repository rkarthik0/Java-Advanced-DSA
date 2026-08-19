import java.util.*;

/**
 * ============================================================
 * Problem            : Connected Components
 *
 * Approach           : Graph
 * Algorithm          : Iterative DFS
 *
 * Time Complexity    : O(V + E + V log V)
 * Space Complexity   : O(V + E)
 *
 * Idea:
 * - Build an undirected adjacency list.
 * - Start DFS from every unvisited vertex.
 * - Each DFS gives one connected component.
 * - Sort each component.
 * - Sort all components by their first element.
 * ============================================================
 */

public class ConnectedComponents {

    public static ArrayList<ArrayList<Integer>> getComponents(
            int A,
            ArrayList<ArrayList<Integer>> B) {

        boolean[] visit = new boolean[A];

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // Build adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < A; i++) {
            graph.add(new ArrayList<>());
        }

        // Build undirected graph
        for (ArrayList<Integer> row : B) {

            int u = row.get(0);
            int v = row.get(1);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Find connected components
        for (int i = 0; i < A; i++) {

            // Already visited → belongs to an existing component
            if (visit[i]) {
                continue;
            }

            ArrayList<Integer> component = new ArrayList<>();

            Stack<Integer> st = new Stack<>();

            // Start DFS from i
            st.push(i);
            visit[i] = true;

            while (!st.isEmpty()) {

                int node = st.pop();

                component.add(node);

                // Visit all neighbours
                for (int neigh : graph.get(node)) {

                    if (!visit[neigh]) {

                        visit[neigh] = true;
                        st.push(neigh);
                    }
                }
            }

            // Sort nodes inside this component
            Collections.sort(component);

            ans.add(component);
        }

        // Sort components by their smallest element
        ans.sort(
                (a, b) -> Integer.compare(
                        a.get(0),
                        b.get(0)
                )
        );

        return ans;
    }

    // ============================================================
    // MAIN METHOD
    // ============================================================

    public static void main(String[] args) {

        int A = 6;

        ArrayList<ArrayList<Integer>> B = new ArrayList<>();

        B.add(new ArrayList<>(Arrays.asList(0, 1)));
        B.add(new ArrayList<>(Arrays.asList(1, 2)));
        B.add(new ArrayList<>(Arrays.asList(3, 4)));

        ArrayList<ArrayList<Integer>> result =
                getComponents(A, B);

        System.out.println(result);
    }
}