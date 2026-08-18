/**
 * ============================================================
 * Problem            : Find Ath Fibonacci Number
 *
 * Approach           : Recursion
 * Algorithm          : Recursive Fibonacci
 *
 * Time Complexity    : O(2^A)
 * Space Complexity   : O(A) due to recursion stack
 *
 * Fibonacci sequence:
 *
 * F(0) = 0
 * F(1) = 1
 *
 * F(A) = F(A - 1) + F(A - 2)
 *
 * Example:
 *
 * A = 5
 *
 * Fibonacci sequence:
 * 0, 1, 1, 2, 3, 5
 *
 * Answer = 5
 * ============================================================
 */

public class Fibonacci {

    public static int findAthFibonacci(int A) {

        // Base case:
        // F(0) = 0
        // F(1) = 1
        if (A <= 1) {
            return A;
        }

        // Recursive case:
        // F(A) = F(A - 1) + F(A - 2)
        return findAthFibonacci(A - 1)
                + findAthFibonacci(A - 2);
    }

    public static void main(String[] args) {

        int A = 5;

        System.out.println(
                "Fibonacci number: " + findAthFibonacci(A)
        );
    }
}