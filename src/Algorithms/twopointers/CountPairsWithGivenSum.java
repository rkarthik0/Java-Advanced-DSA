package Algorithms.TwoPointers;

/**
 * ============================================================
 * Problem            : Count Pairs With Given Sum
 * Created By         : Karthik R
 * Link               :
 * Difficulty         : Medium
 *
 * Approach           : Two Pointers
 * Algorithm          : Two Pointer Technique
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(1)
 * ============================================================
 */

public class CountPairsWithGivenSum {

    /**
     * Counts the number of pairs whose sum is equal to B.
     *
     * The input array must be sorted.
     * Duplicate values are handled by counting their frequencies.
     *
     * @param nums Sorted input array
     * @param target Target sum
     * @return Number of valid pairs modulo 1,000,000,007
     */
    public static int solve(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        long count = 0;
        int mod = 1_000_000_007;

        // Use two pointers from both ends of the sorted array
        while (left <= right) {

            long sum = (long) nums[left] + nums[right];

            // Pair with the required sum found
            if (sum == target) {

                int leftValue = nums[left];
                int rightValue = nums[right];

                // Both pointers point to the same value
                if (leftValue == rightValue) {

                    long length = right - left + 1;

                    // Choose any two elements from the group
                    count = (count +
                            (length * (length - 1) / 2) % mod) % mod;
                }

                long leftCount = 0;
                long rightCount = 0;

                // Count occurrences of the left value
                while (left <= right && nums[left] == leftValue) {
                    left++;
                    leftCount++;
                }

                // Count occurrences of the right value
                while (left <= right && nums[right] == rightValue) {
                    right--;
                    rightCount++;
                }

                // Add all combinations between the two groups
                count = (count +
                        (leftCount * rightCount) % mod) % mod;
            }

            // Sum is too small, move left pointer forward
            else if (sum < target) {
                left++;
            }

            // Sum is too large, move right pointer backward
            else {
                right--;
            }
        }

        return (int) (count % mod);
    }

    public static void main(String[] args) {

        // Sample input
        int[] nums = {1, 1, 1, 2, 2, 3, 3};
        int target = 4;

        // Calling the solution
        int result = solve(nums, target);

        // Printing output
        System.out.println("Number of Pairs: " + result);
    }
}d