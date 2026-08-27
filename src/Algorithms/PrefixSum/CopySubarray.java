/**
 * ============================================================
 * Problem            : Copy Subarray
 * Category           : Algorithms.Array
 * Created By         : Karthik R
 *
 * Approach           : Array Traversal
 * Algorithm          : Copy Elements From B to C
 *
 * Time Complexity    : O(C - B + 1)
 * Space Complexity   : O(C - B + 1)
 *
 * Idea:
 * - Create an array of size C - B + 1.
 * - Copy elements from index B through C.
 * ============================================================
 */

import java.util.*;

public class CopySubarray {

    public int[] solve(int[] A, int B, int C) {

        // +1 because both B and C are included.
        int[] ans = new int[C - B + 1];

        int index = 0;

        for (int i = B; i <= C; i++) {

            ans[index] = A[i];
            index++;
        }

        return ans;
    }

    public static void main(String[] args) {

        CopySubarray obj = new CopySubarray();

        int[] A = {1, 2, 3, 4, 5};
        int B = 1;
        int C = 3;

        int[] result = obj.solve(A, B, C);

        System.out.println(
                Arrays.toString(result)
        );
    }
}