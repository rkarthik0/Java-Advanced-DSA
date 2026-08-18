/**
 * Problem: Find A!
 *
 * Example:
 * A = 5
 *
 * 5! = 5 × 4 × 3 × 2 × 1
 *    = 120
 *
 * Time Complexity  : O(A)
 * Space Complexity : O(A) due to recursion stack
 */

public class FactorialGivenNumber {

    public static int solve(int A) {

        // Base case:
        // 0! = 1
        if (A == 0) {
            return 1;
        }

        // Recursive case:
        // A! = A × (A - 1)!
        return A * solve(A - 1);
    }

    public static void main(String[] args) {

        int A = 5;

        System.out.println("Factorial: " + solve(A));
    }
}