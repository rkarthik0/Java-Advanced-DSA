import java.util.*;

/**
 * ============================================================
 * Problem : Count Numbers With Given Digit Sum
 *
 * Given:
 *     A = number of digits
 *     B = required digit sum
 *
 * Count how many A-digit numbers have digit sum B.
 *
 * Example:
 *
 * A = 2, B = 4
 *
 * Valid numbers:
 *     13
 *     22
 *     31
 *
 * Answer = 3
 *
 * Approach:
 * Dynamic Programming + Space Optimization
 *
 * Time Complexity  : O(A * B * 10)
 * Space Complexity : O(B)
 * ============================================================
 */

public class CountNumbersWithDigitSum {

    static final int MOD = 1000000007;

    public static int solve(int A, int B) {

        /*
         * Maximum possible digit sum with A digits is:
         *
         *     9 * A
         *
         * If B is larger, no answer is possible.
         */
        if (B > 9 * A) {
            return 0;
        }

        /*
         * prev[sum] =
         * number of ways to form the previous number of digits
         * having digit sum = sum.
         */
        long[] prev = new long[B + 1];

        /*
         * First digit cannot be zero.
         *
         * First digit can be:
         * 1, 2, 3, ..., 9
         */
        for (int digit = 1; digit <= 9 && digit <= B; digit++) {
            prev[digit] = 1;
        }

        /*
         * Add remaining digits.
         */
        for (int digits = 2; digits <= A; digits++) {

            long[] curr = new long[B + 1];

            /*
             * Try every possible target sum.
             */
            for (int sum = 0; sum <= B; sum++) {

                /*
                 * Try adding a digit from 0 to 9.
                 */
                for (int digit = 0; digit <= 9; digit++) {

                    if (sum - digit >= 0) {

                        curr[sum] += prev[sum - digit];

                        // Keep result modulo MOD.
                        if (curr[sum] >= MOD) {
                            curr[sum] -= MOD;
                        }
                    }
                }
            }

            // Current row becomes previous row.
            prev = curr;
        }

        return (int) prev[B];
    }

    public static void main(String[] args) {

        int A = 2;
        int B = 4;

        System.out.println(
                "Number of valid numbers: " + solve(A, B)
        );
    }
}