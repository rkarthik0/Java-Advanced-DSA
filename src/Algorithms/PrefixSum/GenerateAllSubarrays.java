/**
 * ============================================================
 * Problem            : Generate All Subarrays
 * Category           : Algorithms.Array
 * Created By         : Karthik R
 *
 * Approach           : Brute Force
 * Algorithm          : Three Nested Loops
 *
 * Time Complexity    : O(N^3)
 * Space Complexity   : O(N^3) including output
 *
 * Idea:
 * - Choose the starting index i.
 * - Choose the ending index j.
 * - Copy all elements from i to j into a new subarray.
 * ============================================================
 */

import java.util.*;

public class GenerateAllSubarrays {

    public ArrayList<ArrayList<Integer>> solve(
            ArrayList<Integer> A) {

        int N = A.size();

        ArrayList<ArrayList<Integer>> ans =
                new ArrayList<>();

        for (int i = 0; i < N; i++) {

            for (int j = i; j < N; j++) {

                ArrayList<Integer> sub =
                        new ArrayList<>();

                for (int k = i; k <= j; k++) {
                    sub.add(A.get(k));
                }

                ans.add(sub);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        GenerateAllSubarrays obj =
                new GenerateAllSubarrays();

        ArrayList<Integer> A =
                new ArrayList<>(Arrays.asList(1, 2, 3));

        ArrayList<ArrayList<Integer>> result =
                obj.solve(A);

        System.out.println(result);
    }
}