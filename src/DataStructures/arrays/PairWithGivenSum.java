/**
 * ============================================================
 * Problem            : Check Pair With Given Sum
 * Created By         : Karthik R
 *
 * Approach           : Brute Force
 * Algorithm          : Two Nested Loops
 *
 * Time Complexity    : O(N^2)
 * Space Complexity   : O(1)
 *
 * Idea:
 * - Check every possible pair of elements.
 * - If any pair has sum equal to B, return 1.
 * - If no pair is found, return 0.
 * ============================================================
 */

public class PairWithGivenSum {

    public int solve(int[] A, int B) {

        for (int i = 0; i < A.length - 1; i++) {

            for (int j = i + 1; j < A.length; j++) {

                if (A[i] + A[j] == B) {
                    return 1;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        PairWithGivenSum obj =
                new PairWithGivenSum();

        int[] A = {2, 7, 11, 15};
        int B = 9;

        System.out.println(obj.solve(A, B));
    }
}