/**
 * ============================================================
 * Problem            : Shortest Path in a Maze
 * Created By         : Karthik R
 *
 * Approach           : Graph + DFS + Backtracking
 * Algorithm          : DFS
 *
 * Time Complexity    : O(4^(N*M))
 * Space Complexity   : O(N*M)
 *
 * Idea:
 * - Start DFS from (B, C).
 * - Move in 4 directions.
 * - Avoid blocked and already visited cells.
 * - When destination (D, E) is reached, update shortest distance.
 * - Backtrack so other possible paths can be explored.
 * ============================================================
 */

import java.util.*;

public class ShortestPathInMaze {

    int shortdist = Integer.MAX_VALUE;

    public int FindShortestPath(
            ArrayList<ArrayList<Integer>> A,
            int B,
            int C,
            int D,
            int E) {

        // Start or destination is blocked
        if (A.get(B).get(C) == 0 ||
                A.get(D).get(E) == 0) {

            return -1;
        }

        int n = A.size();
        int m = A.get(0).size();

        boolean[][] vis = new boolean[n][m];

        solve(
                A,
                B,
                C,
                D,
                E,
                0,
                vis,
                m,
                n
        );

        return shortdist == Integer.MAX_VALUE
                ? -1
                : shortdist;
    }

    private void solve(
            ArrayList<ArrayList<Integer>> A,
            int sr,
            int sc,
            int dr,
            int dc,
            int dis,
            boolean[][] vis,
            int m,
            int n) {

        // Out of bounds
        if (sr < 0 || sc < 0 ||
                sr >= n || sc >= m) {

            return;
        }

        // Blocked or already visited
        if (A.get(sr).get(sc) == 0 ||
                vis[sr][sc]) {

            return;
        }

        // Destination reached
        if (sr == dr && sc == dc) {

            shortdist = Math.min(
                    shortdist,
                    dis
            );

            return;
        }

        // Mark current cell
        vis[sr][sc] = true;

        // Up
        solve(
                A, sr - 1, sc,
                dr, dc, dis + 1,
                vis, m, n
        );

        // Left
        solve(
                A, sr, sc - 1,
                dr, dc, dis + 1,
                vis, m, n
        );

        // Right
        solve(
                A, sr, sc + 1,
                dr, dc, dis + 1,
                vis, m, n
        );

        // Down
        solve(
                A, sr + 1, sc,
                dr, dc, dis + 1,
                vis, m, n
        );

        // Backtrack
        vis[sr][sc] = false;
    }

    // ============================================================
    // MAIN METHOD
    // ============================================================

    public static void main(String[] args) {

        ShortestPathInMaze obj =
                new ShortestPathInMaze();

        ArrayList<ArrayList<Integer>> A =
                new ArrayList<>();

        A.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        A.add(new ArrayList<>(Arrays.asList(0, 1, 1)));
        A.add(new ArrayList<>(Arrays.asList(0, 1, 1)));

        int B = 0;
        int C = 0;

        int D = 2;
        int E = 2;

        System.out.println(
                obj.FindShortestPath(A, B, C, D, E)
        );
    }
}