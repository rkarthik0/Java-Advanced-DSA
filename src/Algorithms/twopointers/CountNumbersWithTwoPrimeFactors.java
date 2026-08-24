/**
 * ============================================================
 * Problem            : Count Numbers With Exactly 2 Prime Factors
 * Created By         : Karthik R
 *
 * Approach           : Sieve
 * Algorithm          : Prime Factor Counting
 *
 * Time Complexity    : O(A log log A)
 * Space Complexity   : O(A)
 *
 * Idea:
 * - countfact[i] stores the number of distinct prime factors of i.
 * - When countfact[i] == 0, i is prime.
 * - Increment the factor count for every multiple of that prime.
 * - Finally, count numbers having exactly 2 distinct prime factors.
 * ============================================================
 */

public class CountNumbersWithTwoPrimeFactors {

    public int solve(int A) {

        int[] countfact = new int[A + 1];

        // Find prime numbers and count their occurrences
        // as prime factors in all their multiples.
        for (int i = 2; i <= A; i++) {

            // If countfact[i] is 0, i is prime.
            if (countfact[i] == 0) {

                // Every multiple of i has i as a prime factor.
                for (int j = i; j <= A; j += i) {
                    countfact[j]++;
                }
            }
        }

        int ans = 0;

        // Count numbers having exactly 2 distinct prime factors.
        for (int i = 2; i <= A; i++) {

            if (countfact[i] == 2) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        CountNumbersWithTwoPrimeFactors obj =
                new CountNumbersWithTwoPrimeFactors();

        int A = 10;

        System.out.println(obj.solve(A));
    }
}