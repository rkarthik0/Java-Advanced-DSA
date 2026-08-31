/**
 * ============================================================
 * Problem            : Decode Ways
 * Category           : Algorithms.DynamicProgramming
 * Created By         : Karthik R
 *
 * Approach           : Dynamic Programming
 * Algorithm          : Space Optimized DP
 *
 * Time Complexity    : O(N)
 * Space Complexity   : O(1)
 *
 * Idea:
 * - prev2 represents dp[i-2].
 * - prev1 represents dp[i-1].
 * - For every character:
 *      1. Decode it as a single digit if it is 1-9.
 *      2. Decode the last two digits together if they form 10-26.
 * - curr stores the total number of ways for the current prefix.
 * ============================================================
 */

public class DecodeWays {

    public int numDecodings(String A) {

        int n = A.length();
        long mod = 1000000007L;

        // dp[0] = 1
        long prev2 = 1;

        // dp[1] = 1 if first character is not zero,
        // otherwise there is no valid decoding.
        long prev1 = A.charAt(0) == '0' ? 0 : 1;

        // Build DP from the second character onwards.
        for (int i = 2; i <= n; i++) {

            long curr = 0;

            // ----------------------------------------------------
            // Option 1: Decode current digit separately.
            // Valid only for digits 1-9.
            // ----------------------------------------------------
            if (A.charAt(i - 1) != '0') {
                curr = prev1;
            }

            // ----------------------------------------------------
            // Option 2: Decode current + previous digit together.
            // Valid only for numbers 10-26.
            // ----------------------------------------------------
            int twoDigit =
                    (A.charAt(i - 2) - '0') * 10
                            + (A.charAt(i - 1) - '0');

            if (twoDigit >= 10 && twoDigit <= 26) {
                curr = (curr + prev2) % mod;
            }

            // Move DP states forward.
            prev2 = prev1;
            prev1 = curr;
        }

        return (int) prev1;
    }

    public static void main(String[] args) {

        DecodeWays obj = new DecodeWays();

        String A = "226";

        // Possible decodings:
        // 2 2 6
        // 22 6
        // 2 26
        //
        // Answer = 3

        System.out.println(obj.numDecodings(A));
    }
}