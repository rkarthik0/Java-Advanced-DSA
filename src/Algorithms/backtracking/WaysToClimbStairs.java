package Algorithms.Backtracking;

import java.util.ArrayList;

/**
 * ============================================================
 * Problem            : Ways to Climb Stairs
 * Created By         : Karthik R
 * Link               :
 * Difficulty         : Medium
 *
 * Approach           : Backtracking
 * Algorithm          : Recursion
 *
 * Time Complexity    : O(2ⁿ)
 * Space Complexity   : O(n)
 * ============================================================
 */

public class WaysToClimbStairs {

    // Stores all possible ways
    private static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    /**
     * Returns all possible ways to climb A stairs
     * by taking either 1 or 2 steps at a time.
     *
     * @param stairs Number of stairs
     * @return List of all possible ways
     */
    public static ArrayList<ArrayList<Integer>> waysToClimb(int stairs) {

        ArrayList<Integer> currentPath = new ArrayList<>();

        solve(stairs, currentPath);

        return result;
    }

    /**
     * Backtracking function to generate all possible paths.
     *
     * @param remaining Remaining stairs
     * @param currentPath Current path being formed
     */
    private static void solve(int remaining, ArrayList<Integer> currentPath) {

        // A valid way is found
        if (remaining == 0) {
            result.add(new ArrayList<>(currentPath));
            return;
        }

        // Take one step
        if (remaining >= 1) {

            currentPath.add(1);

            solve(remaining - 1, currentPath);

            // Backtrack
            currentPath.remove(currentPath.size() - 1);
        }

        // Take two steps
        if (remaining >= 2) {

            currentPath.add(2);

            solve(remaining - 2, currentPath);

            // Backtrack
            currentPath.remove(currentPath.size() - 1);
        }
    }

    public static void main(String[] args) {

        // Sample input
        int stairs = 4;

        // Calling the solution
        ArrayList<ArrayList<Integer>> result = waysToClimb(stairs);

        // Printing all possible ways
        for (ArrayList<Integer> path : result) {
            System.out.println(path);
        }
    }
}