/**
 * ============================================================
 * Problem            : Count Factors of Array Elements
 * Created By         : Karthik R
 *
 * Approach           : Sieve Technique
 * Algorithm          : Divisor Counting using Multiples
 *
 * Time Complexity    : O(MAX * log(MAX))
 * Space Complexity   : O(MAX)
 *
 * Idea:
 * - cnt[x] stores the number of factors of x.
 * - For every i, visit all multiples of i.
 * - Every multiple of i has i as one of its factors.
 * ============================================================
 */

public class CountFactorsUsingSieve {

    public int[] solve(int[] A) {

        // Find maximum element
        int max = 0;

        for (int n : A) {
            max = Math.max(max, n);
        }

        // cnt[x] = number of factors of x
        int[] cnt = new int[max + 1];

        // i is a factor of all its multiples
        for (int i = 1; i <= max; i++) {

            for (int j = i; j <= max; j += i) {
                cnt[j]++;
            }
        }

        // Build answer
        int[] ans = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            ans[i] = cnt[A[i]];
        }

        return ans;
    }

    public static void main(String[] args) {

        CountFactorsUsingSieve obj =
                new CountFactorsUsingSieve();

        int[] A = {2, 3, 4, 6, 10};

        int[] result = obj.solve(A);

        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}