/**
 * ============================================================
 * Problem            : Sort Subarray
 * Created By         : Karthik R
 *
 * Approach           : Divide and Conquer
 * Algorithm          : Merge Sort
 *
 * Time Complexity    : O((C - B + 1) log(C - B + 1))
 * Space Complexity   : O(C - B + 1)
 *
 * Idea:
 * - Sort only the subarray from index B to C.
 * - Apply merge sort within that range.
 * - Elements outside B and C remain unchanged.
 * ============================================================
 */

import java.util.*;

public class SortSubarray {

    public int[] sortSubarray(int[] A, int B, int C) {

        mergeSort(A, B, C);

        return A;
    }

    // ============================================================
    // Merge Sort
    // ============================================================

    private void mergeSort(
            int[] A,
            int left,
            int right) {

        // Base case
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        // Sort left half
        mergeSort(A, left, mid);

        // Sort right half
        mergeSort(A, mid + 1, right);

        // Merge sorted halves
        merge(A, left, mid, right);
    }

    // ============================================================
    // Merge
    // ============================================================

    private void merge(
            int[] A,
            int left,
            int mid,
            int right) {

        int[] temp =
                new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        // Compare both halves
        while (i <= mid && j <= right) {

            if (A[i] <= A[j]) {
                temp[k++] = A[i++];
            } else {
                temp[k++] = A[j++];
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
        for (int x = left; x <= right; x++) {
            A[x] = temp[x - left];
        }
    }

    // ============================================================
    // MAIN METHOD
    // ============================================================

    public static void main(String[] args) {

        SortSubarray obj = new SortSubarray();

        int[] A = {5, 4, 3, 2, 1};

        int B = 1;
        int C = 3;

        int[] result =
                obj.sortSubarray(A, B, C);

        System.out.println(Arrays.toString(result));
    }
}