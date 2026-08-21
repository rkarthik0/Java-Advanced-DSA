/**
 * ============================================================
 * Problem            : Merge Sort
 * Created By         : Karthik R
 *
 * Approach           : Divide and Conquer
 * Algorithm          : Merge Sort
 *
 * Time Complexity    : O(N log N)
 * Space Complexity   : O(N)
 *
 * Idea:
 * - Divide the array into two halves.
 * - Recursively sort both halves.
 * - Merge the two sorted halves.
 * ============================================================
 */

import java.util.*;

public class MergeSort {

    public int[] solve(int[] A) {

        mergeSort(A, 0, A.length - 1);

        return A;
    }

    // Divide the array
    private void mergeSort(
            int[] A,
            int start,
            int end) {

        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        // Sort left half
        mergeSort(A, start, mid);

        // Sort right half
        mergeSort(A, mid + 1, end);

        // Merge both sorted halves
        merge(A, start, mid, end);
    }

    // Merge two sorted parts
    private void merge(
            int[] A,
            int start,
            int mid,
            int end) {

        int[] temp = new int[end - start + 1];

        int i = start;
        int j = mid + 1;
        int k = 0;

        // Compare elements from both halves
        while (i <= mid && j <= end) {

            if (A[i] <= A[j]) {
                temp[k++] = A[i++];
            } else {
                temp[k++] = A[j++];
            }
        }

        // Remaining elements from left half
        while (i <= mid) {
            temp[k++] = A[i++];
        }

        // Remaining elements from right half
        while (j <= end) {
            temp[k++] = A[j++];
        }

        // Copy sorted values back into original array
        for (i = start; i <= end; i++) {
            A[i] = temp[i - start];
        }
    }

    // ============================================================
    // MAIN METHOD
    // ============================================================

    public static void main(String[] args) {

        MergeSort obj = new MergeSort();

        int[] A = {5, 2, 8, 1, 3};

        int[] result = obj.solve(A);

        System.out.println(Arrays.toString(result));
