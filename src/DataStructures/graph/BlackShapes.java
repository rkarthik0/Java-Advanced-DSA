import java.util.*;

public class BlackShapes {

    /*
     * Time Complexity: O(N * M)
     * Space Complexity: O(N * M)
     */

    int n, m;
    String[] grid;

    private void dfs(int i, int j, boolean[][] visited) {

        // Out of bounds
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return;
        }

        // Not a black cell or already visited
        if (visited[i][j] || grid[i].charAt(j) != 'X') {
            return;
        }

        visited[i][j] = true;

        // Visit 4 directions
        dfs(i + 1, j, visited);
        dfs(i - 1, j, visited);
        dfs(i, j + 1, visited);
        dfs(i, j - 1, visited);
    }

    public int countBlackShapes(ArrayList<String> A) {

        n = A.size();
        m = A.get(0).length();

        grid = new String[n];

        for (int i = 0; i < n; i++) {
            grid[i] = A.get(i);
        }

        boolean[][] visited = new boolean[n][m];

        int count = 0;

        // Each unvisited X starts a new black shape.
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (!visited[i][j] &&
                        grid[i].charAt(j) == 'X') {

                    count++;

                    // Visit the complete connected shape.
                    dfs(i, j, visited);
                }
            }
        }

        return count;
    }
}
