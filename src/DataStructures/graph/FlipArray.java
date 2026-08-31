/**
 * ============================================================
 * Problem            : Flip Array
 * Category           : Algorithms.DynamicProgramming
 * Created By         : Karthik R
 *
 * Approach           : 0/1 Knapsack
 *
 * Time Complexity    : O(N * Sum)
 * Space Complexity   : O(Sum)
 *
 * Idea:
 * - Initially all numbers contribute positively to the sum.
 * - Flipping x changes the total by -2*x.
 *
 *      New Sum = Total Sum - 2 * Flipped Sum
 *
 * - Therefore, we want the largest Flipped Sum <= Total Sum/2.
 * - Among all ways to obtain that sum, minimize the number
 *   of elements.
 *
 * dp[sum] = minimum number of elements needed to obtain sum.
 * ============================================================
 */

import java.util.*;

public class FlipArray {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final List<Integer> A) {

        int n = A.size();

        int totalSum = 0;

        // Calculate total sum.
        for (int x : A) {
            totalSum += x;
        }

        // Maximum useful flipped sum.
        int target = totalSum / 2;

        // Represents an impossible state.
        int INF = 1000000;

        /*
         * dp[sum] = minimum number of elements required
         *           to obtain this sum.
         */
        int[] dp = new int[target + 1];

        Arrays.fill(dp, INF);

        // Sum 0 requires 0 elements.
        dp[0] = 0;

        // Process every element once.
        for (int x : A) {

            /*
             * Traverse backwards.
             *
             * This makes sure the same element is not
             * selected more than once.
             */
            for (int sum = target; sum >= x; sum--) {

                if (dp[sum - x] != INF) {

                    dp[sum] = Math.min(
                            dp[sum],
                            dp[sum - x] + 1
                    );
                }
            }
        }

        /*
         * Start from the largest possible flipped sum.
         *
         * The first achievable sum gives the minimum
         * number of flips needed.
         */
        for (int sum = target; sum >= 0; sum--) {

            if (dp[sum] != INF) {
                return dp[sum];
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        FlipArray obj = new FlipArray();

        // Example:
        // A = [8, 4, 2, 5, 3]
        //
        // Total Sum = 22
        // Target = 11
        //
        // Flip 8 + 2 = 10
        // New Sum = 22 - 2(10) = 2
        //
        // Minimum flips = 2

        List<Integer> A =
                Arrays.asList(8, 4, 2, 5, 3);

        System.out.println(obj.solve(A));
    }
}