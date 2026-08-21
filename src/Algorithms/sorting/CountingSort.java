/**
 * ============================================================
 * Problem            : Counting Sort
 * Created By         : Karthik R
 *
 * Approach           : Frequency Array
 * Algorithm          : Counting Sort
 *
 * Time Complexity    : O(N + K)
 * Space Complexity   : O(K)
 *
 * Idea:
 * - Find the minimum and maximum values.
 * - Create a frequency array for the range [min, max].
 * - Count how many times each value occurs.
 * - Reconstruct the sorted array using the frequencies.
 * ============================================================
 */

import java.util.*;

public class CountingSort {

    public int[] solve(int[] A) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Find minimum and maximum values
        for (int i = 0; i < A.length; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }

        // Number of possible values
        int n = max - min + 1;

        int[] freq = new int[n];

        // Count frequency of each value
        for (int i = 0; i < A.length; i++) {
            freq[A[i] - min]++;
        }

        // Reconstruct sorted array
        int idx = 0;

        for (int i = 0; i < freq.length; i++) {

            for (int j = 0; j < freq[i]; j++) {

                A[idx] = i + min;
                idx++;
            }
        }

        return A;
    }

    // ============================================================
    // MAIN METHOD
    // ============================================================

    public static void main(String[] args) {

        CountingSort obj = new CountingSort();

        int[] A = {4, 2, 2, 8, 3, 3, 1};

        int[] result = obj.solve(A);

        System.out.println(Arrays.toString(result));
    }
}