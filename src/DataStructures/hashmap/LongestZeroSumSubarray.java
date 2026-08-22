/**
 * ============================================================
 * Problem            : Longest Subarray with Sum 0
 * Created By         : Karthik R
 *
 * Approach           : Prefix Sum + HashMap
 * Algorithm          : Prefix Sum
 *
 * Time Complexity    : O(N)
 * Space Complexity   : O(N)
 *
 * Idea:
 * - If the same prefix sum occurs at two indices,
 *   the elements between those indices have sum 0.
 * - Store the FIRST occurrence of every prefix sum.
 * - If the prefix sum appears again, calculate the length.
 * - map.put(0L, -1) handles subarrays starting from index 0.
 * ============================================================
 */

import java.util.*;

public class LongestZeroSumSubarray {

    public int solve(ArrayList<Integer> A) {

        HashMap<Long, Integer> map =
                new HashMap<>();

        int max = 0;
        long prefix = 0;

        // Prefix sum 0 exists before index 0
        map.put(0L, -1);

        for (int i = 0; i < A.size(); i++) {

            prefix += A.get(i);

            // Same prefix sum found
            if (map.containsKey(prefix)) {

                int length =
                        i - map.get(prefix);

                max = Math.max(max, length);

            } else {

                // Store only the first occurrence
                // because it gives the longest subarray.
                map.put(prefix, i);
            }
        }

        return max;
    }

    // ============================================================
    // MAIN METHOD
    // ============================================================

    public static void main(String[] args) {

        LongestZeroSumSubarray obj =
                new LongestZeroSumSubarray();

        ArrayList<Integer> A =
                new ArrayList<>(
                        Arrays.asList(1, -1, 2, -2, 3)
                );

        System.out.println(obj.solve(A));
    }
}