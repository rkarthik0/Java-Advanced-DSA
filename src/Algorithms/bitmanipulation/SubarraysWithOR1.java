/**
 * ============================================================
 * Problem            : Subarrays With OR 1
 * Created By         : Karthik R
 * Link               :
 * Difficulty         : Easy
 *
 * Approach           : Counting
 * Algorithm          : Count Total Subarrays - All Zero Subarrays
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(1)
 *
 * Idea:
 * Since the array contains only 0 and 1, a subarray has
 * bitwise OR equal to 1 if it contains at least one 1.
 *
 * Therefore:
 *
 * Valid Subarrays
 * = Total Subarrays - Subarrays Containing Only 0s
 *
 * For a consecutive sequence of zeros of length k:
 *
 * Number of zero-only subarrays = k * (k + 1) / 2
 * ============================================================
 */

public class SubarraysWithOR1 {

    public static int subarraysWithOR1(int[] A) {

        int n = A.length;

        // Total number of subarrays
        int totalSubarrays = n * (n + 1) / 2;

        int zeroCount = 0;
        int zeroSubarrays = 0;

        // Count subarrays consisting entirely of zeros
        for (int i = 0; i < n; i++) {

            if (A[i] == 0) {
                zeroCount++;
            } else {

                // Current zero sequence has ended
                zeroSubarrays += zeroCount * (zeroCount + 1) / 2;

                zeroCount = 0;
            }
        }

        // Handle a zero sequence ending at the last index
        if (zeroCount > 0) {
            zeroSubarrays += zeroCount * (zeroCount + 1) / 2;
        }

        // Remove all-zero subarrays
        return totalSubarrays - zeroSubarrays;
    }

    public static void main(String[] args) {

        int[] A = {0, 1, 1, 0};

        int result = subarraysWithOR1(A);

        System.out.println("Subarrays With OR 1: " + result);
    }
}