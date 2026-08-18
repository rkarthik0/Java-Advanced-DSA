/**
 * ============================================================
 * Problem            : Print Numbers From 1 to A
 *
 * Approach           : Recursion
 *
 * Time Complexity    : O(A)
 * Space Complexity   : O(A) due to recursion stack
 *
 * Example:
 *
 * A = 5
 *
 * Output:
 * 1 2 3 4 5
 * ============================================================
 */

public class PrintNumbers {

    public static void solve(int A) {

        // Call recursive function to print 1 to A
        printNum(A);

        System.out.println();
    }

    private static void printNum(int A) {

        // Base case:
        // Stop recursion when A becomes 0.
        if (A == 0) {
            return;
        }

        /*
         * First go down to 0.
         *
         * printNum(5)
         *   -> printNum(4)
         *      -> printNum(3)
         *         -> printNum(2)
         *            -> printNum(1)
         *               -> printNum(0)
         */
        printNum(A - 1);

        /*
         * Printing happens while recursion is returning.
         *
         * Therefore:
         * 1 is printed first,
         * then 2, then 3, ..., finally A.
         */
        System.out.print(A + " ");
    }

    public static void main(String[] args) {

        int A = 5;

        solve(A);
    }
}