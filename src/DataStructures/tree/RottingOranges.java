/**
 * ============================================================
 * Problem            : Rotting Oranges
 * Category           : Algorithms.Graph.BFS
 * Created By         : Karthik R
 *
 * Approach           : Multi-Source BFS
 * Algorithm          : Breadth First Search
 *
 * Time Complexity    : O(N * M)
 * Space Complexity   : O(N * M)
 *
 * Idea:
 * - Add all initially rotten oranges to the queue.
 * - They all start at time 0.
 * - BFS spreads rot to all fresh oranges in 4 directions.
 * - Each newly rotten orange takes current time + 1.
 * - If fresh oranges remain after BFS, return -1.
 * ============================================================
 */

import java.util.*;

public class RottingOranges {

    // Stores row, column and time.
    static class Info {

        int x;
        int y;
        int time;

        Info(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public int solve(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int fresh = 0;

        Queue<Info> q = new LinkedList<>();

        // Add all initially rotten oranges to the queue.
        // Count all fresh oranges.
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 2) {
                    q.add(new Info(i, j, 0));
                }
                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // No fresh oranges.
        if (fresh == 0) {
            return 0;
        }

        int minute = 0;

        // Left, Up, Right, Down.
        int[] row = {0, -1, 0, 1};
        int[] col = {-1, 0, 1, 0};

        // Multi-source BFS.
        while (!q.isEmpty()) {

            Info curr = q.poll();

            int x = curr.x;
            int y = curr.y;
            int time = curr.time;

            minute = Math.max(minute, time);

            // Check all 4 neighbours.
            for (int i = 0; i < 4; i++) {

                int newX = x + row[i];
                int newY = y + col[i];

                // Check bounds and fresh orange.
                if (newX >= 0 && newX < n &&
                        newY >= 0 && newY < m &&
                        grid[newX][newY] == 1) {

                    // Make it rotten.
                    grid[newX][newY] = 2;

                    // One less fresh orange.
                    fresh--;

                    // It becomes rotten after 1 minute.
                    q.add(new Info(newX, newY, time + 1));
                }
            }
        }

        // Some fresh oranges could not be reached.
        if (fresh != 0) {
            return -1;
        }

        return minute;
    }

    public static void main(String[] args) {

        RottingOranges obj = new RottingOranges();

        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        System.out.println(obj.solve(grid));
    }
}