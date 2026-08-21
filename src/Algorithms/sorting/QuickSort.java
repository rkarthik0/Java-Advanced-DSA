/**
 * ============================================================
 * Problem            : Quick Sort
 * Created By         : Karthik R
 *
 * Approach           : Divide and Conquer
 * Algorithm          : Quick Sort
 *
 * Time Complexity    : O(N log N) average
 *                       O(N^2) worst case
 * Space Complexity   : O(log N) average recursion stack
 *
 * Idea:
 * - Choose the last element as the pivot.
 * - Partition the array so that:
 *      elements < pivot are on the left
 *      elements >= pivot are on the right
 * - Place the pivot at its correct position.
 * - Recursively sort the left and right parts.
 * ============================================================
 */

import java.util.*;

public class QuickSort {

    public int[] solve(int[] A) {

        quickSort(A, 0, A.length - 1);

        return A;
    }

    private void quickSort(
            int[] A,
            int s,
            int e) {

        // Base case
        if (s >= e) {
            return;
        }

        // Partition and get pivot's final index
        int pidx = partition(A, s, e);

        // Sort left part
        quickSort(A, s, pidx - 1);

        // Sort right part
        quickSort(A, pidx + 1, e);
    }

    private int partition(
            int[] A,
            int s,
            int e) {

        // Last element is the pivot
        int p = e;

        int l = s;
        int r = e - 1;

        while (l <= r) {

            // Left value is already smaller than pivot
            if (A[l] < A[p]) {
                l++;
            }

            // Right value is already greater than pivot
            else if (A[r] > A[p]) {
                r--;
            }

            // Both positions need correction
            else {
                int temp = A[l];
                A[l] = A[r];
                A[r] = temp;

                l++;
                r--;
            }
        }

        // Put pivot at its correct position
        int temp = A[p];
        A[p] = A[l];
        A[l] = temp;

        return l;
    }

    // ============================================================
    // MAIN METHOD
    // ============================================================

    public static void main(String[] args) {

        QuickSort obj = new QuickSort();

        int[] A = {5, 3, 8, 4, 2, 7, 1};

        int[] result = obj.solve(A);

        System.out.println(Arrays.toString(result));
    }
}