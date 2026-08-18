/**
 * ============================================================
 * Problem            : Print Array Using Recursion
 *
 * Approach           : Recursion
 *
 * Time Complexity    : O(N)
 * Space Complexity   : O(N) due to recursion stack
 *
 * Example:
 *
 * A = {10, 20, 30, 40}
 *
 * Output:
 * 10 20 30 40
 * ============================================================
 */

public class PrintArray {

    public static void printArray(int[] A) {

        // Start recursion from index 0
        helper(A, 0);

        System.out.println();
    }

    private static void helper(int[] A, int idx) {

        // Base case:
        // Once idx reaches the array length,
        // all elements have been printed.
        if (idx == A.length) {
            return;
        }

        // Print the current element
        System.out.print(A[idx] + " ");

        // Move to the next index
        helper(A, idx + 1);
    }

    public static void main(String[] args) {

        int[] A = {10, 20, 30, 40};

        printArray(A);
    }
}