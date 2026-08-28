/**
 * ============================================================
 * Problem            : Maximum Consecutive Ones
 * Category           : Algorithms.String
 * Created By         : Karthik R
 *
 * Approach           : Sliding Window / Greedy
 *
 * Time Complexity    : O(N)
 * Space Complexity   : O(1)
 *
 * Idea:
 * - Count total number of 1s.
 * - For every 0, find consecutive 1s on its left and right.
 * - The zero can be replaced by a 1 if there are extra 1s available.
 * - The maximum possible length cannot exceed totalOnes.
 * ============================================================
 */

public class MaximumConsecutiveOnes {

    public int solve(String A) {

        int n = A.length();
        int ans = 0;

        // Count total number of 1s.
        int totalOnes = 0;

        for (int i = 0; i < n; i++) {

            if (A.charAt(i) == '1') {
                totalOnes++;
            }
        }

        // If the entire string contains only 1s.
        if (totalOnes == n) {
            return n;
        }

        // Try every zero as the position to replace.
        for (int i = 0; i < n; i++) {

            if (A.charAt(i) == '0') {

                int l = i - 1;
                int r = i + 1;

                // Count consecutive 1s on the left.
                while (l >= 0 && A.charAt(l) == '1') {
                    l--;
                }

                // Count consecutive 1s on the right.
                while (r < n && A.charAt(r) == '1') {
                    r++;
                }

                // Length after connecting left and right groups.
                int currentLen = r - l - 1;

                // Cannot have more 1s than total available 1s.
                currentLen = Math.min(currentLen, totalOnes);

                ans = Math.max(ans, currentLen);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        MaximumConsecutiveOnes obj =
                new MaximumConsecutiveOnes();

        String A = "111011101";

        System.out.println(obj.solve(A));
    }
}