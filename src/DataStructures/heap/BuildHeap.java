package DataStructures.Heap;

/**
 * ============================================================
 * Problem            : Build Heap
 * Platform           : InterviewBit
 * Link               : https://www.interviewbit.com/problems/build-a-heap/
 * Difficulty         : Medium
 *
 * Approach           : Bottom-Up Heap Construction
 * Algorithm          : Min Heap (Heapify)
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(1)
 * ============================================================
 */

public class BuildHeap {

    /**
     * Builds a Min Heap from the given array.
     *
     * @param A Input array
     * @return Min Heap array
     */
    public static int[] buildHeap(int[] A) {

        int n = A.length;

        // Start heapifying from the last non-leaf node
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(A, n, i);
        }

        return A;
    }

    /**
     * Maintains the Min Heap property for the subtree rooted at index i.
     *
     * @param A Heap array
     * @param n Heap size
     * @param i Current node index
     */
    private static void heapify(int[] A, int n, int i) {

        while (true) {

            int smallest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            // Check left child
            if (left < n && A[left] < A[smallest]) {
                smallest = left;
            }

            // Check right child
            if (right < n && A[right] < A[smallest]) {
                smallest = right;
            }

            // Heap property is satisfied
            if (smallest == i) {
                break;
            }

            // Swap parent with the smallest child
            int temp = A[i];
            A[i] = A[smallest];
            A[smallest] = temp;

            // Continue heapifying the affected subtree
            i = smallest;
        }
    }

    public static void main(String[] args) {

        // Sample input
        int[] A = {5, 13, -2, 11, 27, 31, 0, 19};

        // Calling the solution
        int[] result = buildHeap(A);

        // Printing the Min Heap
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}