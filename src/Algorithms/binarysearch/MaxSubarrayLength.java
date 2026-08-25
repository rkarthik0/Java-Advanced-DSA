/**
 * ============================================================
 * Problem            : Maximum Subarray Length With Sum <= B
 * Created By         : Karthik R
 *
 * Approach           : Binary Search + Sliding Window
 * Algorithm          : Fixed-Size Window
 *
 * Time Complexity    : O(N log N)
 * Space Complexity   : O(1)
 *
 * Idea:
 * - Binary search the maximum possible subarray length k.
 * - For each k, check whether every subarray of length k
 *   has sum <= B.
 * - Use a sliding window to check all windows in O(N).
 * - If k is valid, try a larger length.
 * ============================================================
 */

public class MaxSubarrayLength {

    public int solve(int[] A, int B) {

        int l = 1;
        int h = A.length;

        int ans = 0;

        // Binary search for maximum valid length.
        while (l <= h) {

            int m = l + (h - l) / 2;

            if (check(A, m, B)) {

                // Length m is valid.
                // Try a larger length.
                ans = m;
                l = m + 1;

            } else {

                // Length m is not valid.
                // Try a smaller length.
                h = m - 1;
            }
        }

        return ans;
    }

    // Checks whether every subarray of length k
    // has sum <= B.
    public boolean check(int[] A, int k, int B) {

        int sum = 0;

        // First window.
        for (int i = 0; i < k; i++) {
            sum += A[i];
        }

        if (sum > B) {
            return false;
        }

        // Slide the window.
        for (int i = k; i < A.length; i++) {

            // Add new element.
            sum += A[i];

            // Remove element leaving the window.
            sum -= A[i - k];

            if (sum > B) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        MaxSubarrayLength obj =
                new MaxSubarrayLength();

        int[] A = {1, 2, 3, 4, 5};
        int B = 7;

        System.out.println(
                obj.solve(A, B)
        );
    }
}