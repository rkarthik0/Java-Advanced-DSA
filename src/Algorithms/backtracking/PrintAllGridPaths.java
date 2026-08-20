/**
 * ============================================================
 * Problem            : Print All Paths in a Grid
 * Created By         : Karthik R
 *
 * Approach           : Recursion + Backtracking
 * Algorithm          : Backtracking
 *
 * Time Complexity    : O(C(A+B-2, A-1) * (A+B))
 * Space Complexity   : O(A+B)
 *
 * Idea:
 * - Start from (0, 0).
 * - We can move only:
 *      D -> Down
 *      R -> Right
 * - When we reach (A-1, B-1), store the path.
 * - After every recursive call, remove the last move
 *   to backtrack and try another path.
 * ============================================================
 */

import java.util.*;

public class PrintAllGridPaths {

    public ArrayList<String> PrintAllPaths(int A, int B) {

        ArrayList<String> ans = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        solve(
                0,
                0,
                A,
                B,
                ans,
                sb
        );

        return ans;
    }

    private void solve(
            int i,
            int j,
            int A,
            int B,
            ArrayList<String> ans,
            StringBuilder sb) {

        // Destination reached
        if (i == A - 1 && j == B - 1) {

            ans.add(sb.toString());

            return;
        }

        // Move Down
        if (i + 1 < A) {

            sb.append('D');

            solve(
                    i + 1,
                    j,
                    A,
                    B,
                    ans,
                    sb
            );

            // Backtrack
            sb.deleteCharAt(sb.length() - 1);
        }

        // Move Right
        if (j + 1 < B) {

            sb.append('R');

            solve(
                    i,
                    j + 1,
                    A,
                    B,
                    ans,
                    sb
            );

            // Backtrack
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // ============================================================
    // MAIN METHOD
    // ============================================================

    public static void main(String[] args) {

        PrintAllGridPaths obj =
                new PrintAllGridPaths();

        int A = 2;
        int B = 3;

        ArrayList<String> result =
                obj.PrintAllPaths(A, B);

        System.out.println(result);
    }
}