/**
 * ============================================================
 * Problem            : Ways to Climb
 * Created By         : Karthik R
 *
 * Approach           : Recursion + Backtracking
 * Algorithm          : Backtracking
 *
 * Time Complexity    : O(2^A)
 * Space Complexity   : O(A)
 *
 * Idea:
 * - At every step, choose either 1 or 2.
 * - Reduce the remaining steps.
 * - When remaining steps become 0, store the current path.
 * - Backtrack after every choice.
 * ============================================================
 */

import java.util.*;

public class WaysToClimb {

    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> WaysToClimb(int A) {

        ArrayList<Integer> cur = new ArrayList<>();

        solve(A, cur);

        return ans;
    }

    private void solve(int rem, ArrayList<Integer> cur) {

        if (rem == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        // Choose 1 step
        if (rem >= 1) {
            cur.add(1);

            solve(rem - 1, cur);

            // Backtrack
            cur.remove(cur.size() - 1);
        }

        // Choose 2 steps
        if (rem >= 2) {
            cur.add(2);

            solve(rem - 2, cur);

            // Backtrack
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {

        WaysToClimb obj = new WaysToClimb();

        int A = 3;

        ArrayList<ArrayList<Integer>> result =
                obj.WaysToClimb(A);

        System.out.println(result);
    }
}