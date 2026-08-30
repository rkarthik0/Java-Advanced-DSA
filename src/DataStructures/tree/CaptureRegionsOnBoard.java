/**
 * ============================================================
 * Problem            : Capture Regions on Board
 * Category           : Algorithms.Graph.DFS
 * Created By         : Karthik R
 *
 * Approach           : Boundary DFS
 *
 * Time Complexity    : O(N * M)
 * Space Complexity   : O(N * M)
 *
 * Idea:
 * - Only 'O's connected to the boundary can survive.
 * - Run DFS from every boundary 'O'.
 * - Temporarily mark safe 'O's as '#'.
 * - Convert remaining 'O's to 'X' because they are surrounded.
 * - Convert '#' back to 'O'.
 * ============================================================
 */

import java.util.*;

public class CaptureRegionsOnBoard {

    int n;
    int m;

    private void dfs(
            int i,
            int j,
            ArrayList<ArrayList<Character>> board) {

        // Stop if outside the board or current cell is not 'O'.
        if (i < 0 || i >= n ||
                j < 0 || j >= m ||
                board.get(i).get(j) != 'O') {
            return;
        }

        // Mark boundary-connected O as safe.
        board.get(i).set(j, '#');

        // Explore four directions.
        dfs(i + 1, j, board);
        dfs(i - 1, j, board);
        dfs(i, j + 1, board);
        dfs(i, j - 1, board);
    }

    public void solve(ArrayList<ArrayList<Character>> board) {

        n = board.size();
        m = board.get(0).size();

        // --------------------------------------------------------
        // Step 1: DFS from all boundary cells.
        // --------------------------------------------------------

        // First and last column.
        for (int i = 0; i < n; i++) {
            dfs(i, 0, board);
            dfs(i, m - 1, board);
        }

        // First and last row.
        for (int j = 0; j < m; j++) {
            dfs(0, j, board);
            dfs(n - 1, j, board);
        }

        // --------------------------------------------------------
        // Step 2:
        // Remaining O -> X
        // Safe # -> O
        // --------------------------------------------------------
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (board.get(i).get(j) == 'O') {

                    // Surrounded O.
                    board.get(i).set(j, 'X');

                } else if (board.get(i).get(j) == '#') {

                    // Boundary-connected O.
                    board.get(i).set(j, 'O');
                }
            }
        }
    }

    public static void main(String[] args) {

        CaptureRegionsOnBoard obj =
                new CaptureRegionsOnBoard();

        ArrayList<ArrayList<Character>> board =
                new ArrayList<>();

        board.add(new ArrayList<>(
                Arrays.asList('X', 'X', 'X', 'X')
        ));

        board.add(new ArrayList<>(
                Arrays.asList('X', 'O', 'O', 'X')
        ));

        board.add(new ArrayList<>(
                Arrays.asList('X', 'X', 'O', 'X')
        ));

        board.add(new ArrayList<>(
                Arrays.asList('X', 'O', 'X', 'X')
        ));

        obj.solve(board);

        for (ArrayList<Character> row : board) {
            System.out.println(row);
        }
    }
}