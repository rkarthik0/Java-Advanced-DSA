import java.util.*;

public class KnightShortestPath {

    // Time Complexity: O(A * B)
    // Space Complexity: O(A * B)

    public int knight(int A, int B, int C, int D, int E, int F) {

        // 8 possible moves of a knight.
        int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};

        // Convert 1-based coordinates to 0-based.
        C--;
        D--;
        E--;
        F--;

        // BFS because every knight move has equal cost = 1.
        Queue<int[]> queue = new LinkedList<>();

        boolean[][] visited = new boolean[A][B];

        // Store: {row, column, steps}.
        queue.add(new int[]{C, D, 0});
        visited[C][D] = true;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];
            int steps = current[2];

            // Destination reached.
            if (x == E && y == F) {
                return steps;
            }

            // Try all 8 knight moves.
            for (int k = 0; k < 8; k++) {

                int nx = x + dx[k];
                int ny = y + dy[k];

                // Check bounds and avoid revisiting cells.
                if (nx >= 0 && nx < A &&
                        ny >= 0 && ny < B &&
                        !visited[nx][ny]) {

                    visited[nx][ny] = true;

                    queue.add(
                            new int[]{nx, ny, steps + 1}
                    );
                }
            }
        }

        // Destination cannot be reached.
        return -1;
    }
}