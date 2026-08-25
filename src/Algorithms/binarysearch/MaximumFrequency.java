/**
 * ============================================================
 * Problem            : Maximum Frequency
 * Created By         : Karthik R
 *
 * Approach           : Sorting + Prefix Sum + Binary Search
 * Algorithm          : Binary Search on Window Size
 *
 * Time Complexity    : O(N log N)
 * Space Complexity   : O(N)
 *
 * Idea:
 * - Sort the array.
 * - For every A[i], consider making the previous elements
 *   equal to A[i].
 * - Prefix sum calculates the current window sum quickly.
 * - Binary search finds the largest window that can be
 *   converted to A[i] using at most B operations.
 * ============================================================
 */

import java.util.*;

public class MaximumFrequency {

    public int[] solve(int[] A, int B) {

        // Sort so that we can increase smaller values
        // to match A[i].
        Arrays.sort(A);

        int n = A.length;

        // Prefix sum.
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + A[i];
        }

        int maxFrequency = 1;
        int number = A[0];

        // Treat A[i] as the target number.
        for (int i = 0; i < n; i++) {

            int l = 1;
            int h = i + 1;
            int best = 1;

            // Binary search for the largest valid window.
            while (l <= h) {

                int m = l + (h - l) / 2;

                // Window: [i - m + 1 ... i]
                int left = i - m + 1;

                // Sum of elements in the window.
                long currentSum =
                        prefix[i + 1] - prefix[left];

                /*
                 * Cost to make every element equal to A[i]:
                 *
                 * A[i] * m - currentSum
                 */
                long requiredOperations =
                        (long) A[i] * m - currentSum;

                if (requiredOperations <= B) {

                    // This window is possible.
                    best = m;

                    // Try a larger window.
                    l = m + 1;

                } else {

                    // Too many operations required.
                    h = m - 1;
                }
            }

            // Update global maximum.
            if (maxFrequency < best) {

                maxFrequency = best;
                number = A[i];
            }
        }

        return new int[]{maxFrequency, number};
    }

    public static void main(String[] args) {

        MaximumFrequency obj =
                new MaximumFrequency();

        int[] A = {1, 2, 2, 4};
        int B = 2;

        int[] result = obj.solve(A, B);

        System.out.println(
                "Maximum Frequency: " + result[0]
        );

        System.out.println(
                "Number: " + result[1]
        );
    }
}