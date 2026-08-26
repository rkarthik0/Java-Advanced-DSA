/**
 * ============================================================
 * Problem            : Minimum Increment Operations
 * Created By         : Karthik R
 *
 * Approach           : Find Maximum + Greedy
 * Algorithm          : Make Every Element Equal to Maximum
 *
 * Time Complexity    : O(N)
 * Space Complexity   : O(1)
 *
 * Idea:
 * - Find the maximum element.
 * - To make all elements equal, the optimal target is the maximum.
 * - For every element n, required operations = max - n.
 * - Add all required increments.
 * ============================================================
 */

public class MinimumIncrementOperations {

    public int solve(int[] A) {

        int max = Integer.MIN_VALUE;

        // Find maximum element.
        for (int n : A) {
            if (n > max) {
                max = n;
            }
        }

        int ans = 0;

        // Increase every element up to max.
        for (int n : A) {

            // Important:
            // Number of increments required for n.
            ans += max - n;
        }

        return ans;
    }

    public static void main(String[] args) {

        MinimumIncrementOperations obj =
                new MinimumIncrementOperations();

        int[] A = {2, 4, 1, 3};

        System.out.println(obj.solve(A));
    }
}