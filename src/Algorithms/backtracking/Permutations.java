package Algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 * Problem            : Permutations
 * Platform           : LeetCode
 * Link               : https://leetcode.com/problems/permutations/
 * Difficulty         : Medium
 *
 * Approach           : Backtracking
 * Algorithm          : Depth First Search (DFS)
 *
 * Time Complexity    : O(n × n!)
 * Space Complexity   : O(n)
 * ============================================================
 */

public class Permutations {

    // Stores all generated permutations
    private static final List<int[]> permutations = new ArrayList<>();

    /**
     * Generates all possible permutations of the given array.
     *
     * @param nums Input array
     * @return All possible permutations
     */
    public static int[][] permute(int[] nums) {

        int n = nums.length;

        // Stores the current permutation
        int[] current = new int[n];

        // Tracks visited elements
        boolean[] visited = new boolean[n];

        // Generate all permutations
        generatePermutations(nums, current, visited, 0);

        // Convert list to 2D array
        int[][] result = new int[permutations.size()][n];

        for (int i = 0; i < permutations.size(); i++) {
            result[i] = permutations.get(i);
        }

        return result;
    }

    /**
     * Backtracking function to generate permutations.
     */
    private static void generatePermutations(int[] nums, int[] current,
                                             boolean[] visited, int index) {

        // One complete permutation is formed
        if (index == nums.length) {
            permutations.add(current.clone());
            return;
        }

        // Try every unused element
        for (int i = 0; i < nums.length; i++) {

            if (!visited[i]) {

                // Choose the current element
                visited[i] = true;
                current[index] = nums[i];

                // Recur for the next position
                generatePermutations(nums, current, visited, index + 1);

                // Backtrack
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {

        // Sample input
        int[] nums = {1, 2, 3};

        // Calling the solution
        int[][] result = permute(nums);

        // Printing all permutations
        for (int[] permutation : result) {

            System.out.print("[ ");

            for (int num : permutation) {
                System.out.print(num + " ");
            }

            System.out.println("]");
        }
    }
}
