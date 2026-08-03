package Algorithms.Backtracking;

import java.util.ArrayList;

/**
 * ============================================================
 * Problem            : Find Shortest Path in a Grid
 * Created By         : Karthik R
 * Link               :
 * Difficulty         : Medium
 *
 * Approach           : Backtracking
 * Algorithm          : Depth First Search (DFS)
 *
 * Time Complexity    : O(4^(n × m)) (Worst Case)
 * Space Complexity   : O(n × m)
 * ============================================================
 */

public class FindShortestPathInGrid {

    // Stores the shortest distance found
    private static int shortestDistance = Integer.MAX_VALUE;

    /**
     * Finds the shortest path between source and destination
     * in a binary matrix.
     *
     * @param grid Binary matrix (1 = valid cell, 0 = blocked cell)
     * @param sourceRow Source row
     * @param sourceCol Source column
     * @param destinationRow Destination row
     * @param destinationCol Destination column
     * @return Shortest distance, or -1 if unreachable
     */
    public static int findShortestPath(ArrayList<ArrayList<Integer>> grid,
                                       int sourceRow,
                                       int sourceCol,
                                       int destinationRow,
                                       int destinationCol) {

        // Source or destination is blocked
        if (grid.get(sourceRow).get(sourceCol) == 0 ||
                grid.get(destinationRow).get(destinationCol) == 0) {
            return -1;
        }

        int rows = grid.size();
        int cols = grid.get(0).size();

        boolean[][] visited = new boolean[rows][cols];

        solve(grid, sourceRow, sourceCol,
                destinationRow, destinationCol,
                0, visited, rows, cols);

        return shortestDistance == Integer.MAX_VALUE ? -1 : shortestDistance;
    }

    /**
     * Backtracking function to explore all possible paths.
     */
    private static void solve(ArrayList<ArrayList<Integer>> grid,
                              int currentRow,
                              int currentCol,
                              int destinationRow,
                              int destinationCol,
                              int distance,
                              boolean[][] visited,
                              int rows,
                              int cols) {

        // Out of bounds
        if (currentRow < 0 || currentCol < 0 ||
                currentRow >= rows || currentCol >= cols) {
            return;
        }

        // Blocked or already visited
        if (grid.get(currentRow).get(currentCol) == 0 ||
                visited[currentRow][currentCol]) {
            return;
        }

        // Destination reached
        if (currentRow == destinationRow &&
                currentCol == destinationCol) {

            shortestDistance = Math.min(shortestDistance, distance);
            return;
        }

        // Mark current cell as visited
        visited[currentRow][currentCol] = true;

        // Move Up
        solve(grid, currentRow - 1, currentCol,
                destinationRow, destinationCol,
                distance + 1, visited, rows, cols);

        // Move Left
        solve(grid, currentRow, currentCol - 1,
                destinationRow, destinationCol,
                distance + 1, visited, rows, cols);

        // Move Right
        solve(grid, currentRow, currentCol + 1,
                destinationRow, destinationCol,
                distance + 1, visited, rows, cols);

        // Move Down
        solve(grid, currentRow + 1, currentCol,
                destinationRow, destinationCol,
                distance + 1, visited, rows, cols);

        // Backtrack
        visited[currentRow][currentCol] = false;
    }

    public static void main(String[] args) {

        // Sample grid
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();

        grid.add(new ArrayList<>(java.util.Arrays.asList(1, 1, 1, 1)));
        grid.add(new ArrayList<>(java.util.Arrays.asList(1, 0, 1, 0)));
        grid.add(new ArrayList<>(java.util.Arrays.asList(1, 1, 1, 1)));
        grid.add(new ArrayList<>(java.util.Arrays.asList(0, 1, 0, 1)));

        // Source and destination
        int sourceRow = 0;
        int sourceCol = 0;
        int destinationRow = 3;
        int destinationCol = 3;

        // Calling the solution
        int result = findShortestPath(
                grid,
                sourceRow,
                sourceCol,
                destinationRow,
                destinationCol
        );

        // Printing output
        System.out.println("Shortest Distance: " + result);
    }
}