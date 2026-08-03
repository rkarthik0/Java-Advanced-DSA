package Algorithms.Recursion;

/**
 * ============================================================
 * Problem            : K-th Symbol in Grammar
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/k-th-symbol-in-grammar/
 * Difficulty         : Medium
 *
 * Approach           : Recursion
 * Algorithm          : Divide and Conquer
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(n)
 * ============================================================
 */

public class KthSymbolInGrammar {

    /**
     * Returns the K-th symbol in the N-th row of the grammar sequence.
     *
     * @param row Row number (0-based)
     * @param index Position in the row
     * @return K-th symbol (0 or 1)
     */
    public static int solve(int row, long index) {

        // Base case
        if (row == 0) {
            return 0;
        }

        // Find the parent symbol
        int parent = solve(row - 1, index / 2);

        // Even index inherits the parent's value
        if (index % 2 == 0) {
            return parent;
        }

        // Odd index is the complement of the parent
        return 1 - parent;
    }

    public static void main(String[] args) {

        // Sample input
        int row = 4;
        long index = 5;

        // Calling the solution
        int result = solve(row, index);

        // Printing output
        System.out.println("K-th Symbol: " + result);
    }
}