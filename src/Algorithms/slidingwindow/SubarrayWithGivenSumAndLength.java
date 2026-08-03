package Algorithms.SlidingWindow;

/**
 * ============================================================
 * Problem            : Subarray with Given Sum and Length
 * Created By         : Karthik R
 * Link               :
 * Difficulty         : Easy
 *
 * Approach           : Fixed Size Sliding Window
 * Algorithm          : Sliding Window
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(1)
 * ============================================================
 */

public class SubarrayWithGivenSumAndLength {

    /**
     * Checks whether there exists a subarray of length B
     * whose sum is equal to C.
     *
     * @param A Input array
     * @param B Required subarray length
     * @param C Target sum
     * @return 1 if such a subarray exists, otherwise 0
     */
    public static int solve(int[] A, int B, int C) {

        int n = A.length;

        // Calculate the sum of the first window
        int windowSum = 0;

        for (int i = 0; i < B; i++) {
            windowSum += A[i];
        }

        // Check the first window
        if (windowSum == C) {
            return 1;
        }

        // Slide the window across the array
        for (int i = B; i < n; i++) {

            // Add the incoming element
            windowSum += A[i];

            // Remove the outgoing element
            windowSum -= A[i - B];

            // Check if current window sum matches the target
            if (windowSum == C) {
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        // Sample input
        int[] A = {4, 3, 2, 6, 1, 5};
        int B = 3;
        int C = 11;

        // Calling the solution
        int result = solve(A, B, C);

        // Printing output
        System.out.println("Subarray Exists: " + result);
    }
}