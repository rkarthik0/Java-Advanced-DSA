/**
 * ============================================================
 * Problem            : Range Sum Queries
 * Category           : Algorithms.PrefixSum
 * Created By         : Karthik R
 *
 * Approach           : Prefix Sum
 * Algorithm          : Prefix Sum Array
 *
 * Time Complexity    : O(N + Q)
 * Space Complexity   : O(N + Q)
 *
 * Idea:
 * - Build prefix sum where p[i] = sum of A[0...i].
 * - For query [l, r]:
 *   if l == 0 -> p[r]
 *   otherwise -> p[r] - p[l-1]
 * ============================================================
 */

public class RangeSumPrefixSum {

    public long[] rangeSum(int[] A, int[][] B) {

        int N = A.length;

        // Prefix sum array.
        long[] p = new long[N];

        p[0] = A[0];

        for (int i = 1; i < N; i++) {
            p[i] = p[i - 1] + A[i];
        }

        long[] ans = new long[B.length];

        // Answer each range query in O(1).
        for (int i = 0; i < B.length; i++) {

            int l = B[i][0];
            int r = B[i][1];

            if (l == 0) {
                ans[i] = p[r];
            } else {
                ans[i] = p[r] - p[l - 1];
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        RangeSumPrefixSum obj =
                new RangeSumPrefixSum();

        int[] A = {1, 2, 3, 4, 5};

        int[][] B = {
                {0, 2},
                {1, 3},
                {2, 4}
        };

        long[] result = obj.rangeSum(A, B);

        for (long sum : result) {
            System.out.print(sum + " ");
        }
    }
}