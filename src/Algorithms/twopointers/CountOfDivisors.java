package Algorithms.NumberTheory;

/**
 * ============================================================
 * Problem            : Count of Divisors
 * Created By         : Karthik R
 * Link               :
 * Difficulty         : Easy
 *
 * Approach           : Sieve-like Precomputation
 * Algorithm          : Divisor Sieve
 *
 * Time Complexity    : O(M log M + n)
 * Space Complexity   : O(M)
 *
 * M = Maximum element in the input array
 * ============================================================
 */

public class CountOfDivisors {

    /**
     * Finds the number of divisors for every element in the array.
     *
     * @param nums Input array
     * @return Array containing the divisor count of each element
     */
    public static int[] solve(int[] nums) {

        int max = 0;

        // Find the maximum value to determine the sieve size
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // cnt[i] stores the number of divisors of i
        int[] count = new int[max + 1];

        // Use a sieve-like approach to count divisors
        for (int divisor = 1; divisor <= max; divisor++) {

            // Every multiple of divisor has divisor as a factor
            for (int multiple = divisor; multiple <= max; multiple += divisor) {
                count[multiple]++;
            }
        }

        int[] answer = new int[nums.length];

        // Retrieve the precomputed divisor count
        for (int i = 0; i < nums.length; i++) {
            answer[i] = count[nums[i]];
        }

        return answer;
    }

    public static void main(String[] args) {

        // Sample input
        int[] nums = {2, 4, 6, 8, 10};

        // Calling the solution
        int[] result = solve(nums);

        // Printing the divisor counts
        for (int count : result) {
            System.out.print(count + " ");
        }
    }
}