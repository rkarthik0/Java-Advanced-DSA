/**
 * ============================================================
 * Problem            : Equilibrium Index
 * Created By         : Karthik R
 *
 * Approach           : Prefix Sum / Running Sum
 * Algorithm          : Maximum Prefix Value
 *
 * Time Complexity    : O(N)
 * Space Complexity   : O(1)
 *
 * Idea:
 * - For every index i, check whether the maximum element
 *   seen so far is equal to i.
 * - If max == i, all values from 0 to i are within the
 *   required range, so this index is a valid count.
 * ============================================================
 */

import java.util.*;

public class EquilibriumIndex {

    public int solve(int[] A) {

        int i = 0;
        int max = 0;
        int count = 0;

        for (int num : A) {

            // Maximum value seen so far
            max = Math.max(max, num);

            // All values from 0 to i can be placed
            // within the first i + 1 positions.
            if (max == i) {
                count++;
            }

            i++;
        }

        return count;
    }

    // ============================================================
    // MAIN METHOD
    // ============================================================

    public static void main(String[] args) {

        EquilibriumIndex obj = new EquilibriumIndex();

        int[] A = {1, 0, 2, 3, 4};

        int result = obj.solve(A);

        System.out.println(result);
    }
}