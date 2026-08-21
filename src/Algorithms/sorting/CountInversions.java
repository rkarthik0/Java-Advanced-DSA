/**
 * ============================================================
 * Problem            : Count Inversions
 * Created By         : Karthik R
 *
 * Approach           : Divide and Conquer
 * Algorithm          : Merge Sort
 *
 * Time Complexity    : O(N log N)
 * Space Complexity   : O(N)
 *
 * Idea:
 * - Use merge sort to divide the array.
 * - Count inversions in the left half.
 * - Count inversions in the right half.
 * - During merging, if A[i] > A[j], then all elements
 *   from i to mid are greater than A[j].
 *
 *   Number of inversions = mid - i + 1
 *
 * - Take modulo after every addition.
 * ============================================================
 */

import java.util.*;

public class CountInversions {

    static final int MOD = 1000000007;

    public int solve(int[] A) {

        return mergeSort(A, 0, A.length - 1);
    }

    // ============================================================
    // Merge Sort
    // ============================================================

    private int mergeSort(
            int[] A,
            int left,
            int right) {

        // One element -> no inversion
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        int inv = 0;

        // Count inversions in left half
        inv = (inv + mergeSort(
                A,
                left,
                mid
        )) % MOD;

        // Count inversions in right half
        inv = (inv + mergeSort(
                A,
                mid + 1,
                right
        )) % MOD;

        // Count cross inversions while merging
        inv = (inv + merge(
                A,
                left,
                mid,
                right
        )) % MOD;

        return inv;
    }

    // ============================================================
    // Merge two sorted halves and count cross inversions
    // ============================================================

    private int merge(
            int[] A,
            int left,
            int mid,
            int right) {

        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        int inv = 0;

        while (i <= mid && j <= right) {

            // No inversion
            if (A[i] <= A[j]) {

                temp[k++] = A[i++];

            } else {

                // A[i] > A[j]
                temp[k++] = A[j++];

                /*
                 * Since the left half is sorted:
                 *
                 * A[i], A[i+1], ..., A[mid]
                 *
                 * are all greater than A[j].
                 *
                 * Therefore:
                 *
                 * number of inversions =
                 * mid - i + 1
                 */
                inv = (inv + (mid - i + 1)) % MOD;
            }
        }

        // Remaining left elements
        while (i <= mid) {
            temp[k++] = A[i++];
        }

        // Remaining right elements
        while (j <= right) {
            temp[k++] = A[j++];
        }

        // Copy sorted values back
        for (int x = 0; x < temp.length; x++) {
            A[left + x] = temp[x];
        }

        return inv;
    }

    // ============================================================
    // MAIN METHOD
    // ============================================================

    public static void main(String[] args) {

        CountInversions obj = new CountInversions();

        int[] A = {2, 4, 1, 3, 5};

        int result = obj.solve(A);

        System.out.println(result);
    }
}