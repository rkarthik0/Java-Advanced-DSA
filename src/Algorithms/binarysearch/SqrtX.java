package Algorithms.BinarySearch;

/**
 * ============================================================
 * Problem            : Sqrt(x)
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/sqrtx/
 * Difficulty         : Easy
 *
 * Approach           : Binary Search
 * Algorithm          : Binary Search
 *
 * Time Complexity    : O(log n)
 * Space Complexity   : O(1)
 * ============================================================
 */

public class SqrtX {

    /**
     * Returns the integer square root (floor value) of a number.
     *
     * @param number Input number
     * @return Floor value of the square root
     */
    public static int sqrt(int number) {

        // Base cases
        if (number == 0 || number == 1) {
            return number;
        }

        long left = 0;
        long right = number;

        // Stores the floor value of the square root
        long answer = 0;

        while (left <= right) {

            long mid = left + (right - left) / 2;

            // Perfect square found
            if (mid * mid == number) {
                return (int) mid;
            }

            // Search in the right half
            else if (mid * mid < number) {

                // Store the current floor value
                answer = mid;

                left = mid + 1;
            }

            // Search in the left half
            else {
                right = mid - 1;
            }
        }

        return (int) answer;
    }

    public static void main(String[] args) {

        // Sample input
        int number = 27;

        // Calling the solution
        int result = sqrt(number);

        // Printing output
        System.out.println("Square Root (Floor): " + result);
    }
}